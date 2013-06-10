package models;

import java.util.*;
import javax.persistence.*;
import play.db.ebean.*;
import com.avaje.ebean.*;

@Entity public class Occupation extends Model {
	@Id public Integer id; public Integer getId() {return this.id;} public Occupation setId(Integer id) {this.id = id; return this;}

	// has many User
	public List<User> findUsers() {return User.find.where().disjunction().add(Expr.eq("occupation1", id)).add(Expr.eq("occupation2", id)).findList();}
	
	public String name; public String getName() {return this.name;} public Occupation setName(String name) {this.name = name; return this;}
    
	public static Occupation create(Integer id, String name) {
        return (new Occupation()).setId(id).setName(name).saveGet();
    }
	public Occupation saveGet() {this.save(); return this;}
    public static Finder<String, Occupation> find = new Finder<String, Occupation>(String.class, Occupation.class);
}