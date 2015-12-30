package models;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;

import com.avaje.ebean.Model;
@Entity
public class Driver extends Model {
	@Id
    public int id;
	@Column
	public String name;
	@Column
	@Lob
	public byte[] driverimage;
	public boolean avialable;
	public String filename;
	public long mobileno;
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
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
