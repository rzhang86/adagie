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

    @Column(unique=true) public String email = null;
    public String password = null;
    public String gender = null;
    public Integer birthyear = null;
    
    public Long balance = null;
    public Long committedBalance = null;
    public Long watchingStartTime = null;
    public Long watchingEndTime = null;
    public Long watchingPayout = null;
    
    public String username = null;
    
    public static User findByUsername(String username) {
    	try {return User.find.byId(Long.parseLong(username));} catch (Exception e) {return null;}
    }
    
    public Long getPayout(Video video) {
    	try {return video.getPayout(this);} catch (Exception e) {return null;}
    }

    public Integer getAge() {
    	try {return Calendar.getInstance().get(Calendar.YEAR) - this.birthyear;} catch (Exception e) {return null;}
    }
    
    public void setAge(Integer age) {
    	try {this.birthyear = Calendar.getInstance().get(Calendar.YEAR) - age;} catch (Exception e) {this.birthyear = null;}
    }
    
    
    
    // getters/setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<Video> getVideos() {
		return videos;
	}

	public void setVideos(List<Video> videos) {
		this.videos = videos;
	}

	public List<WatchedVideo> getWatchedVideos() {
		return watchedVideos;
	}

	public void setWatchedVideos(List<WatchedVideo> watchedVideos) {
		this.watchedVideos = watchedVideos;
	}

	public List<FinancialInstitutionLogin> getFinancialInstitutionLogins() {
		return financialInstitutionLogins;
	}

	public void setFinancialInstitutionLogins(
			List<FinancialInstitutionLogin> financialInstitutionLogins) {
		this.financialInstitutionLogins = financialInstitutionLogins;
	}

	public List<UserVariable> getUserVariables() {
		return userVariables;
	}

	public void setUserVariables(List<UserVariable> userVariables) {
		this.userVariables = userVariables;
	}

	public Video getWatchingVideo() {
		return watchingVideo;
	}

	public void setWatchingVideo(Video watchingVideo) {
		this.watchingVideo = watchingVideo;
	}

	public Zip getZip() {
		return zip;
	}

	public void setZip(Zip zip) {
		this.zip = zip;
	}

	public List<Occupation> getOccupations() {
		return occupations;
	}

	public void setOccupations(List<Occupation> occupations) {
		this.occupations = occupations;
	}

	public List<Interest> getInterests() {
		return interests;
	}

	public void setInterests(List<Interest> interests) {
		this.interests = interests;
	}

	public List<Zip> getZips() {
		return zips;
	}

	public void setZips(List<Zip> zips) {
		this.zips = zips;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Integer getBirthyear() {
		return birthyear;
	}

	public void setBirthyear(Integer birthyear) {
		this.birthyear = birthyear;
	}

	public Long getBalance() {
		return balance;
	}

	public void setBalance(Long balance) {
		this.balance = balance;
	}

	public Long getCommittedBalance() {
		return committedBalance;
	}

	public void setCommittedBalance(Long committedBalance) {
		this.committedBalance = committedBalance;
	}

	public Long getWatchingStartTime() {
		return watchingStartTime;
	}

	public void setWatchingStartTime(Long watchingStartTime) {
		this.watchingStartTime = watchingStartTime;
	}

	public Long getWatchingEndTime() {
		return watchingEndTime;
	}

	public void setWatchingEndTime(Long watchingEndTime) {
		this.watchingEndTime = watchingEndTime;
	}

	public Long getWatchingPayout() {
		return watchingPayout;
	}

	public void setWatchingPayout(Long watchingPayout) {
		this.watchingPayout = watchingPayout;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
}