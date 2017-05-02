package Interfejs;

import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Dane.Stale;
import Logika.Klient;

public class Kasa {

	private Vector<Klient> kolejka = new Vector<Klient>();
	
	private JLabel obrazKasy;
	
	public Kasa(){
		
		ImageIcon nowaKasa = new ImageIcon(getClass().getResource("kasa.png")); ;
		
		obrazKasy = new JLabel(nowaKasa);
		
		obrazKasy.setSize(Dane.Stale.RozmiaryObrazów.kasaX , Stale.RozmiaryObrazów.kasaY); 
		
		
	}
	
	public JLabel pobierzEtykiete(){
		return obrazKasy;
	}
	public void dodajKlientaDoKolejki(Klient klient){
		
		kolejka.add(klient);
		
	}
	public void usunKlientaZKolejki(Klient klient){
		
		kolejka.remove(0);
		
	}
	public int pobierzDlugoscKolejki(){
		return kolejka.size();
	}
}
