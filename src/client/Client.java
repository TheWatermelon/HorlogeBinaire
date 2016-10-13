package client;

import java.util.Calendar;
import controleur.*;

public class Client extends Thread {
	protected Controleur controleur;
	protected int sommeil;
	
	public Client(Controleur ctrl, int sml) {
		this.controleur = ctrl;
		this.sommeil = sml;
	}
	
	public Controleur lireControleur() { return this.controleur; }
	public int lireSommeil() { return this.sommeil; }
	
	@Override
	public void run() {
		while(true) {
			this.controleur.nouvelleHeure(Calendar.getInstance().get(Calendar.HOUR_OF_DAY), Calendar.getInstance().get(Calendar.MINUTE), Calendar.getInstance().get(Calendar.SECOND));
			try {
				Thread.sleep(this.sommeil);
			} catch(InterruptedException e) {}
		}
	}
}
