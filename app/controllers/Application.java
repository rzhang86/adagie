package controllers;

import java.text.*;
import java.util.*;
import play.mvc.*;

//todo: ensure user only signed in one location, use global boolean flag
//todo: crack jep
@Security.Authenticated(Secured.class) public class Application extends Controller {
    public static String centsToDollars(Long cents) {
        return NumberFormat.getCurrencyInstance(Locale.US).format(cents / 100.0);
    }
}
