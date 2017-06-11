package Logika;

public class Produkt {

	private int id;
	private String nazwa;
	private int cena;
	private boolean czySprzedane;

	public Produkt() {
	}

	public Produkt(int id, String nazwa, int cena) {
		this.id = id;
		this.nazwa = nazwa;
		this.cena = cena;
		this.czySprzedane = false;
	}

	public int getCena() {
		return this.cena;
	}

	public void setCena(int cena) {
		this.cena = cena;
	}

	public String getNazwa() {
		return this.nazwa;
	}

	public void setNazwa(String nazwa) {
		this.nazwa = nazwa;
	}

	public int getid() {
		return this.id;
	}

	public void setid(int id) {
		this.id = id;
	}

	public boolean pobierzCzySprzedane() {
		return czySprzedane;
	}

	public void ustawCzySprzedane(boolean decyzja) {
		this.czySprzedane = decyzja;
	}

	@Override
	public int hashCode() {
		return id;
	}

	public boolean equels(Object o) {
		Produkt p = (Produkt) o;

		return this.getid() == p.getid();
	}

}
