package Logika;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.Vector;

public class Sklep implements Runnable {

	private String nazwa;

	public Sklep(String nazwa) {
		this.nazwa = nazwa;
		Dane.Semafory.semSklep.release();
	}

	public Sklep() {

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
