package models;




import javax.persistence.Entity;
import javax.persistence.Id;

import com.avaje.ebean.Model;

@Entity
public class Booking extends Model {
    @Id
	public int id;
    public String custname;
    public int cabtype;
    public String custsource;
    public String custdestination;
    public long  cabnumber;
    public String custmail;
    public String drivername;
	public byte[] driverimage;
	public boolean avialable;
	public String date;
	
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCustname() {
		return custname;
	}
	public void setCustname(String custname) {
		this.custname = custname;
	}
	public int getCabtype() {
		return cabtype;
	}
	public void setCabtype(int cabtype) {
		this.cabtype = cabtype;
	}
	public String getCustsource() {
		return custsource;
	}
	public void setCustsource(String custsource) {
		this.custsource = custsource;
	}
	public String getCustdestination() {
		return custdestination;
	}
	public void setCustdestination(String custdestination) {
		this.custdestination = custdestination;
	}
	public long getCabnumber() {
		return cabnumber;
	}
	public void setCabnumber(long cabnumber) {
		this.cabnumber = cabnumber;
	}
	public String getCustmail() {
		return custmail;
	}
	public void setCustmail(String custmail) {
		this.custmail = custmail;
	}
	public String getDrivername() {
		return drivername;
	}
	public void setDrivername(String drivername) {
		this.drivername = drivername;
	}
	public byte[] getDriverimage() {
		return driverimage;
	}
	public void setDriverimage(byte[] driverimage) {
		this.driverimage = driverimage;
	}
	public boolean isAvialable() {
		return avialable;
	}
	public void setAvialable(boolean avialable) {
		this.avialable = avialable;
	}
	
}
