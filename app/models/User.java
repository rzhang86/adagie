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
    
    // has many CreditCardAccount
    public List<CreditCardAccount> findCreditCardAccounts() {return CreditCardAccount.find.where().eq("userUsername", username).findList();}
    
    // has one Balance
    public Balance findBalance() {return Balance.find.ref(getUsername());}
    
    // has one CommittedBalance
    public CommittedBalance findCommittedBalance() {return CommittedBalance.find.ref(getUsername());}
    
    // has one ConsumerProfile
    public ConsumerProfile findConsumerProfile() {return ConsumerProfile.find.ref(getUsername());}
    
    // has one WatchingVideo
    public WatchingVideo findWatchingVideo() {return WatchingVideo.find.ref(getUsername());}
    
    public String password; public String getPassword() {return this.password;} public User setPassword(String password) {this.password = password; return this;}
    public String firstName; public String getFirstName() {return firstName;} public User setFirstName(String firstName) {this.firstName = firstName; return this;}
    public String middleName; public String getMiddleName() {return middleName;} public User setMiddleName(String middleName) {this.middleName = middleName; return this;}
    public String lastName; public String getLastName() {return lastName;} public User setLastName(String lastName) {this.lastName = lastName; return this;}
    public Calendar birthday; public Calendar getBirthday() {return birthday;} public User setBirthday(Calendar birthday) {this.birthday = birthday; return this;}
    public String gender; public String getGender() {return gender;} public User setGender(String gender) {this.gender = gender; return this;}
    
    public String address1Street1; public String getAddress1Street1() {return address1Street1;} public User setAddress1Street1(String address1Street1) {this.address1Street1 = address1Street1; return this;}
    public String address1Street2; public String getAddress1Street2() {return address1Street2;} public User setAddress1Street2(String address1Street2) {this.address1Street2 = address1Street2; return this;}
    public String address1City; public String getAddress1City() {return address1City;} public User setAddress1City(String address1City) {this.address1City = address1City; return this;}
    public String address1State; public String getAddress1State() {return address1State;} public User setAddress1State(String address1State) {this.address1State = address1State; return this;}
    public String address1Zip; public String getAddress1Zip() {return address1Zip;} public User setAddress1Zip(String address1Zip) {this.address1Zip = address1Zip; return this;}
    public Double address1Latitude; public Double getAddress1Latitude() {return address1Latitude;} public User setAddress1Latitude(Double address1Latitude) {this.address1Latitude = address1Latitude; return this;}
    public Double address1Longitude; public Double getAddress1Longitude() {return address1Longitude;} public User setAddress1Longitude(Double address1Longitude) {this.address1Longitude = address1Longitude; return this;}
    
    public String address2Street1; public String getAddress2Street1() {return address2Street1;} public User setAddress2Street1(String address2Street1) {this.address2Street1 = address2Street1; return this;}
    public String address2Street2; public String getAddress2Street2() {return address2Street2;} public User setAddress2Street2(String address2Street2) {this.address2Street2 = address2Street2; return this;}
    public String address2City; public String getAddress2City() {return address2City;} public User setAddress2City(String address2City) {this.address2City = address2City; return this;}
    public String address2State; public String getAddress2State() {return address2State;} public User setAddress2State(String address2State) {this.address2State = address2State; return this;}
    public String address2Zip; public String getAddress2Zip() {return address2Zip;} public User setAddress2Zip(String address2Zip) {this.address2Zip = address2Zip; return this;}
    public Double address2Latitude; public Double getAddress2Latitude() {return address2Latitude;} public User setAddress2Latitude(Double address2Latitude) {this.address2Latitude = address2Latitude; return this;}
    public Double address2Longitude; public Double getAddress2Longitude() {return address2Longitude;} public User setAddress2Longitude(Double address2Longitude) {this.address2Longitude = address2Longitude; return this;}
    
    public String email1; public String getEmail1() {return email1;} public User setEmail1(String email1) {this.email1 = email1; return this;}
    public String email2; public String getEmail2() {return email2;} public User setEmail2(String email2) {this.email2 = email2; return this;}
    
    public String phone1; public String getPhone1() {return phone1;} public User setPhone1(String phone1) {this.phone1 = phone1; return this;}
    public String phone2; public String getPhone2() {return phone2;} public User setPhone2(String phone2) {this.phone2 = phone2; return this;}
    
    public Integer occupation1; public Integer getOccupation1() {return occupation1;} public User setOccupation1(Integer occupation1) {this.occupation1 = occupation1; return this;}
    public Integer occupation2; public Integer getOccupation2() {return occupation2;} public User setOccupation2(Integer occupation2) {this.occupation2 = occupation2; return this;}
    public Integer interest1; public Integer getInterest1() {return interest1;} public User setInterest1(Integer interest1) {this.interest1 = interest1; return this;}
    public Integer interest2; public Integer getInterest2() {return interest2;} public User setInterest2(Integer interest2) {this.interest2 = interest2; return this;}
    public Integer interest3; public Integer getInterest3() {return interest3;} public User setInterest3(Integer interest3) {this.interest3 = interest3; return this;}
    public Integer interest4; public Integer getInterest4() {return interest4;} public User setInterest4(Integer interest4) {this.interest4 = interest4; return this;}
    public Integer interest5; public Integer getInterest5() {return interest5;} public User setInterest5(Integer interest5) {this.interest5 = interest5; return this;}
    
	public static User create(String username, String password, String firstName, String middleName, String lastName, Calendar birthday, String gender, String address1Street1, String address1Street2, String address1City, String address1State, String address1Zip, Double address1Latitude, Double address1Longitude, String address2Street1, String address2Street2, String address2City, String address2State, String address2Zip, Double address2Latitude, Double address2Longitude, String email1, String email2, String phone1, String phone2, Integer occupation1, Integer occupation2, Integer interest1, Integer interest2, Integer interest3, Integer interest4, Integer interest5) {
		return (new User())
        		.setUsername(username)
        		.setPassword(password)
        		.setFirstName(firstName)
        		.setMiddleName(middleName)
        		.setLastName(lastName)
        		.setBirthday(birthday)
        		.setGender(gender)
        		.setAddress1Street1(address1Street1)
        		.setAddress1Street2(address1Street2)
        		.setAddress1City(address1City)
        		.setAddress1State(address1State)
        		.setAddress1Zip(address1Zip)
        		.setAddress1Latitude(address1Latitude)
        		.setAddress1Longitude(address1Longitude)
        		.setAddress2Street1(address2Street1)
        		.setAddress2Street2(address2Street2)
        		.setAddress2City(address2City)
        		.setAddress2State(address2State)
        		.setAddress2Zip(address2Zip)
        		.setAddress2Latitude(address2Latitude)
        		.setAddress2Longitude(address2Longitude)
        		.setEmail1(email1)
        		.setEmail2(email2)
        		.setPhone1(phone1)
        		.setPhone2(phone2)
        		.setOccupation1(occupation1)
        		.setOccupation2(occupation2)
        		.setInterest1(interest1)
        		.setInterest2(interest2)
        		.setInterest3(interest3)
        		.setInterest4(interest4)
        		.setInterest5(interest5)
        		.saveGet();
    }
    public User saveGet() {this.save(); return this;}
    public static Finder<String, User> find = new Finder<String, User>(String.class, User.class);
}