package Logika;

public class Komunikat {
	private String nadawca;
	private String data;
	private String tekst;

	public Komunikat(String nadawca, String data, String tekst) {
		this.nadawca = nadawca;
		this.data = data;
		this.tekst = tekst;
	}
	
	public void wypiszKomunikat(){
		System.out.println("Data: " + this.data);
		System.out.println("Nadawca: " + this.nadawca);
		System.out.println("Czynnosc: " + this.tekst);
	}

}
