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
}