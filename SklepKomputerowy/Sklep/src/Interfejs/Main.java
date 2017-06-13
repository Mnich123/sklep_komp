  package Interfejs;

import java.util.concurrent.TimeUnit;

import javax.swing.JFrame;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * 
 * Klasa Main jest klas¹ g³ówn¹, która generuje GUI oraz inicjalizuje po³¹czenie z baz¹ danych
 * 
 * @author Pawe³ Tarsa³a, Mateusz Miko³ajuk, Micha³ Lewandowski
 *
 */
public class Main {

	/*
	 * TODO:
	 * 
	 * Opcjonalne:
	 * Dodaæ animacje ruchu klientów
	 * Dodaæ mijaj¹cy czas obs³ugi klienta przy kasie
	 * 
	 * 
	 */
	public static Configuration cfg = new Configuration();
	public static SessionFactory factory = null;
	/**
	 * Inicjalizowanie bazy danych oraz generowanie okna na ekran 
	 * @param args
	 */
	public static void main(String[] args) {
		
		cfg.configure("hibernate.cfg.xml");
		factory = cfg.buildSessionFactory();	
		
		Okno okno = new Okno();
		okno.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		okno.setSize(1000, 700);
		okno.setVisible(true);
		okno.setTitle("Sklep Komputerowy");
		/*while(true){
			okno.dodajKlienta();
			try {
				TimeUnit.MILLISECONDS.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
		*/
	}

}
