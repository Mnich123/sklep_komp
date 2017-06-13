  package Interfejs;

import java.util.concurrent.TimeUnit;

import javax.swing.JFrame;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * 
 * Klasa Main jest klas� g��wn�, kt�ra generuje GUI oraz inicjalizuje po��czenie z baz� danych
 * 
 * @author Pawe� Tarsa�a, Mateusz Miko�ajuk, Micha� Lewandowski
 *
 */
public class Main {

	/*
	 * TODO:
	 * 
	 * Opcjonalne:
	 * Doda� animacje ruchu klient�w
	 * Doda� mijaj�cy czas obs�ugi klienta przy kasie
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
