package models;

import java.util.*;
import javax.persistence.*;

import play.data.validation.Constraints.*;
import play.db.ebean.*;

// todo: when user withdraws money, wait few hours for it to clear (in case user tries to draw again quickly to overdraw)
// todo: fix optimisticlockexception jpa
@Entity public class User extends Model {
    @Id public String username;
    public User setUsername(String username) {this.username = username; return this;}
    public String getUsername() {return this.username;}
    
    @Required public String password;
    public User setPassword(String password) {this.password = password; return this;}
    public String getPassword() {return this.password;}
    
    @OneToMany(cascade=CascadeType.ALL, mappedBy="user") public List<Video> videos = new ArrayList<Video>();
    public List<Video> getVideos() {return this.videos;}
    
    @OneToMany(cascade=CascadeType.ALL, mappedBy="user") public List<WatchedVideo> watchedVideos = new ArrayList<WatchedVideo>();
    public List<WatchedVideo> getWatchedVideos() {return this.watchedVideos;}
    
    @OneToMany(cascade=CascadeType.ALL, mappedBy="user") public List<CreditCardAccount> creditCardAccounts = new ArrayList<CreditCardAccount>();
    public List<CreditCardAccount> getCreditCardAccounts() {return this.creditCardAccounts;}

    public Balance findBalance() {return Balance.find.ref(getUsername());}
    public CommittedBalance findCommittedBalance() {return CommittedBalance.find.ref(getUsername());}
    public ConsumerProfile findConsumerProfile() {return ConsumerProfile.find.ref(getUsername());}
    public WatchingVideo findWatchingVideo() {return WatchingVideo.find.ref(getUsername());}
    
    public static User create(String username, String password) {
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.save();
        Balance.create(user);
        CommittedBalance.create(user);
        ConsumerProfile.create(user);
        WatchingVideo.create(user);
        return user;
    }

    public static void destroy(User user) {
        user.findBalance().delete();
        user.findCommittedBalance().delete();
        user.findConsumerProfile().delete();
        user.findWatchingVideo().delete();
        user.delete();
    }
    
    public User saveGet() {this.save(); return this;}
    
    public static Finder<String, User> find = new Finder<String, User>(String.class, User.class);
}