package models;

import java.util.*;
import javax.persistence.*;

import play.db.ebean.*;

@Entity public class Occupation extends Model {
	@Id public Long id; public static Finder<Long, Occupation> find = new Finder<Long, Occupation>(Long.class, Occupation.class);
	
	@ManyToMany(mappedBy = "occupations", cascade = CascadeType.PERSIST) public List<User> users = new ArrayList<User>();
	
	@Column(unique=true) public String name = null;
	
	public static List<Occupation> findAll() {return find.orderBy("name").findList();}
}