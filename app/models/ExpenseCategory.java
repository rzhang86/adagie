package models;

import java.util.*;
import javax.persistence.*;

import play.db.ebean.*;

@Entity public class ExpenseCategory extends Model {
	@Id public Long id; public static Finder<Long, ExpenseCategory> find = new Finder<Long, ExpenseCategory>(Long.class, ExpenseCategory.class);
	
	@OneToMany(mappedBy = "expenseCategory", cascade = CascadeType.ALL) public List<ExpenseSubcategory> expenseSubcategorys = new ArrayList<ExpenseSubcategory>();
	
	@Column(unique=true) public String code = null;
	@Column(unique=true) public String name = null;
	
	
	// getters/setters
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public List<ExpenseSubcategory> getExpenseSubcategorys() {
		return expenseSubcategorys;
	}
	public void setExpenseSubcategorys(List<ExpenseSubcategory> expenseSubcategorys) {
		this.expenseSubcategorys = expenseSubcategorys;
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