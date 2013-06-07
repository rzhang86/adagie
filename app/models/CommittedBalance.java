package models;

import javax.persistence.*;

import play.db.ebean.*;

@Entity public class CommittedBalance extends Model {
    @Id public String username;
    public CommittedBalance setUsername(String username) {this.username = username; return this;}
    public String getUsername() {return this.username;}
    
    public Long amount = 0L;
    public CommittedBalance setAmount(Long amount) {this.amount = amount; return this;}
    public Long getAmount() {return this.amount;}

    public User findUser() {return User.find.ref(username);}
    
    public static CommittedBalance create(User user) {
        CommittedBalance committedBalance = new CommittedBalance();
        committedBalance.setUsername(user.getUsername());
        committedBalance.save();
        return committedBalance;
    }

    public static void destroy(CommittedBalance committedBalance) {
        committedBalance.delete();
    }
    
    public CommittedBalance saveGet() {this.save(); return this;}
    
    public static Finder<String, CommittedBalance> find = new Finder<String, CommittedBalance>(String.class, CommittedBalance.class);
}