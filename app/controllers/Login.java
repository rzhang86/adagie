package controllers;

import java.util.*;
import play.mvc.*;
import play.data.*;
import play.db.ebean.*;
import static play.data.Form.*;

import models.*;
import views.html.*;

public class Login extends Controller {
    public static Result login() {
        if (session().get("username") != null) return redirect(routes.Application.index());
        return ok(login.render());
    }

    public static class LoginForm {
        public String username;
        public String password;
    }

    public static Result readLoginForm() {
        session().clear();
        Form<LoginForm> loginForm = form(LoginForm.class).bindFromRequest();
        try {
            String username = loginForm.get().username;
            String password = loginForm.get().password;
            User user = User.find.where().eq("username", username).findUnique();
            if (!user.password.equals(password)) flash("failure", "Invalid username/password");
            else {
                session("username", username);
                flash("success", "You have logged in");
                return redirect(routes.Application.index());
            }
        }
        catch (Exception e) {flash("failure", "Invalid username/password");}
        return redirect(routes.Login.login());
    }

    public static Result logout() {
        session().clear();
        flash("success", "You have logged out");
        return redirect(routes.Login.login());
    }
    
    public static Result signup() {
        session().clear();
    	return ok(signup.render(form(SignupForm.class)));
    }

    public static class SignupForm {
        public String username;
        public String password;
        public String passwordRepeat;
        public String email;
        public String gender;
        public Integer birthyear;
        public String zip;
        public Integer occupation1;
        public Integer occupation2;
        public Integer interest1;
        public Integer interest2;
        public Integer interest3;
        public Integer interest4;
        public Integer interest5;
    }

    //todo: validate username and password can only contain alphanumerics, no escape characters
    public static Result readSignupForm() {
        session().clear();
        Form<SignupForm> signupForm = form(SignupForm.class).bindFromRequest();
        try {
            String username = signupForm.get().username;
            String password = signupForm.get().password;
            String passwordRepeat = signupForm.get().passwordRepeat;
            String email = signupForm.get().email;
            String gender = signupForm.get().gender;
            Integer birthyear = signupForm.get().birthyear;
            String zip = signupForm.get().zip;
            /*Integer occupation1 = signupForm.get().occupation1;
            Integer occupation2 = signupForm.get().occupation2;
            Integer interest1 = signupForm.get().interest1;
            Integer interest2 = signupForm.get().interest2;
            Integer interest3 = signupForm.get().interest3;
            Integer interest4 = signupForm.get().interest4;
            Integer interest5 = signupForm.get().interest5;*/
            
            if (username.length() < 0) flash("failure", "Username must be at least 1 character");
            else if (username.length() > 31) flash("failure", "Max 31 characters in username");
            else if (User.find.where().eq("username", username).findRowCount() > 0) flash("failure", "Username already taken");
            else if (password.length() < 6) flash("failure", "Password must be at least 6 characters");
            else if (password.length() > 31) flash("failure", "Max 31 characters in password");
            else if (!password.equals(passwordRepeat)) flash("failure", "Passwords do not match");
            else if (email.length() > 63) flash("failure", "Max 63 characters in email");
            else {
            	User user = new User();
            	user.username = username;
            	user.password = password;
            	user.email = email;
            	user.gender = gender;
            	user.birthyear = birthyear;
            	user.balance = 0L;
            	user.committedBalance = 0L;
            	user.save();
                /*List<Integer> uniqueValues;
                uniqueValues = new ArrayList<Integer>();
                if (occupation1 != 1 && !uniqueValues.contains(occupation1)) uniqueValues.add(occupation1);
                if (occupation2 != 1 && !uniqueValues.contains(occupation2)) uniqueValues.add(occupation2);
                for (Integer uniqueValue : uniqueValues) UserOccupation.create(username, uniqueValue);
                uniqueValues = new ArrayList<Integer>();
                if (interest1 != 1 && !uniqueValues.contains(interest1)) uniqueValues.add(interest1);
                if (interest2 != 1 && !uniqueValues.contains(interest2)) uniqueValues.add(interest2);
                if (interest3 != 1 && !uniqueValues.contains(interest3)) uniqueValues.add(interest3);
                if (interest4 != 1 && !uniqueValues.contains(interest4)) uniqueValues.add(interest4);
                if (interest5 != 1 && !uniqueValues.contains(interest5)) uniqueValues.add(interest5);
                for (Integer uniqueValue : uniqueValues) UserInterest.create(username, uniqueValue);*/
                session("username", username);
                flash("success", "You have signed up");
                return redirect(routes.Application.index());
            }
        }
        catch (Exception e) {flash("failure", "Sign up failed");}
        return ok(signup.render(signupForm));
    }
}
