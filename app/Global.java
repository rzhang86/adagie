import java.io.*;
import java.sql.*;
import java.text.*;
import java.util.*;
import java.util.Date;
import java.util.concurrent.Callable;

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
            Ebean.save((List) Yaml.load("seed/data-Occupation.yml"));
            Ebean.save((List) Yaml.load("seed/data-Interest.yml"));
            Ebean.save((List) Yaml.load("seed/data-Zip.yml"));
            Ebean.save((List) Yaml.load("seed/data-FinancialInstitution.yml"));
            Ebean.save((List) Yaml.load("seed/data-ExpenseCategory.yml"));
            Ebean.save((List) Yaml.load("seed/data-ExpenseSubcategory.yml"));
            
            User.create("Ray", "secret", null, null, null, null, null);
            Balance.create("Ray", 10000L);
            CommittedBalance.create("Ray", 10000L);
            ConsumerProfile.create("Ray", 0L, 0L, 0L, 0, 0, 0);
            WatchingVideo.create("Ray", null, null, null);
            FinancialInstitutionLogin.create("Ray", 100000L, "AllInfoReqd_dd", "anyvalue");
            //FinancialInstitutionLogin tfa1 = FinancialInstitutionLogin.create("Ray", 100000L, "tfa_text", "anyvalue");
            /*FinancialInstitutionLogin.create("Ray", 100000L, "direct", "anyvalue");
            FinancialInstitutionLogin.create("Ray", 100000L, "bad", "anyvalue");
            FinancialInstitutionLogin.create("Ray", 100000L, "anyvalue", "bad");
            FinancialInstitutionLogin tfa1 = FinancialInstitutionLogin.create("Ray", 100000L, "tfa_text", "anyvalue");
            FinancialInstitutionLogin tfa2 = FinancialInstitutionLogin.create("Ray", 100000L, "tfa_text2", "anyvalue");
            /*FinancialInstitutionLogin.create("Ray", 100000L, "tfa_choice", "anyvalue");
            FinancialInstitutionLogin.create("Ray", 100000L, "tfa_image", "anyvalue");
            FinancialInstitutionLogin.create("Ray", 100000L, "tfa_dynamic_image", "anyvalue");
            FinancialInstitutionLogin.create("Ray", 100000L, "request_error", "anyvalue");
            FinancialInstitutionLogin.create("Ray", 100000L, "error_code", "error number");
            FinancialInstitutionLogin.create("Ray", 100000L, "error_later", "error number");
            FinancialInstitutionLogin.create("Ray", 100000L, "MFA ANSWER", "<MFA answer field> loops");
            FinancialInstitutionLogin.create("Ray", 100000L, "MFA ANSWER", "<MFA answer field> bad");
            FinancialInstitutionLogin.create("Ray", 100000L, "wrong_zip", "anyvalue");
            FinancialInstitutionLogin.create("Ray", 100000L, "wrong_state", "anyvalue");
            FinancialInstitutionLogin.create("Ray", 100000L, "special_char", "anyvalue");
            FinancialInstitutionLogin.create("Ray", 100000L, "wrong_date", "anyvalue");
            FinancialInstitutionLogin.create("Ray", 100000L, "null_date", "anyvalue");
            FinancialInstitutionLogin.create("Ray", 100000L, "null_amt", "anyvalue");
            FinancialInstitutionLogin.create("Ray", 100000L, "null_acctno", "anyvalue");
            FinancialInstitutionLogin.create("Ray", 100000L, "unmasked_acctno", "anyvalue");
            FinancialInstitutionLogin.create("Ray", 100000L, "Opayee_0dd", "anyvalue");
            FinancialInstitutionLogin.create("Ray", 100000L, "Opayee_dd", "anyvalue");
            FinancialInstitutionLogin.create("Ray", 100000L, "payee_0dd", "anyvalue");
            FinancialInstitutionLogin.create("Ray", 100000L, "payee_dd", "anyvalue");
            FinancialInstitutionLogin.create("Ray", 100000L, "SomeInfoReqd_0dd", "anyvalue");
            FinancialInstitutionLogin.create("Ray", 100000L, "SomeInfoReqd_dd", "anyvalue");
            FinancialInstitutionLogin.create("Ray", 100000L, "AllInfoReqd_dd", "anyvalue");*/
            
            User.create("Katie", "secret", null, null, null, null, null);
            Balance.create("Katie", 10000L);
            CommittedBalance.create("Katie", 10000L);
            ConsumerProfile.create("Katie", 0L, 0L, 0L, 0, 0, 0);
            WatchingVideo.create("Katie", null, null, null);
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
        AggCatService service;
        
        public void run() {
            while (applicationIsLive) {
            	service = getService();
            	/*
                Institutions institutions = null;
                boolean institutionsReceived = false;
                while (!institutionsReceived) {
                    try {institutions = service.getInstitutions();}
                    catch (AggCatException e) {System.out.println("aggcatexception: " + e.getMessage()); e.printStackTrace();}
                    catch (Exception e) {System.out.println("exception: " + e.getMessage()); e.printStackTrace();}
                    if (institutions != null) institutionsReceived = true;
                    else try {Thread.sleep(60000); service = getService();} catch (Exception e) {}
                }
                for (Institution institution : institutions.getInstitutions()) {
                    if (!applicationIsLive) break;
                    else {
                    	InstitutionDetail institutionDetail = null;
                        boolean institutionDetailReceived = false;
                        while (!institutionDetailReceived) {
                            try {institutionDetail = service.getInstitutionDetails(institution.getInstitutionId());}
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
                }
                */

                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                for (User user : User.find.all()) {
                    if (!applicationIsLive) break;
                    else {
                        Map<String[], Long[]> transactionMap = new HashMap<String[], Long[]>();
                        Calendar calendar = Calendar.getInstance();
                        calendar.roll(Calendar.YEAR, false);
                        Date oneYearAgo = calendar.getTime();
                        for (UserVariable userVariable : UserVariable.find.where().lt("datePosted", formatter.format(oneYearAgo)).findList()) userVariable.delete();
                        for (FinancialInstitutionLogin financialInstitutionLogin : user.findFinancialInstitutionLogins()) {
                        	try {
                                FinancialInstitution financialInstitution = financialInstitutionLogin.findFinancialInstitution();
                                Credential usernameCredential = new Credential();
                                usernameCredential.setName(financialInstitution.getUsernameKey());
                                usernameCredential.setValue(financialInstitutionLogin.getUsername());
                                Credential passwordCredential = new Credential();
                                passwordCredential.setName(financialInstitution.getPasswordKey());
                                passwordCredential.setValue(financialInstitutionLogin.getPassword());
                                List<Credential> credentialList = new ArrayList<Credential>();
                                credentialList.add(usernameCredential);
                                credentialList.add(passwordCredential);
                                Credentials credentials = new Credentials();
                                credentials.setCredentials(credentialList);
                                InstitutionLogin institutionLogin = new InstitutionLogin();
                                institutionLogin.setCredentials(credentials);
                                
                                System.out.println("\n" + usernameCredential.getValue() + "/" + passwordCredential.getValue());
                                //todo: test multiple MFA challenge question answering
                                DiscoverAndAddAccountsResponse response = service.discoverAndAddAccounts(financialInstitution.getId(), institutionLogin);
                                AccountList accountList = null;
                                if (response.getChallenges() != null && response.getAccountList() == null) {
                                    List<String> questionList = new ArrayList<String>();
                                    // todo: handle choice and image challenges
                                    for (Challenge challenge : response.getChallenges().getChallenges()) {
                                        for (int i = 0; i < challenge.getTextsAndImagesAndChoices().size(); i++) {
                                            if (!(challenge.getTextsAndImagesAndChoices().get(i) instanceof byte[]) && (!(challenge.getTextsAndImagesAndChoices().get(i) instanceof Choice))) {
                                                questionList.add(challenge.getTextsAndImagesAndChoices().get(i).toString());
                                            }
                                        }
                                    }
                                    Map<String, String> answerKey = new HashMap<String, String>();
                                    for (FinancialInstitutionLoginChallenge financialInstitutionLoginChallenge : financialInstitutionLogin.findFinancialInstitutionLoginChallenges()) {
                                    	String question, answer;
                                    	try {question = financialInstitutionLoginChallenge.findChallengeQuestion().getValue();} catch (Exception e) {question = null;}
                                    	try {answer = financialInstitutionLoginChallenge.findChallengeAnswer().getValue();} catch (Exception e) {answer = null;}
                                    	if (question != null) answerKey.put(question, answer);
                                    }
                                    List<String> answerList = new ArrayList<String>();
                                    boolean allAnswersPresent = true;
                                    for (String question : questionList) {
                                    	if (!answerKey.containsKey(question)) {
                                    		allAnswersPresent = false;
                                    		ChallengeQuestion challengeQuestion = null;
                                    		List<ChallengeQuestion> matchingChallengeQuestions = ChallengeQuestion.find.where().eq("value", question).findList();
                                    		if (matchingChallengeQuestions.size() > 0) challengeQuestion = matchingChallengeQuestions.get(0);
                                    		else challengeQuestion = ChallengeQuestion.create(question);
                                    		FinancialInstitutionLoginChallenge.create(financialInstitutionLogin.getId(), challengeQuestion.getId(), null);
                                    	}
                                    	else if (answerKey.get(question) == null) allAnswersPresent = false;
                                    	else answerList.add(answerKey.get(question));
                                    }
                                    if (allAnswersPresent) {
                                    	ChallengeResponses challengeResponses = new ChallengeResponses();
                                    	challengeResponses.setResponses(answerList);
                                    	for (String a : challengeResponses.getResponses()) System.out.println("  " + a);
                                    	DiscoverAndAddAccountsResponse response2 = service.discoverAndAddAccounts(challengeResponses, response.getChallengeSession());
                                    	accountList = response2.getAccountList();
                                    }
                                    //todo: ask user to answer chalenges
                                }
                                else accountList = response.getAccountList();
                                if (accountList != null) {
	                                for (Account account : accountList.getBankingAccountsAndCreditAccountsAndLoanAccounts()) {
	                                    TransactionList transactions = service.getAccountTransactions(account.getAccountId(), formatter.format(oneYearAgo), formatter.format(Calendar.getInstance().getTime()));
	                                	for (com.intuit.ipp.aggcat.data.Transaction transaction : transactions.getLoanTransactions()) {
	                                	    String[] keys = {null, null}; // txn date, category name
	                                	    Long[] values = {0L, 0L}; //amount, frequency
	                                	    
	                                	    try {keys[0] = formatter.format(transaction.getUserDate().getTime());} catch (Exception e) {}
	                                	    try {keys[1] = transaction.getCategorization().getContexts().get(0).getCategoryName();} catch (Exception e) {}
	                                	    try {
	                                	        Long amount = transaction.getAmount().movePointRight(2).longValue();
	                                	        if (amount < 0) {
	                                	            if (!transactionMap.containsKey(keys)) {
	                                	                values[0] = -1L * amount;
	                                	                values[1] = 1L;
    	                                	        }
	                                	            else {
	                                	                values[0] = (-1L * amount) + transactionMap.get(keys)[0];
	                                	                values[1] = 1L + transactionMap.get(keys)[1];
	                                	            }
	                                	            transactionMap.put(keys, values);
	                                	        }
	                                	    }
	                                	    catch (Exception e) {}
	                                		/*System.out.print("\n");
	                                		try {System.out.print(" "); System.out.print(formatter.format(transaction.getPostedDate().getTime()));} catch (Exception e) {System.out.print("na");}
	                                		try {System.out.print(" "); System.out.print(formatter.format(transaction.getAvailableDate().getTime()));} catch (Exception e) {System.out.print("na");}
	                                		try {System.out.print(" "); System.out.print(formatter.format(transaction.getUserDate().getTime()));} catch (Exception e) {System.out.print("na");}
	                                		try {System.out.print(" [A]"); System.out.print(transaction.getPayeeName());} catch (Exception e) {System.out.print("na");}
                                            try {System.out.print(" [B]"); System.out.print(transaction.getAmount());} catch (Exception e) {System.out.print("na");}
                                            try {System.out.print(" [C]"); System.out.print(transaction.getCurrencyType());} catch (Exception e) {System.out.print("na");}
	                                		try {System.out.print(" [D]"); System.out.print(transaction.getType());} catch (Exception e) {System.out.print("na");}
	                                		try {System.out.print(" [E]"); System.out.print(transaction.getMemo());} catch (Exception e) {System.out.print("na");}
	                                		try {System.out.print(" [F]"); System.out.print(transaction.getCategorization().getCommon().getNormalizedPayeeName());} catch (Exception e) {System.out.print("na");}
	                                		try {System.out.print(" [G]"); System.out.print(transaction.getCategorization().getCommon().getMerchant());} catch (Exception e) {System.out.print("na");}
	                                		try {System.out.print(" [H]"); System.out.print(transaction.getCategorization().getCommon().getSic());} catch (Exception e) {System.out.print("na");}
	                                		try {System.out.print(" [I]"); System.out.print(transaction.getCategorization().getContexts().get(0).getCategoryName());} catch (Exception e) {System.out.print("na");}
	                                		try {System.out.print(" [J]"); System.out.print(transaction.getCategorization().getContexts().get(0).getContextType());} catch (Exception e) {System.out.print("na");}
	                                		try {System.out.print(" [K]"); System.out.print(transaction.getCategorization().getContexts().get(0).getScheduleC());} catch (Exception e) {System.out.print("na");}
	                                		try {System.out.print(" [L]"); System.out.print(transaction.getCategorization().getContexts().get(0).getSource().value());} catch (Exception e) {System.out.print("na");}*/
	                                	}
	                                }
	                                System.out.println("    SUCCESS");
                                }
                                else System.out.println("    FAILURE");
                        	}
                        	catch (AggCatException e) {
                        		switch (Integer.parseInt(e.getErrorCode())) {
                        			case 503:
                        				System.out.println("page does not exist");
                        			case 403:
                        				System.out.println("credentials wrong");
                        				break;
                        		}
                        		System.out.println("aggcat exception: " + e.getMessage());
                        	}
            	            catch (Exception e) {
            	                System.out.println("exception: " + e.getMessage());
            	                e.printStackTrace();
            	            }
                        }
                        for (String[] key : transactionMap.keySet()) {
                            ExpenseSubcategory expenseSubcategory = null;
                            try {expenseSubcategory = ExpenseSubcategory.find.where().eq("name", key[1]).findList().get(0);} catch (Exception e) {}
                            if (expenseSubcategory != null) {
                                UserVariable userVariable = null;
                                if (UserVariable.find.where().eq("userUsername", user.getUsername()).eq("datePosted", key[0]).eq("subcategoryCode", expenseSubcategory.getCode()).findRowCount() > 0) {
                                    userVariable = UserVariable.find.where().eq("userUsername", user.getUsername()).eq("datePosted", key[0]).eq("subcategoryCode", expenseSubcategory.getCode()).findList().get(0);
                                    userVariable.setAmount(transactionMap.get(key)[0]).setFrequency(transactionMap.get(key)[1].intValue()).save();
                                }
                                else userVariable = UserVariable.create(user.getUsername(), new Date(Date.parse(key[0])), expenseSubcategory.getCode(), transactionMap.get(key)[0], transactionMap.get(key)[1].intValue());
                            }
                        }
                        
                        for (UserVariable userVariable : user.findUserVariables()) {
                            System.out.println(userVariable.getDatePosted() + ", " + userVariable.getSubcategoryCode() + ", " + userVariable.getAmount() + ", " + userVariable.getFrequency());
                        }
                    }
                }
                
                System.out.println("pause...");
                for (int sec = 0; sec < 60; sec++) {
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
    @Override public Result onError(RequestHeader request, Throwable t) {
    	return internalServerError("error");
    } 
    
    @Override public Result onHandlerNotFound(RequestHeader request) {
    	return notFound("action not found");
    }*/
}