import java.io.*;
import java.sql.*;
import java.text.*;
import java.util.*;
import java.util.Date;

import com.avaje.ebean.*;

import com.intuit.ipp.aggcat.core.*;
import com.intuit.ipp.aggcat.data.*;
import com.intuit.ipp.aggcat.data.Challenges.Challenge.Choice;
import com.intuit.ipp.aggcat.data.Challenges.*;
import com.intuit.ipp.aggcat.exception.*;
import com.intuit.ipp.aggcat.service.*;

import play.*;
import play.libs.*;

import models.*;

//todo: delete videos after not having paid out or watched in X time
public class Global extends GlobalSettings {
    public static boolean applicationIsLive = false;
    public static Thread aggCatServiceThread = new Thread(new AggCatServiceThread());
    //public static Thread consumerProfileUpdaterThread = new Thread(new ConsumerProfileUpdater());
    
    @Override public void onStart(Application app) {
        // Check if the database is empty
        if (User.find.findRowCount() == 0) {
            //Ebean.save((List) Yaml.load("seed/data-FinancialInstitution.yml"));
            Ebean.save((List) Yaml.load("seed/data-Occupation.yml"));
            Ebean.save((List) Yaml.load("seed/data-Interest.yml"));
            Ebean.save((List) Yaml.load("seed/data-Zip.yml"));
            
            User.create("Ray", "secret", null, null, null, null, null);
            Balance.create("Ray", 10000L);
            CommittedBalance.create("Ray", 10000L);
            ConsumerProfile.create("Ray", 0L, 0L, 0L, 0, 0, 0);
            WatchingVideo.create("Ray", null, null, null);
            //FinancialInstitutionLogin.create("Ray", 424L, "cim2phat4u", "zhaamE_263", "379718849191002");
            FinancialInstitutionLogin.create("Ray", 100000L, "direct", "anyvalue");
            
            User.create("Katie", "secret", null, null, null, null, null);
            Balance.create("Katie", 10000L);
            CommittedBalance.create("Katie", 10000L);
            ConsumerProfile.create("Katie", 0L, 0L, 0L, 0, 0, 0);
            WatchingVideo.create("Katie", null, null, null);
            //FinancialInstitutionLogin.create("Katie", 427L, "kwang318", "651Anthony3083", "4128003460359667");
        }
        
        // start looping maintenance threads
        applicationIsLive = true;
        aggCatServiceThread.start();
        //consumerProfileUpdaterThread.start();
    }
    
    @Override public void onStop(Application app) {
        // signal maintenance threads to stop
        applicationIsLive = false;
        try {aggCatServiceThread.join();} catch (Exception e) {}
        //try {consumerProfileUpdaterThread.join();} catch (Exception e) {}
    }

