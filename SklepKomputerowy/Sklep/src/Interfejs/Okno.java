package Interfejs;

import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.ToolTipManager;

import Dane.Stale;
import Logika.Klient;

public class Okno extends JFrame {
	private static final long serialVersionUID = 1L;

	private Vector<Kasa> kasy = new Vector<Kasa>();
	// private Vector<JLabel> klienci = new Vector<JLabel>();
	private Vector<Klient> klienci = new Vector<Klient>();
	private Vector<JLabel> kasyEtykiety = new Vector<JLabel>();

	private int licznikKlientow = 0, licznikKas = 1;
	private int liczbaKlientow = 0;

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
	private JLabel l_liczbaKlientow;

	public Okno() {

		setLayout(null);
		////// ***** ETYKIETY *******////

		
		  l_kasa = new JLabel("Kasa");
		  l_sklep = new JLabel("Sklep");
		  l_reklamacje = new JLabel("Reklamacje");
		  l_kolejkaDoKasy = new JLabel("Liczba Kas:"); 
		  l_liczbaKlientow = new JLabel("Liczba Klientow: " + licznikKlientow); 
		  l_kolejkaDoReklamacji = new JLabel("Reklamacje");
		  
		  //Je�eli nie ustawisz rozmiaru, to nie bedzie wyswietlane
		  
		  l_kasa.setSize(l_kasa.getText().length()*8 ,10);
		  l_sklep.setSize(l_sklep.getText().length()*8 ,10);
		  l_reklamacje.setSize(l_reklamacje.getText().length()*8 ,10);
		  l_kolejkaDoKasy.setSize(l_kolejkaDoKasy.getText().length()*8 ,10);
		  l_kolejkaDoReklamacji.setSize(l_kolejkaDoReklamacji.getText().length()*8 ,10);
		  l_liczbaKlientow.setSize(l_liczbaKlientow.getText().length()*8 ,10);
		 
		  
		  l_sklep.setLocation(new Point(20,20)); l_kasa.setLocation(new
		  Point(20,70)); l_reklamacje.setLocation(new Point(20,130));
		  l_kolejkaDoKasy.setLocation(new Point(20,180));
		  l_kolejkaDoReklamacji.setLocation(new Point(20,230));
		  l_liczbaKlientow.setLocation(new Point(500,30));
		  
		  
		  //add(l_kasa);
		  //add(l_reklamacje);
		  //add(l_sklep);
		  //add(l_kolejkaDoKasy);
		  //add(l_kolejkaDoReklamacji);
		  add(l_liczbaKlientow);
		 

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
				usunKlientaZKolejki(0);
			}
		});

		inicjalizujKlientow();
		inicjalizujKasy();

	}

	public void inicjalizujKlientow() {
		for (int i = 0; i < Dane.Stale.Liczebnosci.klientMax; i++) {
			klienci.add(new Klient());
			klienci.lastElement().pobierzEtykiete().setToolTipText(klienci.lastElement().pobierzImie() + klienci.lastElement().pobierzProdukty());
		}
	}

	public void inicjalizujKasy() {
		for (int i = 0; i < Dane.Stale.Liczebnosci.kasaMax; i++) {
			kasy.add(new Kasa(i));
			kasy.lastElement().ustawOkno(this);
			kasyEtykiety.add(new JLabel("Klientow : "));
			Dane.Semafory.semKasy.add(new Semaphore(0));
		}
	}

	public void resetuj() {
		for (int i = 0; i < Dane.Stale.Liczebnosci.klientMax; i++) {
			if (klienci.get(i).pobierzCzyWKolejce()) {
				remove(klienci.get(i).pobierzEtykiete());
				klienci.get(i).ustawCzyWKolejce(false);
			}

		}
		licznikKlientow = 0;
		
		Dane.Statyczne.wlaczenieKas = false;
		for (int i = 0; i < Dane.Stale.Liczebnosci.kasaMax; i++) {
			if (kasy.get(i).pobierzCzyWidoczna()) {
				kasy.get(i).usunKlientowZKolejki();
				remove(kasy.get(i).pobierzEtykiete());
				remove(kasyEtykiety.get(i));
				kasy.get(i).ustawCzyWidoczna(false);
				
			}

		}
		licznikKas = 1;

		revalidate();

		repaint();
		

		Dane.Statyczne.wlaczenieKas = true;
	}

	public void dodajKase() {

		kasy.get(licznikKas - 1).pobierzEtykiete().setLocation((licznikKas) * (Stale.RozmiaryObraz�w.kasaX + 10), 80);
		kasy.get(licznikKas - 1).ustawCzyWidoczna(true);
		kasy.get(licznikKas - 1).pobierzEtykiete().setToolTipText("To jest KASA nr." + kasy.get(licznikKas - 1).pobierzId());
		
		Thread nowyWatek = new Thread(kasy.get(licznikKas - 1));
		
		nowyWatek.start();
		
		add(kasy.get(licznikKas - 1).pobierzEtykiete());
		kasyEtykiety.get(licznikKas).setLocation((licznikKas) * (Stale.RozmiaryObraz�w.kasaX + 10), 55);
		kasyEtykiety.get(licznikKas).setSize(kasyEtykiety.get(licznikKas).getText().length() * 8, 20);
		
		add(kasyEtykiety.get(licznikKas));

		licznikKas++;

		revalidate();

		repaint();

	}

	public void dodajKlienta() {
		
		
		//jezeli nie ma kas lub klientow jest za duzo to ko�cz
		if (liczbaKlientow == Dane.Stale.Liczebnosci.klientMax || licznikKas == 1)
			return;

		int min = 0;

		//znajdz indeks kasy o najmniejszej kolejce
		for (int i = 0; i < licznikKas - 1; i++) {
			if (kasy.get(i).pobierzDlugoscKolejki() == 0) {
				min = i;
				break;
			}
			if (kasy.get(i).pobierzDlugoscKolejki() < kasy.get(min).pobierzDlugoscKolejki()) {
				min = i;
			}
		}
		
		//wybierz wolnego klienta
		for (int i = 0; i < Dane.Stale.Liczebnosci.klientMax; i++) {

			if (klienci.get(licznikKlientow).pobierzCzyWKolejce()) {
				licznikKlientow = ++licznikKlientow % Dane.Stale.Liczebnosci.klientMax;
			} else {
				klienci.get(licznikKlientow).ustawCzyWKolejce(true);
				break;
			}

		}
		
		// ustawianie klienta w kolejce

		klienci.get(licznikKlientow).pobierzEtykiete().setLocation((min + 1) * (Stale.RozmiaryObraz�w.kasaX + 10) + 30,
				(kasy.get(min).pobierzDlugoscKolejki() + 1) * (Stale.RozmiaryObraz�w.klientY + 5) + 150);

		kasy.get(min).dodajKlientaDoKolejki(klienci.get(licznikKlientow));

		kasyEtykiety.get(min).setText("Klienci: " + (kasy.get(min).pobierzDlugoscKolejki() ));

		add(klienci.get(licznikKlientow).pobierzEtykiete());
		
		Dane.Semafory.semKasy.get(min).release();
		
		liczbaKlientow++;
		
		l_liczbaKlientow.setText("Liczba Klientow: " + (liczbaKlientow ));
		
		revalidate();

		repaint();

	}

	public void usunKlientaZKolejki(int indeksKolejki) {

		if (kasy.get(indeksKolejki).pobierzCzyWidoczna()) {

			if (kasy.get(indeksKolejki).pobierzDlugoscKolejki() != 0) {

				remove(kasy.get(indeksKolejki).pobierzPierwszegoKlienta().pobierzEtykiete());
				

				kasy.get(indeksKolejki).usunKlientaZKolejki();
				
				liczbaKlientow--;

				kasyEtykiety.get(indeksKolejki).setText("Klienci: " + (kasy.get(indeksKolejki).pobierzDlugoscKolejki() + 1));
				l_liczbaKlientow.setText("Liczba Klientow: " + (liczbaKlientow ));

				revalidate();

				repaint();
				
			}

		}

	}
	
	public Okno pobierzOkno(){
		return this;
	}
	
	public static void main(String args[]) {

		Okno okno = new Okno();
		okno.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		okno.setSize(1000, 700);
		okno.setVisible(true);
		okno.setTitle("Sklep Komputerowy");

	}
}
