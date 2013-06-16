package models;

import javax.persistence.*;

import play.db.ebean.*;

@Entity public class ExpenseSubcategory extends Model {
	@Id public Long id; public static Finder<Long, ExpenseSubcategory> find = new Finder<Long, ExpenseSubcategory>(Long.class, ExpenseSubcategory.class);
	
	@ManyToOne public ExpenseCategory expenseCategory = null;
	
	@Column(unique=true) public String code = null;
	@Column(unique=true) public String name = null;
}