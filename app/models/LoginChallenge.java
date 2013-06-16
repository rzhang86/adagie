package models;

import javax.persistence.*;
import play.db.ebean.*;

@Entity public class LoginChallenge extends Model {
	@Id public Long id; public static Finder<Long, LoginChallenge> find = new Finder<Long, LoginChallenge>(Long.class, LoginChallenge.class);
    
	@ManyToOne public FinancialInstitutionLogin financialInstitutionLogin = null;
	@ManyToOne public ChallengeQuestion challengeQuestion = null;
	
	public String answer = null;
}