package controllers;
import java.util.*;
import org.apache.commons.mail.*;
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
        session().clear();
        Form<SignupForm> signupForm = form(SignupForm.class).bindFromRequest();
        try {
        	Map<String, String> map = signupForm.data();
        	String email;			try {email = map.get("email").trim().toLowerCase();} catch(Exception e) {email = null;}
        	String password; 		try {password = map.get("password").trim();} catch(Exception e) {password = null;}
        	String passwordRepeat;  try {passwordRepeat = map.get("passwordRepeat").trim();} catch(Exception e) {passwordRepeat = null;}
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
            	user.email = email;
            	user.password = password;
            	user.birthyear = (age != null ? Calendar.getInstance().get(Calendar.YEAR) - age : null);
            	user.gender = gender;
            	user.zip = Zip.find.where().eq("zipCode", zipCode).findUnique();
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
            	user.balance = 0L;
            	user.committedBalance = 0L;
            	user.save();
                //session("username", username);

            	/*
            	Email e = new SimpleEmail();
            	e.setHostName("smtp.googlemail.com");
            	e.setSmtpPort(465);
            	e.setAuthenticator(new DefaultAuthenticator("bibimbop9", "S1_jeec87"));
            	e.setSSLOnConnect(true);
            	e.setFrom("info@Adagie.com");
            	e.setSubject("Welcome to Adagie");
            	e.setMsg("Your usename is " + username);
            	e.addTo(email);
            	e.send();
            	*/
            	
                flash("success", "You have signed up");
                return redirect("/");
            }
        }
        catch (Exception e) {flash("failure", "Sign up failed");}
        return ok(signup.render(signupForm));
    }
}
