package cnam.pendu.GIRARD;

import java.io.File;
import java.util.Scanner;

/**
 * CLasse RegleDuJeu gérant les informations du jeu et ses mécanismes
 * 
 * @author Emilie GIRARD
 *
 */
public class RegleDuJeu {

	//Mot à trouver
	private String motATrouver;
	
	//Nombre d'essais autorisés
	private /*final*/ int nbEssaisAuto;
	
	//Nombre d'erreurs commises
	private int nbErreurs;
	
	//Tableau de booleens pour les lettres trouvées
	private boolean[] lTrouvees;
	
	
	public RegleDuJeu(){
		
	}
	
	public RegleDuJeu(String motATrouver, int nbEssaisAuto) {
		this.motATrouver = motATrouver;
		this.nbEssaisAuto = nbEssaisAuto;
	}
	
	
	
	
	public String afficher(int nbTraits) {
		//TODO nb de traits à afficher dans le dessin
		String str = "";
		return str;
	}
	
	
	public String afficher(int nbTraits, int nbErreurs) {
		//TODO redéfinir afficher pour augmenter de manière constante le nombre de traits affiches dans le dessin à chaque faute
		String str = "";
		return str;
	}
	
	public String afficherMot(String motATrouver) {
		//TODO affiche le mot à trous selon l'état d'avancement de la partie
		String str ="";
		return str;
	}
	
	public boolean chercheLettre(char lettre) {
		//TODO renvoie un boolean pour indiquer si oui ou non le caractere appartient au mot recherché. Doit modifier l'état du tableau représentant le mot à trou
		return true;
	}
	
	public boolean gagne() {
		//TODO teste toutes les lettres pour savoir si oui ou non on a les toutes trouvées et si on a gagné
		return true;
	}
	
	public boolean jouer(Scanner sc) {
		//TODO recupére le flux de caractere à tester, effectue un tour de jeu, affiche le mot à trous puis demande au joueur 
		//d'entrer un catactere pour le completer, puis elle teste la presence du caractere dans le mot puis teste la fin du jeu, un message est affiche si la partie est gagnée ou perdue
		// retourne true si le jeu continu et false si le jeu s'arrete (gagné ou perdu)
		return true;
	}
	
	public void initialisation (File file) {
		//permet de charger une liste de mots à partir d'un fichier plat, le mot doit être choisi au hasard, sans oublier le nombre d'essai possible pour chaque mot, 
		//un mot court à moins d'essai qu'un mot long
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
