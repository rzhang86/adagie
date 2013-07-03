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
@Security.Authenticated(Secured.class) public class Notifications extends Controller {
    public static Result get() {
    	User user = User.findByUsername(request().username());
        return ok(notifications.render(user));
    }
    
    // only get paid if watching video is being tracked
    public static Result post() {
    	User user = User.findByUsername(request().username());
        Form<ChallengeAnswerForm> challengeAnswerForm = form(ChallengeAnswerForm.class).bindFromRequest();
        try {
        	LoginChallenge loginChallenge = LoginChallenge.find.byId(Long.parseLong(challengeAnswerForm.get().id));
            String answer = challengeAnswerForm.get().answer;
            if (loginChallenge.financialInstitutionLogin.user.equals(user)) {
        		loginChallenge.answer = answer;
        		loginChallenge.save();
        		flash("success", "Answer saved");
            }
            else flash("failure", "Answer not saved, not your challenge");
        }
        catch (Exception e) {flash("failure", "Error, answer not saved");}
        return redirect(routes.Notifications.get());
    }
    
    public static class ChallengeAnswerForm {
        public String id;
        public String answer;
    }
    
}