package main;

import controleur.*;
import client.*;

public class Main {
	public static void main(String[] args) {
		// Controle du nombre d'entrees
		if(args.length==0) {
			System.out.println("Usage : java Main <millisecondes>");
			return;
		}
		if(args.length!=1) {
			System.out.println("Erreur d'utilisation");
			return;
		}
		
		// Controle de l'integrite de l'entree
		if(Integer.parseInt(args[0])<=0) {
			System.out.println("Entrer un entier positif");
			return;
		}
		
		Controleur ctrl = new Controleur();
		ctrl.demarrer();
		
		Client cli = new Client(ctrl, Integer.parseInt(args[0]));
		cli.start();
	}
}
