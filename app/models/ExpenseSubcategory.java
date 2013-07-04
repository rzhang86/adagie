package models;

import javax.persistence.*;

import play.db.ebean.*;

@Entity public class ExpenseSubcategory extends Model {
	@Id public Long id; public static Finder<Long, ExpenseSubcategory> find = new Finder<Long, ExpenseSubcategory>(Long.class, ExpenseSubcategory.class);
	
	@ManyToOne public ExpenseCategory expenseCategory = null;
	
	@Column(unique=true) public String code = null;
	@Column(unique=true) public String name = null;

	
	
	// getters/setters
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public ExpenseCategory getExpenseCategory() {
		return expenseCategory;
	}
	public void setExpenseCategory(ExpenseCategory expenseCategory) {
		this.expenseCategory = expenseCategory;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}