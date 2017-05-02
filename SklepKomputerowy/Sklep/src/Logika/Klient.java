package Logika;

import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Dane.Stale;

public class Klient extends Osoba {

	private Vector<Produkt> koszyk = new Vector<Produkt>();

	private JLabel obrazKlienta;
	
	public Klient(){
		
		ImageIcon nowyKlient = new ImageIcon(getClass().getResource("klient.png")); ;
		
		obrazKlienta = new JLabel(nowyKlient);
		
		obrazKlienta.setSize(Dane.Stale.RozmiaryObraz�w.klientX , Stale.RozmiaryObraz�w.klientY); 
		
	}
	
	public JLabel pobierzEtykiete(){
		return obrazKlienta;
	}
	
	
	public void dodajProdukt( Produkt produkt){
		koszyk.add(produkt);
	}
	
	public boolean usunProdukt(int pozycjaWKoszyku){
		if( koszyk.get(0).pobierzCzySprzedane() == false){
			koszyk.get(0).ustawCzySprzedane(true);
			koszyk.remove(0);
			return true;
		}

		koszyk.remove(0);
		return false;
	}
	
	@Override
	public boolean equals(Object o) {
		Klient k = (Klient) o;
		return this.pobierzPESEL() == k.pobierzPESEL();
	}
}