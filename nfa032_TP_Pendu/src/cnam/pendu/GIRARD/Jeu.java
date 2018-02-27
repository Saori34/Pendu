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
	public static int score;
	private static int nbParties;

	
	public static void main(String[] args) {
		
	
		//Chemin fichier
		File file = new File(".assets/dictionnaire.txt");
		
		//On ouvre un nouveau flux entrant;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("\n\n---------------JEU DU PENDU---------------\n\n");
		
		score = 0;
		nbParties = 1;
		
		
		do {
			boolPartie = false;
			
			//On initialise le mot à trouver avec le dictionnaire
			motATrouver = RegleDuJeu.initialisation(file);
			
			//On initialise le nb d'essais avec le mot à trouver
			nbEssais = RegleDuJeu.nbEssaisAutorises(motATrouver);
			
			//On initialise une nouvelle partie
			RegleDuJeu partie = new RegleDuJeu(motATrouver, nbEssais);
			
			System.out.println("\n-----PARTIE " + nbParties + "-----\n");
			
				//on relance un tour de jeu tant que le boolean est à true
				do {
					boolPartie = partie.jouer(sc);
				}while(boolPartie);
					
				
			System.out.println("\n\nFIN DE LA PARTIE ----- Score : " + score + "/" + nbParties);
			
			nbParties++;
			
			//On propose de recommencer une partie
			do {
				System.out.println("\nVoulez-vous refaire une partie ? Y/N");
				reponse = sc.nextLine().toUpperCase().charAt(0);
				if(reponse == 'Y') 
					continuer = true;
				else if(reponse == 'N')
					continuer = false;
				else
					System.err.println("Veuillez choisir Y pour oui et N pour non\n");
			}while(reponse != 'Y' && reponse != 'N');
			
		}while(continuer);
		
		sc.close();
		System.exit(0);
	}

}
