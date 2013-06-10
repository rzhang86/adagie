package models;

import javax.persistence.*;
import play.db.ebean.*;

@Entity public class CommittedBalance extends Model {
	// has one User
    @Id public String userUsername; public String getUserUsername() {return this.userUsername;} public CommittedBalance setUserUsername(String userUsername) {this.userUsername = userUsername; return this;}
    public User findUser() {return User.find.ref(userUsername);}
    
    public Long amount; public Long getAmount() {return this.amount;} public CommittedBalance setAmount(Long amount) {this.amount = amount; return this;}
    
    public static CommittedBalance create(String userUsername, Long amount) {
    	return (new CommittedBalance()).setUserUsername(userUsername).setAmount(amount).saveGet();
    }
    public CommittedBalance saveGet() {this.save(); return this;}
    public static Finder<String, CommittedBalance> find = new Finder<String, CommittedBalance>(String.class, CommittedBalance.class);
}