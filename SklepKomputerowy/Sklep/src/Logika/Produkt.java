package Logika;


/**
 * 
 * Klasa produkt zawiera wszystkie dane produkt�w oraz sposoby zarz�dzania nimi w sklepie 
 * 
 * @author Pawe� Tarsa�a, Mateusz Miko�ajuk, Micha� Lewandowski
 *
 */
public class Produkt {

	private int IDProduktu;
	private String nazwa;
	private int cena;
	private String fejkCena = null;
	private boolean czySprzedane;

	/**
	 * 
	 * konstruktor przeznaczony dla biblioteki hibernate
	 * 
	 */
	public Produkt() {
		
	}

	/**
	 * 
	 * Ustawia dane produktu na zadane w parametrach
	 * 
	 * @param IDProduktu Okre�la identyfikator produktu
	 * @param nazwa Okre�la nazw� produktu
	 * @param cena Okre�la cen� produktu
	 */
	public Produkt(int IDProduktu, String nazwa, int cena) {
		this.IDProduktu = IDProduktu;
		this.nazwa = nazwa;
		this.cena = cena;
		this.czySprzedane = false;
	}

	/**
	 * pobiera cene produktu
	 * @return
	 */
	public int getCena() {
		return this.cena;
	}

	/**
	 * 
	 * ustawia cene produktu na podan� w parametrze
	 * 
	 * @param cena
	 */
	public void setCena(int cena) {
		this.cena = cena;
	}

	public String getNazwa() {
		return this.nazwa;
	}


	/**
	 * 
	 * ustawia nazw� produktu na podan� w parametrze
	 * @param nazwa - okre�la nazw� na jak� produkt ma zmieni� swoj� nazw�
	 */
	public void setNazwa(String nazwa) {
		this.nazwa = nazwa;
	}
	/**
	 * ustawia cene w postaci ci�gu znak�w  produktu na podan� w parametrze
	 * @param fejk - okre�la cen� na jak� produkt ma zmieni� swoj� cen�
	 */
	public void setFejkCena(String fejk){
		this.fejkCena = fejk;
	}
	/**
	 * 
	 * Pobiera cene w postaci ci�gu znak�w 
	 * @return String
	 */
	public String getFejkCena(){
		return this.fejkCena;
	}
	/**
	 * 
	 * Pobiera identyfikator produktu
	 * 
	 * @return int
	 */
	public int getIDProduktu() {
		return this.IDProduktu;
	}

	/**
	 * 
	 * Ustawia identyfikator produktu na parametr "idProduktu"
	 * @param idProduktu Okre�la identyfikator produktu do zmiany
	 */
	public void setIDProduktu(int idProduktu) {
		this.IDProduktu = idProduktu;
	}

	/*
	 * 
	 * Pobiera dezycj� czy produkt jest sprzedany
	 */
	public boolean pobierzCzySprzedane() {
		return czySprzedane;
	}

	/**
	 * 
	 * Ustawia decyzj� sprzeda�y na zada� w parametrze
	 * 
	 * @param decyzja Okre�la decyzj� ustawienia stanu sprzeda�y produktu
	 */
	public void ustawCzySprzedane(boolean decyzja) {
		this.czySprzedane = decyzja;
	}

	@Override
	public int hashCode() {
		return IDProduktu;
	}

	public String toString(){
		return "ID: " + this.IDProduktu + "\t" + this.nazwa + "\t" + this.fejkCena + "zl";
	}
}
