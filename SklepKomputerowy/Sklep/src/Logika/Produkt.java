package Logika;


/**
 * 
 * Klasa produkt zawiera wszystkie dane produktów oraz sposoby zarz¹dzania nimi w sklepie 
 * 
 * @author Pawe³ Tarsa³a, Mateusz Miko³ajuk, Micha³ Lewandowski
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
	 * @param IDProduktu Okreœla identyfikator produktu
	 * @param nazwa Okreœla nazwê produktu
	 * @param cena Okreœla cenê produktu
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
	 * ustawia cene produktu na podan¹ w parametrze
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
	 * ustawia nazwê produktu na podan¹ w parametrze
	 * @param nazwa - okreœla nazwê na jak¹ produkt ma zmieniæ swoj¹ nazwê
	 */
	public void setNazwa(String nazwa) {
		this.nazwa = nazwa;
	}
	/**
	 * ustawia cene w postaci ci¹gu znaków  produktu na podan¹ w parametrze
	 * @param fejk - okreœla cenê na jak¹ produkt ma zmieniæ swoj¹ cenê
	 */
	public void setFejkCena(String fejk){
		this.fejkCena = fejk;
	}
	/**
	 * 
	 * Pobiera cene w postaci ci¹gu znaków 
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
	 * @param idProduktu Okreœla identyfikator produktu do zmiany
	 */
	public void setIDProduktu(int idProduktu) {
		this.IDProduktu = idProduktu;
	}

	/*
	 * 
	 * Pobiera dezycjê czy produkt jest sprzedany
	 */
	public boolean pobierzCzySprzedane() {
		return czySprzedane;
	}

	/**
	 * 
	 * Ustawia decyzjê sprzeda¿y na zada¹ w parametrze
	 * 
	 * @param decyzja Okreœla decyzjê ustawienia stanu sprzeda¿y produktu
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
