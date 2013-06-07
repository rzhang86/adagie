package models;

import java.util.*;
import javax.persistence.*;

import play.data.validation.Constraints.*;
import play.db.ebean.*;

// todo: when user withdraws money, wait few hours for it to clear (in case user tries to draw again quickly to overdraw)
// todo: fix optimisticlockexception jpa
@Entity public class User extends Model {
    @Id public String username;
    public String getUsername() {return this.username;}
    
    @Required public String password;
    public void setPassword(String password) {this.password = password;}
    public String getPassword() {return this.password;}
    
    @OneToMany(cascade=CascadeType.ALL, mappedBy="user") public List<Video> videos = new ArrayList<Video>();
    public List<Video> getVideos() {return this.videos;}
    
    @OneToMany(cascade=CascadeType.ALL, mappedBy="user") public List<WatchedVideo> watchedVideos = new ArrayList<WatchedVideo>();
    public List<WatchedVideo> getWatchedVideos() {return this.watchedVideos;}
    
    @OneToMany(cascade=CascadeType.ALL, mappedBy="user") public List<CreditCardAccount> creditCardAccounts = new ArrayList<CreditCardAccount>();
    public List<CreditCardAccount> getCreditCardAccounts() {return this.creditCardAccounts;}
    
    
    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }
    
    public static Finder<String, User> find = new Finder<String, User>(String.class, User.class);
}