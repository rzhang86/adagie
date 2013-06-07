package models;

import javax.persistence.*;

import play.db.ebean.*;

@Entity public class ConsumerProfile extends Model {
    @Id public String username;
    public ConsumerProfile setUsername(String username) {this.username = username; return this;}
    public String getUsername() {return this.username;}
    
    public Long a7 = 0L;
    public ConsumerProfile setA7(Long a7) {this.a7 = a7; return this;}
    public Long getA7() {return this.a7;}
    
	public Long a30 = 0L;
    public ConsumerProfile setA30(Long a30) {this.a30 = a30; return this;}
    public Long getA30() {return this.a30;}
    
	public Long a365 = 0L;
    public ConsumerProfile setA365(Long a365) {this.a365 = a365; return this;}
    public Long getA365() {return this.a365;}
    
    public Integer f7 = 0;
    public ConsumerProfile setF7(Integer f7) {this.f7 = f7; return this;}
    public Integer getF7() {return this.f7;}
    
    public Integer f30 = 0;
    public ConsumerProfile setF30(Integer f30) {this.f30 = f30; return this;}
    public Integer getF30() {return this.f30;}
    
    public Integer f365 = 0;
    public ConsumerProfile setF365(Integer f365) {this.f365 = f365; return this;}
    public Integer getF365() {return this.f365;}

    public User findUser() {return User.find.ref(username);}
    
    public static ConsumerProfile create(User user) {
        ConsumerProfile consumerProfile = new ConsumerProfile();
        consumerProfile.setUsername(user.getUsername());
        consumerProfile.save();
        return consumerProfile;
    }
    
    public static void destroy(ConsumerProfile consumerProfile) {
        consumerProfile.delete();
    }
    
    public ConsumerProfile saveGet() {this.save(); return this;}
	
	public static Finder<String, ConsumerProfile> find = new Finder<String, ConsumerProfile>(String.class, ConsumerProfile.class);
}