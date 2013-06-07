package models;

import java.util.*;
import javax.persistence.*;

import play.data.validation.Constraints.*;
import play.db.ebean.*;

@Entity public class WatchedVideo extends Model {
    @Id public Long id;
    public Long getId() {return this.id;}
    
    @Required @ManyToOne public User user;
    public User getUser() {return this.user;}
    
    @Required @ManyToOne public Video video;
    public Video getVideo() {return this.video;}
    
    public Calendar startTime = null;
    public void setStartTime(Calendar startTime) {this.startTime = startTime;}
    public Calendar getStartTime() {return this.startTime;}
    
    public Calendar endTime = null;
    public void setEndTime(Calendar endTime) {this.endTime = endTime;}
    public Calendar getEndTime() {return this.endTime;}
    
    public Long payout = 0L;
    public void setPayout(Long payout) {this.payout = payout;}
    public Long getPayout() {return this.payout;}
    
    
    public WatchedVideo(User user, Video video) {
        this.user = user;
        this.video = video;
    }
    
    public static Finder<Long, WatchedVideo> find = new Finder<Long, WatchedVideo>(Long.class, WatchedVideo.class);
}