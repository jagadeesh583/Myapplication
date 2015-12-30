package models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.avaje.ebean.Model;
@Entity
public class Customer extends Model {
	    @Id
	    public int id;
	    @Column
	    public String name;	
	    @Column
	    public long mobile;
	    public String getDate() {
			return date;
		}
		public void setDate(String date) {
			this.date = date;
		}
		@Column
	    public String email;
	    @Column
	    public String source;
	    @Column
	    public String destination;
	    public String password;
	 //   @Temporal(TemporalType.DATE)
	   // public Date date;
		public String date;
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public String getSource() {
			return source;
		}
		public void setSource(String source) {
			this.source = source;
		}
		public String getDestination() {
			return destination;
		}
		public void setDestination(String destination) {
			this.destination = destination;
		}
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public long getMobile() {
			return mobile;
		}
		public void setMobile(long mobile) {
			this.mobile = mobile;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
	    
 
}
