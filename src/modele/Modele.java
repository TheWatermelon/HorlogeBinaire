package modele;

public class Modele {
	private boolean[][] diodes;
	
	public static int lireLignes() { return 4; }
	public static int lireColonnes() { return 6; }
	
	public Modele() {
		diodes = new boolean[4][6];
	}
	
	public boolean lireDiode(int ligne, int colonne) { return diodes[ligne][colonne]; }
	public void ecrireDiode(int ligne, int colonne, boolean etat) { diodes[ligne][colonne] = etat; }
	
	public void nouvelleHeure(int hh, int mm, int ss) {
		convertir(hh/10, 0);
		convertir(hh%10, 1);
		convertir(mm/10, 2);
		convertir(mm%10, 3);
		convertir(ss/10, 4);
		convertir(ss%10, 5);
	}
	
	protected void convertir(int chiffre, int colonne) {
		boolean[] convertir = { false, true };
		
		for(int i=3; i>=0; i--) {
			diodes[i][colonne] = convertir[chiffre%2];
			chiffre/=2;
		}
	}
}
