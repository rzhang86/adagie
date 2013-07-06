package controllers;
import java.util.*;

import play.mvc.*;
import play.data.*;
import static play.data.Form.*;
import models.*;
import views.html.*;

public class Faq extends Controller {
    public static Result get() {
    	return ok(faq.render());
    }
}
