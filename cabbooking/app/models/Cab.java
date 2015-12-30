package models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import com.avaje.ebean.Model;
@Entity
public class Cab extends Model {

	    @Id
	    public int id;	
	    @Column
	    public long cabnumber;
        @Column
	    public int  cabtype;
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public long getCabnumber() {
			return cabnumber;
		}
		public void setCabnumber(long cabnumber) {
			this.cabnumber = cabnumber;
		}
		public int getCabtype() {
			return cabtype;
		}
		public void setCabtype(int cabtype) {
			this.cabtype = cabtype;
		}    
}
