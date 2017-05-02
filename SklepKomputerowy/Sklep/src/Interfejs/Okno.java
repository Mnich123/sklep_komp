package Interfejs;

import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Dane.Stale;
import Logika.Klient;

public class Okno extends JFrame {
	private static final long serialVersionUID = 1L;
	

	private Vector<Kasa> kasy = new Vector<Kasa>();
	//private Vector<JLabel> klienci = new Vector<JLabel>();
	private Vector<Klient> klienci = new Vector<Klient>();
	
	private int licznikKlientow = 0, licznikKas = 1;

	private JPanel myPanel;

	private JButton b_dodajProdukt;
	private JButton b_dodajKlienta;
	private JButton b_dodajKase;
	private JButton b_resetuj;
	private JButton b_start;
	private JButton b_stop;

	private JLabel l_kasa;
	private JLabel l_reklamacje;
	private JLabel l_sklep;
	private JLabel l_kolejkaDoKasy;
	private JLabel l_kolejkaDoReklamacji;
	private JLabel l_i_klient;
	private JLabel l_i_klient2;


	public Okno() {
		
		
		setLayout(null);
		////// ***** ETYKIETY *******////

		/*
		 * l_kasa = new JLabel("Kasa"); l_sklep = new JLabel("Sklep");
		 * l_reklamacje = new JLabel("Reklamacje"); l_kolejkaDoKasy = new
		 * JLabel("Liczba Kas:"); l_kolejkaDoReklamacji = new
		 * JLabel("Reklamacje");
		 * 
		 * //Je¿eli nie ustawisz rozmiaru, to nie bedzie wyswietlane
		 * 
		 * l_kasa.setSize(l_kasa.getText().length()*8 ,10);
		 * l_sklep.setSize(l_sklep.getText().length()*8 ,10);
		 * l_reklamacje.setSize(l_reklamacje.getText().length()*8 ,10);
		 * l_kolejkaDoKasy.setSize(l_kolejkaDoKasy.getText().length()*8 ,10);
		 * l_kolejkaDoReklamacji.setSize(l_kolejkaDoReklamacji.getText().length(
		 * )*8 ,10);
		 * 
		 * 
		 * l_sklep.setLocation(new Point(20,20)); l_kasa.setLocation(new
		 * Point(20,70)); l_reklamacje.setLocation(new Point(20,130));
		 * l_kolejkaDoKasy.setLocation(new Point(20,180));
		 * l_kolejkaDoReklamacji.setLocation(new Point(20,230));
		 * 
		 * 
		 * add(l_kasa); add(l_reklamacje); add(l_sklep); add(l_kolejkaDoKasy);
		 * add(l_kolejkaDoReklamacji);
		 */

		

		////// ****** PRZYCISKI ******///////

		b_dodajProdukt = new JButton("Dodaj Produkt");
		b_dodajKlienta = new JButton("Dodaj Klienta");
		b_dodajKase = new JButton("Dodaj Kase");
		b_resetuj = new JButton("Resetuj");
		// b_start = new JButton("START");
		// b_stop = new JButton("STOP");

		b_dodajProdukt.setSize(b_dodajProdukt.getText().length() * 8 + 20, 30);
		b_dodajKlienta.setSize(b_dodajKlienta.getText().length() * 8 + 20, 30);
		b_dodajKase.setSize(b_dodajKase.getText().length() * 8 + 20, 30);
		b_resetuj.setSize(b_resetuj.getText().length() * 8 + 30, 30);
		// b_start.setSize(b_start.getText().length()* 8 + 50,30);
		// b_stop.setSize(b_stop.getText().length()* 8 + 50,30);

		b_dodajKlienta.setLocation(new Point(20, 20));
		b_dodajKase.setLocation(new Point(150, 20));
		b_dodajProdukt.setLocation(new Point(260, 20));
		b_resetuj.setLocation(new Point(400, 20));
		// b_start.setLocation(new Point(150,250));
		// b_stop.setLocation(new Point(260,250));

		add(b_dodajProdukt);
		add(b_dodajKlienta);
		add(b_dodajKase);
		add(b_resetuj);
		// add(b_start);
		// add(b_stop);
		
		
		b_dodajKlienta.addActionListener(new ActionListener() { 
			  public void actionPerformed(ActionEvent e) { 
				    dodajKlienta();
				  } 
				});
		
		b_dodajKase.addActionListener(new ActionListener() { 
			  public void actionPerformed(ActionEvent e) { 
				    dodajKase();
				  } 
				});
		
		b_resetuj.addActionListener(new ActionListener() { 
			  public void actionPerformed(ActionEvent e) { 
				    resetuj();
				  } 
				});
		
		inicjalizujKlientow();
		inicjalizujKasy();

	}
	
