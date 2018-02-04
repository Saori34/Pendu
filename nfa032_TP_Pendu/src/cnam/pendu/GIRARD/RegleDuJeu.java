package cnam.pendu.GIRARD;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;



/**
 * CLasse RegleDuJeu gérant les informations du jeu et ses mécanismes
 * 
 * @author Emilie GIRARD
 *
 */
public class RegleDuJeu {

	//Mot à trouver
	private static String motATrouver;
	
	//Nombre d'essais autorisés
	private static /*final*/ int nbEssais;
	
	//Nombre d'erreurs commises
	private int nbErreurs;
	
	//Tableau de booleens pour les lettres trouvées
	private boolean[] lTrouvees;
	
	
	public RegleDuJeu(){
		
	}
	
	public RegleDuJeu(String motATrouve, int nbEssaisAuto) {
		motATrouver = motATrouve;
		nbEssais = nbEssaisAuto;
		lTrouvees = new boolean[motATrouver.length()];
		
	}
	
	//GETTERS AND SETTERS
	
	/**
	 * @return the motATrouver
	 */
	public String getMotATrouver() {
		return motATrouver;
	}

	/**
	 * @param motATrouver the motATrouver to set
	 */
	public void setMotATrouver(String motATrouve) {
		motATrouver = motATrouve;
	}

	/**
	 * @return the nbEssais
	 */
	public int getNbEssais() {
		return nbEssais;
	}

	/**
	 * @param nbEssais the nbEssais to set
	 */
	public void setNbEssais(int essais) {
		nbEssais = essais;
	}

	/**
	 * @return the nbErreurs
	 */
	public int getNbErreurs() {
		return nbErreurs;
	}

	/**
	 * @param nbErreurs the nbErreurs to set
	 */
	public void setNbErreurs(int nbErreurs) {
		this.nbErreurs = nbErreurs;
	}

	/**
	 * @return the lTrouvees
	 */
	public boolean[] getlTrouvees() {
		return lTrouvees;
	}

	/**
	 * @param lTrouvees the lTrouvees to set
	 */
	public void setlTrouvees(boolean[] lTrouvees) {
		this.lTrouvees = lTrouvees;
	}

	
	//METHODES
	
	
	public void afficher(int nbTraits) {
		//TODO nb de traits à afficher dans le dessin
		
		
	
	}
	
	
	
	public void afficher(int nbTraits, int nbErreurs) {
		//TODO redéfinir afficher pour augmenter de manière constante le nombre de traits affiches dans le dessin à chaque faute
		
	}
	
	/*
	 * Affiche le mot à trous selon l'état d'avancement de la partie, donc selon le tableau de boolean
	 */
	public void afficherMot() {
		
		for(int i = 0; i<lTrouvees.length; i++) {
			if(lTrouvees[i]) {
				System.out.print(motATrouver.charAt(i));
			}
			else {
				System.out.print("_");
			}
		}
	}
	
	/*
	 * Renvoie un boolean pour indiquer si oui ou non le caractere appartient au mot recherché. Doit modifier l'état du tableau représentant le mot à trou
	 * @param lettre : lettre testée par l'utilisateur
	 */
	public boolean[] chercheLettre(char lettre) {
		//TODO 
		char[] tabMot = motATrouver.toCharArray();
		for(int i = 0; i<tabMot.length; i++) {
				if(lettre == tabMot[i]) {
					lTrouvees[i] = true;
				}
				else {
					lTrouvees[i] = false;
				}
		}
			
		return lTrouvees;
	}
	
	/*
	 * Teste toutes les lettres pour savoir si oui ou non on a les toutes trouvées et si on a gagné
	 */
	public boolean gagne() {
		
		int ok = 0;
		for(int i = 0; i<lTrouvees.length; i++) {
			if(lTrouvees[i]) {
				ok++;
			}
		}
		if(ok == lTrouvees.length) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean jouer(Scanner sc) {
		//TODO recupére le flux de caractere à tester, effectue un tour de jeu, affiche le mot à trous puis demande au joueur 
		//d'entrer un catactere pour le completer, puis elle teste la presence du caractere dans le mot puis teste la fin du jeu, un message est affiche si la partie est gagnée ou perdue
		// retourne true si le jeu continu et false si le jeu s'arrete (gagné ou perdu)
		return true;
	}
	
	/*
	 * Permet de charger une liste de mots à partir d'un fichier plat, le mot doit être choisi au hasard, sans oublier le nombre d'essai possible pour chaque mot, 
	 * un mot court à moins d'essai qu'un mot long
	 * @param fichier File , un fichier txt
	 * @return String le mot à trouver
	 */
	public static String initialisation (File file) {
		ArrayList<String>tabMots = new ArrayList<>();
		int NbMots = 0; 
		Random rand = new Random();
		
		try{
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			
			try{
				//extraction chaine du fichier
				String tmp;
				while((tmp = br.readLine()) != null){
					NbMots++;
					tabMots.add(tmp);
				}
			}finally{
			//Libérer les ressources
			br.close();
			fr.close();
			}
		}catch(FileNotFoundException e){
			e.printStackTrace();
			System.err.println("Fichier non trouvé");
		}catch(IOException e){
			System.err.println("Erreur acces fichier");
			e.printStackTrace();
		}
		
		//on prend un index au hasard
		int index = rand.nextInt(NbMots);
		//on va chercher le mot de la liste à cet index
		motATrouver = tabMots.get(index);
			
		return motATrouver;
	}
	
	/*
	 *On donne un nombre d'essais autorises selon la longueur du mot 
	 *@param le mot à trouver
	 *@return int le nombre d'essais
	 */
	public static int nbEssaisAutorises(String motATrouver) {
				if(motATrouver.length() <= 5)
					nbEssais = 5;
				else if(motATrouver.length() > 5 && motATrouver.length() < 9)
					nbEssais = 10;
				else if(motATrouver.length() > 9)
					nbEssais = 13;
				return nbEssais;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
