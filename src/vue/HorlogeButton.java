package vue;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;

import javax.swing.*;

import modele.*;

class HorlogeButton extends JPanel {
	protected Vue vue;
	protected JButton[][] diodes;
	
	public HorlogeButton(Vue v) {
		super();
		this.setLayout(new GridLayout(v.lireModele().lireLignes()+2, v.lireModele().lireColonnes()+2, 5, 5));
		
		this.vue = v;
		this.diodes = new JButton[v.lireModele().lireLignes()+2][v.lireModele().lireColonnes()+2];
		for(int i=0; i<v.lireModele().lireLignes()+2; i++) {
			for(int j=0; j<v.lireModele().lireColonnes()+2; j++) {
				this.diodes[i][j] = new JButton();
				// Couleurs
				if(i!=0 && i!=v.lireModele().lireLignes()+1) {
					this.diodes[i][j].setOpaque(true);
					if(j!=0 && j<3) { this.diodes[i][j].setBackground(Color.RED); }
					else if(j<5) { this.diodes[i][j].setBackground(Color.GREEN); }
					else if(j<7) { this.diodes[i][j].setBackground(Color.BLUE); }
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
