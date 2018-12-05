package projetDomino;
import java.util.ArrayList;

/**
 * JoueurAutomatique hérite de Joueur et qui représente les joueurs automatique
 * @see Joueur
 */
public class JoueurAutomatique extends Joueur {
	/**
	 * Constructeur de JoueurAutomatique.
	 * @param name Nom du joueur.
	 * @param piocheJoueur Main du joueur.
	 */
    public JoueurAutomatique (String name, ArrayList<Domino> piocheJoueur) {
        super(name , piocheJoueur);
    }
	@Override
	public Domino choisirDominoAposer(Domino GaucheDeLaChaine, Domino DroiteDeLaChaine) throws IllegalStateException{
		 ArrayList<Domino> maPioche = getPiocheJoueur();
		 if (maPioche.isEmpty()) throw new IllegalStateException("Aucun domino disponible");
		 else{
			 if (DroiteDeLaChaine == null && GaucheDeLaChaine == null){ 
				 //Ne peut se faire si au premier tour, tous les joueurs consoles ont pioché
		        	return maPioche.get(0);
		     }else{
		        for (int i =0; i<maPioche.size();i++) {
		        	Domino domino = maPioche.get(i);
		            if (domino.getRight() == GaucheDeLaChaine.getLeft() || domino.getLeft() == DroiteDeLaChaine.getRight())
		                return domino;
		            if (domino.getLeft() == GaucheDeLaChaine.getLeft() || domino.getRight() == DroiteDeLaChaine.getRight()){
		                domino.rotate();
		                return domino;
		            }
		        }
		        return null;
			 }
		 }
	}
}

