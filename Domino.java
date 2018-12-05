package projetDomino;
import java.lang.IllegalArgumentException;

/**
 * Domino est la classe repr�sentant un domino.
 * @author Hind Dadoun
 *
 */
public class Domino {
	/**
	 * Entier �crit � gauche sur le domino.
	 */
    private int left;
    
    /**
     * Entier �crit � droite sur le domino.
     */
    private int right;
    
    /**
     * Constructeur d'un domino.
     * @param left Indique l'entier compris entre 0 et 6 � mettre � gauche sur le domino.
     * @param right Indique l'entier compris entre 0 et 6 � mettre � droite sur le domino.
     * @throws IllegalArgumentException
     */
    public Domino(int left, int right) throws IllegalArgumentException {
        if (left <0 || left >6 || right<0 || right>6)
            throw new IllegalArgumentException(new String("Veuillez selectionner un chiffre compris entre 0 et 6" ));
        this.left=left;
        this.right=right;
    }
    
    /**
     * Permet de r�cup�rer l'entier � droite sur le domino.
     * @return L'entier �crit � droite sur le domino.
     */
    public int getRight(){
        return right;
    }
    
    /**
     * Permet de r�cup�rer l'entier � gauche sur le domino.
     * @return L'entier �crit � gauche sur le domino.
     */
    public int getLeft(){
        return left;
    }
    
    /**
     * M�thode permettant de retourner un domino. C'est-�-dire inverser la droite et la gauche.
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

