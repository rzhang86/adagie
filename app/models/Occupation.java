package models;

import java.util.*;
import javax.persistence.*;

import play.db.ebean.*;

@Entity public class Occupation extends Model {
	@Id public Long id; public static Finder<Long, Occupation> find = new Finder<Long, Occupation>(Long.class, Occupation.class);
	
	@ManyToMany(mappedBy = "occupations", cascade = CascadeType.PERSIST) public List<User> users = new ArrayList<User>();
	
	@Column(unique=true) public String name = null;
	
	public static List<Occupation> findAll() {return find.findList();}
	
	public static String getNameByString(String s) {
		try {return Occupation.find.byId(Long.parseLong(s)).getName();} catch (Exception e) {return "";}
	}

	
	
	// getters/setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}