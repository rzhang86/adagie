package models;

import java.util.*;

import javax.persistence.*;
import play.db.ebean.*;

@Entity public class FinancialInstitution extends Model {
	@Id public Integer id; public Integer getId() {return this.id;} public FinancialInstitution setId(Integer id) {this.id = id; return this;}
    
	// has many CreditCardAccount
	public List<CreditCardAccount> findCreditCardAccounts() {return CreditCardAccount.find.where().eq("financialInstutionId", id).findList();}
    
    public String name;  public String getName() {return this.name;} public FinancialInstitution setName(String name) {this.name = name; return this;}
    public String url; public String getUrl() {return this.url;} public FinancialInstitution setUrl(String url) {this.url = url; return this;}
    public String org; public String getOrg() {return this.org;} public FinancialInstitution setOrg(String org) {this.org = org; return this;} 
    public String fid; public String getFid() {return this.fid;} public FinancialInstitution setFid(String fid) {this.fid = fid; return this;}
    
    public static FinancialInstitution create(Integer id, String name, String url, String org, String fid) {
        return (new FinancialInstitution()).setId(id).setName(name).setUrl(url).setOrg(org).setFid(fid).saveGet();
    }
    public FinancialInstitution saveGet() {this.save(); return this;}
    public static Finder<Integer, FinancialInstitution> find = new Finder<Integer, FinancialInstitution>(Integer.class, FinancialInstitution.class);
    
    public static List<FinancialInstitution> findAll() {return find.all();}
}