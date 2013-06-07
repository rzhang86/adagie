import java.sql.*;
import java.text.*;
import java.util.*;
import java.util.Date;

import play.*;

import models.*;

//todo: delete videos after not having paid out or watched in X time
public class Global extends GlobalSettings {
    public Thread consumerProfileUpdaterThread = new Thread(new ConsumerProfileUpdater());
    public static boolean applicationIsLive = false;
    
    @Override public void onStart(Application app) {
        // Check if the database is empty
        if (User.find.findRowCount() == 0) {
            //Ebean.save((List) Yaml.load("test-data.yml"));
            //User user = User.find.ref("Ray");
            User userRay = new User("Ray", "secret");
            userRay.save();
            Balance balanceRay = new Balance(userRay.getUsername());
            balanceRay.setAmount(10000L);
            balanceRay.save();
            CommittedBalance committedBalanceRay = new CommittedBalance(userRay.getUsername());
            committedBalanceRay.setAmount(10000L);
            committedBalanceRay.save();
            ConsumerProfile consumerProfileRay = new ConsumerProfile(userRay.getUsername());
            consumerProfileRay.save();
            CreditCardAccount creditCardAccountRay = new CreditCardAccount(userRay);
            creditCardAccountRay.setOfxUser("cim2phat4u");
            creditCardAccountRay.setOfxPassword("zhaamE_263");
            creditCardAccountRay.setFiUrl("https://online.americanexpress.com/myca/ofxdl/desktop/desktopDownload.do?request_type=nl_ofxdownload");
            creditCardAccountRay.setFiOrganizationName("AMEX");
            creditCardAccountRay.setFiId("3101");
            creditCardAccountRay.setCcNumber("379718849191002");
            creditCardAccountRay.save();
            
            User userKatie = new User("Katie", "secret");
            userKatie.save();
            Balance balanceKatie = new Balance(userKatie.getUsername());
            balanceKatie.setAmount(10000L);
            balanceKatie.save();
            CommittedBalance committedBalanceKatie = new CommittedBalance(userKatie.getUsername());
            committedBalanceKatie.setAmount(10000L);
            committedBalanceKatie.save();
            ConsumerProfile consumerProfileKatie = new ConsumerProfile(userKatie.getUsername());
            consumerProfileKatie.save();
            CreditCardAccount creditCardAccountKatie = new CreditCardAccount(userKatie);
            creditCardAccountKatie.setOfxUser("kwang318");
            creditCardAccountKatie.setOfxPassword("651Anthony3083");
            creditCardAccountKatie.setFiUrl("https://www.accountonline.com/cards/svc/CitiOfxManager.do");
            creditCardAccountKatie.setFiOrganizationName("Citigroup");
            creditCardAccountKatie.setFiId("24909");
            creditCardAccountKatie.setCcNumber("4128003460359667");
            creditCardAccountKatie.save();
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
                	ConsumerProfile consumerProfile = ConsumerProfile.find.byId(user.getUsername());
                    for (CreditCardAccount creditCardAccount : user.getCreditCardAccounts()) {
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
                    	    
                    		Connection connection = DriverManager.getConnection(
                    				"jdbc:ofx:" +
            						"OFXVersion=102;" +
            						"ApplicationVersion=1401;" +
            						"ApplicationId=QWIN;" +
            						"OFXUser=" + creditCardAccount.getOfxUser() + ";" +
            						"OFXPassword=" + creditCardAccount.getOfxPassword() + ";" +
            						"FIUrl=" + creditCardAccount.getFiUrl() + ";" +
            						"FIOrganizationName=" + creditCardAccount.getFiOrganizationName() + ";" +
            						"FIId=" + creditCardAccount.getFiId() + ";" +
            						"CCNumber=" + creditCardAccount.getCcNumber() + ";");
                    		Statement statement = connection.createStatement();
                    		ResultSet resultSet;
                    		ResultSetMetaData metaData;
                        	Calendar today = Calendar.getInstance();
                    		Calendar daysAgo7 = Calendar.getInstance(); daysAgo7.add(Calendar.DAY_OF_YEAR, -7);
                    		Calendar daysAgo30 = Calendar.getInstance(); daysAgo30.add(Calendar.DAY_OF_YEAR, -30);
                    		Calendar daysAgo365 = Calendar.getInstance(); daysAgo365.add(Calendar.DAY_OF_YEAR, -365);
                    		statement.executeQuery("select DatePosted, Amount from CCTransactions " +
                    				"where DatePosted < '" + dateFormat.format(today.getTime()) + "' " +
                    				"and DatePosted > '" + dateFormat.format(daysAgo365.getTime()) + "'"); // todo: paginate
                    		resultSet = statement.getResultSet();
                    		metaData = resultSet.getMetaData();
                    		consumerProfile.setA7(0L);
                    		consumerProfile.setA30(0L);
                    		consumerProfile.setA365(0L);
                    		consumerProfile.setF7(0);
                    		consumerProfile.setF30(0);
                    		consumerProfile.setF365(0);
                    		while (resultSet.next()) {
                    			Date datePosted = dateFormat.parse(resultSet.getString(1));
                    			int amount = Integer.parseInt(resultSet.getString(2).replaceAll(",", "").replaceAll("\\.", ""));
            					if (amount < 0) {
            						amount *= -1;
            						if (datePosted.after(daysAgo365.getTime())) { 
            							consumerProfile.setA365(consumerProfile.getA365() + (long) amount);
            							consumerProfile.setF365(consumerProfile.getF365() + 1);
            						}
            						if (datePosted.after(daysAgo30.getTime())) {
            							consumerProfile.setA30(consumerProfile.getA30() + (long) amount);
            							consumerProfile.setF30(consumerProfile.getF30() + 1);
            						}
            						if (datePosted.after(daysAgo7.getTime())) {
            							consumerProfile.setA7(consumerProfile.getA7() + (long) amount);
            							consumerProfile.setF7(consumerProfile.getF7() + 1);
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