package Logika;

import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Dane.Stale;

public class Klient extends Osoba {

	private Vector<Produkt> koszyk = new Vector<Produkt>();

	private JLabel obrazKlienta;
	
	private boolean czyWKolejce;
	
	public Klient(){
		
		this.czyWKolejce = false;
		ImageIcon nowyKlient = new ImageIcon(getClass().getResource("klient.png"));
		
		obrazKlienta = new JLabel(nowyKlient);
		
		obrazKlienta.setSize(Dane.Stale.RozmiaryObrazów.klientX , Stale.RozmiaryObrazów.klientY); 
		
	}
	
	public JLabel pobierzEtykiete(){
		return obrazKlienta;
	}
	
	public String pobierzProdukty(){
		
		String wszytkieProdukty = "";
		
		for( int i = 0 ; i < koszyk.size(); i++){
			wszytkieProdukty+= koszyk.get(i).getNazwa() + "\n";
			
		}
		
		return wszytkieProdukty;
	}
	public boolean pobierzCzyWKolejce(){
		return this.czyWKolejce;
	}
	
	public void ustawCzyWKolejce(boolean decyzja){
		this.czyWKolejce = decyzja;	
	}
	public void dodajProdukt( Produkt produkt){
		koszyk.add(produkt);
	}
	
	public boolean usunProdukt(int pozycjaWKoszyku){
		if( koszyk.get(pozycjaWKoszyku).pobierzCzySprzedane() == false){
			koszyk.get(pozycjaWKoszyku).ustawCzySprzedane(true);
			koszyk.remove(pozycjaWKoszyku);
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
