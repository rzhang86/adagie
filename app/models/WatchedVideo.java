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

	
	
	// getters/setters
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Video getVideo() {
		return video;
	}
	public void setVideo(Video video) {
		this.video = video;
	}
	public Long getStartTime() {
		return startTime;
	}
	public void setStartTime(Long startTime) {
		this.startTime = startTime;
	}
	public Long getEndTime() {
		return endTime;
	}
	public void setEndTime(Long endTime) {
		this.endTime = endTime;
	}
	public Long getPayout() {
		return payout;
	}
	public void setPayout(Long payout) {
		this.payout = payout;
	}
}