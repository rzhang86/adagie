import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import static java.nio.file.StandardCopyOption.*;
import java.text.*;
import java.util.*;

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
    public static Thread aggCatServiceThread;
    
    @Override public void onStart(Application app) {
        // Check if the database is empty
        if (User.find.findRowCount() == 0) {
        	Ebean.save((List) Yaml.load("seed/data-ExpenseCategory.yml"));
            Ebean.save((List) Yaml.load("seed/data-ExpenseSubcategory.yml"));
            Ebean.save((List) Yaml.load("seed/data-FinancialInstitution.yml"));
            Ebean.save((List) Yaml.load("seed/data-Interest.yml"));
            Ebean.save((List) Yaml.load("seed/data-Occupation.yml"));
            Ebean.save((List) Yaml.load("seed/data-Zip.yml"));
            writeJson();
            
            User user;
            user = new User();
            user.setEmail("kwang318@gmail.com");
            user.setPassword("secret");
            user.setGender("F");
            user.setAge(26);
            user.setBalance(10000L);
            user.setCommittedBalance(10000L);
            user.save();
            
            user = new User();
            user.setEmail("rzhang86@gmail.com");
            user.setPassword("secret");
            user.setGender("M");
            user.setAge(27);
            user.setBalance(10000L);
            user.setCommittedBalance(10000L);
            user.save();
            
            FinancialInstitutionLogin financialInstitutionLogin;
            financialInstitutionLogin = new FinancialInstitutionLogin();
            financialInstitutionLogin.setUser(user);
            
            FinancialInstitution financialInstitution = FinancialInstitution.find.where().eq("iid", 100000L).findUnique();
            financialInstitutionLogin.financialInstitution = financialInstitution;
            financialInstitutionLogin.setUsername("direct");
            financialInstitutionLogin.setPassword("anyvalue");
            financialInstitutionLogin.save();
        }
        
        /*
        // start looping maintenance threads
        applicationIsLive = true;
        try {
        	aggCatServiceThread = new Thread(new AggCatServiceThread());
        	aggCatServiceThread.start();
    	} catch (Exception e) {e.printStackTrace();}
    	*/
    }
    
    @Override public void onStop(Application app) {
        /*
    	// signal maintenance threads to stop
        applicationIsLive = false;
        try {aggCatServiceThread.join();} catch (Exception e) {e.printStackTrace();}
        */
    }

    public static void writeJson() {
    	// objects
        try (BufferedWriter writer = new BufferedWriter(Files.newBufferedWriter(Paths.get("public/data/ExpenseCategories-temp.json"), Charset.defaultCharset()))) {
    		writer.write("[");
    		String delimiter = "";
    		for (ExpenseCategory expenseCategory : ExpenseCategory.find.orderBy("name").findList()) {
    			writer.write(delimiter + "{\"id\":" + expenseCategory.getId() + ",\"name\":\"" + escape(expenseCategory.getName()) + "\"}");
    			delimiter = ",";
    		}
    		writer.write("]");
    		writer.flush();
    		Files.move(Paths.get("public/data/ExpenseCategories-temp.json"), Paths.get("public/data/ExpenseCategories.json"), REPLACE_EXISTING);
    	} catch (Exception e) {}
        
        try (BufferedWriter writer = new BufferedWriter(Files.newBufferedWriter(Paths.get("public/data/ExpenseSubcategories-temp.json"), Charset.defaultCharset()))) {
    		writer.write("[");
    		String delimiter = "";
    		for (ExpenseSubcategory expenseSubcategory : ExpenseSubcategory.find.orderBy("name").findList()) {
    			writer.write(delimiter + "{\"id\":" + expenseSubcategory.getId() + ",\"name\":\"" + escape(expenseSubcategory.getName()) + "\"}");
    			delimiter = ",";
    		}
    		writer.write("]");
    		writer.flush();
    		Files.move(Paths.get("public/data/ExpenseSubcategories-temp.json"), Paths.get("public/data/ExpenseSubcategories.json"), REPLACE_EXISTING);
    	} catch (Exception e) {}
        
    	try (BufferedWriter writer = new BufferedWriter(Files.newBufferedWriter(Paths.get("public/data/Interests-temp.json"), Charset.defaultCharset()))) {
    		writer.write("[");
    		String delimiter = "";
    		for (Interest interest : Interest.find.orderBy("name").findList()) {
    			writer.write(delimiter + "{\"id\":" + interest.getId() + ",\"name\":\"" + escape(interest.getName()) + "\"}");
    			delimiter = ",";
    		}
    		writer.write("]");
    		writer.flush();
    		Files.move(Paths.get("public/data/Interests-temp.json"), Paths.get("public/data/Interests.json"), REPLACE_EXISTING);
    	} catch (Exception e) {}
    	
    	try (BufferedWriter writer = new BufferedWriter(Files.newBufferedWriter(Paths.get("public/data/Occupations-temp.json"), Charset.defaultCharset()))) {
    		writer.write("[");
    		String delimiter = "";
    		for (Occupation occupation : Occupation.find.orderBy("name").findList()) {
    			writer.write(delimiter + "{\"id\":" + occupation.getId() + ",\"name\":\"" + escape(occupation.getName()) + "\"}");
    			delimiter = ",";
    		}
    		writer.write("]");
    		writer.flush();
    		Files.move(Paths.get("public/data/Occupations-temp.json"), Paths.get("public/data/Occupations.json"), REPLACE_EXISTING);
    	} catch (Exception e) {}
    	
    	// lists
    	try (BufferedWriter writer = new BufferedWriter(Files.newBufferedWriter(Paths.get("public/data/FinancialInstitutions-temp.json"), Charset.defaultCharset()))) {
    		writer.write("[");
    		String delimiter = "";
    		for (FinancialInstitution financialInstitution : FinancialInstitution.find.orderBy("name").findList()) {
    			writer.write(delimiter + "\"" +escape(financialInstitution.getName()) + "\"");
    			delimiter = ",";
    		}
    		writer.write("]");
    		writer.flush();
    		Files.move(Paths.get("public/data/FinancialInstitutions-temp.json"), Paths.get("public/data/FinancialInstitutions.json"), REPLACE_EXISTING);
    	} catch (Exception e) {}
    	
    	try (BufferedWriter writer = new BufferedWriter(Files.newBufferedWriter(Paths.get("public/data/Zips-temp.json"), Charset.defaultCharset()))) {
    		writer.write("[");
    		String delimiter = "";
    		for (Zip zip : Zip.find.orderBy("zipCode").findList()) {
    			writer.write(delimiter + "\"" +escape(zip.getZipCode()) + "\"");
    			delimiter = ",";
    		}
    		writer.write("]");
    		writer.flush();
    		Files.move(Paths.get("public/data/Zips-temp.json"), Paths.get("public/data/Zips.json"), REPLACE_EXISTING);
    	} catch (Exception e) {}
    }

    public static String escape(String input) {
        return input.replace("\\", "\\\\").replace("@", "@@");
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
            	try (BufferedWriter writer = new BufferedWriter(Files.newBufferedWriter(Paths.get("public/data/FinancialInstitutions-temp.json"), Charset.defaultCharset()))) {
            		writer.write("[");
            		String delimiter = "";
            		for (FinancialInstitution financialInstitution : FinancialInstitution.find.orderBy("name").findList()) {
            			writer.write(delimiter + "\"" + escape(financialInstitution.name) + "\"");
            			delimiter = ",";
            		}
            		writer.write("]");
            		writer.flush();
            		Files.move(Paths.get("public/data/FinancialInstitutions-temp.json"), Paths.get("public/data/FinancialInstitutions.json"), REPLACE_EXISTING);
            	}
            	catch (Exception e) {}
            	
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            	for (User user : User.find.all()) {
                    if (!applicationIsLive) break;
                    else {
                    	int[] timepointDays = {360, 270, 180, 150, 120, 90, 75, 60, 45, 30, 25, 20, 15, 10, 5, 4, 3, 2, 1};
                    	Calendar[] timepointCalendars = new Calendar[timepointDays.length];
                    	for (int i = 0; i < timepointDays.length; i++) {
                    		timepointCalendars[i] = Calendar.getInstance();
                    		timepointCalendars[i].add(Calendar.DATE, -timepointDays[i]);
                    	}
                    	Map<String, Map<Integer, Long[]>> amountMap = new HashMap<String, Map<Integer, Long[]>>(); //<categoryname, <timepoint, amount[0=debit,1=credit]>>
                    	Map<String, Map<Integer, Integer[]>> frequencyMap = new HashMap<String, Map<Integer, Integer[]>>();
                        for (FinancialInstitutionLogin financialInstitutionLogin : user.financialInstitutionLogins) {
                        	try {
                        		System.out.println("  accessing " + financialInstitutionLogin.username + "/" + financialInstitutionLogin.password);
                        		FinancialInstitution financialInstitution = FinancialInstitution.find.byId(financialInstitutionLogin.financialInstitution.id);
                                Credential usernameCredential = new Credential();
                                usernameCredential.setName(financialInstitution.usernameKey);
                                usernameCredential.setValue(financialInstitutionLogin.username);
                                Credential passwordCredential = new Credential();
                                passwordCredential.setName(financialInstitution.passwordKey);
                                passwordCredential.setValue(financialInstitutionLogin.password);
                                List<Credential> credentialList = new ArrayList<Credential>();
                                credentialList.add(usernameCredential);
                                credentialList.add(passwordCredential);
                                Credentials credentials = new Credentials();
                                credentials.setCredentials(credentialList);
                                InstitutionLogin institutionLogin = new InstitutionLogin();
                                institutionLogin.setCredentials(credentials);
                                
                                //todo: test multiple MFA challenge question answering
                                DiscoverAndAddAccountsResponse response = service.discoverAndAddAccounts(financialInstitution.iid, institutionLogin);
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
                                    for (LoginChallenge financialInstitutionLoginChallenge : financialInstitutionLogin.loginChallenges) {
                                    	String question, answer;
                                    	try {question = ChallengeQuestion.find.byId(financialInstitutionLoginChallenge.challengeQuestion.id).value;} catch (Exception e) {question = null;}
                                    	try {answer = financialInstitutionLoginChallenge.answer;} catch (Exception e) {answer = null;}
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
                                    		else {
                                    			challengeQuestion = new ChallengeQuestion();
                                    			challengeQuestion.value = question;
                                    			challengeQuestion.save();
                                    		}
                                    		LoginChallenge loginChallenge = new LoginChallenge();
                                    		loginChallenge.financialInstitutionLogin = financialInstitutionLogin;
                                    		loginChallenge.challengeQuestion = challengeQuestion;
                                    		loginChallenge.save();
                                    	}
                                    	else if (answerKey.get(question) == null) allAnswersPresent = false;
                                    	else answerList.add(answerKey.get(question));
                                    }
                                    if (allAnswersPresent) {
                                    	ChallengeResponses challengeResponses = new ChallengeResponses();
                                    	challengeResponses.setResponses(answerList);
                                    	DiscoverAndAddAccountsResponse response2 = service.discoverAndAddAccounts(challengeResponses, response.getChallengeSession());
                                    	accountList = response2.getAccountList();
                                    }
                                    //todo: ask user to answer chalenges
                                }
                                else accountList = response.getAccountList();
                                
                                if (accountList != null) {
	                                for (Account account : accountList.getBankingAccountsAndCreditAccountsAndLoanAccounts()) {
	                                    TransactionList transactions = service.getAccountTransactions(account.getAccountId(), formatter.format(timepointCalendars[0].getTime()), formatter.format(Calendar.getInstance().getTime()));
	                                	for (com.intuit.ipp.aggcat.data.Transaction transaction : transactions.getCreditCardTransactions()) {
	                                	    Calendar transactionTime = null;
	                                	    String transactionCategory = null;
	                                	    Long transactionAmount = null;
	                                	    try {
	                                	    	transactionTime = transaction.getUserDate();
	                                	    	transactionCategory = transaction.getCategorization().getContexts().get(0).getCategoryName();
	                                	    	transactionAmount = transaction.getAmount().movePointRight(2).longValue();
	                                	    }
	                                	    catch (Exception e) {}
	                                	    if (transactionTime != null && transactionCategory != null && transactionAmount != null) {
	                                	    	for (int i = 0; i < timepointDays.length; i++) {
		                                	    	if ((timepointCalendars[i].before(transactionTime) || timepointCalendars[i].equals(transactionTime)) && transactionTime.before(i < timepointDays.length - 1 ? timepointCalendars[i + 1] : Calendar.getInstance())) {
		                                	    		Map<Integer, Long[]> amountSubmap;
		                                	    		Map<Integer, Integer[]> frequencySubmap;
		                                	    		Long[] amount;
		                                	    		Integer[] frequency;
		                                	    		if (amountMap.containsKey(transactionCategory)) {
			                                	    		amountSubmap = amountMap.get(transactionCategory);
			                                	    		frequencySubmap = frequencyMap.get(transactionCategory);
			                                	    	}
		                                	    		else {
			                                	    		amountSubmap = new HashMap<Integer, Long[]>();
			                                	    		frequencySubmap = new HashMap<Integer, Integer[]>();
		                                	    		}
		                                	    		if (amountSubmap.containsKey(timepointDays[i])) {
		                                	    			amount = amountSubmap.get(timepointDays[i]);
		                                	    			frequency = frequencySubmap.get(timepointDays[i]);
		                                	    		}
		                                	    		else {
		                                	    			amount = new Long[2];
		                                	    			amount[0] = amount[1] = 0L;
		                                	    			frequency = new Integer[2];
		                                	    			frequency[0] = frequency[1] = 0;
		                                	    		}
		                                	    		if (transactionAmount < 0L) {
	                                	    				amount[0] = amount[0] - transactionAmount;
	                                	    				frequency[0] = frequency[0] + 1;
	                                	    			}
	                                	    			else {
	                                	    				amount[1] = amount[1] + transactionAmount;
	                                	    				frequency[1] = frequency[1] + 1;
	                                	    			}
	                                	    			amountSubmap.put(timepointDays[i], amount);
		                                	    		frequencySubmap.put(timepointDays[i], frequency);
		                                	    		amountMap.put(transactionCategory, amountSubmap);
		                                	    		frequencyMap.put(transactionCategory, frequencySubmap);
		                                	    	}
		                                	    }
	                                	    }
	                                		
//	                                		System.out.print("\n");
//	                                		try {System.out.print(" "); System.out.print(transaction.getPostedDate().getTime().toString());} catch (Exception e) {System.out.print("na");}
//	                                		try {System.out.print(" | "); System.out.print(transaction.getAvailableDate().getTime().toString());} catch (Exception e) {System.out.print("na");}
//	                                		try {System.out.print(" | "); System.out.print(transaction.getUserDate().getTime().toString());} catch (Exception e) {System.out.print("na");}
//	                                		try {System.out.print(" [A]"); System.out.print(transaction.getPayeeName());} catch (Exception e) {System.out.print("na");}
//                                            try {System.out.print(" [B]"); System.out.print(transaction.getAmount());} catch (Exception e) {System.out.print("na");}
//                                            try {System.out.print(" [C]"); System.out.print(transaction.getCurrencyType());} catch (Exception e) {System.out.print("na");}
//	                                		try {System.out.print(" [D]"); System.out.print(transaction.getType());} catch (Exception e) {System.out.print("na");}
//	                                		try {System.out.print(" [E]"); System.out.print(transaction.getMemo());} catch (Exception e) {System.out.print("na");}
//	                                		try {System.out.print(" [F]"); System.out.print(transaction.getCategorization().getCommon().getNormalizedPayeeName());} catch (Exception e) {System.out.print("na");}
//	                                		try {System.out.print(" [G]"); System.out.print(transaction.getCategorization().getCommon().getMerchant());} catch (Exception e) {System.out.print("na");}
//	                                		try {System.out.print(" [H]"); System.out.print(transaction.getCategorization().getCommon().getSic());} catch (Exception e) {System.out.print("na");}
//	                                		try {System.out.print(" [I]"); System.out.print(transaction.getCategorization().getContexts().get(0).getCategoryName());} catch (Exception e) {System.out.print("na");}
//	                                		try {System.out.print(" [J]"); System.out.print(transaction.getCategorization().getContexts().get(0).getContextType());} catch (Exception e) {System.out.print("na");}
//	                                		try {System.out.print(" [K]"); System.out.print(transaction.getCategorization().getContexts().get(0).getScheduleC());} catch (Exception e) {System.out.print("na");}
//	                                		try {System.out.print(" [L]"); System.out.print(transaction.getCategorization().getContexts().get(0).getSource().value());} catch (Exception e) {System.out.print("na");}
	                                	}
	                                }
	                                System.out.println("    SUCCESS");
                                }
                                else System.out.println("    FAILURE");

                                service.deleteCustomer(); //recreating user? how can i access another account at the same institution?
                        	}
                        	catch (AggCatException e) {
//                        		switch (Integer.parseInt(e.getErrorCode())) {
//                        			case 503:
//                        				System.out.println("page does not exist");
//                        				break;
//                        			case 403:
//                        				System.out.println("credentials wrong");
//                        				break;
//                        		}
                        		e.printStackTrace();
                        	}
            	            catch (Exception e) {e.printStackTrace();}
                        }
                        
                        for (UserVariable userVariable : user.userVariables) userVariable.delete(); //todo: handle what if intuit offline? still delete?
                        for (String name : amountMap.keySet()) {
                        	String code = null;
                            try {code = ExpenseSubcategory.find.where().eq("name", name).findUnique().code;} catch (Exception e) {}
                            if (code == null) try {code = ExpenseCategory.find.where().eq("name", name).findUnique().code;} catch (Exception e) {}
                            if (code != null) {	
                            	Map<Integer, Long[]> amountSubmap = amountMap.get(name);
                            	Map<Integer, Integer[]> frequencySubmap = frequencyMap.get(name);
                            	for (Integer timepoint : amountSubmap.keySet()) {
                            		Long[] amount = amountSubmap.get(timepoint);
                            		Integer[] frequency = frequencySubmap.get(timepoint);
                            		if (frequency[0] > 0) {
                            			UserVariable userVariable = new UserVariable();
                            			userVariable.user = user;
                            			userVariable.code = code;
                            			userVariable.timepoint = timepoint;
                            			userVariable.isDebit = true;
                            			userVariable.amount = amount[0];
                            			userVariable.frequency = frequency[0];
                            			userVariable.save();
                            		}
                            		if (frequency[1] > 0){
                            			UserVariable userVariable = new UserVariable();
                            			userVariable.user = user;
                            			userVariable.code = code;
                            			userVariable.timepoint = timepoint;
                            			userVariable.isDebit = false;
                            			userVariable.amount = amount[1];
                            			userVariable.frequency = frequency[1];
                            			userVariable.save();
                            		}
                            	}
                            }
                        }
                    }
                }
            	
            	/*
            	for (UserVariable userVariable : UserVariable.find.all()) {
            		System.out.println(userVariable.getUserUsername() + "  " + userVariable.getSubcategoryCode() + "  " + userVariable.getDaysAgo() + "  " + userVariable.getIsDebit() + "  " + userVariable.getAmount() + "  " + userVariable.getFrequency());
            	}
            	*/
                
                System.out.println("pause...");
                for (int sec = 0; sec < 600000; sec++) {
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
                if (service == null) try {Thread.sleep(1000 * 60);} catch (Exception e) {}
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