package Logika;

public class Produkt {

	private int id;
	private String nazwa;
	private int cena;
	private boolean czySprzedane;

	public Produkt(int id, String nazwa, int cena) {
		this.id = id;
		this.nazwa = nazwa;
		this.cena = cena;
		this.czySprzedane = false;
	}
	
	public int pobierzCene() {
		return this.cena;
	}
	
	public String pobierzNazwe() {
		return this.nazwa;
	}

	public int pobierzId() {
		return this.id;
	}
	public boolean pobierzCzySprzedane(){
		return czySprzedane;
	}
	
	public void ustawCzySprzedane( boolean decyzja){
		this.czySprzedane = decyzja;
	}
	@Override
	public int hashCode(){
		return id;
	}
	public boolean equels(Object o){
		Produkt p = (Produkt) o ;
		
		return this.pobierzId() == p.pobierzId() ;
	}

}
