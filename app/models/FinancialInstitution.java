package models;

import java.util.*;
import javax.persistence.*;

import play.db.ebean.*;

@Entity public class FinancialInstitution extends Model {
	@Id public Long id;	public static Finder<Long, FinancialInstitution> find = new Finder<Long, FinancialInstitution>(Long.class, FinancialInstitution.class);
	
	@OneToMany(mappedBy = "financialInstitution", cascade = CascadeType.ALL) public List<FinancialInstitutionLogin> financialInstitutionLogins = new ArrayList<FinancialInstitutionLogin>();
	
	@Column(unique=true) public Long intuitId = null;
	public String name = null;
    public String url = null;
    public String phone = null;
    public String address1 = null;
    public String address2 = null;
    public String address3 = null;
    public String city = null;
    public String state = null;
    public String postalCode = null;
    public String country = null;
    public String currencyCode = null;
    public String usernameKey = null;
    public String passwordKey = null;
}