package vue;

import java.awt.Dimension;

import javax.swing.JFrame;

import modele.Modele;

public class VueRond extends JFrame {
	private static final long serialVersionUID = 1L;
	
	protected Modele modele;
	protected HorlogeRond horloge;
	
	public VueRond(Modele m) {
		super("Horloge Binaire");
		
		this.modele = m;
		this.horloge = new HorlogeRond(this);
	
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(true);
		this.setLocation(100, 100);
		this.add(this.horloge);
		this.pack();
		this.setVisible(false);;
	}
	
	public Modele lireModele() { return this.modele; }
	
	public void mettreAJour() {
		this.horloge.mettreAJour();
	}
}
