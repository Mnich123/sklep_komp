package Logika;

public class Osoba {
	private String imie, nazwisko, PESEL;

	public Osoba(String imie, String nazwisko, String PESEL) {
		this.imie = imie;
		this.nazwisko = nazwisko;
		this.PESEL = PESEL;
	}

	public Osoba() {
		// EMPTY
	}

	public String pobierzImie() {
		return imie;
	}

	public String pobierzNazwisko() {
		return nazwisko;
	}

	public String pobierzPESEL() {
		return PESEL;
	}

	public void ustawImie(String imie) {
		this.imie = imie;
	}

	public void ustawNazwisko(String nazwisko) {
		this.nazwisko = nazwisko;
	}

	public void ustawPESEL(String PESEL) {
		this.PESEL = PESEL;
	}
}
