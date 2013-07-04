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
        public String email;
        public String gender;
        public String age;
        public String zip;
        public String occupation1;
        public String occupation2;
        public String interest1;
        public String interest2;
        public String interest3;
        public String interest4;
    }
	
    //todo: validate username and password can only contain alphanumerics, no escape characters
    public static Result post() {
    	User user = User.findByUsername(request().username());
        Form<ProfileForm> profileForm = form(ProfileForm.class).bindFromRequest();
        try {
        	Map<String, String> map = profileForm.data();
            Integer age;			try {age = Integer.parseInt(map.get("age").trim());} catch (Exception e) {age = null;}
            String zipCode;			try {zipCode = map.get("zipCode").trim();} catch(Exception e) {zipCode = null;}
            String gender;			try {gender = map.get("gender").trim();} catch(Exception e) {gender = null;}
            Long occupation1; 		try {occupation1 = Long.parseLong(map.get("occupation1").trim());} catch (Exception e) {occupation1 = null;}
            Long occupation2; 		try {occupation2 = Long.parseLong(map.get("occupation2").trim());} catch (Exception e) {occupation2 = null;}
            Long interest1; 		try {interest1 = Long.parseLong(map.get("interest1").trim());} catch (Exception e) {interest1 = null;}
            Long interest2; 		try {interest2 = Long.parseLong(map.get("interest2").trim());} catch (Exception e) {interest2 = null;}
            Long interest3; 		try {interest3 = Long.parseLong(map.get("interest3").trim());} catch (Exception e) {interest3 = null;}
            Long interest4; 		try {interest4 = Long.parseLong(map.get("interest4").trim());} catch (Exception e) {interest4 = null;}
            
        	user.birthyear = (age != null ? Calendar.getInstance().get(Calendar.YEAR) - age : null);
        	user.gender = gender;
        	user.zip = Zip.find.where().eq("zipCode", zipCode).findUnique();
            List<Long> uniqueValues;
            uniqueValues = new ArrayList<Long>();
            if (occupation1 != -1 && !uniqueValues.contains(occupation1)) uniqueValues.add(occupation1);
            if (occupation2 != -1 && !uniqueValues.contains(occupation2)) uniqueValues.add(occupation2);
            for (Occupation occupation : user.occupations) user.occupations.remove(occupation);
            for (Long uniqueValue : uniqueValues) user.occupations.add(Occupation.find.ref(uniqueValue));
            uniqueValues = new ArrayList<Long>();
            if (interest1 != -1 && !uniqueValues.contains(interest1)) uniqueValues.add(interest1);
            if (interest2 != -1 && !uniqueValues.contains(interest2)) uniqueValues.add(interest2);
            if (interest3 != -1 && !uniqueValues.contains(interest3)) uniqueValues.add(interest3);
            if (interest4 != -1 && !uniqueValues.contains(interest4)) uniqueValues.add(interest4);
            for (Interest interest : user.interests) user.interests.remove(interest);
            for (Long uniqueValue : uniqueValues) user.interests.add(Interest.find.ref(uniqueValue));
        	user.save();
            flash("success", "Edits saved");
            return redirect("/profile");
        }
        catch (Exception e) {flash("failure", "Edits failed to save");}
        return ok(profile.render(user, profileForm));
    }
	
	public static Form<ProfileForm> getProfileForm(User user) {
    	ProfileForm profileForm = new ProfileForm();
    	profileForm.email = 		(user.email != null ? user.email : null);
    	profileForm.gender = 		(user.gender != null ? user.gender : null);
    	profileForm.age = 			(user.birthyear != null ? String.valueOf(Calendar.getInstance().get(Calendar.YEAR) - user.birthyear) : null);
    	profileForm.zip = 			(user.zip != null ? Zip.find.ref(user.zip.id).zipCode : null);
    	List<Occupation> occupations = user.occupations;
    	profileForm.occupation1 = 	(occupations.size() >= 1 ? String.valueOf(occupations.get(0).id) : null);
    	profileForm.occupation2 = 	(occupations.size() >= 2 ? String.valueOf(occupations.get(1).id) : null);
    	List<Interest> interests = user.interests;
    	profileForm.interest1 = 	(interests.size() >= 1 ? String.valueOf(interests.get(0).id) : null);
    	profileForm.interest2 = 	(interests.size() >= 2 ? String.valueOf(interests.get(1).id) : null);
    	profileForm.interest3 = 	(interests.size() >= 3 ? String.valueOf(interests.get(2).id) : null);
    	profileForm.interest4 = 	(interests.size() >= 4 ? String.valueOf(interests.get(3).id) : null);
    	Form<ProfileForm> form = form(ProfileForm.class);
    	form = form.fill(profileForm);
    	return form;
    }
}