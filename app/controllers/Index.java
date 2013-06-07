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
	            WatchingVideo watchingVideo = user.findWatchingVideo()
                    .setStartTime(Calendar.getInstance())
                    .setVideo(videoPayoutRate.video)
                    .setPayout(videoPayoutRate.payout)
                    .saveGet();
        		return ok(index.render(user, watchingVideo, form(VideoEndedInfo.class)));
	        }
        }
        return ok(index.render(user, null, form(VideoEndedInfo.class)));
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
        public String videoId;
    }
    
    // only get paid if watching video is being tracked
    @Transactional public static Result post() {
        Form<VideoEndedInfo> videoEndedInfoForm = form(VideoEndedInfo.class).bindFromRequest();
        try {
            User user = User.find.ref(request().username());
            WatchingVideo watchingVideo = user.findWatchingVideo();
            Video video = Video.find.ref(Long.parseLong(videoEndedInfoForm.get().videoId));
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
                    return redirect(routes.Index.get());
                }
            }
        }
        catch (Exception e) {}
        return redirect(routes.Index.get());
    }
}
