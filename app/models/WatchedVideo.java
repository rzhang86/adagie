package models;

import java.util.*;
import javax.persistence.*;

import play.data.validation.Constraints.*;
import play.db.ebean.*;

@Entity public class WatchedVideo extends Model {
    @Id public Long id;
    public Long getId() {return this.id;}
    
    @Required @ManyToOne public User user;
    public WatchedVideo setUser(User user) {this.user = user; return this;}
    public User getUser() {return this.user;}
    
    @Required @ManyToOne public Video video;
    public WatchedVideo setVideo(Video video) {this.video = video; return this;}
    public Video getVideo() {return this.video;}
    
    public Calendar startTime = null;
    public WatchedVideo setStartTime(Calendar startTime) {this.startTime = startTime; return this;}
    public Calendar getStartTime() {return this.startTime;}
    
    public Calendar endTime = null;
    public WatchedVideo setEndTime(Calendar endTime) {this.endTime = endTime; return this;}
    public Calendar getEndTime() {return this.endTime;}
    
    public Long payout = 0L;
    public WatchedVideo setPayout(Long payout) {this.payout = payout; return this;}
    public Long getPayout() {return this.payout;}
    
    public static WatchedVideo create(User user, Video video) {
        WatchedVideo watchedVideo = new WatchedVideo();
        watchedVideo.setUser(user);
        watchedVideo.setVideo(video);
        watchedVideo.save();
        return watchedVideo;
    }

    public static void destroy(WatchedVideo watchedVideo) {
        watchedVideo.delete();
    }
    
    public WatchedVideo saveGet() {this.save(); return this;}
    
    public static Finder<Long, WatchedVideo> find = new Finder<Long, WatchedVideo>(Long.class, WatchedVideo.class);
}