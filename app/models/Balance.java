package models;

import javax.persistence.*;

import play.db.ebean.*;

@Entity public class Balance extends Model {
    @Id public String username;
    public Balance setUsername(String username) {this.username = username; return this;}
    public String getUsername() {return this.username;}
    
    public Long amount = 0L;
    public Balance setAmount(Long amount) {this.amount = amount; return this;}
    public Long getAmount() {return this.amount;}

    public User findUser() {return User.find.ref(username);}
    
    public static Balance create(User user) {
        Balance balance = new Balance();
        balance.setUsername(user.getUsername());
        balance.save();
        return balance;
    }

    public static void destroy(Balance balance) {
        balance.delete();
    }
    
    public Balance saveGet() {this.save(); return this;}
    
    public static Finder<String, Balance> find = new Finder<String, Balance>(String.class, Balance.class);
}