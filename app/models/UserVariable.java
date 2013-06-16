package models;

import java.util.*;
import javax.persistence.*;
import play.db.ebean.*;

@Entity public class UserVariable extends Model {
	@Id public Long id; public static Finder<Long, UserVariable> find = new Finder<Long, UserVariable>(Long.class, UserVariable.class);
    
	@ManyToOne public User user = null;
	
    public String code = null;
    public Integer timepoint = null;
    public Boolean isDebit = null;
    public Long amount = null;
    public Integer frequency = null;
}