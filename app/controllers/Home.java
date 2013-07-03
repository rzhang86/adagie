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

@Security.Authenticated(Secured.class) public class Home extends Controller {
    public static Result get() {
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
    
    // only get paid if watching video is being tracked
    public static Result post() {
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
                    if (transferMoney(video.user, user, watchedVideo.payout)) flash("success", "You earned " + Application.centsToDollars(watchedVideo.payout));
                    else flash("failure", "Error transferring money");
                }
            }
        }
        catch (Exception e) {}
        return redirect(routes.Home.get());
    }
    
    public static class VideoPayoutRate implements Comparable<VideoPayoutRate> {
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
}
