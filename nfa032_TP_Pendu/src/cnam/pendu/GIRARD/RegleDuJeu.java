package cnam.pendu.GIRARD;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;



/**
 * CLasse RegleDuJeu g�rant les informations du jeu et ses m�canismes
 * 
 * @author Emilie GIRARD
 *
 */
public class RegleDuJeu {

	//Mot � trouver
	private static String motATrouver;
	
	//Nombre d'essais autoris�s
	private static  int nbEssais;
	
	//Nombre d'erreurs commises
	private int nbErreurs;
	
	//Tableau de booleens pour les lettres trouv�es
	private boolean[] lTrouvees;
	
	//Tableau de char pour les lettres d�j� propos�es
	private ArrayList<Character> lettresProposees = new ArrayList<>();
	
	
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
	 * retourne un tableau de boolean repr�sentant les lettres d�j� trouv�es
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
	
	/*
	 * @return arrayList lettresProposees
	 */
	public ArrayList<Character> getLettresProposees(){
		return lettresProposees;
	}

	
	//METHODES
	
	/*
	 * Affiche un certain nombre de traits pour le dessin du pendu
	 */
	public void afficher(int nbTraits) {
		System.out.println("\n");
		int [][] ordreDessin = Dessin.getOrdreDessin();
		char [][] dessin = Dessin.getDessin();
		boolean trouve = false;
		
		for(int i = 0 ; i < ordreDessin.length ; i++) {
			System.out.print("\n");
			for(int j = 0 ; j < ordreDessin[i].length ; j++) {	
				trouve = false;
				for(int k = nbTraits ; k > 0 ; k--) {
					if(ordreDessin[i][j] == k) {
						System.out.print(dessin[i][j]);
						trouve = true;
					}
				}
				if(!trouve) {
					System.out.print(" ");
				}
			}
		}		
		System.out.println("\n");
	}
	
	
	/*
	 * Red�fini la fonction afficher pour augmenter le nombre de traits � afficher � chaque nouvelle erreur, en fonction du nombre d'essais autoris�s et du nombre d'erreurs en cors
	 */
	public void afficher(int nbEssais, int nbErreurs) {
		//TODO red�finir afficher pour augmenter de mani�re constante le nombre de traits affiches dans le dessin � chaque faute
		int nbTraits = 1;
		
		//si on a autant d'erreurs que d'essais (donc le jeu est perdu) alors on affiche aussi le reste de la division (modulo) pour compl�menter le dessin
		if(nbErreurs == nbEssais) {
			nbTraits = (Dessin.getNOMBREMAXELEMENT() / nbEssais) * nbErreurs + (Dessin.getNOMBREMAXELEMENT() % nbEssais);
		}
		
		nbTraits = (Dessin.getNOMBREMAXELEMENT() / nbEssais) * nbErreurs;
		
		
		this.afficher(nbTraits);
		
	}
	
	/*
	 * Affiche le mot � trous selon l'�tat d'avancement de la partie, donc selon le tableau de boolean
	 */
	public void afficherMot(boolean[]lTrouvees) {
		
		System.out.println("");
		for(int i = 0; i<lTrouvees.length; i++) {
			if(lTrouvees[i]) {
				System.out.print(motATrouver.charAt(i));
			}
			else {
				System.out.print("_");
			}
		}
		System.out.println("");
	}
	
	/*
	 * Renvoie un boolean pour indiquer si oui ou non le caractere appartient au mot recherch�. Doit modifier l'�tat du tableau repr�sentant le mot � trou
	 * @param lettre : lettre test�e par l'utilisateur
	 * @return un boolean true si la lettre est pr�sente
	 */
	public boolean chercheLettre(char lettre) {
		char[]tabMot = motATrouver.toCharArray();
		boolean []lettres = this.getlTrouvees();
		boolean cherche = false;
		//plutot que d'utiliser une m�thode de la classe String comme indexOf(), on pr�f�rera chercher case par case pour �tre s�rs de trouver toutes les occurences de lettres
		for(int i = 0; i<tabMot.length; i++) {
			if(tabMot[i] == lettre) {
				lettres[i] = true;
				cherche = true;
			}
		}
		return cherche;
	}
	
