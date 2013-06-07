package models;

import javax.persistence.*;

import play.db.ebean.*;

@Entity public class CommittedBalance extends Model {
    @Id public String username;
    public String getUsername() {return this.username;}
    
    public Long amount = 0L;
    public void setAmount(Long amount) {this.amount = amount;}
    public Long getAmount() {return this.amount;}
    
    
    public static Finder<String, CommittedBalance> find = new Finder<String, CommittedBalance>(String.class, CommittedBalance.class);
    
    public CommittedBalance(String username) {
        this.username = username;
    }
}