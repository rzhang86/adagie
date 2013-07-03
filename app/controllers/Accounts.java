package controllers;

import java.io.*;
import java.text.*;
import java.util.*;

import play.mvc.*;
import play.mvc.Http.*;
import play.mvc.Http.MultipartFormData.*;
import play.data.*;
import play.db.ebean.*;
import com.avaje.ebean.*;
import static play.data.Form.*;

import models.*;
import views.html.*;

//todo: ensure user only signed in one location, use global boolean flag
//todo: crack jep
@Security.Authenticated(Secured.class) public class Accounts extends Controller {
    public static Result get() {
    	User user = User.findByUsername(request().username());
    	return ok(accounts.render(user, form(FinancialInstitutionLoginForm.class)));
    }

    public static Result post() {
    	User user = User.findByUsername(request().username());
        Form<FinancialInstitutionLoginForm> financialInstitutionLoginForm = form(FinancialInstitutionLoginForm.class).bindFromRequest();
        try {
            String name = financialInstitutionLoginForm.get().name;
            String username = financialInstitutionLoginForm.get().username;
            String password = financialInstitutionLoginForm.get().password;
            String passwordRepeat = financialInstitutionLoginForm.get().passwordRepeat;
            FinancialInstitution financialInstitution = FinancialInstitution.find.where().eq("name", name).findUnique();
            if (username.length() < 0) flash("failure", "Username must be at least 1 character");
            else if (username.length() > 31) flash("failure", "Max 31 characters in username");
            else if (password.length() < 1) flash("failure", "Password must be at least 1 character");
            else if (password.length() > 31) flash("failure", "Max 31 characters in password");
            else if (!password.equals(passwordRepeat)) flash("failure", "Passwords do not match");
            else if (financialInstitution.id == null) flash("failure", "Malformed entry, try again");
            else {
                FinancialInstitutionLogin financialInstitutionLogin = FinancialInstitutionLogin.find.where().eq("user", user).eq("financialInstitution", financialInstitution).eq("username", username).findUnique();
                if (financialInstitutionLogin == null) {
                	financialInstitutionLogin = new FinancialInstitutionLogin();
                    financialInstitutionLogin.user = user;
                    financialInstitutionLogin.financialInstitution = financialInstitution;
                    financialInstitutionLogin.username = username;
                }
                financialInstitutionLogin.password = password;
            	financialInstitutionLogin.save();
            	flash("success", "Financial institution login saved");
            	return redirect(routes.Accounts.get());
            }
        }
        catch (Exception e) {flash("failure", "Submission failed");}
        return ok(accounts.render(user, financialInstitutionLoginForm));
    }
    
    public static Result delete(Long id) {
    	User user = User.findByUsername(request().username());
    	FinancialInstitutionLogin financialInstitutionLogin = FinancialInstitutionLogin.find.byId(id);
        if (financialInstitutionLogin.user.equals(user)) {
        	financialInstitutionLogin.delete();
            flash("success", "Login credentials deleted");
        }
        else {
            flash("failure", "You many not someone else's login credentials");
            //return forbidden();
        }
        return redirect(routes.Accounts.get());
    }
    
    public static class FinancialInstitutionLoginForm {
        public String name;
        public String username;
        public String password;
        public String passwordRepeat;
    }
}
