package controllers;

import play.mvc.*;
import play.data.*;
import play.db.ebean.*;
import static play.data.Form.*;

import models.*;
import views.html.*;

public class Login extends Controller {
    public static Result login() {
        if (session().get("username") != null) return redirect(routes.Application.index());
    	//return ok(login.render(form(LoginInfo.class)));
        return ok(login.render());
    }

    public static class LoginForm {
        public String username;
        public String password;
    }

    @Transactional public static Result readLoginForm() {
        session().clear();
        Form<LoginForm> loginForm = form(LoginForm.class).bindFromRequest();
        try {
            String username = loginForm.get().username;
            String password = loginForm.get().password;
            User user = User.find.ref(username);
            if (!user.getPassword().equals(password)) flash("failure", "Invalid username/password");
            else {
                session("username", username);
                flash("success", "You have logged in");
                return redirect(routes.Application.index());
            }
        }
        catch (Exception e) {flash("failure", "Invalid username/password");}
        return ok(login.render());
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
    }

    @Transactional public static Result readSignupForm() {
        session().clear();
        Form<SignupForm> signupForm = form(SignupForm.class).bindFromRequest();
        try {
            String username = signupForm.get().username;
            System.out.println("YOLO:" + username);
            String password = signupForm.get().password;
            String passwordRepeat = signupForm.get().passwordRepeat;
            if (username.length() < 0) flash("failure", "Username must be at least 1 character");
            else if (username.length() > 31) flash("failure", "Max 31 characters in username");
            else if (User.find.where().eq("username", username).findRowCount() > 0) flash("failure", "Username already taken");
            else if (password.length() < 6) flash("failure", "Password must be at least 6 characters");
            else if (password.length() > 31) flash("failure", "Max 31 characters in password");
            else if (!password.equals(passwordRepeat)) flash("failure", "Passwords do not match");
            else {
                User.create(username, password);
                session("username", username);
                flash("success", "You have signed up");
                return redirect(routes.Application.index());
            }
        }
        catch (Exception e) {flash("failure", "Sign up failed");}
        return ok(signup.render(signupForm));
    }
}
