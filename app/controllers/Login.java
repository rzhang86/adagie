package controllers;

import java.util.*;
import play.mvc.*;
import play.data.*;
import play.db.ebean.*;
import static play.data.Form.*;
import models.*;
import views.html.*;

public class Login extends Controller {
    public static Result get() {
        if (session().get("id") != null) return redirect("/home");
        return ok(login.render(form(LoginForm.class)));
    }
    
    public static class LoginForm {
		public String changePassword;
    	public String email;
        public String password;
    }
    
    // implement user must wait more time each time he incorrectly logs in
    public static Result post() {
        session().clear();
        Form<LoginForm> loginForm = form(LoginForm.class).bindFromRequest();
        try {
        	Map<String, String> map = loginForm.data();
        	Integer changePassword;		try {changePassword = Integer.parseInt(map.get("changePassword"));} catch (Exception e) {changePassword = null;}
        	String email;				try {email = map.get("email").trim().toLowerCase();} catch(Exception e) {email = null;}
        	String password; 			try {password = map.get("password").trim();} catch(Exception e) {password = null;}
        	User user = User.find.where().eq("email", email).findUnique();
            if (user == null) flash("failure", "Email not registered");
            else if (changePassword != null && changePassword == 1) {
            	String newPassword = String.valueOf((int) Math.abs(Math.random() * 1000000000.0) + 123456);
            	user.setPassword(newPassword);
            	user.save();
            	Application.sendEmail(user.getEmail(), "Your new Adagie password", "You have requested to reset your Adagie password.\n\nYour new password: " + newPassword + ".");
            	flash("success", "A new password has been emailed to you");
            }
            else if (password == null || !user.getPassword().equals(password)) flash("failure", "Incorrect password");
            else {
                session("id", String.valueOf(user.getId()));
                flash("success", "You have logged in");
                return redirect("/home");
            }
        }
        catch (Exception e) {flash("failure", "Invalid credentials");}
        return ok(login.render(loginForm));
    }
}