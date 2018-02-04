package cnam.pendu.GIRARD;


/**
 * Classe Dessin permettant la gestion du dessin du pendu
 * 
 * @author Emilie GIRARD
 *
 */
public class Dessin {

	//Tableau à double dimension pour le dessin du pendu
	private char[][] dessin = 
			{{' ', ' ', '_', '_', '_', '_', '_'},
			{' ', ' ', '|', '/', ' ', ' ', '|', ' '},
			{' ', ' ', '|', ' ', ' ', ' ', 'O', ' '},
			{' ', ' ', '|', ' ', ' ', '/', '|', '\\'},
			{' ', ' ', '|', ' ', ' ', '/', ' ', '\\'}};
	
	
	//Tableau à double dimension por l'ordre d'apparition de chaque élément
	private int[][] ordreDessin = 
					{{0, 0, 13, 14, 15, 16},
					{0, 0, 12, 17, 0 , 0, 18},
					{0, 0, 11, 0, 0, 0, 19},
					{0, 0, 10, 0, 0, 21, 20, 22},
					{0, 0, 9, 0, 0, 23, 0, 24},
					{1, 2, 8, 3, 4, 5, 6, 7}};
	
	
	//Constante
	private final int NOMBREMAXELEMENT = 25;


		
	//GETTERS AND SETTERS
	
	/**
	 * @return the dessin
	 */
	public char[][] getDessin() {
		return dessin;
	}


	/**
	 * @return the ordreDessin
	 */
	public int[][] getOrdreDessin() {
		return ordreDessin;
	}


	/**
	 * @return the nOMBREMAXELEMENT
	 */
	public int getNOMBREMAXELEMENT() {
		return NOMBREMAXELEMENT;
	}

	
	
	
}
