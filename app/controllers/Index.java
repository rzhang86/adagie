package controllers;

import java.util.*;

import com.avaje.ebean.Expr;

import play.mvc.*;
import play.data.*;
import play.db.ebean.Transactional;
import static play.data.Form.*;

import models.*;
import views.html.*;

//todo: ensure user only signed in one location, use global boolean flag
//todo: crack jep
@Security.Authenticated(Secured.class) public class Index extends Controller {
    public static Result get() {
        User user = User.find.ref(request().username());
        Balance balance = Balance.find.ref(user.getUsername());
        CommittedBalance committedBalance = CommittedBalance.find.ref(user.getUsername());
        ConsumerProfile consumerProfile = ConsumerProfile.find.ref(user.getUsername());
        List<Long> watchedVideoIds = new ArrayList<Long>();
        for (WatchedVideo watchedVideo : user.getWatchedVideos()) if (watchedVideo.getEndTime() != null) watchedVideoIds.add(watchedVideo.getVideo().getId());
        List<Video> unwatchedVideos = Video.find.where().ne("user", user).not(Expr.in("id", watchedVideoIds)).findList();
        if (unwatchedVideos.size() > 0) {
	        List<VideoPayoutRate> videoPayoutRates = new ArrayList<VideoPayoutRate>();
	        for (Video video : unwatchedVideos) {
	        	long payout = video.getPayout(user);
	        	CommittedBalance committedBalancePayer = CommittedBalance.find.ref(video.getUser().getUsername());
	        	if (payout <= committedBalancePayer.getAmount()) {
			        VideoPayoutRate videoPayoutRate = new VideoPayoutRate(video, payout); 
			        videoPayoutRates.add(videoPayoutRate);
	        	}
	        }
	        Collections.sort(videoPayoutRates);
	        // todo: send a list of top few videos, to lessen queries
	        for (VideoPayoutRate videoPayoutRate : videoPayoutRates) {
        		// todo: dont send video by form like this? may not be safe someone could change source to different video id
                WatchedVideo watchedVideo = new WatchedVideo(user, videoPayoutRate.video);
                watchedVideo.setStartTime(Calendar.getInstance());
                watchedVideo.setEndTime(null);
                watchedVideo.setPayout(videoPayoutRate.payout);
                watchedVideo.save();
        		return ok(index.render(user, balance, committedBalance, consumerProfile, watchedVideo, form(VideoEndedInfo.class)));
	        }
        }
        ConsumerProfile c = ConsumerProfile.find.ref(user.getUsername());
        //System.out.println("YOHO: " + user.username + " " + c.a7);
        return ok(index.render(user, balance, committedBalance, consumerProfile, null, form(VideoEndedInfo.class)));
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

    public static class VideoEndedInfo {
        public String watchedVideoId;
    }
    
    // only get paid if watched being tracked
    @Transactional public static Result post() {
        Form<VideoEndedInfo> videoEndedInfoForm = form(VideoEndedInfo.class).bindFromRequest();
        try {
            WatchedVideo watchedVideo = WatchedVideo.find.ref(Long.parseLong(videoEndedInfoForm.get().watchedVideoId));
            User user = User.find.ref(request().username());
            if (!watchedVideo.getUser().getUsername().equals(user.getUsername())) flash("failure", "Video was not tracked");
            else {
                Calendar currentTime = Calendar.getInstance();
                Calendar endTime = watchedVideo.getStartTime();
                endTime.add(Calendar.SECOND, watchedVideo.getVideo().getDuration());
                if (currentTime.before(endTime)) flash("failure", "Video ended prematurely");
                else {
                    watchedVideo.setEndTime(currentTime);
                    watchedVideo.save();
    	        	CommittedBalance committedBalancePayer = CommittedBalance.find.ref(watchedVideo.getVideo().getUser().getUsername());
    	        	committedBalancePayer.setAmount(committedBalancePayer.getAmount() - watchedVideo.getPayout());
    	        	committedBalancePayer.save();
    	        	Balance balancePayee = Balance.find.ref(watchedVideo.getVideo().getUser().getUsername());
    	        	balancePayee.setAmount(balancePayee.getAmount() + watchedVideo.getPayout());
    	        	balancePayee.save();
                    flash("Success", "You earned " + Video.centsToDollars(watchedVideo.getPayout()));
                    return redirect(routes.Index.get());
                }
            }
        }
        catch (Exception e) {}
        return redirect(routes.Index.get());
    }
}
