package models;

import java.util.*;

import javax.persistence.*;
import play.db.ebean.*;

@Entity public class ExpenseCategory extends Model {
	@Id public String code; public String getCode() {return this.code;} public ExpenseCategory setCode(String code) {this.code = code; return this;}

	// has many ExpenseSubcategory
    public List<ExpenseSubcategory> findExpenseSubcategories() {return ExpenseSubcategory.find.where().gt("code", code).lt("code", code + 1).findList();}
    
	public String name; public String getName() {return this.name;} public ExpenseCategory setName(String name) {this.name = name; return this;}
    
	public ExpenseCategory saveGet() {this.save(); return this;}
    public static Finder<String, ExpenseCategory> find = new Finder<String, ExpenseCategory>(String.class, ExpenseCategory.class);
}