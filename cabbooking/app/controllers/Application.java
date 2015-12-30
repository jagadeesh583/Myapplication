package controllers;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Authenticator;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import models.Booking;
import models.Cab;
import models.Customer;
import models.Driver;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;

import com.avaje.ebean.Model;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

public class Application extends Controller {

	private class SMTPAuthenticator extends javax.mail.Authenticator {
	       public PasswordAuthentication getPasswordAuthentication() {
	         return new PasswordAuthentication("rajneshshakya07@gmail.com","imadpurr");
	     }
	  }
	
    public Result index() {
        return ok(views.html.index.render(""));
    }

    public Result driver(){
    	return ok(views.html.driver.render("enter driver details"));
    }
    
    public Result driverreg()
    {
    	Driver driver =Form.form(Driver.class).bindFromRequest().get();
    	List<Driver> dr =new Model.Finder(Integer.class,Driver.class).all();
    	Iterator <Driver>it = dr.iterator();
    	Driver dr1;
    	 while (it.hasNext())
    	 {
    		dr1=it.next();
    		if(dr1.name.equals(driver.name)){
    			return ok(views.html.index.render("driver with same is alreay existed"));
    		}
    		else
        	 {
        	 byte a[]=new byte[4096];
             try
             {
             FileInputStream fin=new FileInputStream(driver.getFilename());
             int i=0,j=0;
             while((i=fin.read())!=-1)
             {
                 a[j]=(byte)i;
                 j++;
             }
             }
             catch(Exception e)
             {
                 e.printStackTrace();
             }
             driver.setDriverimage(a);
             driver.save();
        	return ok(views.html.success.render("successfully registered"));
        	}
    	}
    	return ok(views.html.index.render(""));
    	
    	}
    public Result cust(){
     
    	
       return ok(views.html.custreg.render("first register to book a cab"));
    }
    public Result custreg(){
    	Customer cust =Form.form(Customer.class).bindFromRequest().get();
    	cust.save();
    	return ok(views.html.success.render("successfully registerd"));
    }
    
