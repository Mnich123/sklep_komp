package Interfejs;

import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.util.Vector;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import Dane.Stale;
import Logika.Klient;
import bazaDanych.ProduktStore;

/**
 * 
 * Klasa Okno odpowiada za manipulacj� danymi wy�wietlanymi si� na oknie.
 * 
 * @author Pawe� Tarsa�a, Mateusz Miko�ajuk, Micha� Lewandowski
 *
 */
public class Okno extends JFrame {
	private static final long serialVersionUID = 1L;
	private ProduktStore produktStore = new ProduktStore();
	public String[] nazwy = { "Sluchawki", "Procesor", "G�o�niki", "Laptop", "Monitor", "Mikrofon", "Mysz",
			"Klawiatura", "Pendrive", "Telefon", "PC", "Wied�min 3: Dziki Gon" };

	private Vector<Kasa> kasy = new Vector<Kasa>();
	private Vector<Thread> kasyWatki = new Vector<Thread>();
	// private Vector<JLabel> klienci = new Vector<JLabel>();
	private Vector<Klient> klienci = new Vector<Klient>();
	private Vector<JLabel> kasyEtykiety = new Vector<JLabel>();

	private int licznikKlientow = 0, licznikKas = 1;
	private int liczbaKlientow = 0;

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

	/**
	 * Inicjalizacja podstawowych przycisk�w, etykiet oraz grafik do
	 * wy�wietlenia na ekranie
	 */
	public Okno() {

		setLayout(null);
		////// ETYKIETY ////

		l_kasa = new JLabel("Kasa");
		l_sklep = new JLabel("Sklep");
		l_reklamacje = new JLabel("Reklamacje");
		l_kolejkaDoKasy = new JLabel("Liczba Kas:");
		l_liczbaKlientow = new JLabel("Liczba Klientow: " + licznikKlientow);
		l_kolejkaDoReklamacji = new JLabel("Reklamacje");

		// Je�eli nie ustawisz rozmiaru, to nie bedzie wyswietlane
		int rozmiarZnaku = 8;
		int wysokoscZnaku = 10;
		l_kasa.setSize(l_kasa.getText().length() * rozmiarZnaku, wysokoscZnaku);
		l_sklep.setSize(l_sklep.getText().length() * rozmiarZnaku, wysokoscZnaku);
		l_reklamacje.setSize(l_reklamacje.getText().length() * rozmiarZnaku, wysokoscZnaku);
		l_kolejkaDoKasy.setSize(l_kolejkaDoKasy.getText().length() * rozmiarZnaku, wysokoscZnaku);
		l_kolejkaDoReklamacji.setSize(l_kolejkaDoReklamacji.getText().length() * rozmiarZnaku, wysokoscZnaku);
		l_liczbaKlientow.setSize(l_liczbaKlientow.getText().length() * rozmiarZnaku, wysokoscZnaku);

		l_sklep.setLocation(new Point(20, 20));
		l_kasa.setLocation(new Point(20, 70));
		l_reklamacje.setLocation(new Point(20, 130));
		l_kolejkaDoKasy.setLocation(new Point(20, 180));
		l_kolejkaDoReklamacji.setLocation(new Point(20, 230));
		l_liczbaKlientow.setLocation(new Point(500, 30));

		// add(l_kasa);
		// add(l_reklamacje);
		// add(l_sklep);
		// add(l_kolejkaDoKasy);
		// add(l_kolejkaDoReklamacji);
		add(l_liczbaKlientow);

		////// PRZYCISKI ///////

		b_dodajProdukt = new JButton("Dodaj Produkt");
		b_dodajKlienta = new JButton("Dodaj Klienta");
		b_dodajKase = new JButton("Dodaj Kase");
		b_resetuj = new JButton("Resetuj");
		b_start = new JButton("START");
		b_stop = new JButton("STOP");

		int szerokoscPrzycisku1 = 20;
		int szerokoscPrzycisku2 = 30;
		int szerokoscPrzycisku3 = 50;
		int wysokoscPrzycisku = 30;
		b_dodajProdukt.setSize(b_dodajProdukt.getText().length() * rozmiarZnaku + szerokoscPrzycisku1,
				wysokoscPrzycisku);
		b_dodajKlienta.setSize(b_dodajKlienta.getText().length() * rozmiarZnaku + szerokoscPrzycisku1,
				wysokoscPrzycisku);
		b_dodajKase.setSize(b_dodajKase.getText().length() * rozmiarZnaku + szerokoscPrzycisku1, wysokoscPrzycisku);
		b_resetuj.setSize(b_resetuj.getText().length() * rozmiarZnaku + szerokoscPrzycisku2, wysokoscPrzycisku);
		b_start.setSize(b_start.getText().length() * rozmiarZnaku + szerokoscPrzycisku3, wysokoscPrzycisku);
		b_stop.setSize(b_stop.getText().length() * rozmiarZnaku + szerokoscPrzycisku3, wysokoscPrzycisku);

		b_dodajKlienta.setLocation(new Point(20, 20));
		b_dodajKase.setLocation(new Point(150, 20));
		b_dodajProdukt.setLocation(new Point(260, 20));
		b_resetuj.setLocation(new Point(400, 20));
		b_start.setLocation(new Point(630, 20));
		b_stop.setLocation(new Point(750, 20));

		add(b_dodajProdukt);
		add(b_dodajKlienta);
		add(b_dodajKase);
		add(b_resetuj);
		add(b_start);
		add(b_stop);

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

		b_start.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				startuj();
			}
		});

		b_stop.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				stopuj();
			}
		});
		b_dodajProdukt.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				produktStore.dodajProduktDoBazy(nazwy[new Random().nextInt(Dane.Stale.Liczebnosci.liczbaNazwProduktow)],
						new Random().nextInt(Dane.Stale.Liczebnosci.cenaProduktuMax)
								+ Dane.Stale.Liczebnosci.cenaProduktuMin);
			}
		});

		inicjalizujKlientow();
		inicjalizujKasy();
		


	}

	/**
	 * Inicjalizacja obiekt�w klient�w
	 */
	public void inicjalizujKlientow() {
		for (int i = 0; i < Dane.Stale.Liczebnosci.klientMax; i++) {
			klienci.add(new Klient());
		}
	}

	/**
	 * 
	 * Iniclalizacja obiekt�w kas
	 * 
	 */
	public void inicjalizujKasy() {
		for (int i = 0; i < Dane.Stale.Liczebnosci.kasaMax; i++) {
			kasy.add(new Kasa(i));
			kasyWatki.add(new Thread(kasy.get(i)));
			kasy.lastElement().ustawOkno(this);
			kasyEtykiety.add(new JLabel("Klienci : "));
			Dane.Semafory.semKasy.add(new Semaphore(0));
		}
	}

	/**
	 * 
	 * Uruchomienie kas
	 * 
	 */
	public void startuj() {
		Dane.Statyczne.pauza = false;
	}

	/**
	 * 
	 * Zastopowanie kas
	 * 
	 */
	public void stopuj() {
		Dane.Statyczne.pauza = true;
	}

	/**
	 * 
	 * Zresetowanie do pocz�tkowych ustawien
	 * 
	 */
	public void resetuj() {
		for (int i = 0; i < Dane.Stale.Liczebnosci.klientMax; i++) {
			if (klienci.get(i).pobierzCzyWKolejce()) {
				remove(klienci.get(i).pobierzEtykiete());
				klienci.get(i).ustawCzyWKolejce(false);
			}

		}

		Dane.Statyczne.wlaczenieKas = false;

		try {
			TimeUnit.MILLISECONDS.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		kasyWatki.clear();
		Dane.Semafory.semKasy.clear();
		Dane.Statyczne.wlaczenieKas = true;

		for (int i = 0; i < Dane.Stale.Liczebnosci.kasaMax; i++) {

			if (kasy.get(i).pobierzCzyWidoczna()) {
				kasy.get(i).pobierzEtykiete().setToolTipText("<html></html>");
				kasy.get(i).usunKlientowZKolejki();
				kasyEtykiety.get(i + 1).setText("Klienci: 0");
				remove(kasy.get(i).pobierzEtykiete());
				remove(kasyEtykiety.get(i + 1));
			}

			kasyWatki.add(new Thread(kasy.get(i)));
			Dane.Semafory.semKasy.add(new Semaphore(0));
			kasy.get(i).ustawCzyWidoczna(false);

		}

		licznikKas = 1;
		licznikKlientow = 0;
		liczbaKlientow = 0;

		l_liczbaKlientow.setText("Liczba Klientow: " + licznikKlientow);

		revalidate();

		repaint();

	}

	/**
	 * 
	 * Dodaje kas� na ekran
	 * 
	 */
	public void dodajKase() {

		if (licznikKas == Dane.Stale.Liczebnosci.kasaMax)
			return;

		int odlegloscOdGornejKrawedziOkna = 80;

		kasy.get(licznikKas - 1).pobierzEtykiete().setLocation((licznikKas) * (Stale.RozmiaryObraz�w.kasaX + 10),
				odlegloscOdGornejKrawedziOkna);
		kasy.get(licznikKas - 1).ustawCzyWidoczna(true);
		kasy.get(licznikKas - 1).pobierzEtykiete()
				.setToolTipText("To jest KASA nr." + kasy.get(licznikKas - 1).pobierzId());

		kasyWatki.get(licznikKas - 1).start();

		int odlegloscEtykietyOdGornejKrawiedziOkna = 55; 
		int wysokoscTekstu = 20 ;
		add(kasy.get(licznikKas - 1).pobierzEtykiete());
		kasyEtykiety.get(licznikKas).setLocation((licznikKas) * (Stale.RozmiaryObraz�w.kasaX + 10), odlegloscEtykietyOdGornejKrawiedziOkna);
		kasyEtykiety.get(licznikKas).setSize(kasyEtykiety.get(licznikKas).getText().length() * 8, wysokoscTekstu);

		add(kasyEtykiety.get(licznikKas));

		licznikKas++;

		revalidate();

		repaint();

	}

	/**
	 * 
	 * Dodaje klienta na ekran
	 * 
	 */
	public void dodajKlienta() {

		// jezeli nie ma kas lub klientow jest za duzo to ko�cz
		if (liczbaKlientow == Dane.Stale.Liczebnosci.klientMax || licznikKas == 1)
			return;

		int min = 0;

		// znajdz indeks kasy o najmniejszej kolejce
		for (int i = 0; i < licznikKas - 1; i++) {
			if (kasy.get(i).pobierzDlugoscKolejki() == 0) {
				min = i;
				break;
			}
			if (kasy.get(i).pobierzDlugoscKolejki() < kasy.get(min).pobierzDlugoscKolejki()) {
				min = i;
			}
		}

		// wybierz wolnego klienta
		for (int i = 0; i < Dane.Stale.Liczebnosci.klientMax; i++) {

			if (klienci.get(licznikKlientow).pobierzCzyWKolejce()) {
				licznikKlientow = ++licznikKlientow % Dane.Stale.Liczebnosci.klientMax;
			} else {
				klienci.get(licznikKlientow).ustawCzyWKolejce(true);
				break;
			}

		}

		// ustawianie klienta w kolejce

		int przesuniecieNaSrodekKasy = 30 ; 
		int odstepOdGornejKrawedziOkna = 150; 
		int odstepMiedzyKlientami = 5; 
		
		klienci.get(licznikKlientow).pobierzEtykiete().setLocation((min + 1) * (Stale.RozmiaryObraz�w.kasaX + 10) + przesuniecieNaSrodekKasy,
				(kasy.get(min).pobierzDlugoscKolejki() + 1) * (Stale.RozmiaryObraz�w.klientY + odstepMiedzyKlientami) + odstepOdGornejKrawedziOkna);

		kasy.get(min).dodajKlientaDoKolejki(klienci.get(licznikKlientow));

		klienci.get(licznikKlientow).dodajProdukt(produktStore.pobierzProduktZBazy());
		klienci.get(licznikKlientow).pobierzEtykiete().setToolTipText(klienci.get(licznikKlientow).pobierzProdukty());

		kasyEtykiety.get(min + 1).setText("Klienci: " + (kasy.get(min).pobierzDlugoscKolejki()));

		add(klienci.get(licznikKlientow).pobierzEtykiete());

		Dane.Semafory.semKasy.get(min).release();

		liczbaKlientow++;

		l_liczbaKlientow.setText("Liczba Klientow: " + (liczbaKlientow));

		revalidate();

		repaint();

	}

	/**
	 * Usuwa klienta o wybranym indetyfikatorze "indeksKolejki"
	 * 
	 * @param indeksKolejki Okre�la indeks klienta do usuni�cia z kolejki
	 */
	public void usunKlientaZKolejki(int indeksKolejki) {

		if (kasy.get(indeksKolejki).pobierzCzyWidoczna()) {

			if (kasy.get(indeksKolejki).pobierzDlugoscKolejki() != 0) {

				remove(kasy.get(indeksKolejki).pobierzPierwszegoKlienta().pobierzEtykiete());

				kasy.get(indeksKolejki).usunKlientaZKolejki();

				liczbaKlientow--;

				kasyEtykiety.get(indeksKolejki + 1)
						.setText("Klienci: " + (kasy.get(indeksKolejki).pobierzDlugoscKolejki()));
				l_liczbaKlientow.setText("Liczba Klientow: " + (liczbaKlientow));

				revalidate();

				repaint();

			}

		}

	}

	/**
	 * Zwraca referencje na dane okno
	 * 
	 * @return
	 */
	public Okno pobierzOkno() {
		return this;
	}

}
