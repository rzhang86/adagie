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

@Security.Authenticated(Secured.class) public class Uploads extends Controller {
    public static Result get() {
    	User user = User.findByUsername(request().username());
        return ok(uploads.render(user, form(UploadVideoForm.class)));
    }
    
    // todo:add limit on input file size/duration
    // todo: keep connection open and show progress when uploading long jobs
    // todo: adjust ffmpeg resolution
    //todo: verify payformula parses with jep
    public static Result post() {
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
		                return redirect("/uploads");
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
        flash("new", "1");
        return ok(uploads.render(user, uploadVideoForm));
    }
    
    //todo: right now this is delete, have to also allow edits
    public static Result delete(Long id) {
    	User user = User.findByUsername(request().username());
        Video video = Video.find.byId(id);
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
        return redirect("/uploads");
    }

    public static class UploadVideoForm {
        public String title;
        public String description;
    	public List<String> conditions;
    	public List<String> results;
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
}
