package models;

import java.util.*;

import javax.persistence.*;
import play.db.ebean.*;
import com.avaje.ebean.*;

@Entity public class Interest extends Model {
	@Id public Integer id; public Integer getId() {return this.id;} public Interest setId(Integer id) {this.id = id; return this;}

	// has many UserInterest
    public List<UserInterest> findUserInterests() {return UserInterest.find.where().eq("interestId", id).findList();}
    
	public String name; public String getName() {return this.name;} public Interest setName(String name) {this.name = name; return this;}
    
	public static Interest create(Integer id, String name) {
        return (new Interest()).setId(id).setName(name).saveGet();
    }
	public Interest saveGet() {this.save(); return this;}
    public static Finder<Integer, Interest> find = new Finder<Integer, Interest>(Integer.class, Interest.class);
}