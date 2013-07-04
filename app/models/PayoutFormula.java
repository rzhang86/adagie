package models;

import javax.persistence.*;
import play.db.ebean.*;

@Entity public class PayoutFormula extends Model {
	@Id public Long id; public static Finder<Long, PayoutFormula> find = new Finder<Long, PayoutFormula>(Long.class, PayoutFormula.class);
    
	@ManyToOne public Video video = null;
	
    public String condition = null;
    public String result = null;

	
	
	// getters/setters
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Video getVideo() {
		return video;
	}
	public void setVideo(Video video) {
		this.video = video;
	}
	public String getCondition() {
		return condition;
	}
	public void setCondition(String condition) {
		this.condition = condition;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
}