    public Result login(){
    	return ok(views.html.login.render(""));
    }
    public Result logincust()
    {
    	    Customer cust =Form.form(Customer.class).bindFromRequest().get();
    	    List<Customer> list= new Model.Finder(Integer.class,Customer.class).all();
    	    Iterator <Customer> itr=list.iterator();
    	    Customer cust1;
    		 while(itr.hasNext())
    		    {  
    		        cust1=itr.next();
    		       
    		        if(cust.getName().equals(cust1.getName())&&cust.getPassword().equals(cust1.getPassword()))
    		        {
    		        	System.out.println("jagadeesh"+cust1.getName()+"pass"+cust1.getPassword());
    		          return ok(views.html.book.render("select source and destination"));
    		       }
    		      
    		    }
    		 return ok(views.html.index.render("login fail"));
    }
    public Result book(){
    	Customer cust =Form.form(Customer.class).bindFromRequest().get();
    	System.out.println("cust id "+cust.getId());	
    	List<Driver> dr =new Model.Finder(Integer.class,Driver.class).all();
    	if(dr.size()!=0){
    	if(cust.source.equals(cust.destination)){
    		return ok(views.html.book.render("selected same source and destination"));
    	}
    	Cab cab =Form.form(Cab.class).bindFromRequest().get();
    	List<Driver> driverlist= new Model.Finder(Integer.class,Driver.class).all();
    	Iterator <Driver> itr1=driverlist.iterator();
    	   Driver temp;
    	if(cab.cabtype==4){
    		
        	System.out.println("you selected 4 members type cab");  
        	List<Cab> list= new Model.Finder(Integer.class,Cab.class).all();
    	    Iterator <Cab> itr=list.iterator();
    	    Cab cab1;
    		 while(itr.hasNext())
    		    {
    		        cab1=itr.next();
    		        if(cab1.cabtype==4){
    		        cab1.getCabnumber();
    		         Booking book=new Booking();
    		         book.cabtype=cab1.getCabtype();
    		         book.cabnumber=cab1.getCabnumber();
    		         book.custdestination=cust.destination;
    		         book.custmail=cust.getEmail();
    		         book.custsource=cust.source;
    		         book.date=cust.getDate();
    		        while(itr1.hasNext()){
    		        	temp=itr1.next();
    		        	if(temp.avialable==true){
    		        		book.drivername=temp.getName();
    		        		book.driverimage=temp.getDriverimage();
    		        		book.avialable=temp.avialable;
    		        		book.save();
    		        		return ok(views.html.bookingdetails.render("booking details",cust));
    		        	}
    		        	else{
    		        		System.out.println("no drivers are currently available");	
    		        	}
    		        }
    		        book.save();
    		         System.out.println(""+cab1.getCabnumber());
    		         break;
    		         }
    		        else{
    		        	System.out.println("no cabs  are currently  found with this type");
    		        }
    		        break;
    		    }
    		
          //  System.out.println(""+ cab.getCabnumber());
    	}
    	if(cab.cabtype==6){
          System.out.println("you selected 6 members type cab");  
        	List<Cab> list= new Model.Finder(Integer.class,Cab.class).all();
    	    Iterator <Cab> itr=list.iterator();
    	    Cab cab1;
    		 while(itr.hasNext())
    		    {
    		        cab1=itr.next();
    		        if(cab1.cabtype==6){
    		        	
    		         cab1.getCabnumber();
    		         Booking book=new Booking();
    		         book.cabtype=cab1.getCabtype();
    		         book.cabnumber=cab1.getCabnumber();
    		         book.custdestination=cust.destination;
    		         book.custmail=cust.getEmail();
    		         book.custsource=cust.source;
    		        while(itr1.hasNext()){
    		        	temp=itr1.next();
    		        	if(temp.avialable==true){
    		        		book.drivername=temp.getName();
    		        		book.driverimage=temp.getDriverimage();
    		        		book.avialable=temp.avialable;
    		        		book.save();
    		        		return ok(views.html.bookingdetails.render("booking details",cust));
    		        	
    		        	}
    		        	
    		        	else{
    		        		System.out.println("no drivers are currently available");	
    		        	}
    		        	book.save();
    		        }
    		        
    		       
    		         System.out.println(""+cab1.getCabnumber());
    		         break;
    		         }
    		        else{
    		        	System.out.println("no cabs  are currently  found with this type");
    		        }
    		        break;
    		    }

    	}
    	}
    	else{
    		return ok(views.html.index.render("no driver is available"));
    	}
    	
    	return ok(views.html.bookingdetails.render("booking details", cust));
    }
    public Result cabdetails(){
    	return ok(views.html.cab.render(""));
    }
    public Result cab(){
    
    	Cab cab=Form.form(Cab.class).bindFromRequest().get();
    	cab.save();
    	return ok(views.html.success.render("cab details entered successfully"));
    }
    public Result bookingdetails(){
    	
    	List<Customer > cust= (List<Customer>) new Model.Finder(Integer.class,Customer.class).all();
    	List <Booking> booking =(List<Booking>)	new Model.Finder(Integer.class,Booking.class).all();
    	int size=booking.size();
	    String name= cust.get(0).getName();
	    String email=cust.get(0).getEmail();
	    String source=booking.get(size-1).getCustsource();
	    String destination=booking.get(size-1).getCustdestination();
	    String schedule=booking.get(size-1).getDate();
	    List<Cab> cab= (List<Cab>) new Model.Finder(Integer.class,Cab.class).all();
	    long number=cab.get(0).getCabnumber();
	    int cabtype=cab.get(0).getCabtype();
	    List<Driver> driver= (List<Driver>) new Model.Finder(Integer.class,Driver.class).all();
	    String drivername=driver.get(0).getName();
	    	try{
	        File file =new File("/home/jagadeeshwara/cab.pdf");
    	    FileOutputStream pdfFile = new FileOutputStream(file);
            Document doc = new Document();
          try{
            PdfWriter.getInstance(doc, pdfFile);
            doc.addAuthor("jagadeesh");
			doc.addTitle("cab details");
            doc.open();
			Paragraph pg1=new Paragraph();	
			pg1.add("    ");
		    pg1.add("              Booking done  On the Date: "+ new Date()+"\n \n");
		    pg1.add("schedule \n"+schedule);
			pg1.add("                                         Name of customer: "+name+"\n"
					+"Source:"+source+"\n"+"Destination:"+destination+"\n"+"On Cab Number :"+number+"\n"+"Type of cab chooseen :"+cabtype+" Memebers"+"\n"+"Driver name "+drivername);
			pg1.add("\n \n \n \n \n ");
			pg1.add("                   Thank you for choosing this service ");
			pg1.add("\n \n ");
			pg1.add("  _________________ Happy joureny_______________________");
			doc.add(pg1);
            doc.close();
          }
           catch(DocumentException ex){
        	   ex.printStackTrace();
           }
            }
   catch(IOException e)
   {
	e.printStackTrace();
   
    }   	       
	    	       Properties props = new Properties();
	    	       props.put("mail.smtp.host", "smtp.gmail.com");
	    	       props.put("mail.smtp.port", "465");
	    	       props.put("mail.smtp.auth", "true");
	    	       props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");     
	    	       try {
	    	       Authenticator auth = new SMTPAuthenticator();  
	    	       Session session = Session.getInstance(props,auth);      
	    	       MimeMessage msg = new MimeMessage(session);
	    	       msg.setSubject("this is information about recent cab booking ");
	    	       msg.setFrom(new InternetAddress("rajneshshakya07@gmail.com"));
	    	       msg.addRecipient(Message.RecipientType.TO, new InternetAddress(cust.get(0).getEmail()));
	    	       BodyPart messageBodyPart = new MimeBodyPart(); 
	    	       messageBodyPart.setText("hello dear ");        
	    	       Multipart multipart = new MimeMultipart();        
	    	       multipart.addBodyPart(messageBodyPart);        
	    	       messageBodyPart = new MimeBodyPart();
	    	       String filename =  "/home/jagadeeshwara/cab.pdf";    
	    	       DataSource source1 = new FileDataSource(filename);
	    	       messageBodyPart.setDataHandler(new DataHandler(source1));
	    	       messageBodyPart.setFileName(filename);
	    	       multipart.addBodyPart(messageBodyPart);                                 
	    	       msg.setContent(multipart);
	    	       Transport.send(msg);
	    	       }
	    	        catch (Exception ex) {
	    	          ex.printStackTrace();
	    	          
	    	         }
	    	       return ok(views.html.index.render("booking successful check your mail for details"));
	    	         
	     }
}
