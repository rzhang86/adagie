package models;

import javax.persistence.*;
import play.db.ebean.*;

@Entity public class ExpenseSubcategory extends Model {
	@Id public String code; public String getCode() {return this.code;} public ExpenseSubcategory setCode(String code) {this.code = code; return this;}

	// has one ExpenseCategory
    public ExpenseCategory findExpenseCategory() {return ExpenseCategory.find.ref((code + ".").split("\\.")[0]);}
    
	public String name; public String getName() {return this.name;} public ExpenseSubcategory setName(String name) {this.name = name; return this;}
    
	public ExpenseSubcategory saveGet() {this.save(); return this;}
    public static Finder<String, ExpenseSubcategory> find = new Finder<String, ExpenseSubcategory>(String.class, ExpenseSubcategory.class);
}