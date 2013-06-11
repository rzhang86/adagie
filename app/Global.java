import java.sql.*;
import java.text.*;
import java.util.*;
import java.util.Date;

import com.avaje.ebean.*;

import play.*;
import play.libs.*;

import models.*;

//todo: delete videos after not having paid out or watched in X time
public class Global extends GlobalSettings {
    public Thread consumerProfileUpdaterThread = new Thread(new ConsumerProfileUpdater());
    public static boolean applicationIsLive = false;
    
    @Override public void onStart(Application app) {
        // Check if the database is empty
        if (User.find.findRowCount() == 0) {
            Ebean.save((List) Yaml.load("data-FinancialInstitution.yml"));
            Ebean.save((List) Yaml.load("data-Occupation.yml"));
            Ebean.save((List) Yaml.load("data-Interest.yml"));
            Ebean.save((List) Yaml.load("data-Zip.yml"));
            
            User.create("Ray", "secret", null, null, null, null, null);
            Balance.create("Ray", 10000L);
            CommittedBalance.create("Ray", 10000L);
            ConsumerProfile.create("Ray", 0L, 0L, 0L, 0, 0, 0);
            WatchingVideo.create("Ray", null, null, null);
            CreditCardAccount.create("Ray", 424, "cim2phat4u", "zhaamE_263", "379718849191002");
            
            User.create("Katie", "secret", null, null, null, null, null);
            Balance.create("Katie", 10000L);
            CommittedBalance.create("Katie", 10000L);
            ConsumerProfile.create("Katie", 0L, 0L, 0L, 0, 0, 0);
            WatchingVideo.create("Katie", null, null, null);
            CreditCardAccount.create("Katie", 427, "kwang318", "651Anthony3083", "4128003460359667");
        }

        // start looping maintenance threads
        applicationIsLive = true;
        consumerProfileUpdaterThread.start();
    }
    
    @Override public void onStop(Application app) {
        // signal maintenance threads to stop
        applicationIsLive = false;
        try {consumerProfileUpdaterThread.join();} catch (Exception e) {}
    }
    
    public static class ConsumerProfileUpdater implements Runnable {
        public void run() {
            //while(applicationIsLive) {
            	DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
                for (User user : User.find.all()) {
                	ConsumerProfile consumerProfile = user.findConsumerProfile();
                    for (CreditCardAccount creditCardAccount : user.findCreditCardAccounts()) {
                    	try {
                    	    /*
                            List<String> properties = new ArrayList<String>();
                            properties.add("AccountId");
                            properties.add("AccountType");
                            properties.add("ApplicationId");
                            properties.add("ApplicationVersion");
                            properties.add("BankId");
                            properties.add("BrokerId");
                            properties.add("CCNumber");
                            properties.add("FIId");
                            properties.add("FIOrganizationName");
                            properties.add("FIUrl");
                            properties.add("OFXPassword");
                            properties.add("OFXUser");
                            properties.add("OFXVersion");
                            */
                    		FinancialInstitution financialInstitution = creditCardAccount.findFinancialInstitution();
                    		Connection connection = DriverManager.getConnection(
                    				"jdbc:ofx:" +
            						"OFXVersion=102;" +
            						"ApplicationVersion=1401;" +
            						"ApplicationId=QWIN;" +
            						"OFXUser=" + creditCardAccount.getOfxUser() + ";" +
            						"OFXPassword=" + creditCardAccount.getOfxPassword() + ";" +
            						"FIUrl=" + financialInstitution.getUrl() + ";" +
            						"FIOrganizationName=" + financialInstitution.getOrg() + ";" +
            						"FIId=" + financialInstitution.getFid() + ";" +
            						"CCNumber=" + creditCardAccount.getCcNumber() + ";");
                    		Statement statement = connection.createStatement();
                    		ResultSet resultSet;
                    		//ResultSetMetaData metaData;
                        	Calendar today = Calendar.getInstance();
                    		Calendar daysAgo7 = Calendar.getInstance(); daysAgo7.add(Calendar.DAY_OF_YEAR, -7);
                    		Calendar daysAgo30 = Calendar.getInstance(); daysAgo30.add(Calendar.DAY_OF_YEAR, -30);
                    		Calendar daysAgo365 = Calendar.getInstance(); daysAgo365.add(Calendar.DAY_OF_YEAR, -365);
                			statement.executeQuery("select DatePosted, Amount from CCTransactions " +
                    				"where DatePosted < '" + dateFormat.format(today.getTime()) + "' " +
                    				"and DatePosted > '" + dateFormat.format(daysAgo365.getTime()) + "'"); // todo: paginate
                    		resultSet = statement.getResultSet();
                    		//metaData = resultSet.getMetaData();
                    		consumerProfile.setA7(0L).setA30(0L).setA365(0L).setF7(0).setF30(0).setF365(0);
                    		while (resultSet.next()) {
                    			Date datePosted = dateFormat.parse(resultSet.getString(1));
                    			int amount = Integer.parseInt(resultSet.getString(2).replaceAll(",", "").replaceAll("\\.", ""));
            					if (amount < 0) {
            						amount *= -1;
            						if (datePosted.after(daysAgo365.getTime())) { 
            							consumerProfile
            							    .setA365(consumerProfile.getA365() + (long) amount)
            							    .setF365(consumerProfile.getF365() + 1);
            						}
            						if (datePosted.after(daysAgo30.getTime())) {
            							consumerProfile
            							    .setA30(consumerProfile.getA30() + (long) amount)
            							    .setF30(consumerProfile.getF30() + 1);
            						}
            						if (datePosted.after(daysAgo7.getTime())) {
            							consumerProfile
            							    .setA7(consumerProfile.getA7() + (long) amount)
            							    .setF7(consumerProfile.getF7() + 1);
            						}
            					}
                    		}
                    	}
                    	catch (Exception e) {e.printStackTrace();}
                    }
            		consumerProfile.save();
                }
                //try {Thread.sleep(5000);} catch (Exception e) {}
            //}
        }
    }
    
    /*
    @Override public Result onError(RequestHeader request, Throwable t) {
    	return internalServerError("error");
    } 
    
    @Override public Result onHandlerNotFound(RequestHeader request) {
    	return notFound("action not found");
    }*/
}