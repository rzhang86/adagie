package models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import play.data.validation.Constraints.*;
import play.db.ebean.*;

@Entity public class FinancialInstitution extends Model {
    @Id public Long id;
    public Long getId() {return this.id;}
    
    @OneToMany(cascade=CascadeType.ALL, mappedBy="financialInstitution") public List<CreditCardAccount> creditCardAccounts = new ArrayList<CreditCardAccount>();
    public List<CreditCardAccount> getCreditCardAccounts() {return this.creditCardAccounts;}
    
    public String name = "";
    public FinancialInstitution setName(String name) {this.name = name; return this;}
    public String getName() {return this.name;}
    
    public String url = "";
    public FinancialInstitution setUrl(String url) {this.url = url; return this;}
    public String getUrl() {return this.url;}
    
    public String org = "";
    public FinancialInstitution setOrg(String org) {this.org = org; return this;}
    public String getOrg() {return this.org;}
    
    public String fid = "";
    public FinancialInstitution setFid(String fid) {this.fid = fid; return this;}
    public String getFid() {return this.fid;}
    
    public FinancialInstitution(Long id) {
    	this.id = id;
    }
    
    public static FinancialInstitution create(Long id) {
        FinancialInstitution financialInstitution = new FinancialInstitution(id);
        financialInstitution.save();
        return financialInstitution;
    }

    public static void destroy(FinancialInstitution financialInstitution) {
    	financialInstitution.delete();
    }
    
    public FinancialInstitution saveGet() {this.save(); return this;}
    
    public static Finder<Long, FinancialInstitution> find = new Finder<Long, FinancialInstitution>(Long.class, FinancialInstitution.class);
}