package models;

import java.util.*;

import javax.persistence.*;
import play.db.ebean.*;

@Entity public class FinancialInstitution extends Model {
	@Id public Long id; public Long getId() {return this.id;} public FinancialInstitution setId(Long id) {this.id = id; return this;}
    
	// has many FinancialInstitutionLogin
	public List<FinancialInstitutionLogin> findFinancialInstitutionLogins() {return FinancialInstitutionLogin.find.where().eq("financialInstutionId", id).findList();}
    
    public String name;  public String getName() {return this.name;} public FinancialInstitution setName(String name) {this.name = name; return this;}
    public String url; public String getUrl() {return this.url;} public FinancialInstitution setUrl(String url) {this.url = url; return this;}
     
    public String phone; public String getPhone() {return this.phone;} public FinancialInstitution setPhone(String phone) {this.phone = phone; return this;}
    public String address1; public String getAddress1() {return this.address1;} public FinancialInstitution setAddress1(String address1) {this.address1 = address1; return this;}
    public String address2; public String getAddress2() {return this.address2;} public FinancialInstitution setAddress2(String address2) {this.address2 = address2; return this;}
    public String address3; public String getAddress3() {return this.address3;} public FinancialInstitution setAddress3(String address3) {this.address3 = address3; return this;}
    public String city; public String getCity() {return this.city;} public FinancialInstitution setCity(String city) {this.city = city; return this;}
    public String state; public String getState() {return this.state;} public FinancialInstitution setState(String state) {this.state = state; return this;}
    public String postalCode; public String getPostalCode() {return this.postalCode;} public FinancialInstitution setPostalCode(String postalCode) {this.postalCode = postalCode; return this;}
    public String country; public String getCountry() {return this.country;} public FinancialInstitution setCountry(String country) {this.country = country; return this;}
    public String currencyCode; public String getCurrencyCode() {return this.currencyCode;} public FinancialInstitution setCurrencyCode(String currencyCode) {this.currencyCode = currencyCode; return this;}

    public String usernameKey; public String getUsernameKey() {return this.usernameKey;} public FinancialInstitution setUsernameKey(String usernameKey) {this.usernameKey = usernameKey; return this;}
    public String passwordKey; public String getPasswordKey() {return this.passwordKey;} public FinancialInstitution setPasswordKey(String passwordKey) {this.passwordKey = passwordKey; return this;}
    
    public static FinancialInstitution create(Long id, String name, String url, String phone, String address1, String address2, String address3, String city, String state, String postalCode, String country, String currencyCode, String usernameKey, String passwordKey) {
        return (new FinancialInstitution()).setId(id).setName(name).setUrl(url).setPhone(phone).setAddress1(address1).setAddress2(address2).setAddress3(address3).setCity(city).setState(state).setPostalCode(postalCode).setCountry(country).setCurrencyCode(currencyCode).setUsernameKey(usernameKey).setPasswordKey(passwordKey).saveGet();
    }
    public FinancialInstitution saveGet() {this.save(); return this;}
    public static Finder<Long, FinancialInstitution> find = new Finder<Long, FinancialInstitution>(Long.class, FinancialInstitution.class);
    
    public static List<FinancialInstitution> findAll() {return find.all();}
}