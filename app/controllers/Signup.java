package controllers;
import java.util.*;

import play.mvc.*;
import play.data.*;
import static play.data.Form.*;
import models.*;
import views.html.*;

public class Signup extends Controller {
    public static Result get() {
        session().clear();
    	return ok(signup.render(form(SignupForm.class)));
    }

    public static class SignupForm {
        public String email;
        public String password;
        public String passwordRepeat;
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
    public static Result post() {
        session().clear();
        Form<SignupForm> signupForm = form(SignupForm.class).bindFromRequest();
        try {
        	Map<String, String> map = signupForm.data();
        	String email;			try {email = map.get("email").trim().toLowerCase();} catch(Exception e) {email = null;}
        	String password; 		try {password = map.get("password");} catch(Exception e) {password = null;}
        	String passwordRepeat;  try {passwordRepeat = map.get("passwordRepeat");} catch(Exception e) {passwordRepeat = null;}
            Integer age;			try {age = Integer.parseInt(map.get("age").trim());} catch (Exception e) {age = null;}
            String zipCode;			try {zipCode = map.get("zipCode").trim();} catch(Exception e) {zipCode = null;}
            String gender;			try {gender = map.get("gender").trim();} catch(Exception e) {gender = null;}
            Long occupation1; 		try {occupation1 = Long.parseLong(map.get("occupation1").trim());} catch (Exception e) {occupation1 = null;}
            Long occupation2; 		try {occupation2 = Long.parseLong(map.get("occupation2").trim());} catch (Exception e) {occupation2 = null;}
            Long interest1; 		try {interest1 = Long.parseLong(map.get("interest1").trim());} catch (Exception e) {interest1 = null;}
            Long interest2; 		try {interest2 = Long.parseLong(map.get("interest2").trim());} catch (Exception e) {interest2 = null;}
            Long interest3; 		try {interest3 = Long.parseLong(map.get("interest3").trim());} catch (Exception e) {interest3 = null;}
            Long interest4; 		try {interest4 = Long.parseLong(map.get("interest4").trim());} catch (Exception e) {interest4 = null;}
            
            if (email == null || email.length() < 1 || email.length() > 63) flash("failure", "Email invalid");
            else if (User.find.where().eq("email", email).findRowCount() > 0) flash("failure", "Email already registered");
            else if (password == null || password.length() < 1 || password.length() > 31) flash("failure", "Password invalid");
            else if (passwordRepeat == null || !passwordRepeat.equals(password)) flash("failure", "Passwords do not match");
            else {
            	User user = new User();
            	user.setEmail(email);
            	user.setPassword(password);
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
            	user.setBalance(0L);
            	user.setCommittedBalance(0L);
            	user.save();
            	//Application.sendEmail(email, "Welcome to Adagie", "Your usename is " + username);
                //session("username", username);
                flash("success", "You have signed up");
                return redirect("/");
            }
        }
        catch (Exception e) {flash("failure", "Sign up failed"); e.printStackTrace();}
        return ok(signup.render(signupForm));
    }
}
