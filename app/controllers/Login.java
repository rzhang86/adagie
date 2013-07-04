package controllers;

import java.util.*;
import org.apache.commons.mail.*;
import play.mvc.*;
import play.data.*;
import play.db.ebean.*;
import static play.data.Form.*;
import models.*;
import views.html.*;

public class Login extends Controller {
    public static Result get() {
        if (session().get("id") != null) return redirect("/home");
        return ok(login.render());
    }
    
    public static class LoginForm {
    	public String email;
        public String password;
    }
    
    // implement user must wait more time each time he incorrectly logs in
    public static Result post() {
        session().clear();
        Form<LoginForm> loginForm = form(LoginForm.class).bindFromRequest();
        try {
        	Map<String, String> map = loginForm.data();
        	String email;		try {email = map.get("email").trim().toLowerCase();} catch(Exception e) {email = null;}
        	String password; 	try {password = map.get("password").trim();} catch(Exception e) {password = null;}
            User user = User.find.where().eq("email", email).findUnique();
            if (user == null) flash("failure", "Email not registered");
            else if (!user.password.equals(password)) flash("failure", "Incorrect password");
            else {
                session("id", String.valueOf(user.id));
                flash("success", "You have logged in");
                return redirect("/home");
            }
        }
        catch (Exception e) {flash("failure", "Invalid credentials");}
        return redirect("/");
    }
}