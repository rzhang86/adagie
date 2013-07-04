package models;

import java.util.*;
import javax.persistence.*;
import play.db.ebean.*;

@Entity public class FinancialInstitutionLogin extends Model {
	@Id public Long id; public static Finder<Long, FinancialInstitutionLogin> find = new Finder<Long, FinancialInstitutionLogin>(Long.class, FinancialInstitutionLogin.class);
    
	@OneToMany(mappedBy = "financialInstitutionLogin", cascade = CascadeType.ALL) public List<LoginChallenge> loginChallenges = new ArrayList<LoginChallenge>();
	
	@ManyToOne public User user = null;
	@ManyToOne public FinancialInstitution financialInstitution = null;

	public String username = null;
    public String password = null;
    
    
    
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

	public FinancialInstitution getFinancialInstitution() {
		return financialInstitution;
	}

	public void setFinancialInstitution(FinancialInstitution financialInstitution) {
		this.financialInstitution = financialInstitution;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public User getUser() {
		return user;
	}
	
	public void setUser(User user) {
		this.user = user;
	}
}