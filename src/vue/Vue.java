package vue;

import java.awt.Dimension;

import javax.swing.*;
import modele.*;

public class Vue extends JFrame {
	private static final long serialVersionUID = 1L;
	
	protected Modele modele;
	protected HorlogeButton horloge;
	
	public Vue(Modele m) {
		super("Horloge Binaire");
		
		this.modele = m;
		this.horloge = new HorlogeButton(this);
	
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(true);
		this.setSize(new Dimension(800,600));
		this.add(this.horloge);
		this.pack();
		this.setVisible(false);;
	}
	
	public Modele lireModele() { return this.modele; }
	
	public void mettreAJour() {
		this.horloge.mettreAJour();
	}
}
