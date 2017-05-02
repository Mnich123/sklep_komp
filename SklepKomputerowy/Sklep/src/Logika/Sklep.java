package Logika;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.Vector;

public class Sklep implements Runnable {

	private String nazwa;
	private Set<Pracownik> pracownicy = new HashSet<Pracownik>();
	private Set<Klient> klienci = new HashSet<Klient>();
	private ArrayList<Dzia�> dzia�y = new ArrayList<Dzia�>();
	private Vector<Komunikat> komunikaty = new Vector<Komunikat>();

	public Sklep(String nazwa) {
		this.nazwa = nazwa;
		Dane.Semafory.semSklep.release();
	}

	public Sklep() {

	}

	
	public void ustaw() {
		dzia�y.add(new Dzia�("Reklamacje", 1000, this));
		dzia�y.add(new Dzia�("Kasy", 200, this));
		dzia�y.add(new Dzia�("PunktObslugiKlienta", 300, this));
		dzia�y.add(new Dzia�("Zwroty", 100, this));
	}

	public void dodajPracownika(Pracownik pracownik) {
		try {
			Dane.Semafory.semSklep.acquire();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		pracownicy.add(pracownik);

		Dane.Semafory.semSklep.release();
	}

	public void dodajKlienta(Klient klient) {
		try {
			Dane.Semafory.semSklep.acquire();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		klienci.add(klient);

		Dane.Semafory.semSklep.release();
	}

	public void dodajDzia�(Dzia� dzia�) {
		dzia�y.add(dzia�);
	}

	public void dodajKomunikat(Komunikat komunikat) {
		try {
			Dane.Semafory.semSklep.acquire();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		komunikaty.add(komunikat);

		Dane.Semafory.semSklep.release();
	}

	public Sklep pobierzSklep() {
		return this;
	}
	public String pobierzNazwe(){
		return this.nazwa;
	}

	public void run() {
		while (true) {

		}
	}

}
