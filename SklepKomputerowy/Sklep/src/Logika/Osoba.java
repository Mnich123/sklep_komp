package Logika;
/**
 * 
 * Klasa Osoba zawiera podstawowe informacje oraz funkcjonalnoœci osoby w sklepie 
 * 
 * @author Pawe³ Tarsa³a, Mateusz Miko³ajuk, Micha³ Lewandowski
 *
 */
public class Osoba {
	private String imie, nazwisko, PESEL;

	/**
	 * 
	 * Ustawia osobê o podanych parametrach 
	 * @param imie
	 * @param nazwisko
	 * @param PESEL
	 */
	public Osoba(String imie, String nazwisko, String PESEL) {
		this.imie = imie;
		this.nazwisko = nazwisko;
		this.PESEL = PESEL;
	}

	public Osoba() {
		// EMPTY
	}

	/**
	 * 
	 * Pobiera imiê osoby
	 * @return
	 */
	public String pobierzImie() {
		return imie;
	}

	/**
	 * 
	 * Pobiera nazwisko osoby
	 * @return
	 */
	public String pobierzNazwisko() {
		return nazwisko;
	}

	/**
	 * 
	 * Pobiera PESEL Osoby
	 * @return
	 */
	public String pobierzPESEL() {
		return PESEL;
	}

	/**
	 * 
	 * Ustawia imiê Osoby na podane w parametrze 
	 * @param imie
	 */
	public void ustawImie(String imie) {
		this.imie = imie;
	}

	/**
	 * 
	 * Ustawia nazwisko osoby na podane w parametrze
	 * 
	 * @param nazwisko
	 */
	public void ustawNazwisko(String nazwisko) {
		this.nazwisko = nazwisko;
	}

	/**
	 * 
	 * Ustawia PESEL osoby na podane w parametrze
	 * @param PESEL
	 */
	public void ustawPESEL(String PESEL) {
		this.PESEL = PESEL;
	}
}
