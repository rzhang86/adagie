package models;

import java.util.*;
import javax.persistence.*;

import play.db.ebean.*;

@Entity public class FinancialInstitution extends Model {
	@Id public Long id;	public static Finder<Long, FinancialInstitution> find = new Finder<Long, FinancialInstitution>(Long.class, FinancialInstitution.class);
	
	@OneToMany(mappedBy = "financialInstitution", cascade = CascadeType.ALL) public List<FinancialInstitutionLogin> financialInstitutionLogins = new ArrayList<FinancialInstitutionLogin>();
	
	@Column(unique=true) public Long iid = null;
	public String name = null;
    public String url = null;
    public String phone = null;
    public String address1 = null;
    public String address2 = null;
    public String address3 = null;
    public String city = null;
    public String state = null;
    public String postalCode = null;
	public String country = null;
    public String currencyCode = null;
    public String usernameKey = null;
    public String passwordKey = null;
    
    
	
	// getters/setters
    public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public List<FinancialInstitutionLogin> getFinancialInstitutionLogins() {
		return financialInstitutionLogins;
	}
	public void setFinancialInstitutionLogins(
			List<FinancialInstitutionLogin> financialInstitutionLogins) {
		this.financialInstitutionLogins = financialInstitutionLogins;
	}
	public Long getIid() {
		return iid;
	}
	public void setIid(Long iid) {
		this.iid = iid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress1() {
		return address1;
	}
	public void setAddress1(String address1) {
		this.address1 = address1;
	}
	public String getAddress2() {
		return address2;
	}
	public void setAddress2(String address2) {
		this.address2 = address2;
	}
	public String getAddress3() {
		return address3;
	}
	public void setAddress3(String address3) {
		this.address3 = address3;
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
	public String getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getCurrencyCode() {
		return currencyCode;
	}
	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}
	public String getUsernameKey() {
		return usernameKey;
	}
	public void setUsernameKey(String usernameKey) {
		this.usernameKey = usernameKey;
	}
	public String getPasswordKey() {
		return passwordKey;
	}
	public void setPasswordKey(String passwordKey) {
		this.passwordKey = passwordKey;
	}
}