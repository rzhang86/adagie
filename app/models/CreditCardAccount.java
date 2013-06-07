package models;

import javax.persistence.*;

import play.data.validation.Constraints.*;
import play.db.ebean.*;

@Entity public class CreditCardAccount extends Model {
    @Id public Long id;
    public Long getId() {return this.id;}
    
    @Required @ManyToOne public User user;
    public User getUser() {return this.user;}
    
    public String ofxUser = "";
    public void setOfxUser(String ofxUser) {this.ofxUser = ofxUser;}
    public String getOfxUser() {return this.ofxUser;}
    
    public String ofxPassword = "";
    public void setOfxPassword(String ofxPassword) {this.ofxPassword = ofxPassword;}
    public String getOfxPassword() {return this.ofxPassword;}
    
    public String fiUrl = "";
    public void setFiUrl(String fiUrl) {this.fiUrl = fiUrl;}
    public String getFiUrl() {return this.fiUrl;}
    
    public String fiOrganizationName = "";
    public void setFiOrganizationName(String fiOrganizationName) {this.fiOrganizationName = fiOrganizationName;}
    public String getFiOrganizationName() {return this.fiOrganizationName;}
    
    public String fiId = "";
    public void setFiId(String fiId) {this.fiId = fiId;}
    public String getFiId() {return this.fiId;}
    
    public String ccNumber = ""; //todo: make unique?
    public void setCcNumber(String ccNumber) {this.ccNumber = ccNumber;}
    public String getCcNumber() {return this.ccNumber;}
    

    public CreditCardAccount(User user) {
        this.user = user;
    }
    
    public static Finder<Long, CreditCardAccount> find = new Finder<Long, CreditCardAccount>(Long.class, CreditCardAccount.class);
}