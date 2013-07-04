package models;

import javax.persistence.*;
import play.db.ebean.*;

@Entity public class LoginChallenge extends Model {
	@Id public Long id; public static Finder<Long, LoginChallenge> find = new Finder<Long, LoginChallenge>(Long.class, LoginChallenge.class);
    
	@ManyToOne public FinancialInstitutionLogin financialInstitutionLogin = null;
	@ManyToOne public ChallengeQuestion challengeQuestion = null;
	
	public String answer = null;

	
	
	// getters/setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public FinancialInstitutionLogin getFinancialInstitutionLogin() {
		return financialInstitutionLogin;
	}

	public void setFinancialInstitutionLogin(
			FinancialInstitutionLogin financialInstitutionLogin) {
		this.financialInstitutionLogin = financialInstitutionLogin;
	}

	public ChallengeQuestion getChallengeQuestion() {
		return challengeQuestion;
	}

	public void setChallengeQuestion(ChallengeQuestion challengeQuestion) {
		this.challengeQuestion = challengeQuestion;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}
}