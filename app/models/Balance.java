package models;

import javax.persistence.*;

import play.db.ebean.*;

@Entity public class Balance extends Model {
    @Id public String username;
    public String getUsername() {return this.username;}
    
    public Long amount = 0L;
    public void setAmount(Long amount) {this.amount = amount;}
    public Long getAmount() {return this.amount;}
    
    
    public static Finder<String, Balance> find = new Finder<String, Balance>(String.class, Balance.class);
    
    public Balance (String username) {
        this.username = username;
    }
}