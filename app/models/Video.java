package models;

import java.util.*;
import javax.persistence.*;
import play.db.ebean.*;
import org.nfunk.jep.*;

// todo: limit duration to 1 minute? infinite duration will prevent payment
// todo: may not upload videos if committed balance is negative
// todo: add limit of money spent?
@Entity public class Video extends Model {
	@Id public Long id; public static Finder<Long, Video> find = new Finder<Long, Video>(Long.class, Video.class);
    
	@ManyToOne public User user = null;
	
	@OneToMany(mappedBy = "watchingVideo", cascade = CascadeType.ALL) public List<User> watchingUsers = new ArrayList<User>();
	@OneToMany(mappedBy = "video", cascade = CascadeType.ALL) public List<WatchedVideo> watchedVideos = new ArrayList<WatchedVideo>();
	@OneToMany(mappedBy = "video", cascade = CascadeType.ALL) public List<PayoutFormula> payoutFormulas = new ArrayList<PayoutFormula>();
	
    public String title = null;
    public String description = null;
    public Integer duration = null;
    
    public Long getPayout(User user) {
        try {
        	JEP jep = new JEP();
            jep.setAllowUndeclared(false);
            jep.setAllowAssignment(false);
            jep.setImplicitMul(false);
            jep.setTraverse(false);
            
            List<Integer> timepointDays = new ArrayList<Integer>(Arrays.asList(360, 270, 180, 150, 120, 90, 75, 60, 45, 30, 25, 20, 15, 10, 5, 4, 3, 2, 1));
            //todo: categories do not need to be queried each time, store them somewhow
            List<String> categoryCodes = new ArrayList<String>();
            List<String> subcategoryCodes = new ArrayList<String>();
            categoryCodes.add("0");
            for (ExpenseCategory expenseCategory : ExpenseCategory.find.all()) categoryCodes.add(expenseCategory.code);
            for (ExpenseSubcategory expenseSubcategory : ExpenseSubcategory.find.all()) subcategoryCodes.add(expenseSubcategory.code);
            Long[][][][] categorySpending = new Long[categoryCodes.size()][timepointDays.size()][2][2]; //cat, days, debit/credit, amount/freq
            Long[][][][] subcategorySpending = new Long[subcategoryCodes.size()][timepointDays.size()][2][2];
            for (int i = 0; i < categorySpending.length; i++) for (int j = 0; j < categorySpending[i].length; j++) for (int k = 0; k < categorySpending[i][j].length; k++) for (int l = 0; l < categorySpending[i][j][k].length; l++) {
            	categorySpending[i][j][k][l] = 0L;
            }
            for (int i = 0; i < subcategorySpending.length; i++) for (int j = 0; j < subcategorySpending[i].length; j++) for (int k = 0; k < subcategorySpending[i][j].length; k++) for (int l = 0; l < subcategorySpending[i][j][k].length; l++) {
            	subcategorySpending[i][j][k][l] = 0L;
            }
            for (UserVariable userVariable : user.userVariables) {
            	String code = userVariable.code;
            	int iCategory = categoryCodes.indexOf(code);
            	int iTimepoint = timepointDays.indexOf(userVariable.timepoint);
            	int iSubcategory = subcategoryCodes.indexOf(code);
            	if (iTimepoint >= 0) {
	            	if (iSubcategory >= 0) {
	            		if (userVariable.isDebit) {
	        				for (int i = iTimepoint; i >= 0; i--) {
	        					subcategorySpending[iSubcategory][i][0][0] += userVariable.amount;
	        					subcategorySpending[iSubcategory][i][0][1] += userVariable.frequency;
	        				}
	        			}
	        			else {
	        				for (int i = iTimepoint; i >= 0; i--) {
	        					subcategorySpending[iSubcategory][i][1][0] += userVariable.amount;
	        					subcategorySpending[iSubcategory][i][1][1] += userVariable.frequency;
	        				}
	        			}
	            		iCategory = categoryCodes.indexOf(code.split("\\.")[0]);
	            	}
	            	if (iCategory >= 0) {
	        			if (userVariable.isDebit) {
	        				for (int i = iTimepoint; i >= 0; i--) {
	        					categorySpending[iCategory][i][0][0] += userVariable.amount;
	        					categorySpending[iCategory][i][0][1] += userVariable.frequency;
	        				}
	        			}
	        			else {
	        				for (int i = iTimepoint; i >= 0; i--) {
	        					categorySpending[iCategory][i][1][0] += userVariable.amount;
	        					categorySpending[iCategory][i][1][1] += userVariable.frequency;
	        				}
	        			}
	            	}
	            	if (userVariable.isDebit) {
	    				for (int i = iTimepoint; i >= 0; i--) {
	    					categorySpending[0][i][0][0] += userVariable.amount;
	    					categorySpending[0][i][0][1] += userVariable.frequency;
	    				}
	    			}
	    			else {
	    				for (int i = iTimepoint; i >= 0; i--) {
	    					categorySpending[0][i][1][0] += userVariable.amount;
	    					categorySpending[0][i][1][1] += userVariable.frequency;
	    				}
	    			}
            	}
            }
            for (int i = 0; i < categorySpending.length; i++) for (int j = 0; j < categorySpending[i].length; j++) for (int k = 0; k < categorySpending[i][j].length; k++) for (int l = 0; l < categorySpending[i][j][k].length; l++) {
				jep.addVariable((l == 0 ? "a" : "f") + categoryCodes.get(i) + (k == 0 ? "d" : "c") + timepointDays.get(j), (double) categorySpending[i][j][k][l]);
            }
            for (int i = 0; i < subcategorySpending.length; i++) for (int j = 0; j < subcategorySpending[i].length; j++) for (int k = 0; k < subcategorySpending[i][j].length; k++) for (int l = 0; l < subcategorySpending[i][j][k].length; l++) {
				jep.addVariable((l == 0 ? "a" : "f") + subcategoryCodes.get(i) + (k == 0 ? "d" : "c") + timepointDays.get(j), (double) subcategorySpending[i][j][k][l]);
            }
            // todo: catch invalid parse, and check pay formula at time of video creation
            for (PayoutFormula videoPayFormula : this.payoutFormulas) {
            	try {
	            	jep.parseExpression(videoPayFormula.condition);
	            	if (jep.getValue() == 1.0 || videoPayFormula.condition.trim().equals("")) {
	            		jep.parseExpression(videoPayFormula.result);
	            		return Math.max(1L, (long) Math.round(jep.getValue()));
	            	}
            	}
            	catch (Exception e) {}
            }
        }
        catch (Exception e) {e.printStackTrace();}
        return 1L;
    }
}