package controllers;

import play.mvc.*;
import play.data.*;
import play.db.ebean.*;
import static play.data.Form.*;

import models.*;
import views.html.*;

public class Signup extends Controller {  
    public static Result get() {
        session().clear();
    	return ok(signup.render(form(SignupInfo.class)));
    }

    public static class SignupInfo {
        public String username;
        public String password;
        public String passwordRepeat;
    }

    @Transactional public static Result post() {
        session().clear();
        Form<SignupInfo> signupInfoForm = form(SignupInfo.class).bindFromRequest();
        try {
            String username = signupInfoForm.get().username;
            String password = signupInfoForm.get().password;
            String passwordRepeat = signupInfoForm.get().passwordRepeat;
            if (User.find.where().eq("username", username).findRowCount() > 0) flash("failure", "Username already taken");
            else if (password.length() < 6) flash("failure", "Password must be at least 6 characters");
            else if (!password.equals(passwordRepeat)) flash("failure", "Passwords do not match");
            else {
                (new User(username, password)).save();
                (new Balance(username)).save();
                (new CommittedBalance(username)).save();
                (new ConsumerProfile(username)).save();
                session("username", username);
                flash("success", "You have signed up");
                return redirect(routes.Index.get());
            }
        }
        catch (Exception e) {flash("failure", "Sign up failed");}
        return redirect(routes.Signup.get());
    }
}
