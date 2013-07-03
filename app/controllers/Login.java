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
        if (session().get("username") != null) return redirect(routes.Home.get());
        return ok(index.render());
    }
    
    public static Result post() {
        session().clear();
        Form<LoginForm> loginForm = form(LoginForm.class).bindFromRequest();
        try {
        	Map<String, String> map = loginForm.data();
        	String username = (map.containsKey("username") ? map.get("username") : null);
        	String password = (map.containsKey("password") ? map.get("password") : null);
            //String username = loginForm.get().username;
            //String password = loginForm.get().password;
            User user = User.find.where().eq("username", username).findUnique();
            if (!user.password.equals(password)) flash("failure", "Invalid username/password");
            else {
                session("username", username);
                flash("success", "You have logged in");
                return redirect(routes.Home.get());
            }
        }
        catch (Exception e) {flash("failure", "Invalid username/password");}
        return redirect(routes.Login.get());
    }
    
    public static class LoginForm {
        public String username;
        public String password;
    }
}