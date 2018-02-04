package cnam.pendu.GIRARD;

import java.io.File;

/**
 * Classe Jeu qui contient la méthode main pour effectuer une partie de pendu
 * 
 * @author Emilie
 *
 */
public class Jeu {

	

	
	public static void main(String[] args) {
		
	
		//Chemin fichier
		File file = new File(".assets/dictionnaire.txt");
		RegleDuJeu jeu = new RegleDuJeu();
		
		jeu.nbEssaisAutorises(jeu.initialisation(file));
		System.out.println("mot : " + jeu.getMotATrouver() + " essais : " + jeu.getNbEssais());
		
		

	}

}
