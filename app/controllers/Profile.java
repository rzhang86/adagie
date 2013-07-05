package controllers;
import java.util.*;
import play.mvc.*;
import play.data.*;
import static play.data.Form.*;
import models.*;
import views.html.*;

@Security.Authenticated(Secured.class) public class Profile extends Controller {
    public static Result get() {
    	User user = User.findByUsername(request().username());
    	return ok(profile.render(user, getProfileForm(user)));
    }

	public static class ProfileForm {
		public String changePassword;
		public String password;
		public String newPassword;
		public String newPasswordRepeat;
        public String email;
        public String gender;
        public String age;
        public String zipCode;
        public String occupation1;
        public String occupation2;
        public String interest1;
        public String interest2;
        public String interest3;
        public String interest4;
    }
	
    //todo: validate username and password can only contain alphanumerics, no escape characters
	//todo: confirm that making new ArrayList for occupations and interests deletes old entries
	//todo: make zip selection not free entry
    public static Result post() {
    	User user = User.findByUsername(request().username());
        Form<ProfileForm> profileForm = form(ProfileForm.class).bindFromRequest();
        try {
        	Map<String, String> map = profileForm.data();
            Integer changePassword;		try {changePassword = Integer.parseInt(map.get("changePassword"));} catch (Exception e) {changePassword = null;}
            String password;			try {password = map.get("password");} catch (Exception e) {password = null;}
            String newPassword;			try {newPassword = map.get("newPassword");} catch (Exception e) {newPassword = null;}
            String newPasswordRepeat;	try {newPasswordRepeat = map.get("newPasswordRepeat");} catch (Exception e) {newPasswordRepeat = null;}
            Integer age;				try {age = Integer.parseInt(map.get("age").trim());} catch (Exception e) {age = null;}
            String zipCode;				try {zipCode = map.get("zipCode").trim();} catch(Exception e) {zipCode = null;}
            String gender;				try {gender = map.get("gender").trim();} catch(Exception e) {gender = null;}
            Long occupation1; 			try {occupation1 = Long.parseLong(map.get("occupation1").trim());} catch (Exception e) {occupation1 = null;}
            Long occupation2; 			try {occupation2 = Long.parseLong(map.get("occupation2").trim());} catch (Exception e) {occupation2 = null;}
            Long interest1; 			try {interest1 = Long.parseLong(map.get("interest1").trim());} catch (Exception e) {interest1 = null;}
            Long interest2; 			try {interest2 = Long.parseLong(map.get("interest2").trim());} catch (Exception e) {interest2 = null;}
            Long interest3; 			try {interest3 = Long.parseLong(map.get("interest3").trim());} catch (Exception e) {interest3 = null;}
            Long interest4; 			try {interest4 = Long.parseLong(map.get("interest4").trim());} catch (Exception e) {interest4 = null;}

            if (changePassword == 1) {
            	if (password == null || !user.getPassword().equals(password)) flash("failure", "Incorrect password");
            	else if (newPassword == null || newPassword.length() < 1 || newPassword.length() > 31) flash("failure", "New password invalid");
                else if (newPasswordRepeat == null || !newPasswordRepeat.equals(newPassword)) flash("failure", "New passwords do not match");
                else {
                	user.setPassword(newPassword);
                	user.setAge(age);
    	        	user.setGender(gender);
    	        	user.setZip(Zip.find.where().eq("zipCode", zipCode).findUnique());
    	            HashSet<Long> uniqueValues;
    	            uniqueValues = new HashSet<Long>();
    	            uniqueValues.add(occupation1);
    	            uniqueValues.add(occupation2);
    	            uniqueValues.remove(Long.valueOf(-1));
    	            ArrayList<Occupation> occupations = new ArrayList<Occupation>();
    	            for (Long uniqueValue : uniqueValues) occupations.add(Occupation.find.ref(uniqueValue));
    	            user.setOccupations(occupations);
    	            uniqueValues = new HashSet<Long>();
    	            uniqueValues.add(interest1);
    	            uniqueValues.add(interest2);
    	            uniqueValues.add(interest3);
    	            uniqueValues.add(interest4);
    	            uniqueValues.remove(Long.valueOf(-1));
    	            ArrayList<Interest> interests = new ArrayList<Interest>();
    	            for (Long uniqueValue : uniqueValues) interests.add(Interest.find.ref(uniqueValue));
    	            user.setInterests(interests);
    	        	user.save();
    	            flash("success", "Edits saved");
    	            return redirect("/profile");
                }
            	flash("changePassword", "1");
            }
            else {
	        	user.setAge(age);
	        	user.setGender(gender);
	        	user.setZip(Zip.find.where().eq("zipCode", zipCode).findUnique());
	            HashSet<Long> uniqueValues;
	            uniqueValues = new HashSet<Long>();
	            uniqueValues.add(occupation1);
	            uniqueValues.add(occupation2);
	            uniqueValues.remove(Long.valueOf(-1));
	            ArrayList<Occupation> occupations = new ArrayList<Occupation>();
	            for (Long uniqueValue : uniqueValues) occupations.add(Occupation.find.ref(uniqueValue));
	            user.setOccupations(occupations);
	            uniqueValues = new HashSet<Long>();
	            uniqueValues.add(interest1);
	            uniqueValues.add(interest2);
	            uniqueValues.add(interest3);
	            uniqueValues.add(interest4);
	            uniqueValues.remove(Long.valueOf(-1));
	            ArrayList<Interest> interests = new ArrayList<Interest>();
	            for (Long uniqueValue : uniqueValues) interests.add(Interest.find.ref(uniqueValue));
	            user.setInterests(interests);
	        	user.save();
	            flash("success", "Edits saved");
	            return redirect("/profile");
            }
        }
        catch (Exception e) {flash("failure", "Edits failed to save"); e.printStackTrace();}
        flash("edit", "1");
        return ok(profile.render(user, profileForm));
    }
	
	public static Form<ProfileForm> getProfileForm(User user) {
    	ProfileForm profileForm = new ProfileForm();
    	profileForm.email = user.getEmail();
    	profileForm.gender = user.getGender();
    	Integer age = user.getAge();
    	if (age != null) profileForm.age = String.valueOf(age);
    	Zip zip = user.getZip();
    	if (zip != null)profileForm.zipCode = zip.getZipCode();
    	List<Occupation> occupations = user.getOccupations();
    	if (occupations.size() > 0) profileForm.occupation1 = String.valueOf(occupations.get(0).id);
    	if (occupations.size() > 1) profileForm.occupation2 = String.valueOf(occupations.get(1).id);
    	List<Interest> interests = user.getInterests();
    	if (interests.size() > 0) profileForm.interest1 = String.valueOf(interests.get(0).id);
    	if (interests.size() > 1) profileForm.interest2 = String.valueOf(interests.get(1).id);
    	if (interests.size() > 2) profileForm.interest3 = String.valueOf(interests.get(2).id);
    	if (interests.size() > 3) profileForm.interest4 = String.valueOf(interests.get(3).id);
    	Form<ProfileForm> form = form(ProfileForm.class);
    	form = form.fill(profileForm);
    	return form;
    }
}