package models;

import java.util.*;
import javax.persistence.*;
import play.db.ebean.*;

@Entity public class Zip extends Model {
	@Id public String zipCode; public String getZipCode() {return this.zipCode;} public Zip setZipCode(String zipCode) {this.zipCode = zipCode; return this;}
	public String zipCodeType; public String getZipCodeType() {return this.zipCodeType;} public Zip setZipCodeType(String zipCodeType) {this.zipCodeType = zipCodeType; return this;}
	public String city; public String getCity() {return this.city;} public Zip setCity(String city) {this.city = city; return this;}
	public String state; public String getState() {return this.state;} public Zip setState(String state) {this.state = state; return this;}
	public String locationType; public String getLocationType() {return this.locationType;} public Zip setLocationType(String locationType) {this.locationType = locationType; return this;}
	public String latitude; public String getLatitude() {return this.latitude;} public Zip setLatitude(String latitude) {this.latitude = latitude; return this;}
	public String longitude; public String getLongitude() {return this.longitude;} public Zip setLongitude(String longitude) {this.longitude = longitude; return this;}
	public String location; public String getLocation() {return this.location;} public Zip setLocation(String location) {this.location = location; return this;}
	public String decommisioned; public String getDecommisioned() {return this.decommisioned;} public Zip setDecommisioned(String decommisioned) {this.decommisioned = decommisioned; return this;}
	public String taxReturnsFiled; public String getTaxReturnsFiled() {return this.taxReturnsFiled;} public Zip setTaxReturnsFiled(String taxReturnsFiled) {this.taxReturnsFiled = taxReturnsFiled; return this;}
	public String estimatedPopulation; public String getEstimatedPopulation() {return this.estimatedPopulation;} public Zip setEstimatedPopulation(String estimatedPopulation) {this.estimatedPopulation = estimatedPopulation; return this;}
	public String totalWages; public String getTotalWages() {return this.totalWages;} public Zip setTotalWages(String totalWages) {this.totalWages = totalWages; return this;}

	public Zip saveGet() {this.save(); return this;}
    public static Finder<String, Zip> find = new Finder<String, Zip>(String.class, Zip.class);
    
    public static List<Zip> findAll() {return find.all();}
}