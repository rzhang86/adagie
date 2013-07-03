package controllers;

import play.mvc.*;

@Security.Authenticated(Secured.class) public class Logout extends Controller {
	public static Result get() {
        session().clear();
        flash("success", "You have logged out");
        //return redirect(routes.Login.get());
        return redirect("/");
    }
}
