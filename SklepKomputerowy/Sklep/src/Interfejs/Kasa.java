package Interfejs;

import java.util.Vector;
import java.util.concurrent.TimeUnit;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Dane.Stale;
import Logika.Klient;
import Logika.Sklep;

public class Kasa implements Runnable {

	private Vector<Klient> kolejka = new Vector<Klient>();

	private JLabel obrazKasy;

	private int id;

	private boolean czyWidoczna;

	private Okno okno = null;

	private Sklep sklep = null;

	public Kasa(int id) {

		this.id = id;

		czyWidoczna = false;

		ImageIcon nowaKasa = new ImageIcon(getClass().getResource("kasa.png"));

		obrazKasy = new JLabel(nowaKasa);

		obrazKasy.setSize(Dane.Stale.RozmiaryObraz�w.kasaX, Stale.RozmiaryObraz�w.kasaY);



	}

	public void usunKlientowZKolejki() {
		kolejka.clear();
	}

	public void ustawCzyWidoczna(boolean decyzja) {
		this.czyWidoczna = decyzja;
	}

	public void ustawOkno(Okno okno) {
		this.okno = okno;
	}

	public void ustawSklep(Sklep sklep) {
		this.sklep = sklep;
	}

	public void dodajKlientaDoKolejki(Klient klient) {

		kolejka.add(klient);

	}

	public void usunKlientaZKolejki() {

		if (kolejka.size() == 0)
			return;

		kolejka.get(0).ustawCzyWKolejce(false);

		kolejka.remove(0);

		for (int i = 0; i < kolejka.size(); i++) {
			kolejka.get(i).pobierzEtykiete().setLocation(kolejka.get(i).pobierzEtykiete().getX(),
					kolejka.get(i).pobierzEtykiete().getY() - Dane.Stale.RozmiaryObraz�w.klientY - 5);
		}

	}

	public Klient pobierzPierwszegoKlienta() {
		if (kolejka.size() != 0) {
			return kolejka.get(0);
		}
		return null;
	}
	
	public int pobierzId(){
		return this.id;
	}

	public int pobierzDlugoscKolejki() {
		return kolejka.size();
	}

	public boolean pobierzCzyWidoczna() {
		return this.czyWidoczna;

	}

	public void realizujUsluge() {
		try {
			TimeUnit.MILLISECONDS.sleep(300);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public JLabel pobierzEtykiete() {
		return obrazKasy;
	}

	@Override
	public void run() {
		while (Dane.Statyczne.wlaczenieKas) {
			
			try {
				Dane.Semafory.semKasy.get(id).acquire();
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			if (kolejka.size() != 0) {

				try {
					Dane.Semafory.semSklep.acquire();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				if (!Dane.Statyczne.wlaczenieKas) {

					Dane.Semafory.semSklep.release();
					break;
				}

				realizujUsluge();
				okno.usunKlientaZKolejki(id);

				Dane.Semafory.semSklep.release();
				try {
					TimeUnit.MILLISECONDS.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}

		}

	}
}
