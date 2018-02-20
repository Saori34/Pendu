package cnam.pendu.GIRARD;


/**
 * Classe Dessin permettant la gestion du dessin du pendu
 * 
 * @author Emilie GIRARD
 *
 */
public class Dessin {

	//Tableau à double dimension pour le dessin du pendu
	static private char[][] dessin = 
			{{' ', ' ', '_', '_', '_', '_', '_'},
			{' ', ' ', '|', '/', ' ', ' ', '|'},
			{' ', ' ', '|', ' ', ' ', ' ', 'O'},
			{' ', ' ', '|', ' ', ' ', '/', '|', '\\'},
			{' ', ' ', '|', ' ', ' ', '/', ' ', '\\'},
			{'_', '_', '|', '_', '_', '_', '_', '_'}};
	
	
	//Tableau à double dimension por l'ordre d'apparition de chaque élément
	static private int[][] ordreDessin = 
					{{0, 0, 13, 14, 15, 16, 17},
					{0, 0, 12, 18, 0, 0, 19},
					{0, 0, 11, 0, 0, 0, 20},
					{0, 0, 10, 0, 0, 22, 21, 23},
					{0, 0, 9, 0, 0, 24, 0, 25},
					{1, 2, 8, 3, 4, 5, 6, 7}};
	
		
			
	//Constante
	static private final int NOMBREMAXELEMENT = 25;


		
	//GETTERS AND SETTERS
	
	/**
	 * @return the dessin
	 */
	public static char[][] getDessin() {
		return dessin;
	}


	/**
	 * @return the ordreDessin
	 */
	public static int[][] getOrdreDessin() {
		return ordreDessin;
	}


	/**
	 * @return the nOMBREMAXELEMENT
	 */
	public static int getNOMBREMAXELEMENT() {
		return NOMBREMAXELEMENT;
	}

	
	
	
}
