package Logika;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;
import java.util.concurrent.TimeUnit;

public class Dział implements Runnable {

	private DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	private String nazwa;
	private int czasTrwaniaUslugi;
	private Vector<Klient> kolejka = new Vector<Klient>();

	private Sklep sklep = null;

	public Dział(String nazwa, int czasTrwaniaUslugiWms, Sklep sklep) {
		this.nazwa = nazwa;
		this.czasTrwaniaUslugi = czasTrwaniaUslugiWms;
		this.sklep = sklep;
	}

	public String pobierzNazwe() {
		return this.nazwa;
	}

	public void dodajKlientaDoKolejki(Klient klient) {
		kolejka.add(klient);
	}

	public void usunPierwszegoZKolejki() {
		kolejka.remove(0);
	}

	public void ustawCzasTrwaniaUsługi(int milisekundy) {
		this.czasTrwaniaUslugi = milisekundy;
	}

	public void realizujUsluge(Klient klient) {
		try {
			TimeUnit.MILLISECONDS.sleep(this.czasTrwaniaUslugi);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Date data = new Date();
		Komunikat komunikat = new Komunikat(this.nazwa, dateFormat.format(data),
				" Zrealiowano usluge od klienta " + klient.pobierzPESEL());
		kolejka.remove(0);
		//sklep.dodajKomunikat(komunikat);

	}

	public void run() {
		while (true) {
			if (kolejka.size() != 0) {

				try {
					Dane.Semafory.semSklep.acquire();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				realizujUsluge(kolejka.get(0));

				Dane.Semafory.semSklep.release();
			}

		}
	}

}
