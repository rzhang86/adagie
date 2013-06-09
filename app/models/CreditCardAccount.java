package models;

import javax.persistence.*;

import play.data.validation.Constraints.*;
import play.db.ebean.*;

@Entity public class CreditCardAccount extends Model {
    @Id public Long id;
    public Long getId() {return this.id;}
    
    @Required @ManyToOne public User user;
    public CreditCardAccount setUser(User user) {this.user = user; return this;}
    public User getUser() {return this.user;}
    
    @ManyToOne public FinancialInstitution financialInstitution;
    public CreditCardAccount setFinancialInstitution(FinancialInstitution financialInstitution) {this.financialInstitution = financialInstitution; return this;}
    public FinancialInstitution getFinancialInstitution() {return this.financialInstitution;}
    
    public String ofxUser = "";
    public CreditCardAccount setOfxUser(String ofxUser) {this.ofxUser = ofxUser; return this;}
    public String getOfxUser() {return this.ofxUser;}
    
    public String ofxPassword = "";
    public CreditCardAccount setOfxPassword(String ofxPassword) {this.ofxPassword = ofxPassword; return this;}
    public String getOfxPassword() {return this.ofxPassword;}
    
    public String ccNumber = "";
    public CreditCardAccount setCcNumber(String ccNumber) {this.ccNumber = ccNumber; return this;}
    public String getCcNumber() {return this.ccNumber;}
    
    public static CreditCardAccount create(User user) {
        CreditCardAccount creditCardAccount = new CreditCardAccount();
        creditCardAccount.setUser(user);
        creditCardAccount.save();
        return creditCardAccount;
    }

    public static void destroy(CreditCardAccount creditCardAccount) {
        creditCardAccount.delete();
    }
    
    public CreditCardAccount saveGet() {this.save(); return this;}
    
    public static Finder<Long, CreditCardAccount> find = new Finder<Long, CreditCardAccount>(Long.class, CreditCardAccount.class);
}