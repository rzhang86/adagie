package models;

import javax.persistence.*;
import play.db.ebean.*;

@Entity public class WatchedVideo extends Model {
	@Id public Long id; public static Finder<Long, WatchedVideo> find = new Finder<Long, WatchedVideo>(Long.class, WatchedVideo.class);
    
	@ManyToOne public User user = null;
	@ManyToOne public Video video= null;
 	
    public Long startTime = null;
    public Long endTime = null;
    public Long payout = null;
}