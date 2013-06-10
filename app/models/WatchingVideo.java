package models;

import java.util.*;
import javax.persistence.*;
import play.db.ebean.*;

@Entity public class WatchingVideo extends Model {
	// has one User
    @Id public String userUsername; public String getUserUsername() {return this.userUsername;} public WatchingVideo setUserUsername(String userUsername) {this.userUsername = userUsername; return this;}
    public User findUser() {return User.find.ref(userUsername);}

    // has one Video
    public Long videoId; public Long getVideoId() {return this.videoId;} public WatchingVideo setVideoId(Long videoId) {this.videoId = videoId; return this;}
 	public Video findVideo() {return Video.find.ref(videoId);}
 	
    public Calendar startTime; public Calendar getStartTime() {return this.startTime;} public WatchingVideo setStartTime(Calendar startTime) {this.startTime = startTime; return this;}
    public Long payout; public Long getPayout() {return this.payout;} public WatchingVideo setPayout(Long payout) {this.payout = payout; return this;}
    
    public static WatchingVideo create(String userUsername, Long videoId, Calendar startTime, Long payout) {
    	return (new WatchingVideo()).setUserUsername(userUsername).setVideoId(videoId).setStartTime(startTime).setPayout(payout).saveGet();
    }
    public WatchingVideo saveGet() {this.save(); return this;}
    public static Finder<String, WatchingVideo> find = new Finder<String, WatchingVideo>(String.class, WatchingVideo.class);
}