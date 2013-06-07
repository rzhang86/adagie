package controllers;

import play.mvc.*;
import play.data.*;
import static play.data.Form.*;

import models.*;
import views.html.*;

public class Login extends Controller {  
    public static Result get() {
    	return ok(login.render(form(LoginInfo.class)));
    }

    public static class LoginInfo {
        public String username;
        public String password;
    }

    public static Result post() {
        session().clear();
        Form<LoginInfo> loginInfoForm = form(LoginInfo.class).bindFromRequest();
        try {
            String username = loginInfoForm.get().username;
            String password = loginInfoForm.get().password;
            User user = User.find.ref(username);
            if (!user.getPassword().equals(password)) flash("failure", "Invalid username/password");
            else {
                session("username", username);
                flash("success", "You have logged in");
                return redirect(routes.Index.get());
            }
        }
        catch (Exception e) {flash("failure", "Invalid username/password");}
        return redirect(routes.Login.get());
    }

    public static Result logout() {
        session().clear();
        flash("success", "You have logged out");
        return redirect(routes.Login.get());
    }
}
