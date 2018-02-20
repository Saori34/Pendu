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
	private static boolean continuer = false;
	private static char reponse = ' ';
	private static boolean boolPartie;

	
	public static void main(String[] args) {
		
	
		//Chemin fichier
		File file = new File(".assets/dictionnaire.txt");
		
		//On ouvre un nouveau flux entrant;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("\n\n---------------JEU DU PENDU---------------\n\n");
		
		
		do {
			boolPartie = true;
			
			//On initialise le mot à trouver avec le dictionnaire
			motATrouver = RegleDuJeu.initialisation(file);
			
			//On initialise le nb d'essais avec le mot à trouver
			nbEssais = RegleDuJeu.nbEssaisAutorises(motATrouver);
			
			//On initialise une nouvelle partie
			RegleDuJeu partie = new RegleDuJeu(motATrouver, nbEssais);
			
				//on relance un tour de jeu tant que le boolean est à true
				while(boolPartie) {
					boolPartie = partie.jouer(sc);
				}
				
			System.out.println("\n\nFIN DE LA PARTIE");
			
			
			//On propose de recommencer une partie
			while(reponse != 'Y' && reponse != 'N') {
				System.out.println("Voulez-vous refaire une partie ? Y/N");
				reponse = sc.nextLine().toUpperCase().charAt(0);
				if(reponse == 'Y') {
					continuer = true;
				}
			}
			
		}while(continuer);
		
		sc.close();
		System.exit(0);
	}

}
