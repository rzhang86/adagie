package models;

import java.util.*;
import javax.persistence.*;

import play.db.ebean.*;

@Entity public class Zip extends Model {
	@Id public Long id; public static Finder<Long, Zip> find = new Finder<Long, Zip>(Long.class, Zip.class);
	
	@OneToMany(mappedBy = "zip", cascade = CascadeType.PERSIST) public List<User> users = new ArrayList<User>();
	
	@Column(unique=true) public String zipCode = null;
	public String zipCodeType = null;
	public String city = null;
	public String state = null;
	public String locationType = null;
	public String latitude = null;
	public String longitude = null;
	public String location = null;
	public String decommisioned = null;
	public String taxReturnsFiled = null;
	public String estimatedPopulation = null;
	public String totalWages = null;
}