package cnam.pendu.GIRARD;

import java.io.File;
import java.util.Scanner;

/**
 * CLasse RegleDuJeu g�rant les informations du jeu et ses m�canismes
 * 
 * @author Emilie GIRARD
 *
 */
public class RegleDuJeu {

	//Mot � trouver
	private String motATrouver;
	
	//Nombre d'essais autoris�s
	private /*final*/ int nbEssaisAuto;
	
	//Nombre d'erreurs commises
	private int nbErreurs;
	
	//Tableau de booleens pour les lettres trouv�es
	private boolean[] lTrouvees;
	
	
	public RegleDuJeu(){
		
	}
	
	public RegleDuJeu(String motATrouver, int nbEssaisAuto) {
		this.motATrouver = motATrouver;
		this.nbEssaisAuto = nbEssaisAuto;
	}
	
	
	
	
	public String afficher(int nbTraits) {
		//TODO nb de traits � afficher dans le dessin
		String str = "";
		return str;
	}
	
	
	public String afficher(int nbTraits, int nbErreurs) {
		//TODO red�finir afficher pour augmenter de mani�re constante le nombre de traits affiches dans le dessin � chaque faute
		String str = "";
		return str;
	}
	
	public String afficherMot(String motATrouver) {
		//TODO affiche le mot � trous selon l'�tat d'avancement de la partie
		String str ="";
		return str;
	}
	
	public boolean chercheLettre(char lettre) {
		//TODO renvoie un boolean pour indiquer si oui ou non le caractere appartient au mot recherch�. Doit modifier l'�tat du tableau repr�sentant le mot � trou
		return true;
	}
	
	public boolean gagne() {
		//TODO teste toutes les lettres pour savoir si oui ou non on a les toutes trouv�es et si on a gagn�
		return true;
	}
	
	public boolean jouer(Scanner sc) {
		//TODO recup�re le flux de caractere � tester, effectue un tour de jeu, affiche le mot � trous puis demande au joueur 
		//d'entrer un catactere pour le completer, puis elle teste la presence du caractere dans le mot puis teste la fin du jeu, un message est affiche si la partie est gagn�e ou perdue
		// retourne true si le jeu continu et false si le jeu s'arrete (gagn� ou perdu)
		return true;
	}
	
	public void initialisation (File file) {
		//permet de charger une liste de mots � partir d'un fichier plat, le mot doit �tre choisi au hasard, sans oublier le nombre d'essai possible pour chaque mot, 
		//un mot court � moins d'essai qu'un mot long
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
