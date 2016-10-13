package controleur;

import vue.*;
import modele.*;

public class Controleur {
	protected Vue vue;
	protected VueRond vueRond;
	protected Modele modele;
	
	public Controleur() {
		modele = new Modele();
		vue = new Vue(modele);
		vueRond = new VueRond(modele);
	}
	
	public void demarrer() {
		vue.setVisible(true);
		vueRond.setVisible(true);
	}
	
	public void nouvelleHeure(int hh, int mm, int ss) {
		modele.nouvelleHeure(hh, mm, ss);
		vue.mettreAJour();
		vueRond.mettreAJour();
	}
}
