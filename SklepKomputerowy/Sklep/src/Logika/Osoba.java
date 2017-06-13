package Logika;
/**
 * 
 * Klasa Osoba zawiera podstawowe informacje oraz funkcjonalno�ci osoby w sklepie 
 * 
 * @author Pawe� Tarsa�a, Mateusz Miko�ajuk, Micha� Lewandowski
 *
 */
public class Osoba {
	private String imie, nazwisko, PESEL;

	/**
	 * 
	 * Ustawia osob� o podanych parametrach 
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
	 * Pobiera imi� osoby
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
	 * Ustawia imi� Osoby na podane w parametrze 
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
