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
@Security.Authenticated(Secured.class) public class Application extends Controller {
    public static String centsToDollars(Long cents) {
        return NumberFormat.getCurrencyInstance(Locale.US).format(cents / 100.0);
    }
}
