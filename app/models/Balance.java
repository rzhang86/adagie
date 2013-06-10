package models;

import javax.persistence.*;
import play.db.ebean.*;

@Entity public class Balance extends Model {
	// has one User
    @Id public String userUsername; public String getUserUsername() {return this.userUsername;} public Balance setUserUsername(String userUsername) {this.userUsername = userUsername; return this;}
    public User findUser() {return User.find.ref(userUsername);}
    
    public Long amount; public Long getAmount() {return this.amount;} public Balance setAmount(Long amount) {this.amount = amount; return this;}
    
    public static Balance create(String userUsername, Long amount) {
    	return (new Balance()).setUserUsername(userUsername).setAmount(amount).saveGet();
    }
    public Balance saveGet() {this.save(); return this;}
    public static Finder<String, Balance> find = new Finder<String, Balance>(String.class, Balance.class);
    
    public Balance addAmount(Long delta) {
        this.amount += delta;
        return this.saveGet();
    }
}