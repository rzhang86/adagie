package controllers;

import java.io.*;

import play.mvc.*;

import models.*;
import views.html.*;

@Security.Authenticated(Secured.class) public class YourVideos extends Controller {
    public static Result get() {
        return ok(yourVideos.render(User.find.ref(request().username())));
    }
    
    public static Result deleteVideo(Long videoId) {
        Video video = Video.find.ref(videoId);
        if (video.getUser().getUsername().equals(request().username())) {
        	(new File("public/uploads/" + video.id + ".mp4")).delete();
        	(new File("public/uploads/" + video.id + ".webm")).delete();
        	video.delete();
            flash("success", "Video deleted");
            return redirect(routes.YourVideos.get());
        }
        else {
            flash("failure", "You many not delete videos that you did not create");
            return redirect(routes.YourVideos.get());
            //return forbidden();
        }
    }
}