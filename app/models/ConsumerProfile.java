package models;

import javax.persistence.*;
import play.db.ebean.*;

@Entity public class ConsumerProfile extends Model {
	// has one User
	@Id public String userUsername; public String getUserUsername() {return this.userUsername;} public ConsumerProfile setUserUsername(String userUsername) {this.userUsername = userUsername; return this;}
    public User findUser() {return User.find.ref(userUsername);}
    
    public Long a7; public Long getA7() {return this.a7;} public ConsumerProfile setA7(Long a7) {this.a7 = a7; return this;}
	public Long a30; public Long getA30() {return this.a30;} public ConsumerProfile setA30(Long a30) {this.a30 = a30; return this;}
    public Long a365; public Long getA365() {return this.a365;} public ConsumerProfile setA365(Long a365) {this.a365 = a365; return this;}
    public Integer f7; public Integer getF7() {return this.f7;} public ConsumerProfile setF7(Integer f7) {this.f7 = f7; return this;}
    public Integer f30; public Integer getF30() {return this.f30;} public ConsumerProfile setF30(Integer f30) {this.f30 = f30; return this;}
    public Integer f365; public Integer getF365() {return this.f365;} public ConsumerProfile setF365(Integer f365) {this.f365 = f365; return this;}

    public static ConsumerProfile create(String userUsername, Long a7, Long a30, Long a365, Integer f7, Integer f30, Integer f365) {
    	return (new ConsumerProfile()).setUserUsername(userUsername).setA7(a7).setA30(a30).setA365(a365).setF7(f7).setF30(f30).setF365(f365).saveGet();
    }
    public ConsumerProfile saveGet() {this.save(); return this;}
    public static Finder<String, ConsumerProfile> find = new Finder<String, ConsumerProfile>(String.class, ConsumerProfile.class);
}