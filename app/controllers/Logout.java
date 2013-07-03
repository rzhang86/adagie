package controllers;

import play.mvc.*;
import play.mvc.Http.*;
import play.mvc.Http.MultipartFormData.*;
import play.data.*;
import play.db.ebean.*;
import com.avaje.ebean.*;
import static play.data.Form.*;

import models.*;
import views.html.*;

@Security.Authenticated(Secured.class) public class Logout extends Controller {
	public static Result get() {
        session().clear();
        flash("success", "You have logged out");
        return redirect(routes.Login.get());
    }
}
