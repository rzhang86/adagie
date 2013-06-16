package models;

import java.util.*;
import javax.persistence.*;
import play.db.ebean.*;

@Entity public class ChallengeQuestion extends Model {
	@Id public Long id; public static Finder<Long, ChallengeQuestion> find = new Finder<Long, ChallengeQuestion>(Long.class, ChallengeQuestion.class);
    
	@OneToMany(mappedBy = "challengeQuestion", cascade = CascadeType.ALL) public List<LoginChallenge> loginChallenges = new ArrayList<LoginChallenge>();
	
	@Column(unique=true) public String value = null;
}