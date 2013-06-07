package models;

import java.text.*;
import java.util.*;

import javax.persistence.*;

import com.singularsys.jep.Jep;
import com.singularsys.jep.standard.StandardVariableTable;

import play.data.validation.Constraints.*;
import play.db.ebean.*;

// todo: limit duration to 1 minute? infinite duration will prevent payment
// todo: may not upload videos if committed balance is negative
@Entity public class Video extends Model {
    @Id public Long id;
    public Long getId() {return this.id;}
    
    @Required @ManyToOne public User user;
    public Video setUser(User user) {this.user = user; return this;}
    public User getUser() {return this.user;}
    
    @OneToMany(cascade=CascadeType.ALL, mappedBy="video") public List<WatchedVideo> watchedVideos = new ArrayList<WatchedVideo>();
    public List<WatchedVideo> getWatchedVideos() {return this.watchedVideos;}
    
    @OneToMany(cascade=CascadeType.ALL, mappedBy="video") public List<WatchingVideo> watchingVideos = new ArrayList<WatchingVideo>();
    public List<WatchingVideo> getWatchingVideos() {return this.watchingVideos;}
    
    public String title = "Untitled";
    public Video setTitle(String title) {this.title = title; return this;}
    public String getTitle() {return this.title;}
    
    public String description = "No description";
    public Video setDescription(String description) {this.description = description; return this;}
    public String getDescription() {return this.description;}
    
    public Integer duration = 0;
    public Video setDuration(Integer duration) {this.duration = duration; return this;}
    public Integer getDuration() {return this.duration;}
    
    public String payFormula = "";
    public Video setPayFormula(String payFormula) {this.payFormula = payFormula; return this;}
    public String getPayFormula() {return this.payFormula;}
    
    public static Video create(User user) {
        Video video = new Video();
        video.setUser(user);
        video.save();
        return video;
    }

    public static void destroy(Video video) {
        video.delete();
    }
    
    public Video saveGet() {this.save(); return this;}
    
    public static Finder<Long, Video> find = new Finder<Long, Video>(Long.class, Video.class);
    
    public Long getPayout(User user) {
        try {
        	ConsumerProfile consumerProfile = ConsumerProfile.find.ref(user.getUsername());
            Jep jep = new Jep();
            jep.setComponent(new StandardVariableTable(jep.getVariableFactory()));
            jep.addVariable("a7", (double) (consumerProfile.getA7() / 100L));
            jep.addVariable("a30", (double) (consumerProfile.getA30() / 100L));
            jep.addVariable("a365", (double) (consumerProfile.getA365() / 100L));
            jep.addVariable("f7", (double) consumerProfile.getF7());
            jep.addVariable("f30", (double) consumerProfile.getF30());
            jep.addVariable("f365", (double) consumerProfile.getF365());
            jep.parse(payFormula); // todo: catch invalid parse, and check pay formula at time of video creation
            return (long) Math.ceil(Double.parseDouble(jep.evaluate().toString()) * 100.0);
        }
        catch (Exception e) {e.printStackTrace();}
        return 0L;
    }

    public static String centsToDollars(Long cents) {
        return NumberFormat.getCurrencyInstance(Locale.US).format(cents / 100.0);
    }
}