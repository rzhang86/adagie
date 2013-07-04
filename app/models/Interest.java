package models;

import java.util.*;

import javax.persistence.*;

import play.db.ebean.*;

@Entity public class Interest extends Model {
	@Id public Long id; public static Finder<Long, Interest> find = new Finder<Long, Interest>(Long.class, Interest.class);

	@ManyToMany(mappedBy = "interests", cascade = CascadeType.PERSIST) public List<User> users = new ArrayList<User>();
	
	@Column(unique=true) public String name = null;
	
	public static List<Interest> findAll() {return find.findList();}


	
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