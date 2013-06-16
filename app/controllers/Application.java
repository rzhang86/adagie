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
    	User user = User.findByUsername(request().username());
        List<Long> watchedVideoIds = new ArrayList<Long>();
        for (WatchedVideo watchedVideo : user.watchedVideos) if (watchedVideo.endTime != null) watchedVideoIds.add(watchedVideo.video.id);
        List<Video> unwatchedVideos = Video.find.where().ne("user", user).not(Expr.in("id", watchedVideoIds)).findList();
        if (unwatchedVideos.size() > 0) {
	        List<VideoPayoutRate> videoPayoutRates = new ArrayList<VideoPayoutRate>();
	        for (Video video : unwatchedVideos) {
	        	long payout = video.getPayout(user);
	        	User payer = video.user;
	        	if (payout <= user.committedBalance) {
			        VideoPayoutRate videoPayoutRate = new VideoPayoutRate(video, payout); 
			        videoPayoutRates.add(videoPayoutRate);
	        	}
	        }
	        Collections.sort(videoPayoutRates);
	        // todo: send a list of top few videos, to lessen queries
	        for (VideoPayoutRate videoPayoutRate : videoPayoutRates) {
        		// todo: dont send video by form like this? may not be safe someone could change source to different video id
	        	user.watchingVideo = videoPayoutRate.video;
	        	user.watchingStartTime = Calendar.getInstance().getTimeInMillis();
	        	user.watchingEndTime = user.watchingStartTime + user.watchingVideo.duration;
	        	user.watchingPayout = videoPayoutRate.payout;
	        	user.save();
        		return ok(index.render(user, form(VideoEndedForm.class)));
	        }
        }
        return ok(index.render(user, form(VideoEndedForm.class)));
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
    public static Result readVideoEndedForm() {
        Form<VideoEndedForm> videoEndedForm = form(VideoEndedForm.class).bindFromRequest();
        try {
        	User user = User.findByUsername(request().username());
            Video video = Video.find.byId(Long.parseLong(videoEndedForm.get().videoId));
            if (!user.watchingVideo.equals(video)) flash("failure", "Video was not tracked");
            else {
            	Long currentTime = Calendar.getInstance().getTimeInMillis();
                if (currentTime < user.watchingEndTime) flash("failure", "Video ended prematurely");
                else if (user.watchedVideos.contains(video)) flash("failure", "You have already been paid for watching this video recently");
                else {
                    WatchedVideo watchedVideo = new WatchedVideo();
                    watchedVideo.user = user;
                    watchedVideo.video = video;
                    watchedVideo.startTime = user.watchingStartTime;
                    watchedVideo.endTime = currentTime;
                    watchedVideo.payout = user.watchingPayout;
                    watchedVideo.save();
                    if (transferMoney(video.user, user, watchedVideo.payout)) flash("success", "You earned " + centsToDollars(watchedVideo.payout));
                    else flash("failure", "Error transferring money");
                }
            }
        }
        catch (Exception e) {}
        return redirect(routes.Application.index());
    }
    
    @Transactional public static boolean transferMoney(User payer, User payee, Long amount) {
    	// are these transactions safe? require table lock?
    	try {
	    	payer.committedBalance -= amount;
	    	payee.balance += amount;
	    	payer.save();
	    	payee.save();
	    	return true;
    	}
    	catch (Exception e) {System.out.println("error transferring money: " + e.getMessage());}
    	return false;
    }
    
    public static Result myVideos() {
    	User user = User.findByUsername(request().username());
        return ok(myVideos.render(user, form(UploadVideoForm.class)));
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
    	User user = User.findByUsername(request().username());
        Video video = new Video();
        video.user = user;
        Form<UploadVideoForm> uploadVideoForm = form(UploadVideoForm.class).bindFromRequest();
        MultipartFormData formData = request().body().asMultipartFormData();
        File file = new File("public/uploads/" + video.id + "-temp.mp4");
        File tempFile = new File("public/uploads/" + video.id + "-temp.mp4");
        File finalFileMp4 = new File("public/uploads/" + video.id + ".mp4");
        File finalFileWebm = new File("public/uploads/" + video.id + ".webm");
        try {
        	String title = formData.asFormUrlEncoded().get("title")[0];
        	String description = formData.asFormUrlEncoded().get("description")[0];
        	String payFormula = formData.asFormUrlEncoded().get("payFormula")[0];
        	if (title.length() > 63) flash("failure", "Max of 63 characters in title");
        	else if (description.length() > 255) flash("failure", "Max of 255 characters in description");
        	else if (payFormula.length() > 255) flash("failure", "Max of 255 characters in pay formula");
        	else {
        		video.title = title;
        		video.description = description;
        		//video.payoutFormulas = //todo: implement multiple pay formulas
	            file = formData.getFile("file").getFile();
	            Process process = Runtime.getRuntime().exec("cmd /C lib\\ffmpeg -y -i " + file.getAbsolutePath() + " -vf scale=320:trunc(ow/a/2)*2 " + tempFile.getAbsolutePath());
	            int duration = getDuration(process);
	            process = Runtime.getRuntime().exec("cmd /C lib\\ffmpeg -y -i " + tempFile.getAbsolutePath() + " -vf scale=trunc(oh*a/2)*2:240 " + finalFileMp4.getAbsolutePath());
	            getDuration(process);
	            process = Runtime.getRuntime().exec("cmd /C lib\\ffmpeg -y -i " + finalFileMp4.getAbsolutePath() + " " + finalFileWebm.getAbsolutePath());
	            getDuration(process);
	            if (!finalFileMp4.exists() || !finalFileWebm.exists() || duration == 0) flash("failure", "Video improperly formatted");
	            else {
	                video.duration = duration;
	                video.save();
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
        return ok(myVideos.render(user, uploadVideoForm));
    }
    
    public static int getDuration(Process process) {
        int duration = 0;
        try {
            BufferedReader errorReader = new BufferedReader(new InputStreamReader(process.getErrorStream()));
            BufferedReader outputReader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = errorReader.readLine()) != null) {if (duration == 0) duration = getDurationReader(line);}
            while ((line = outputReader.readLine()) != null) {if (duration == 0) duration = getDurationReader(line);}
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
    	User user = User.findByUsername(request().username());
        Video video = Video.find.byId(videoId);
        if (video.user.equals(user)) {
        	(new File("public/uploads/" + video.id + ".mp4")).delete();
        	(new File("public/uploads/" + video.id + ".webm")).delete();
        	video.delete();
            flash("success", "Video deleted");
        }
        else {
            flash("failure", "You many not delete videos that you did not create");
            //return forbidden();
        }
        return redirect(routes.Application.myVideos());
    }
    
    public static Result myProfile() {
    	User user = User.findByUsername(request().username());
    	return ok(myProfile.render(user, form(FinancialInstitutionLoginForm.class)));
    }
    
    public static class FinancialInstitutionLoginForm {
        public String name;
        public String username;
        public String password;
        public String passwordRepeat;
    }

    public static Result readFinancialInstitutionLoginForm() {
    	User user = User.findByUsername(request().username());
        Form<FinancialInstitutionLoginForm> financialInstitutionLoginForm = form(FinancialInstitutionLoginForm.class).bindFromRequest();
        try {
            String name = financialInstitutionLoginForm.get().name;
            String username = financialInstitutionLoginForm.get().username;
            String password = financialInstitutionLoginForm.get().password;
            String passwordRepeat = financialInstitutionLoginForm.get().passwordRepeat;
            FinancialInstitution financialInstitution = FinancialInstitution.find.where().eq("name", name).findUnique();
            if (username.length() < 0) flash("failure", "Username must be at least 1 character");
            else if (username.length() > 31) flash("failure", "Max 31 characters in username");
            else if (password.length() < 1) flash("failure", "Password must be at least 1 character");
            else if (password.length() > 31) flash("failure", "Max 31 characters in password");
            else if (!password.equals(passwordRepeat)) flash("failure", "Passwords do not match");
            else if (financialInstitution.id == null) flash("failure", "Malformed entry, try again");
            else {
                FinancialInstitutionLogin financialInstitutionLogin = new FinancialInstitutionLogin();
                financialInstitutionLogin.financialInstitution = financialInstitution;
                financialInstitutionLogin.user = user;
                financialInstitutionLogin.username = username;
                financialInstitutionLogin.password = password;
                financialInstitutionLogin.save();
                flash("success", "Financial institution login saved");
                return redirect(routes.Application.myProfile());
            }
        }
        catch (Exception e) {flash("failure", "Submission failed");}
        return ok(myProfile.render(user, financialInstitutionLoginForm));
    }

    public static class ChallengeAnswerForm {
        public String id;
        public String answer;
    }
    
    // only get paid if watching video is being tracked
    public static Result readChallengeAnswerForm() {
    	User user = User.findByUsername(request().username());
        Form<ChallengeAnswerForm> challengeAnswerForm = form(ChallengeAnswerForm.class).bindFromRequest();
        try {
        	LoginChallenge loginChallenge = LoginChallenge.find.byId(Long.parseLong(challengeAnswerForm.get().id));
            String answer = challengeAnswerForm.get().answer;
            if (loginChallenge.financialInstitutionLogin.user.equals(user)) {
        		loginChallenge.answer = answer;
        		loginChallenge.save();
        		flash("success", "Answer saved");
            }
            else flash("failure", "Answer not saved, not your challenge");
        }
        catch (Exception e) {flash("failure", "Error, answer not saved");}
        return redirect(routes.Application.index());
    }
    
    public static String centsToDollars(Long cents) {
        return NumberFormat.getCurrencyInstance(Locale.US).format(cents / 100.0);
    }
}
