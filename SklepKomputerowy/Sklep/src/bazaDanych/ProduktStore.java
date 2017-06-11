package bazaDanych;

import org.hibernate.Session;  
import org.hibernate.SessionFactory;  
import org.hibernate.Transaction;  
import org.hibernate.cfg.Configuration;  
import Logika.Produkt;

public class ProduktStore {

	public static void main(String[] args) {  
	      
	    //creating configuration object  
	    Configuration cfg=new Configuration();  
	    cfg.configure("hibernate.cfg.xml");//populates the data of the configuration file  
	      
	    //creating seession factory object  
	    SessionFactory factory=cfg.buildSessionFactory();  
	      
	    //creating session object  
	    Session session=factory.openSession();  
	     
	    //creating transaction object  
	    Transaction t=session.beginTransaction();  
	          
	    Produkt e1=new Produkt(); //przykladowa transakcja, dodaje nowy produkt o cenie 4 i nazwie gra, id samoinkrementowalne
	    e1.setCena(4);
	    e1.setNazwa("gra");
	    session.persist(e1);//persisting the object  
	    t.commit();//transaction is committed  
	    session.close();  
	      
	    System.out.println("successfully saved"+e1.getCena()+" "+e1.getid());  
	      
	}   
}
