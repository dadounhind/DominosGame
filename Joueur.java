package projetDomino;

import java.util.ArrayList;

/**
 * Joueur est la classe abstraite repr�sentant un joueur.
 * @author Hind Dadoun
 *
 */
public abstract class Joueur {
	/**
	 * Nom du joueur.
	 */
	public String name;
	/**
	 * Main du joueur (ensemble de dominos).
	 */
    private ArrayList<Domino> piocheJoueur;
    
	/**
	 * Affiche la liste de domino donn� en param�tre .
	 * @param ensembleDomino Liste de domino � afficher.
	 */
	private static void afficheensembleDomino(ArrayList<Domino> ensembleDomino){ //Creation d'une pioche
		if (ensembleDomino.isEmpty()){
			System.out.println("Aucun domino");
		}
		for(Domino i:ensembleDomino){
			i.aprintDomino();
		}System.out.println("");
	}
	
	/**
	 * Constructeur de Joueur.
	 * @param n Nom du joueur.
	 * @param p Main du joueur.
	 */
    public Joueur(String n, ArrayList<Domino> p) {
        this.name=n;
        this.piocheJoueur=p;
    }
    
    /**
     * Affiche les informations du joueur. Son nom et sa main.
     */
    public void printJoueur(){
    	System.out.println("Le joueur "+name+" a la pioche :");
    	afficheensembleDomino(piocheJoueur);
    }
    
    /**
     * M�thode demandant au joueur de choisir un domino � poser par rapport aux dominos en place dans le jeu.
     * @param GaucheDeLaChaine Domino le plus � gauche parmi ceux d�j� jou�s.
     * @param DroiteDeLaChaine Domino le plus � droite parmi ceux d�j� jou�s.
     * @return Un domino pouvant �tre plac� dans le jeu, et Null sinon.
     * @throws IllegalStateException Le joueur n'a plus de pioche, mais est demand� de choisir un domino.
     */
	public abstract Domino choisirDominoAposer (Domino GaucheDeLaChaine, Domino DroiteDeLaChaine ) throws IllegalStateException;

/* On va creer une m�thode qui permet de recevoir une copie de la pioche du gestionnaire.
   De cette maniere le joeur ne pourra pas tromper le gestionnaire mais aura quand meme acc�s � sa pioche*/
	
	/**
	 * Permet d'obtenir la main du joueur.
	 * @return La main du joueur
	 */
    public ArrayList<Domino> getPiocheJoueur() {
    	return piocheJoueur;
    }
}
