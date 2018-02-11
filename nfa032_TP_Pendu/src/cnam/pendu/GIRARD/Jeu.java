package cnam.pendu.GIRARD;

import java.io.File;
import java.util.Scanner;

/**
 * Classe Jeu qui contient la méthode main pour effectuer une partie de pendu
 * 
 * @author Emilie
 *
 */
public class Jeu {

	private static String motATrouver;
	private static int nbEssais;

	
	public static void main(String[] args) {
		
	
		//Chemin fichier
		File file = new File(".assets/dictionnaire.txt");
		
		//On initialise le mot à trouver avec le dictionnaire
		motATrouver = RegleDuJeu.initialisation(file);
		
		//On initialise le nb d'essais avec le mot à trouver
		nbEssais = RegleDuJeu.nbEssaisAutorises(motATrouver);
		
		//On initialise une nouvelle partie
		RegleDuJeu partie = new RegleDuJeu(motATrouver, nbEssais);
		
		//On ouvre un nouveau flux entrant;
		Scanner sc = new Scanner(System.in);
		
		do{
			partie.jouer(sc);
		}while(partie.jouer(sc));
		

	}

}
