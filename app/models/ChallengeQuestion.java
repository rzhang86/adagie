package models;

import java.util.*;
import javax.persistence.*;
import play.db.ebean.*;

@Entity public class ChallengeQuestion extends Model {
	@Id public Long id; public static Finder<Long, ChallengeQuestion> find = new Finder<Long, ChallengeQuestion>(Long.class, ChallengeQuestion.class);
    
	@OneToMany(mappedBy = "challengeQuestion", cascade = CascadeType.ALL) public List<LoginChallenge> loginChallenges = new ArrayList<LoginChallenge>();
	
	@Column(unique=true) public String value = null;

	
	
	// getters/setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<LoginChallenge> getLoginChallenges() {
		return loginChallenges;
	}

	public void setLoginChallenges(List<LoginChallenge> loginChallenges) {
		this.loginChallenges = loginChallenges;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
}