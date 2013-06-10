package controllers;

import java.io.*;
import java.text.*;
import java.util.*;
import play.mvc.*;
import play.mvc.Http.*;
import play.mvc.Http.MultipartFormData.*;
import play.data.*;
import play.db.ebean.*;
import com.avaje.ebean.*;
import static play.data.Form.*;

import models.*;
import views.html.*;

//todo: ensure user only signed in one location, use global boolean flag
//todo: crack jep
@Security.Authenticated(Secured.class) public class Application extends Controller {
    public static Result index() {
        User user = User.find.ref(request().username());
        Balance balance = Balance.find.ref(user.getUsername());
        CommittedBalance committedBalance = CommittedBalance.find.ref(user.getUsername());
        ConsumerProfile consumerProfile = ConsumerProfile.find.ref(user.getUsername());
        List<Long> watchedVideoIds = new ArrayList<Long>();
        for (WatchedVideo watchedVideo : user.findWatchedVideos()) if (watchedVideo.getEndTime() != null) watchedVideoIds.add(watchedVideo.findVideo().getId());
        List<Video> unwatchedVideos = Video.find.where().ne("user", user).not(Expr.in("id", watchedVideoIds)).findList();
        if (unwatchedVideos.size() > 0) {
	        List<VideoPayoutRate> videoPayoutRates = new ArrayList<VideoPayoutRate>();
	        for (Video video : unwatchedVideos) {
	        	long payout = video.getPayout(user);
	        	CommittedBalance committedBalancePayer = CommittedBalance.find.ref(video.findUser().getUsername());
	        	if (payout <= committedBalancePayer.getAmount()) {
			        VideoPayoutRate videoPayoutRate = new VideoPayoutRate(video, payout); 
			        videoPayoutRates.add(videoPayoutRate);
	        	}
	        }
	        Collections.sort(videoPayoutRates);
	        // todo: send a list of top few videos, to lessen queries
	        for (VideoPayoutRate videoPayoutRate : videoPayoutRates) {
        		// todo: dont send video by form like this? may not be safe someone could change source to different video id
	            WatchingVideo watchingVideo = user.findWatchingVideo()
                    .setStartTime(Calendar.getInstance())
                    .setVideo(videoPayoutRate.video)
                    .setPayout(videoPayoutRate.payout)
                    .saveGet();
        		return ok(index.render(user, watchingVideo, form(VideoEndedForm.class)));
	        }
        }
        return ok(index.render(user, null, form(VideoEndedForm.class)));
    }
    
    public static class VideoPayoutRate implements Comparable<VideoPayoutRate>{
    	Video video;
    	Long payout;
    	double payoutRate;
    	public VideoPayoutRate(Video video, Long payout) {
    		this.video = video;
    		this.payout = payout;
    		this.payoutRate = (double) payout / (double) video.duration;
    	}
		@Override public int compareTo(VideoPayoutRate otherVideo) {
			return otherVideo.payoutRate > this.payoutRate ? 1 : otherVideo.payoutRate < this.payoutRate ? -1 : 0;
		}
    }

    public static class VideoEndedForm {
        public String videoId;
    }
    
    // only get paid if watching video is being tracked
    @Transactional public static Result readVideoEndedForm() {
        Form<VideoEndedForm> videoEndedForm = form(VideoEndedForm.class).bindFromRequest();
        try {
            User user = User.find.ref(request().username());
            WatchingVideo watchingVideo = user.findWatchingVideo();
            Video video = Video.find.ref(Long.parseLong(videoEndedForm.get().videoId));
            if (!watchingVideo.getVideo().equals(video)) flash("failure", "Video was not tracked");
            else {
                Calendar currentTime = Calendar.getInstance();
                Calendar endTime = watchingVideo.getStartTime();
                endTime.add(Calendar.SECOND, watchingVideo.getVideo().getDuration());
                if (currentTime.before(endTime)) flash("failure", "Video ended prematurely");
                else if (user.getWatchedVideos().contains(video)) flash("failure", "You have already been paid for watching this video recently");
                else {
                    WatchedVideo watchedVideo = WatchedVideo.create(user, video)
                        .setStartTime(watchingVideo.getStartTime())
                        .setEndTime(currentTime)
                        .setPayout(watchingVideo.getPayout())
                        .saveGet();
                    Long payout = watchedVideo.getPayout();
                    CommittedBalance committedBalance = video.getUser().findCommittedBalance();
                    committedBalance.setAmount(committedBalance.getAmount() - payout).save();
    	        	Balance balancePayee = user.findBalance();
    	        	balancePayee.setAmount(balancePayee.getAmount() + payout).save();
    	        	watchingVideo.setStartTime(null).setVideo(null).setPayout(0L).save();
                    flash("Success", "You earned " + Video.centsToDollars(payout));
                    return redirect(routes.Application.index());
                }
            }
        }
        catch (Exception e) {}
        return redirect(routes.Application.index());
    }
    
    public static Result myVideos() {
        return ok(myVideos.render(User.find.ref(request().username()), form(UploadVideoForm.class)));
    }

    public static class UploadVideoForm {
        public String title;
        public String description;
    	public String payFormula;
    }
    
    // todo:add limit on input file size/duration
    // todo: keep connection open and show progress when uploading long jobs
    // todo: adjust ffmpeg resolution
    //todo: verify payformula parses with jep
    public static Result readUploadVideoForm() {
        Video video = Video.create(User.find.ref(request().username()));
        Form<UploadVideoForm> uploadVideoForm = form(UploadVideoForm.class).bindFromRequest();
        MultipartFormData formData = request().body().asMultipartFormData();
        File file = new File("public/uploads/" + video.getId() + "-temp.mp4");
        File tempFile = new File("public/uploads/" + video.getId() + "-temp.mp4");
        File finalFileMp4 = new File("public/uploads/" + video.getId() + ".mp4");
        File finalFileWebm = new File("public/uploads/" + video.getId() + ".webm");
        try {
        	String title = formData.asFormUrlEncoded().get("title")[0];
        	String description = formData.asFormUrlEncoded().get("description")[0];
        	String payFormula = formData.asFormUrlEncoded().get("payFormula")[0];
        	if (title.length() > 63) flash("failure", "Max of 63 characters in title");
        	else if (description.length() > 255) flash("failure", "Max of 255 characters in description");
        	else if (payFormula.length() > 255) flash("failure", "Max of 255 characters in pay formula");
        	else {
	            video.setTitle(title).setDescription(description).setPayFormula(payFormula);
	            file = formData.getFile("file").getFile();
	            Process process;
	            process = Runtime.getRuntime().exec("cmd /C lib\\ffmpeg -y -i " + file.getAbsolutePath() + " -vf scale=320:trunc(ow/a/2)*2 " + tempFile.getAbsolutePath());
	            int duration = getDuration(process);
	            process = Runtime.getRuntime().exec("cmd /C lib\\ffmpeg -y -i " + tempFile.getAbsolutePath() + " -vf scale=trunc(oh*a/2)*2:240 " + finalFileMp4.getAbsolutePath());
	            getDuration(process);
	            process = Runtime.getRuntime().exec("cmd /C lib\\ffmpeg -y -i " + finalFileMp4.getAbsolutePath() + " " + finalFileWebm.getAbsolutePath());
	            getDuration(process);
	            if (!finalFileMp4.exists() || !finalFileWebm.exists() || duration == 0) flash("failure", "Video improperly formatted");
	            else {
	                video.setDuration(duration).save();
	                flash("success", "Video uploaded");
	                file.delete();
	                tempFile.delete();
	                return redirect(routes.Application.myVideos());
	            }
        	}
        }
        catch (Exception e) {flash("failure", "Invalid file");}
        file.delete();
        tempFile.delete();
        finalFileMp4.delete();
        finalFileWebm.delete();
        video.delete();
        return ok(myVideos.render(User.find.ref(request().username()), uploadVideoForm));
    }
    
    public static int getDuration(Process process) {
        int duration = 0;
        try {
            BufferedReader errorReader = new BufferedReader(new InputStreamReader(process.getErrorStream()));
            BufferedReader outputReader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = errorReader.readLine()) != null) { if (duration == 0) duration = getDurationReader(line);}
            while ((line = outputReader.readLine()) != null) { if (duration == 0) duration = getDurationReader(line);}
            process.waitFor();
        }
        catch (Exception e) {}
        return duration;
    }
    
    public static int getDurationReader(String line) {
        int duration = 0;
        if (line.contains("Duration: ")) {
            String[] durationTokens = line.split("Duration: ")[1].split(",")[0].split(":");
            duration = (Integer.parseInt(durationTokens[0]) * 60 * 60) + (Integer.parseInt(durationTokens[1]) * 60) + ((int) Double.parseDouble(durationTokens[2]));
        }
        return duration;
    }
    
    public static Result deleteVideo(Long videoId) {
        Video video = Video.find.ref(videoId);
        if (video.getUser().getUsername().equals(request().username())) {
        	(new File("public/uploads/" + video.id + ".mp4")).delete();
        	(new File("public/uploads/" + video.id + ".webm")).delete();
        	video.delete();
            flash("success", "Video deleted");
            return redirect(routes.Application.myVideos());
        }
        else {
            flash("failure", "You many not delete videos that you did not create");
            return redirect(routes.Application.myVideos());
            //return forbidden();
        }
    }
    
    public static Result myProfile() {
    	return ok(myProfile.render(User.find.ref(request().username()), form(CreditCardAccountForm.class)));
    }
    
    public static class CreditCardAccountForm {
        public String ofxUser;
        public String ofxPassword;
        public String ofxPasswordRepeat;
    }

    @Transactional public static Result readCreditCardAccountForm() {
    	User user = User.find.ref(request().username());
        Form<CreditCardAccountForm> creditCardAccountForm = form(CreditCardAccountForm.class).bindFromRequest();
        try {
            String ofxUser = creditCardAccountForm.get().ofxUser;
            String ofxPassword = creditCardAccountForm.get().ofxPassword;
            String ofxPasswordRepeat = creditCardAccountForm.get().ofxPasswordRepeat;
            if (ofxUser.length() < 0) flash("failure", "Username must be at least 1 character");
            else if (ofxUser.length() > 31) flash("failure", "Max 31 characters in username");
            else if (ofxPassword.length() < 1) flash("failure", "Password must be at least 1 character");
            else if (ofxPassword.length() > 31) flash("failure", "Max 31 characters in password");
            else if (!ofxPassword.equals(ofxPasswordRepeat)) flash("failure", "Passwords do not match");
            else {
                CreditCardAccount.create(User.find.ref(request().username())).setOfxUser(ofxUser).setOfxPassword(ofxPassword).save();
                flash("success", "Credit card credentials saved");
                return redirect(routes.Application.myProfile());
            }
        }
        catch (Exception e) {flash("failure", "Submission failed");}
        return ok(myProfile.render(user, creditCardAccountForm));
    }

    public static String centsToDollars(Long cents) {
        return NumberFormat.getCurrencyInstance(Locale.US).format(cents / 100.0);
    }
}
