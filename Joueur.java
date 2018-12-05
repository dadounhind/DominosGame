package projetDomino;

import java.util.ArrayList;

/**
 * Joueur est la classe abstraite représentant un joueur.
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
	 * Affiche la liste de domino donné en paramètre .
	 * @param ensembleDomino Liste de domino à afficher.
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
     * Méthode demandant au joueur de choisir un domino à poser par rapport aux dominos en place dans le jeu.
     * @param GaucheDeLaChaine Domino le plus à gauche parmi ceux déjà joués.
     * @param DroiteDeLaChaine Domino le plus à droite parmi ceux déjà joués.
     * @return Un domino pouvant être placé dans le jeu, et Null sinon.
     * @throws IllegalStateException Le joueur n'a plus de pioche, mais est demandé de choisir un domino.
     */
	public abstract Domino choisirDominoAposer (Domino GaucheDeLaChaine, Domino DroiteDeLaChaine ) throws IllegalStateException;

/* On va creer une méthode qui permet de recevoir une copie de la pioche du gestionnaire.
   De cette maniere le joeur ne pourra pas tromper le gestionnaire mais aura quand meme accès à sa pioche*/
	
	/**
	 * Permet d'obtenir la main du joueur.
	 * @return La main du joueur
	 */
    public ArrayList<Domino> getPiocheJoueur() {
    	return piocheJoueur;
    }
}
