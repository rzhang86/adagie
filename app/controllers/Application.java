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
	// -- start profile
    public static Result getProfile() {
    	User user = User.findByUsername(request().username());
    	return ok(profile.render(user, getProfileForm(user)));
    }
    
    //todo: validate username and password can only contain alphanumerics, no escape characters
    public static Result postProfile() {
    	User user = User.findByUsername(request().username());
        Form<ProfileForm> profileForm = form(ProfileForm.class).bindFromRequest();
        try {
        	Map<String, String> map = profileForm.data();
        	String username = (map.containsKey("username") ? (!map.get("username").trim().equals("") ? map.get("username") : null) : null);
        	String email = (map.containsKey("email") ? (!map.get("email").trim().equals("") ? map.get("email") : null) : null);
        	String password = (map.containsKey("password") ? (!map.get("password").trim().equals("") ? map.get("password") : null) : null);
        	String passwordRepeat = (map.containsKey("passwordRepeat") ? (!map.get("passwordRepeat").trim().equals("") ? map.get("passwordRepeat") : null) : null);
            Integer age = null; try {age = Integer.parseInt(map.get("age"));} catch (Exception e) {}
            String zip = (map.containsKey("zip") ? (!map.get("zip").trim().equals("") ? map.get("zip") : null) : null);
            String gender = (map.containsKey("gender") ? (!map.get("gender").trim().equals("") ? map.get("gender") : null) : null);
            Long occupation1 = null; try {occupation1 = Long.parseLong(map.get("occupation1"));} catch (Exception e) {}
            Long occupation2 = null; try {occupation2 = Long.parseLong(map.get("occupation2"));} catch (Exception e) {}
            Long interest1 = null; try {interest1 = Long.parseLong(map.get("interest1"));} catch (Exception e) {}
            Long interest2 = null; try {interest2 = Long.parseLong(map.get("interest2"));} catch (Exception e) {}
            Long interest3 = null; try {interest3 = Long.parseLong(map.get("interest3"));} catch (Exception e) {}
            Long interest4 = null; try {interest4 = Long.parseLong(map.get("interest4"));} catch (Exception e) {}
            
            //todo: username cannot have weird characters or spaces
            if (username == null || username.length() < 1 || username.length() > 31) flash("failure", "Username invalid");
            else if (User.find.where().eq("username", username).findRowCount() > 0) flash("failure", "Username already taken");
            else if (email == null || email.length() < 1 || email.length() > 63) flash("failure", "Email invalid");
            else if (password == null || password.length() < 1 || password.length() > 31) flash("failure", "Password invalid");
            else if (passwordRepeat == null || !passwordRepeat.equals(password)) flash("failure", "Passwords do not match");
            else {
            	user.username = username;
            	user.email = email;
            	user.password = password;
            	user.birthyear = (age != null ? Calendar.getInstance().get(Calendar.YEAR) - age : null);
            	user.gender = gender;
                List<Long> uniqueValues;
                uniqueValues = new ArrayList<Long>();
                if (occupation1 != -1 && !uniqueValues.contains(occupation1)) uniqueValues.add(occupation1);
                if (occupation2 != -1 && !uniqueValues.contains(occupation2)) uniqueValues.add(occupation2);
                for (Long uniqueValue : uniqueValues) user.occupations.add(Occupation.find.ref(uniqueValue));
                uniqueValues = new ArrayList<Long>();
                if (interest1 != -1 && !uniqueValues.contains(interest1)) uniqueValues.add(interest1);
                if (interest2 != -1 && !uniqueValues.contains(interest2)) uniqueValues.add(interest2);
                if (interest3 != -1 && !uniqueValues.contains(interest3)) uniqueValues.add(interest3);
                if (interest4 != -1 && !uniqueValues.contains(interest4)) uniqueValues.add(interest4);
                for (Long uniqueValue : uniqueValues) user.interests.add(Interest.find.ref(uniqueValue));
            	user.save();
                flash("success", "You have signed up");
                return redirect(routes.Application.getProfile());
            }
        }
        catch (Exception e) {flash("failure", "Profile change failed"); e.printStackTrace();}
        return ok(profile.render(user, profileForm));
    }

	public static class ProfileForm {
        public String username;
        public String email;
        public String password;
        public String passwordRepeat;
        public String gender;
        public Integer age;
        public String zip;
        public Long occupation1;
        public Long occupation2;
        public Long interest1;
        public Long interest2;
        public Long interest3;
        public Long interest4;
    }
	
	public static Form<ProfileForm> getProfileForm(User user) {
    	ProfileForm profileForm = new ProfileForm();
    	profileForm.username = (user.username != null ? user.username : null);
    	profileForm.email = (user.email != null ? user.email : null);
    	profileForm.gender = (user.gender != null ? user.gender : null);
    	profileForm.age = (user.birthyear != null ? Calendar.getInstance().get(Calendar.YEAR) - user.birthyear : null);
    	Zip zip = user.zip;
    	profileForm.zip = (zip != null ? Zip.find.byId(user.zip.id).zipCode : null);
    	List<Occupation> occupations = user.occupations;
    	profileForm.occupation1 = (occupations.size() >= 1 ? occupations.get(0).id : null);
    	profileForm.occupation2 = (occupations.size() >= 2 ? occupations.get(1).id : null);
    	List<Interest> interests = user.interests;
    	profileForm.interest1 = (interests.size() >= 1 ? interests.get(0).id : null);
    	profileForm.interest2 = (interests.size() >= 2 ? interests.get(1).id : null);
    	profileForm.interest3 = (interests.size() >= 3 ? interests.get(2).id : null);
    	profileForm.interest4 = (interests.size() >= 4 ? interests.get(3).id : null);
    	Form<ProfileForm> form = form(ProfileForm.class);
    	form = form.fill(profileForm);
    	return form;
    }
    // -- end profile
	
	
    public static Result home() {
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
        		return ok(home.render(user, form(VideoEndedForm.class)));
	        }
        }
        return ok(home.render(user, form(VideoEndedForm.class)));
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
        return redirect(routes.Application.home());
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
    	public List<String> conditions;
    	public List<String> results;
	}
    
    // todo:add limit on input file size/duration
    // todo: keep connection open and show progress when uploading long jobs
    // todo: adjust ffmpeg resolution
    //todo: verify payformula parses with jep
    public static Result readUploadVideoForm() {
    	User user = User.findByUsername(request().username());
    	Form<UploadVideoForm> uploadVideoForm = form(UploadVideoForm.class).bindFromRequest();
        MultipartFormData formData = request().body().asMultipartFormData();
        Video video = new Video();
        video.user = user;
        video.save();
        Long videoId = video.id;
        File file = new File("public/uploads/" + videoId + "-temp.mp4");
        File tempFile = new File("public/uploads/" + videoId + "-temp.mp4");
        File finalFileMp4 = new File("public/uploads/" + videoId + ".mp4");
        File finalFileWebm = new File("public/uploads/" + videoId + ".webm");
        try {
        	String title = formData.asFormUrlEncoded().get("title")[0];
        	String description = formData.asFormUrlEncoded().get("description")[0];
        	List<String> conditions = new ArrayList<String>();
        	List<String> results = new ArrayList<String>();
        	try {
        		for (int i = 0; true; i++) {
	        		conditions.add(formData.asFormUrlEncoded().get("conditions[" + i + "]")[0]);
	        		results.add(formData.asFormUrlEncoded().get("results[" + i + "]")[0]);
        		}
        	}
        	catch (Exception e) {}
        	if (title.length() > 63) flash("failure", "Max of 63 characters in title");
        	else if (description.length() > 255) flash("failure", "Max of 255 characters in description");
        	else {
        		boolean ok = true;
        		for (int i = 0; i < conditions.size(); i++) {
        			// todo: validate formula are well formed
        			if (conditions.get(i).length() > 255 || results.get(i).length() > 255) {
        				ok = false;
	        			flash("failure", "Max of 255 characters in formulas");
	        			break;
        			}
        		}
        		if (ok) {
	        		video.title = title;
	        		video.description = description;
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
		                // todo: make this part transactional?
	        			for (int i = 0; i < conditions.size(); i++) {
	        				PayoutFormula payoutFormula = new PayoutFormula();
	        				payoutFormula.video = video;
	        				payoutFormula.condition = conditions.get(i);
	        				payoutFormula.result = results.get(i);
	        				payoutFormula.save();
	        			}
		                flash("success", "Video uploaded");
		                file.delete();
		                tempFile.delete();
		                return redirect(routes.Application.myVideos());
		            }
        		}
        	}
        }
        catch (Exception e) {flash("failure", "Invalid file");
        	e.printStackTrace();
        }
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
                FinancialInstitutionLogin financialInstitutionLogin = FinancialInstitutionLogin.find.where().eq("user", user).eq("financialInstitution", financialInstitution).eq("username", username).findUnique();
                if (financialInstitutionLogin == null) {
                	financialInstitutionLogin = new FinancialInstitutionLogin();
                    financialInstitutionLogin.user = user;
                    financialInstitutionLogin.financialInstitution = financialInstitution;
                    financialInstitutionLogin.username = username;
                }
                financialInstitutionLogin.password = password;
            	financialInstitutionLogin.save();
            	flash("success", "Financial institution login saved");
            	return redirect(routes.Application.myProfile());
            }
        }
        catch (Exception e) {flash("failure", "Submission failed");}
        return ok(myProfile.render(user, financialInstitutionLoginForm));
    }
    
    public static Result deleteFinancialInstitutionLogin(Long financialInstitutionLoginId) {
    	User user = User.findByUsername(request().username());
    	FinancialInstitutionLogin financialInstitutionLogin = FinancialInstitutionLogin.find.byId(financialInstitutionLoginId);
        if (financialInstitutionLogin.user.equals(user)) {
        	financialInstitutionLogin.delete();
            flash("success", "Login credentials deleted");
        }
        else {
            flash("failure", "You many not someone else's login credentials");
            //return forbidden();
        }
        return redirect(routes.Application.myProfile());
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
        return redirect(routes.Application.home());
    }
    
    public static Result logout() {
        session().clear();
        flash("success", "You have logged out");
        return redirect(routes.Lobby.getIndex());
    }
    
    public static String centsToDollars(Long cents) {
        return NumberFormat.getCurrencyInstance(Locale.US).format(cents / 100.0);
    }
}
