package controllers;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import models.Password;
import models.Registration;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;

import com.avaje.ebean.Model;
public class Application extends Controller {  
	public Result index() {
       return ok(views.html.index.render("Your new application is ready."));
   }
   public Result add() {
       return ok(views.html.add.render(""));
   }
   
   public Result login() {
       return ok(views.html.login.render(""));
   }
   
   public Result success() {
       return ok(views.html.success.render("successfully Done"));
   }
   
   public Result loginfail() {
       return ok(views.html.loginfail.render(""));
   }
   public Result forget() {
       return ok(views.html.forgetpassword.render(""));
   }
   
   
public Result addPerson(){
        Registration reg=Form.form(Registration.class).bindFromRequest().get();     
        reg.save();
       
       
       return redirect(routes.Application.success());
       
   }
public Result loginPerson()
{
    Registration reg=Form.form(Registration.class).bindFromRequest().get();
    List<Registration> list= new Model.Finder(Integer.class,Registration.class).all();
    Iterator <Registration> itr=list.iterator();
    String user=reg.getUser1();
    String pass=reg.getPassword();
    boolean flag=false;
    Registration reg1;
    ArrayList <Registration> al=new ArrayList<Registration>();
    while(itr.hasNext())
    {
        reg1=itr.next();
        if(user.equals(reg1.getUser1())&&pass.equals(reg1.getPassword()))
        {
            al.add(reg1);
            flag=true;
            break;
        }
    }
    if(flag)
    {
        return ok(views.html.welcome.render(al));
    }
    else
    {
        return redirect(routes.Application.loginfail());
    }
}
public Result logout()
{
    return ok(views.html.logout.render(""));
}

public Result forgetpass(){
	  Registration reg=Form.form(Registration.class).bindFromRequest().get();
	    List<Registration> list= new Model.Finder(Registration.class).all();
	    Iterator <Registration> itr=list.iterator();
	    String user=reg.getUser1();
	    String city=reg.getCity();
	    boolean flag=false;
	    Registration reg1;
	    String pass=null;
	    while(itr.hasNext())
	    {
	        reg1=itr.next();
	       
	        if(user.equals(reg1.getUser1())&&city.equals(reg1.getCity()))
	        {
	           pass=reg1.getPassword();
	            flag=true;
	            break;
	        }
	    }
	    if(flag)
	    {
	        return ok("your password"+pass );
	    }
	    else
	    {
	        return ok("user name and city are wrong ");
	    }

}
public Result changepass(){
	 Password reg=Form.form(Password.class).bindFromRequest().get();
	 String pass=reg.getOldpassword();
	 String newpass=reg.getNewpassword();
	 List<Registration> list= new Model.Finder(Integer.class,Registration.class).all();
	 Iterator <Registration> itr=list.iterator();
	 Registration reg1;
	 while(itr.hasNext())
	    {
	        reg1=itr.next();
	       
	        if(pass.equals(reg1.getPassword()))
	        {
	           reg1.setPassword(newpass);
	           reg1.save();
	            break;
	        }
	    }
	return ok("password successfully changed");
}

}