    /* intuit stuff*/
    public static class AggCatServiceThread implements Runnable {
        String OAUTH_CONSUMER_KEY = "qyprdNIHBI0Ym9iddckwTR8Fzq9Mmj";
        String OAUTH_CONSUMER_SECRET = "86MmKfrvrDheNMQdvYNgrkc9HEFvoczwmIRqFaMj";
        String SAML_PROVIDER_ID = "adder.161321.cc.dev-intuit.ipp.prod";
        String userId = "rzhang86"; // i think userId = rzhang86 
        public void run() {
            while (applicationIsLive) {
            	AggCatService service = getService();
            	/*
                Institutions institutions = null;
                boolean institutionsReceived = false;
                while (!institutionsReceived) {
                    try {institutions = service.getInstitutions();}
                    catch (AggCatException e) {System.out.println("aggcatexception: " + e.getMessage()); e.printStackTrace();}
                    catch (Exception e) {System.out.println("exception: " + e.getMessage()); e.printStackTrace();}
                    if (institutions != null) institutionsReceived = true;
                    else try {Thread.sleep(60000); service = getService();} catch (Exception e) {}
                }*/
                //for (Institution institution : institutions.getInstitutions()) {
                    if (!applicationIsLive) break;
                    else {
                    	/*InstitutionDetail institutionDetail = null;
                        boolean institutionDetailReceived = false;
                        while (!institutionDetailReceived) {
                            try {institutionDetail = service.getInstitutionDetails(institution.getInstitutionId());}
                            catch (AggCatException e) {System.out.println("aggcatexception: " + e.getMessage()); e.printStackTrace();}
                            catch (Exception e) {System.out.println("exception: " + e.getMessage()); e.printStackTrace();}
                            if (institutionDetail != null) institutionDetailReceived = true;
                            else try {Thread.sleep(60000); service = getService();} catch (Exception e) {}
                        }*/
                    	InstitutionDetail institutionDetail = null;
                        boolean institutionDetailReceived = false;
                        while (!institutionDetailReceived) {
                            try {institutionDetail = service.getInstitutionDetails(100000L);}
                            catch (AggCatException e) {System.out.println("aggcatexception: " + e.getMessage()); e.printStackTrace();}
                            catch (Exception e) {System.out.println("exception: " + e.getMessage()); e.printStackTrace();}
                            if (institutionDetail != null) institutionDetailReceived = true;
                            else try {Thread.sleep(60000); service = getService();} catch (Exception e) {}
                        }
                        Long id = institutionDetail.getInstitutionId();
                        String name = institutionDetail.getInstitutionName();
                        String url = institutionDetail.getHomeUrl();
                        String phone = institutionDetail.getPhoneNumber();
                        String address1 = institutionDetail.getAddress().getAddress1();
                        String address2 = institutionDetail.getAddress().getAddress2();
                        String address3 = institutionDetail.getAddress().getAddress3();
                        String city = institutionDetail.getAddress().getCity();
                        String state = institutionDetail.getAddress().getState();
                        String postalCode = institutionDetail.getAddress().getPostalCode();
                        String country = institutionDetail.getAddress().getCountry();
                        String currencyCode = institutionDetail.getCurrencyCode().toString();
                        String usernameKey;
                        String passwordKey;
                        if (!(institutionDetail.getKeys().getKeies().get(0).isMask())) {
                            usernameKey = institutionDetail.getKeys().getKeies().get(0).getName();
                            passwordKey = institutionDetail.getKeys().getKeies().get(1).getName();
                        }
                        else {
                            usernameKey = institutionDetail.getKeys().getKeies().get(1).getName();
                            passwordKey = institutionDetail.getKeys().getKeies().get(0).getName();
                        }
                        if (FinancialInstitution.find.where().eq("id", id).findRowCount() == 0) FinancialInstitution.create(id, name, url, phone, address1, address2, address3, city, state, postalCode, country, currencyCode, usernameKey, passwordKey);
                        else FinancialInstitution.find.ref(id).setName(name).setUrl(url).setPhone(phone).setAddress1(address1).setAddress2(address2).setAddress3(address3).setCity(city).setState(state).setPostalCode(postalCode).setCountry(country).setCurrencyCode(currencyCode).setUsernameKey(usernameKey).setPasswordKey(passwordKey).save();
                    }
                //}
                
                for (User user : User.find.all()) {
                    if (!applicationIsLive) break;
                    else {
                        //ConsumerProfile consumerProfile = user.findConsumerProfile();
                        for (FinancialInstitutionLogin financialInstitutionLogin : user.findFinancialInstitutionLogins()) {
                        	try {
                                FinancialInstitution financialInstution = financialInstitutionLogin.findFinancialInstitution();
                                Credential usernameCredential = new Credential();
                                usernameCredential.setName(financialInstution.getUsernameKey());
                                usernameCredential.setValue(financialInstitutionLogin.getUsername());
                                Credential passwordCredential = new Credential();
                                passwordCredential.setName(financialInstution.getPasswordKey());
                                passwordCredential.setValue(financialInstitutionLogin.getPassword());
                                List<Credential> credentialList = new ArrayList<Credential>();
                                credentialList.add(usernameCredential);
                                credentialList.add(passwordCredential);
                                Credentials credentials = new Credentials();
                                credentials.setCredentials(credentialList);
                                InstitutionLogin institutionLogin = new InstitutionLogin();
                                institutionLogin.setCredentials(credentials);
                                
                                DiscoverAndAddAccountsResponse response = null;
                                boolean responseReceived = false;
                                while (!responseReceived) {
                                    try {response = service.discoverAndAddAccounts(financialInstution.getId(), institutionLogin);}
                                    catch (AggCatException e) {System.out.println("aggcatexception: " + e.getMessage()); e.printStackTrace();}
                                    catch (Exception e) {System.out.println("exception: " + e.getMessage()); e.printStackTrace();}
                                    if (response != null) responseReceived = true;
                                    else try {Thread.sleep(60000); service = getService();} catch (Exception e) {}
                                }
                                AccountList accountList = new AccountList();
                                if (response.getChallenges() != null && response.getAccountList() == null) {
                                    List<String> questionList = new ArrayList<String>();
                                    // Intuit says only Text is handled right now.
                                    for (Challenge challenge : response.getChallenges().getChallenges()) {
                                        for (int i = 0; i < challenge.getTextsAndImagesAndChoices().size(); i++) {
                                            if (!(challenge.getTextsAndImagesAndChoices().get(i) instanceof byte[]) && (!(challenge.getTextsAndImagesAndChoices().get(i) instanceof Choice))) {
                                                questionList.add(challenge.getTextsAndImagesAndChoices().get(i).toString());
                                            }
                                        }
                                    }
                                    ChallengeSession challengeSession = response.getChallengeSession();
                                    //todo: ask user to answer chalenges
                                    int questionsLeft = questionList.size();
                                    for (FinancialInstitutionLoginChallenge financialInstitutionLoginChallenge : FinancialInstitutionLoginChallenge.find.where().eq("financialInstitutionLoginId", financialInstitutionLogin.getId()).findList()) {
                                    	String question = financialInstitutionLoginChallenge.getQuestion();
                                    	String answer = financialInstitutionLoginChallenge.getAnswer();
                                    	while (questionList.contains(question)) {
                                    		questionList.set(questionList.indexOf(question), answer);
                                    		questionsLeft--;
                                    	}
                                    }
                                    if (questionsLeft <= 0) {
                                    	ChallengeResponses challengeResponses = new ChallengeResponses();
                                    	challengeResponses.setResponses(questionList);
                                    	
                                    	DiscoverAndAddAccountsResponse response2 = null;
    	                                boolean response2Received = false;
    	                                while (!response2Received) {
    	                                    try {response2 = service.discoverAndAddAccounts(challengeResponses, challengeSession);}
    	                                    catch (AggCatException e) {System.out.println("aggcatexception: " + e.getMessage()); e.printStackTrace();}
    	                                    catch (Exception e) {System.out.println("exception: " + e.getMessage()); e.printStackTrace();}
    	                                    if (response2 != null) response2Received = true;
    	                                    else try {Thread.sleep(60000); service = getService();} catch (Exception e) {}
    	                                }
                                    	accountList = response2.getAccountList();
                                    }
                                }
                                else accountList = response.getAccountList();
                                
                                List<List<String>> accounts = new ArrayList<List<String>>();
                                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                                for (Account account : accountList.getBankingAccountsAndCreditAccountsAndLoanAccounts()) {
                                    /*List<String> item = new ArrayList<String>();
                                    item.add(Long.toString(account.getAccountId()));
                                    item.add(Long.toString(account.getInstitutionId()));
                                    if (null != account.getAggrSuccessDate()) item.add(formatter.format(account.getAggrSuccessDate().getTime())); else item.add("");
                                    if (null != account.getBalanceAmount()) item.add(account.getBalanceAmount().toString()); else item.add("");
                                    if (null != account.getDescription()) item.add(account.getDescription()); else item.add("");
                                    if (null != account.getCurrencyCode()) item.add(account.getCurrencyCode().toString()); else item.add("");
                                    accounts.add(item);*/
                                	String startDate = "2013-01-01";
                                	String endDate = "2013-06-12";
                                	
                                	TransactionList transactions = null;
                                    boolean transactionReceived = false;
                                    while (!transactionReceived) {
                                        try {transactions = service.getAccountTransactions(account.getAccountId(), startDate, endDate);}
                                        catch (AggCatException e) {System.out.println("aggcatexception: " + e.getMessage()); e.printStackTrace();}
                                        catch (Exception e) {System.out.println("exception: " + e.getMessage()); e.printStackTrace();}
                                        if (transactions != null) transactionReceived = true;
                                        else try {Thread.sleep(60000); service = getService();} catch (Exception e) {}
                                    }
                                	for (com.intuit.ipp.aggcat.data.Transaction transaction : transactions.getLoanTransactions()) {
                                		try {System.out.print("\ntrans--------- ");} catch (Exception e) {System.out.print(", NILYO");}
                                		try {System.out.print(", " + transaction.getPayeeName());} catch (Exception e) {System.out.print(", NILYO");}
                                		try {System.out.print(", " + transaction.getType());} catch (Exception e) {System.out.print(", NILYO");}
                                		try {System.out.print(", " + transaction.getAvailableDate().getTime().toString());} catch (Exception e) {System.out.print(", NILYO");}
                                		try {System.out.print(", " + transaction.getAmount());} catch (Exception e) {System.out.print(", NILYO");}
                                		try {System.out.print(", " + transaction.getRunningBalanceAmount());} catch (Exception e) {System.out.print(", NILYO");}
                                		try {System.out.print(", " + transaction.getCurrencyType());} catch (Exception e) {System.out.print(", NILYO");}
                                		try {System.out.print(", " + transaction.getMemo());} catch (Exception e) {System.out.print(", NILYO");}
                                		try {System.out.print("\ncat common---- ");} catch (Exception e) {System.out.print(", NILYO");}
                                		try {System.out.print(", " + transaction.getCategorization().getCommon().getMerchant());} catch (Exception e) {System.out.print(", NILYO");}
                                		try {System.out.print(", " + transaction.getCategorization().getCommon().getNormalizedPayeeName());} catch (Exception e) {System.out.print(", NILYO");}
                                		try {System.out.print(", " + transaction.getCategorization().getCommon().getSic());} catch (Exception e) {System.out.print(", NILYO");}
                                		try {System.out.print("\ncat context--- ");} catch (Exception e) {System.out.print(", NILYO");}
                                		try {System.out.print(", " + transaction.getCategorization().getContexts().get(0).getCategoryName());} catch (Exception e) {System.out.print(", NILYO");}
                                		try {System.out.print(", " + transaction.getCategorization().getContexts().get(0).getContextType());} catch (Exception e) {System.out.print(", NILYO");}
                                		try {System.out.print(", " + transaction.getCategorization().getContexts().get(0).getScheduleC());} catch (Exception e) {System.out.print(", NILYO");}
                                		try {System.out.print(", " + transaction.getCategorization().getContexts().get(0).getSource().getDeclaringClass().getName());} catch (Exception e) {System.out.print(", NILYO");}
                                	}
                                }
                                //todo: handle what to do with accountList
                                /*System.out.println(financialInstitutionLogin.getUserUsername());
                                System.out.println("  ---  cc fid: " + financialInstitutionLogin.getFinancialInstitutionId());
                                for (List<String> subList : accountList) {
                                    System.out.print("  ------  ");
                                    for (String s : subList) System.out.print(s  + " ");
                                    System.out.println();
                                }*/
                        	}
            	            catch (Exception e) {
            	                System.out.println("exception: " + e.getMessage());
            	                e.printStackTrace();
            	            }
                        }
                    }
                }
                
                
                System.out.println("pause...");
                for (int sec = 0; sec < 60 * 60 * 24; sec++) {
                    if (!applicationIsLive) break;
                    else try {Thread.sleep(1000);} catch (Exception e) {}
                }
                System.out.println("unpause...");
            }
        }
        
