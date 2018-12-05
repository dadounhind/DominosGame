package projetDomino;

import java.util.ArrayList;

import org.junit.Test;

/**
 * Classe de tests des joueurs automatiques.
 * @author Hind Dadoun
 *
 */
public class JoueurAutomatiqueTest {
	private Domino creerDomino() { //Creation d'un domino
        int i,j;
        i = (int)(Math.random() * 6);
        j = (int)(Math.random() * 6);
        return new Domino(i,j);
    }
    
   
    private ArrayList<Domino> creerensembleDomino(int taille){ //Creation d'une pioche de taille donnée
    	ArrayList<Domino> ensembleDomino = new ArrayList<Domino>();
    	for(int i =0; i<taille ; i++){
    		ensembleDomino.add(creerDomino());
    	}
    	return ensembleDomino;
    }
    
    /**
     * Permet de tester les erreurs si on demande à un joueur n'ayant pas de domino d'en choisir un.
     */
    public void exceptionDominoVide(){
    	Domino GaucheDeLaChaine= new Domino(2,1);
		Domino DroiteDeLaChaine=new Domino (3,4); 
		ArrayList<Domino> pioche= new ArrayList<Domino>(); 
		Joueur j = new JoueurAutomatique("moi",pioche);
		j.choisirDominoAposer(GaucheDeLaChaine, DroiteDeLaChaine);
    }
    
    /**
     * Test si en présence de domino, la méthode choisirDominoAposer des Joueurs automatiques fonctionnent bien.
     */
    public void exceptionDominoAPlacer(){
    	Domino GaucheDeLaChaine= new Domino(2,1);
		Domino DroiteDeLaChaine=new Domino (3,4); 
		ArrayList<Domino> pioche= creerensembleDomino(7); 
		Joueur j = new JoueurAutomatique("moi",pioche);
		j.choisirDominoAposer(GaucheDeLaChaine, DroiteDeLaChaine);
    }
    
	@Test
	public void test() {
		exceptionDominoAPlacer();
		exceptionDominoVide();
	}

}
