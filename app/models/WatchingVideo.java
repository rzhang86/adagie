package models;

import java.util.*;

import javax.persistence.*;

import play.data.validation.Constraints.*;
import play.db.ebean.*;

@Entity public class WatchingVideo extends Model {
    @Id public String username;
    public WatchingVideo setUsername(String username) {this.username = username; return this;}
    public String getUsername() {return this.username;}

    @ManyToOne public Video video;
    public WatchingVideo setVideo(Video video) {this.video = video; return this;}
    public Video getVideo() {return this.video;}
    
    public Calendar startTime = null;
    public WatchingVideo setStartTime(Calendar startTime) {this.startTime = startTime; return this;}
    public Calendar getStartTime() {return this.startTime;}
    
    public Long payout = 0L;
    public WatchingVideo setPayout(Long payout) {this.payout = payout; return this;}
    public Long getPayout() {return this.payout;}
    
    public User findUser() {return User.find.ref(username);}
    
    public static WatchingVideo create(User user) {
        WatchingVideo watchingVideo = new WatchingVideo();
        watchingVideo.setUsername(user.getUsername());
        watchingVideo.save();
        return watchingVideo;
    }
    
    public static void destroy(WatchingVideo watchingVideo) {
        watchingVideo.delete();
    }
    
    public WatchingVideo saveGet() {this.save(); return this;}
    
    public static Finder<String, WatchingVideo> find = new Finder<String, WatchingVideo>(String.class, WatchingVideo.class);
}