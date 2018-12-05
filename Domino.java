package projetDomino;
import java.lang.IllegalArgumentException;

/**
 * Domino est la classe représentant un domino.
 * @author Hind Dadoun
 *
 */
public class Domino {
	/**
	 * Entier écrit à gauche sur le domino.
	 */
    private int left;
    
    /**
     * Entier écrit à droite sur le domino.
     */
    private int right;
    
    /**
     * Constructeur d'un domino.
     * @param left Indique l'entier compris entre 0 et 6 à mettre à gauche sur le domino.
     * @param right Indique l'entier compris entre 0 et 6 à mettre à droite sur le domino.
     * @throws IllegalArgumentException
     */
    public Domino(int left, int right) throws IllegalArgumentException {
        if (left <0 || left >6 || right<0 || right>6)
            throw new IllegalArgumentException(new String("Veuillez selectionner un chiffre compris entre 0 et 6" ));
        this.left=left;
        this.right=right;
    }
    
    /**
     * Permet de récupérer l'entier à droite sur le domino.
     * @return L'entier écrit à droite sur le domino.
     */
    public int getRight(){
        return right;
    }
    
    /**
     * Permet de récupérer l'entier à gauche sur le domino.
     * @return L'entier écrit à gauche sur le domino.
     */
    public int getLeft(){
        return left;
    }
    
    /**
     * Méthode permettant de retourner un domino. C'est-à-dire inverser la droite et la gauche.
     */
    public void rotate() {
        int temp=left;
        left=right;
        right=temp;
    }
    
    /**
     * Permet d'afficher le domino
     */
    public void printDomino(){
    	System.out.println("Le domino est ("+this.left+", "+this.right+")");
    }
    
    /**
     * Permet d'afficher le domino sous un format plus compact, utile pour afficher une liste de domino .
     * @see Domino#printDomino()
     */
    public void aprintDomino(){
    	System.out.print("("+this.left+", "+this.right+") ");
    }
}

