package vue;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;

import javax.swing.*;

import modele.*;

class HorlogeRond extends JPanel {
	private static final long serialVersionUID = 1L;
	protected VueRond vue;
	protected Diode[][] diodes;
	
	public HorlogeRond(VueRond v) {
		super();
		this.setLayout(new GridLayout(Modele.lireLignes()+2, Modele.lireColonnes()+2, 5, 5));
		
		this.vue = v;
		this.diodes = new Diode[Modele.lireLignes()+2][Modele.lireColonnes()+2];
		for(int i=0; i<Modele.lireLignes()+2; i++) {
			for(int j=0; j<Modele.lireColonnes()+2; j++) {
				this.diodes[i][j] = new Diode();
				// Couleurs
				if(i!=0 && i!=Modele.lireLignes()+1) {
					this.diodes[i][j].setOpaque(true);
					if(j!=0 && j<3) { this.diodes[i][j].setColor(Color.RED); }
					else if(j<5) { this.diodes[i][j].setColor(Color.GREEN); }
					else if(j<7) { this.diodes[i][j].setColor(Color.BLUE); }
					else { this.diodes[i][j].setOpaque(false); }
				} else { this.diodes[i][j].setOpaque(false); }
				this.diodes[i][j].setVisible(false);
				add(this.diodes[i][j]);
			}
		}
	}
	
	protected void mettreAJour() {
		Modele modele = this.vue.lireModele();
		for(int i=0; i<Modele.lireLignes(); i++) {
			for(int j=0; j<Modele.lireColonnes(); j++) {
				diodes[i+1][j+1].setVisible(modele.lireDiode(i,j));
			}
		}
	}
}
