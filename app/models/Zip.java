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
	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	public String getZipCodeType() {
		return zipCodeType;
	}
	public void setZipCodeType(String zipCodeType) {
		this.zipCodeType = zipCodeType;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getLocationType() {
		return locationType;
	}
	public void setLocationType(String locationType) {
		this.locationType = locationType;
	}
	public String getLatitude() {
		return latitude;
	}
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	public String getLongitude() {
		return longitude;
	}
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getDecommisioned() {
		return decommisioned;
	}
	public void setDecommisioned(String decommisioned) {
		this.decommisioned = decommisioned;
	}
	public String getTaxReturnsFiled() {
		return taxReturnsFiled;
	}
	public void setTaxReturnsFiled(String taxReturnsFiled) {
		this.taxReturnsFiled = taxReturnsFiled;
	}
	public String getEstimatedPopulation() {
		return estimatedPopulation;
	}
	public void setEstimatedPopulation(String estimatedPopulation) {
		this.estimatedPopulation = estimatedPopulation;
	}
	public String getTotalWages() {
		return totalWages;
	}
	public void setTotalWages(String totalWages) {
		this.totalWages = totalWages;
	}
}