	public void inicjalizujKlientow(){
		for( int i = 0 ; i < Dane.Stale.Liczebnosci.klientMax; i++ ){
			klienci.add(new Klient());
		}
	}
	public void inicjalizujKasy(){
		for( int i = 0 ; i < Dane.Stale.Liczebnosci.kasaMax; i++ ){
			kasy.add(new Kasa());
		}
	}
	
	public void resetuj(){
		for( int i = 0 ; i < Dane.Stale.Liczebnosci.klientMax ; i++){
			if(klienci.get(i).pobierzCzyWKolejce()){
				remove(klienci.get(i).pobierzEtykiete());
				klienci.get(i).ustawCzyWKolejce(false);
			}
			
		}
		licznikKlientow = 0;
		
		for( int i = 0 ; i < Dane.Stale.Liczebnosci.kasaMax ; i++){
			if(kasy.get(i).pobierzCzyWidoczna()){
				kasy.get(i).usunKlientowZKolejki();
				remove(kasy.get(i).pobierzEtykiete());
				kasy.get(i).ustawCzyWidoczna(false);
			}
			
		}
		licznikKas = 1;
		

		revalidate();
		
		repaint();
	}
	public void dodajKase() {

		kasy.get(licznikKas-1).pobierzEtykiete().setLocation((licznikKas) * (Stale.RozmiaryObrazów.kasaX + 10),60);
		kasy.get(licznikKas-1).ustawCzyWidoczna(true);
		add(kasy.get(licznikKas-1).pobierzEtykiete());
		
		licznikKas++;

		revalidate();
		
		repaint();

	}

	
	public void dodajKlienta() {
		
		if(licznikKlientow == Dane.Stale.Liczebnosci.klientMax - 1 || licznikKas == 1)return;
		
		
		int min = 0;

		for (int i = 0 ; i < licznikKas - 1; i++) {
			if(kasy.get(i).pobierzDlugoscKolejki() == 0){
				min = i;
				break;
			}
			if (kasy.get(i).pobierzDlugoscKolejki() < kasy.get(min).pobierzDlugoscKolejki()) {
				min = i;
			}
		}
		
		for( int i = 0 ; i <Dane.Stale.Liczebnosci.klientMax; i++ ){

			if(klienci.get(licznikKlientow).pobierzCzyWKolejce()){
				licznikKlientow = ++licznikKlientow%Dane.Stale.Liczebnosci.klientMax;
			}
			else{
				klienci.get(licznikKlientow).ustawCzyWKolejce(true);
				break;
			}
			
		}
		//ustawianie klienta w kolejce
		
		klienci.get(licznikKlientow).pobierzEtykiete().setLocation(( min + 1) * (Stale.RozmiaryObrazów.kasaX + 10) + 30, (kasy.get(min).pobierzDlugoscKolejki() + 1)*(Stale.RozmiaryObrazów.klientY + 5) + 130  );
		
		kasy.get(min).dodajKlientaDoKolejki(klienci.get(licznikKlientow));
		
		add(klienci.get(licznikKlientow).pobierzEtykiete());
		
		revalidate();
		
		repaint();
		
		
	}

	public static void main(String args[]) {

		Okno okno = new Okno();
		okno.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		okno.setSize(1000, 700);
		okno.setVisible(true);
		okno.setTitle("Sklep Komputerowy");

	}
}
