
package models;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;import com.avaje.ebean.Model;
@Entity
@Table(name="registration")
public class Registration extends Model{
    @Id
    private int id;
    @Column
    private String name;
    @Column
    private String city;
    @Column
    private String user1;
    @Column
    private String state;
    @Column
    private String country;
    @Column
    private String password;
    
  
    
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public String getState() {
        return state;
    }
    public void setState(String state) {
        this.state = state;
    }
    public String getCountry() {
        return country;
    }
    public void setCountry(String country) {
        this.country = country;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    
    
    
    public String getUser1() {
        return user1;
    }
    public void setUser1(String user1) {
        this.user1 = user1;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    
    }