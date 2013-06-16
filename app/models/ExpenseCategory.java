package models;

import java.util.*;
import javax.persistence.*;

import play.db.ebean.*;

@Entity public class ExpenseCategory extends Model {
	@Id public Long id; public static Finder<Long, ExpenseCategory> find = new Finder<Long, ExpenseCategory>(Long.class, ExpenseCategory.class);
	
	@OneToMany(mappedBy = "expenseCategory", cascade = CascadeType.ALL) public List<ExpenseSubcategory> expenseSubcategorys = new ArrayList<ExpenseSubcategory>();
	
	@Column(unique=true) public String code = null;
	@Column(unique=true) public String name = null;
}