	/*
	 * Teste toutes les lettres pour savoir si oui ou non on a les toutes trouv�es et si on a gagn�
	 * @return un booleen true si on a trouv� toutes les lettres
	 */
	public boolean gagne() {
		boolean []lettres = this.getlTrouvees();
		int ok = 0;
		for(int i = 0; i < lettres.length; i++) {
			if(lettres[i]) {
				ok++;
			}
		}
		if(ok == lettres.length) {
			return true;
		}
		else {
			return false;
		}
	}
	
	
	/*
	 * 
	 */
	public boolean jouer(Scanner sc) {
		//TODO recup�re le flux de caractere � tester, effectue un tour de jeu, affiche le mot � trous puis demande au joueur 
		//d'entrer un catactere pour le completer, puis elle teste la presence du caractere dans le mot puis teste la fin du jeu, un message est affiche si la partie est gagn�e ou perdue
		// retourne true si le jeu continu et false si le jeu s'arrete (gagn� ou perdu)
		boolean jouer = true;
		//On r�cup�re la saisie utilisateur
		String tmp = "";
		char lettre;
		
		//On affiche le mot
		this.afficherMot(this.getlTrouvees());
		
	
		//On demande � l'utilisateur de donner une lettre � tester
		System.out.println("\n\nVeuillez saisir une lettre � tester");
		
		//On r�cup�re la saisie utilisateur en v�rifiant s'il s'agit bien de lettres
		do {
			do {
				tmp = sc.nextLine();
				tmp = tmp.toUpperCase();
				if(!tmp.matches("^[A-Z]")) {
					System.err.println("\nVous devez saisir une lettre !");
				}
			}while(!tmp.matches("^[A-Z]"));//tant qu'il ne s'agit pas de lettre on recommence la boucle
			
			//On r�cup�re uniquement la premi�re lettre (si la chaine est plus longue)
			lettre = tmp.charAt(0);
			
			
		}while(this.lettreProposee(lettre));//on refait la boucle tant que la lettre a d�j� �t� propos�e
		
		//On ajoute la lettre � la liste de lettres deja propos�es
		lettresProposees.add(lettre);
				
		//On teste si la lettre est pr�sente
		if(!this.chercheLettre(lettre)) {
			nbErreurs++;
			System.out.println("");
			this.afficher(nbEssais, nbErreurs);
			//Si on a utilis� tous les essais on a perdu
			if(nbErreurs == nbEssais) {
				System.out.println("\nPERDU !! \nVous avez atteint le nombre d'essais maximum !\n");
				System.out.println("Le mot � trouver �tait : " + motATrouver);
				jouer = false;
			}
			else{
				System.out.println("\nD�sol� cette lettre ne fait pas partie de ce mot");
				System.out.println("Nombre d'essais restants : " + (nbEssais-nbErreurs));
			}
			
		}
		
		else {
			if(!this.gagne()) {//si on a pas gagn� la partie on affiche qu'on a trouv� une lettre seulement 
				System.out.println("\nBravo ! Vous avez trouv� une lettre !");
				System.out.println("Nombre d'essais restants : " + (nbEssais-nbErreurs));
			}
			else {//sinon on affiche qu'on a gagn� la partie
				System.out.println("\nGAGNE ! Vous avez trouv� le mot !");
				System.out.println(motATrouver);
				jouer = false;
			}
		}
		
		return jouer;
	}
	
	/*
	 * Permet de charger une liste de mots � partir d'un fichier plat, le mot doit �tre choisi au hasard, sans oublier le nombre d'essai possible pour chaque mot, 
	 * un mot court � moins d'essai qu'un mot long
	 * @param fichier File , un fichier txt
	 * @return String le mot � trouver
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
			//Lib�rer les ressources
			br.close();
			fr.close();
			}
		}catch(FileNotFoundException e){
			e.printStackTrace();
			System.err.println("Fichier non trouv�");
		}catch(IOException e){
			System.err.println("Erreur acces fichier");
			e.printStackTrace();
		}
		
		//on prend un index au hasard
		int index = rand.nextInt(NbMots);
		//on va chercher le mot de la liste � cet index
		motATrouver = tabMots.get(index);
		//on supprime les �ventuels espaces autour du mot
		motATrouver = motATrouver.trim();
			
		return motATrouver;
	}
	
	/*
	 *On donne un nombre d'essais autorises selon la longueur du mot 
	 *@param le mot � trouver
	 *@return int le nombre d'essais
	 */
	public static int nbEssaisAutorises(String motATrouver) {
				if(motATrouver.length() <= 5)
					nbEssais = 5;
				else if(motATrouver.length() > 5 && motATrouver.length() <= 9)
					nbEssais = 7;
				else if(motATrouver.length() > 9)
					nbEssais = 10;
				return nbEssais;
	}
	
	/*
	 * On v�rifie si la lettre propos� par l'utilisateur a d�j� �t� propos�e{
	 * @param char[] lettresProp les lettres d�j� test�es
	 * @param char la lettre actuellement propos�e
	 * @return true si la lettre a d�j� �t� propos�e
	 */
	public boolean lettreProposee(char lettre) {
		ArrayList<Character> lettresProp = this.getLettresProposees();
		Iterator <Character> it = lettresProp.iterator();
		if(!lettresProp.isEmpty()) {
			while(it.hasNext()) {
				if(it.next() == lettre) {
					System.err.println("Vous avez d�j� test� cette lettre, veuillez en saisir une autre");
					return true;
				}
			}
		}
		return false;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
