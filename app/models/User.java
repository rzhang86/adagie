package models;

import java.util.*;

import javax.persistence.*;

import play.db.ebean.*;

// todo: when user withdraws money, wait few hours for it to clear (in case user tries to draw again quickly to overdraw)
// todo: fix optimisticlockexception jpa
// todo: add forgot your password? page
@Entity public class User extends Model {
	@Id public Long id; public static Finder<Long, User> find = new Finder<Long, User>(Long.class, User.class);
	
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL) public List<Video> videos = new ArrayList<Video>();
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL) public List<WatchedVideo> watchedVideos = new ArrayList<WatchedVideo>();
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL) public List<FinancialInstitutionLogin> financialInstitutionLogins = new ArrayList<FinancialInstitutionLogin>();
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL) public List<UserVariable> userVariables = new ArrayList<UserVariable>();
    
    @ManyToOne public Video watchingVideo = null;
    @ManyToOne public Zip zip = null;
    
    @ManyToMany public List<Occupation> occupations = new ArrayList<Occupation>();
    @ManyToMany public List<Interest> interests = new ArrayList<Interest>();
    @ManyToMany public List<Zip> zips = new ArrayList<Zip>();

    @Column(unique=true) public String username = null;
    public String password = null;
    public String email = null;
    public String gender = null;
    public Integer birthyear = null;
    
    public Long balance = null;
    public Long committedBalance = null;
    public Long watchingStartTime = null;
    public Long watchingEndTime = null;
    public Long watchingPayout = null;
    
    public static User findByUsername(String username) {return find.where().eq("username", username).findUnique();}
    
    public Long getPayout(Video video) {
    	return video.getPayout(this);
    }
}