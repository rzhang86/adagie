package controllers;

import java.io.*;
import java.text.*;
import java.util.*;

import play.mvc.*;
import play.mvc.Http.*;
import play.mvc.Http.MultipartFormData.*;
import play.data.*;
import play.db.ebean.*;
import com.avaje.ebean.*;
import static play.data.Form.*;

import models.*;
import views.html.*;

@Security.Authenticated(Secured.class) public class Profile extends Controller {
    public static Result get() {
    	User user = User.findByUsername(request().username());
    	return ok(profile.render(user, getProfileForm(user)));
    }
    
    //todo: validate username and password can only contain alphanumerics, no escape characters
    public static Result post() {
    	User user = User.findByUsername(request().username());
        Form<ProfileForm> profileForm = form(ProfileForm.class).bindFromRequest();
        try {
        	Map<String, String> map = profileForm.data();
        	String username = (map.containsKey("username") ? (!map.get("username").trim().equals("") ? map.get("username") : null) : null);
        	String email = (map.containsKey("email") ? (!map.get("email").trim().equals("") ? map.get("email") : null) : null);
        	String password = (map.containsKey("password") ? (!map.get("password").trim().equals("") ? map.get("password") : null) : null);
        	String passwordRepeat = (map.containsKey("passwordRepeat") ? (!map.get("passwordRepeat").trim().equals("") ? map.get("passwordRepeat") : null) : null);
            Integer age = null; try {age = Integer.parseInt(map.get("age"));} catch (Exception e) {}
            String zip = (map.containsKey("zip") ? (!map.get("zip").trim().equals("") ? map.get("zip") : null) : null);
            String gender = (map.containsKey("gender") ? (!map.get("gender").trim().equals("") ? map.get("gender") : null) : null);
            Long occupation1 = null; try {occupation1 = Long.parseLong(map.get("occupation1"));} catch (Exception e) {}
            Long occupation2 = null; try {occupation2 = Long.parseLong(map.get("occupation2"));} catch (Exception e) {}
            Long interest1 = null; try {interest1 = Long.parseLong(map.get("interest1"));} catch (Exception e) {}
            Long interest2 = null; try {interest2 = Long.parseLong(map.get("interest2"));} catch (Exception e) {}
            Long interest3 = null; try {interest3 = Long.parseLong(map.get("interest3"));} catch (Exception e) {}
            Long interest4 = null; try {interest4 = Long.parseLong(map.get("interest4"));} catch (Exception e) {}
            
            //todo: username cannot have weird characters or spaces
            if (username == null || username.length() < 1 || username.length() > 31) flash("failure", "Username invalid");
            else if (User.find.where().eq("username", username).findRowCount() > 0) flash("failure", "Username already taken");
            else if (email == null || email.length() < 1 || email.length() > 63) flash("failure", "Email invalid");
            else if (password == null || password.length() < 1 || password.length() > 31) flash("failure", "Password invalid");
            else if (passwordRepeat == null || !passwordRepeat.equals(password)) flash("failure", "Passwords do not match");
            else {
            	user.username = username;
            	user.email = email;
            	user.password = password;
            	user.birthyear = (age != null ? Calendar.getInstance().get(Calendar.YEAR) - age : null);
            	user.gender = gender;
                List<Long> uniqueValues;
                uniqueValues = new ArrayList<Long>();
                if (occupation1 != -1 && !uniqueValues.contains(occupation1)) uniqueValues.add(occupation1);
                if (occupation2 != -1 && !uniqueValues.contains(occupation2)) uniqueValues.add(occupation2);
                for (Long uniqueValue : uniqueValues) user.occupations.add(Occupation.find.ref(uniqueValue));
                uniqueValues = new ArrayList<Long>();
                if (interest1 != -1 && !uniqueValues.contains(interest1)) uniqueValues.add(interest1);
                if (interest2 != -1 && !uniqueValues.contains(interest2)) uniqueValues.add(interest2);
                if (interest3 != -1 && !uniqueValues.contains(interest3)) uniqueValues.add(interest3);
                if (interest4 != -1 && !uniqueValues.contains(interest4)) uniqueValues.add(interest4);
                for (Long uniqueValue : uniqueValues) user.interests.add(Interest.find.ref(uniqueValue));
            	user.save();
                flash("success", "You have signed up");
                return redirect(routes.Profile.get());
            }
        }
        catch (Exception e) {flash("failure", "Profile change failed"); e.printStackTrace();}
        return ok(profile.render(user, profileForm));
    }

	public static class ProfileForm {
        public String username;
        public String email;
        public String password;
        public String passwordRepeat;
        public String gender;
        public Integer age;
        public String zip;
        public Long occupation1;
        public Long occupation2;
        public Long interest1;
        public Long interest2;
        public Long interest3;
        public Long interest4;
    }
	
	public static Form<ProfileForm> getProfileForm(User user) {
    	ProfileForm profileForm = new ProfileForm();
    	profileForm.username = (user.username != null ? user.username : null);
    	profileForm.email = (user.email != null ? user.email : null);
    	profileForm.gender = (user.gender != null ? user.gender : null);
    	profileForm.age = (user.birthyear != null ? Calendar.getInstance().get(Calendar.YEAR) - user.birthyear : null);
    	Zip zip = user.zip;
    	profileForm.zip = (zip != null ? Zip.find.byId(user.zip.id).zipCode : null);
    	List<Occupation> occupations = user.occupations;
    	profileForm.occupation1 = (occupations.size() >= 1 ? occupations.get(0).id : null);
    	profileForm.occupation2 = (occupations.size() >= 2 ? occupations.get(1).id : null);
    	List<Interest> interests = user.interests;
    	profileForm.interest1 = (interests.size() >= 1 ? interests.get(0).id : null);
    	profileForm.interest2 = (interests.size() >= 2 ? interests.get(1).id : null);
    	profileForm.interest3 = (interests.size() >= 3 ? interests.get(2).id : null);
    	profileForm.interest4 = (interests.size() >= 4 ? interests.get(3).id : null);
    	Form<ProfileForm> form = form(ProfileForm.class);
    	form = form.fill(profileForm);
    	return form;
    }
}