        public AggCatService getService() {
            AggCatService service = null;
            while (service == null) {
                try {
                    System.out.println("Authorizing with Intuit...");
                    OAuthAuthorizer oauthAuthorizer = new OAuthAuthorizer(OAUTH_CONSUMER_KEY, OAUTH_CONSUMER_SECRET, SAML_PROVIDER_ID, userId);
                    service = new AggCatService(new Context(oauthAuthorizer));
                    service.deleteCustomer(); // todo: in production, make sure extra unnecessary customers are not created each time i connect, building up charges
                    System.out.println("...Intuit says ok");
                }
                catch (AggCatException e) {
                    //"Exception while generating OAuth tokens. Please check whether the configured keys and cert files are valid."
                    System.out.println("aggcatexception: " + e.getMessage());
                    e.printStackTrace();
                }
                catch (Exception e) {
                    System.out.println("exception: " + e.getMessage());
                    e.printStackTrace();
                }
                if (service == null) try {Thread.sleep(60000);} catch (Exception e) {}
            }
            return service;
        }
    }
    /*
    public static class ConsumerProfileUpdater implements Runnable {
        public void run() {
            //while(applicationIsLive) {
            	DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
                for (User user : User.find.all()) {
                	ConsumerProfile consumerProfile = user.findConsumerProfile();
                    for (FinancialInstitutionLogin financialInstitutionLogin : user.findFinancialInstitutionLogins()) {
                    	try {
                    	    
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
                            
                    		FinancialInstitution financialInstitution = financialInstitutionLogin.findFinancialInstitution();
                    		Connection connection = DriverManager.getConnection(
                    				"jdbc:ofx:" +
            						"OFXVersion=102;" +
            						"ApplicationVersion=1401;" +
            						"ApplicationId=QWIN;" +
            						"OFXUser=" + financialInstitutionLogin.getOfxUser() + ";" +
            						"OFXPassword=" + financialInstitutionLogin.getOfxPassword() + ";" +
            						"FIUrl=" + financialInstitution.getUrl() + ";" +
            						"FIOrganizationName=" + financialInstitution.getOrg() + ";" +
            						"FIId=" + financialInstitution.getFid() + ";" +
            						"CCNumber=" + financialInstitutionLogin.getCcNumber() + ";");
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
    */
    /*
    @Override public Result onError(RequestHeader request, Throwable t) {
    	return internalServerError("error");
    } 
    
    @Override public Result onHandlerNotFound(RequestHeader request) {
    	return notFound("action not found");
    }*/
}