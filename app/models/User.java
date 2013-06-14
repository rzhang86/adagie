package models;

import java.util.*;
import javax.persistence.*;
import play.db.ebean.*;

// todo: when user withdraws money, wait few hours for it to clear (in case user tries to draw again quickly to overdraw)
// todo: fix optimisticlockexception jpa
// todo: add forgot your password? page
@Entity public class User extends Model {
    @Id public String username; public String getUsername() {return this.username;} public User setUsername(String username) {this.username = username; return this;}
    
    // has many Video
    public List<Video> findVideos() {return Video.find.where().eq("userUsername", username).findList();}
    
    // has many WatchedVideo
    public List<WatchedVideo> findWatchedVideos() {return WatchedVideo.find.where().eq("userUsername", username).findList();}
    
    // has many FinancialInstitutionLogin
    public List<FinancialInstitutionLogin> findFinancialInstitutionLogins() {return FinancialInstitutionLogin.find.where().eq("userUsername", username).findList();}
    
    // has many UserVariable
    public List<UserVariable> findUserVariables() {return UserVariable.find.where().eq("userUsername", username).findList();}
    
    // has one Balance
    public Balance findBalance() {return Balance.find.ref(getUsername());}
    
    // has one CommittedBalance
    public CommittedBalance findCommittedBalance() {return CommittedBalance.find.ref(getUsername());}
    
    // has one ConsumerProfile
    public ConsumerProfile findConsumerProfile() {return ConsumerProfile.find.ref(getUsername());}
    
    // has one WatchingVideo
    public WatchingVideo findWatchingVideo() {return WatchingVideo.find.ref(getUsername());}
    
    public String password; public String getPassword() {return this.password;} public User setPassword(String password) {this.password = password; return this;}
    public String email; public String getEmail() {return email;} public User setEmail(String email) {this.email = email; return this;}
    
    public String gender; public String getGender() {return gender;} public User setGender(String gender) {this.gender = gender; return this;}
    public Integer birthyear; public Integer getBirthyear() {return birthyear;} public User setBirthyear(Integer birthyear) {this.birthyear = birthyear; return this;}
    public Double latitude; public Double getLatitude() {return latitude;} public User setLatitude(Double latitude) {this.latitude = latitude; return this;}
    public Double longitude; public Double getLongitude() {return longitude;} public User setLongitude(Double longitude) {this.longitude = longitude; return this;}
    
    // can have up to two UserOccupation
    public List<UserOccupation> findUserOccupations() {return UserOccupation.find.where().eq("userUsername", username).findList();}
    
    // can have up to five UserInterest
    public List<UserInterest> findUserInterests() {return UserInterest.find.where().eq("userUsername", username).findList();}
    
	public static User create(String username, String password, String email, String gender, Integer birthyear, Double latitude, Double longitude) {
		return (new User()).setUsername(username).setPassword(password).setEmail(email).setGender(gender).setBirthyear(birthyear).setLatitude(latitude).setLongitude(longitude).saveGet();
    }
    public User saveGet() {this.save(); return this;}
    public static Finder<String, User> find = new Finder<String, User>(String.class, User.class);
}