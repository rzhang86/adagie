package models;

import java.util.*;
import javax.persistence.*;
import play.db.ebean.*;

@Entity public class UserVariable extends Model {
	@Id public Long id; public static Finder<Long, UserVariable> find = new Finder<Long, UserVariable>(Long.class, UserVariable.class);
    
	@ManyToOne public User user = null;
	
    public String code = null;
    public Integer timepoint = null;
    public Boolean isDebit = null;
    public Long amount = null;
    public Integer frequency = null;

	
	
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
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public Integer getTimepoint() {
		return timepoint;
	}
	public void setTimepoint(Integer timepoint) {
		this.timepoint = timepoint;
	}
	public Boolean getIsDebit() {
		return isDebit;
	}
	public void setIsDebit(Boolean isDebit) {
		this.isDebit = isDebit;
	}
	public Long getAmount() {
		return amount;
	}
	public void setAmount(Long amount) {
		this.amount = amount;
	}
	public Integer getFrequency() {
		return frequency;
	}
	public void setFrequency(Integer frequency) {
		this.frequency = frequency;
	}
}