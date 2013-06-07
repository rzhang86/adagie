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
    public User getUser() {return this.user;}
    
    @OneToMany(cascade=CascadeType.ALL, mappedBy="video") public List<WatchedVideo> watchedVideos = new ArrayList<WatchedVideo>();
    public List<WatchedVideo> getWatchedVideos() {return this.watchedVideos;}
    
    public String title = "Untitled";
    public void setTitle(String title) {this.title = title;}
    public String getTitle() {return this.title;}
    
    public String description = "No description";
    public void setDescription(String description) {this.description = description;}
    public String getDescription() {return this.description;}
    
    public Integer duration = 0;
    public void setDuration(Integer duration) {this.duration = duration;}
    public Integer getDuration() {return this.duration;}
    
    public String payFormula = "";
    public void setPayFormula(String payFormula) {this.payFormula = payFormula;}
    public String getPayFormula() {return this.payFormula;}
    
    
    public Video(User user) {
        this.user = user;
    }
    
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