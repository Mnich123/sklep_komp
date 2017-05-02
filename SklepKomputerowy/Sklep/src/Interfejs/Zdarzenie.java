package Interfejs;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Zdarzenie implements ActionListener{
	
	private Okno okno = null;
	private String komenda;
	
	public Zdarzenie(String komenda, Okno okno ){
		this.komenda = komenda;
		this.okno = okno;
	}
	public void actionPerformed(ActionEvent e){
		if(komenda == "dodajKlienta"){
			okno.dodajKlienta();
			
		}
		if(komenda == "dodajKase"){
			okno.dodajKase();
		}
	}
	
	public void ustawOkno( Okno okno){
		this.okno = okno; 
	}
}
