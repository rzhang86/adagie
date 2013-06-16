package models;

import javax.persistence.*;
import play.db.ebean.*;

@Entity public class PayoutFormula extends Model {
	@Id public Long id; public static Finder<Long, PayoutFormula> find = new Finder<Long, PayoutFormula>(Long.class, PayoutFormula.class);
    
	@ManyToOne public Video video = null;
	
    public String condition = null;
    public String result = null;
}