package controllers;
import static play.data.Form.form;

import java.text.*;
import java.util.*;
import play.mvc.*;
import views.html.login;
import org.apache.commons.mail.*;

//todo: ensure user only signed in one location, use global boolean flag
//todo: crack jep
@Security.Authenticated(Secured.class) public class Application extends Controller {
    public static String centsToDollars(Long cents) {
        return NumberFormat.getCurrencyInstance(Locale.US).format(cents / 100.0);
    }
    
    public static void sendEmail(String address, String subject, String message) {
    	try {
	    	Email e = new SimpleEmail();
	    	e.setHostName("smtp.googlemail.com");
	    	e.setSmtpPort(465);
	    	e.setAuthenticator(new DefaultAuthenticator("bibimbop9", "S1_jeec87"));
	    	e.setSSLOnConnect(true);
	    	e.setFrom("info@Adagie.com");
	    	e.setSubject(subject);
	    	e.setMsg(message);
	    	e.addTo(address);
	    	e.send();
    	} catch (Exception e) {}
    }
}
