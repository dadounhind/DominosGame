package projetDomino;

import java.util.ArrayList;
import java.lang.IllegalStateException;

/**
 *La classe Gestionnaire est le centre de controle du jeu.
 *Elle crée les joueurs, leur assigne 7 domino chacun et crée la pioche commune.
 *<p>
 *Elle est aussi la responsable du (bon) déroulement du jeu.
 *@see Gestionnaire#Gestionnaire(int, int)
  *@see Gestionnaire#jeu()
 *@author Hind Dadoun
*/

public class Gestionnaire {
	/**
	 * La liste des joueurs
	 */
    private ArrayList<Joueur> joueurs; //Liste des joueurs
    
    /**
     * Pioche commune des joueurs
     */
    private ArrayList<Domino> pioche; // Pioche commune
    
    /**
     * A true indique que la partie est en cours, et à False indique qu'il y a un gagnant.
     */
    private boolean partiEnCours = true;
    
    /**
     * Indique le nombre affiché à gauche du domino le plus à gauche dans la chaine de domino posé
     */
    private Domino GaucheDeLaChaine;
    
    /**
     * Indique le nombre affiché à droite du domino le plus à droite dans la chaine de domino posé
     */
    private Domino DroiteDeLaChaine;
    
    
    /*private void afficheListeJoueur(){
    	if (joueurs.isEmpty()){
			System.out.println("Aucun joueur");
		}
		for(Joueur i:joueurs){
			i.printJoueur();
		}
    }*/
    
    /**
     * Créé un domino dont les faces sont aléatoirement générées, mais comprise entre 0 et 6
     * @return Le domino créé.
     */
    private Domino creerDomino() { //Creation d'un domino
        int i,j;
        i = (int)(Math.random() * 6);
        j = (int)(Math.random() * 6);
        return new Domino(i,j);
    }
    
   /**
    * Créé un liste de dominos aléatoirement généré.
    * @see Gestionnaire#creerDomino()
    * @param taille Indique exactement le nombre de dominos dans la liste; la taille de la liste.
    * @return Une liste de longueur <i>taille</i> contenant des dominos générés aléatoirement.
    */
    private ArrayList<Domino> creerensembleDomino(int taille){ //Creation d'une pioche de taille donnée
    	ArrayList<Domino> ensembleDomino = new ArrayList<Domino>();
    	for(int i =0; i<taille ; i++){
    		ensembleDomino.add(creerDomino());
    	}
    	return ensembleDomino;
    }
    
    /*private void afficheensembleDomino(ArrayList<Domino> ensembleDomino){ //Creation d'une pioche
    	if (ensembleDomino.isEmpty()){
    		System.out.println("Aucun domino");
    	}
    	for(Domino i:ensembleDomino){
    		i.aprintDomino();
    	}
    }*/
    
    /**
     * Constructeur de Gestionnaire
     * 
     * A la construction d'un Gestionnaire, créer les joueurs avec leur main, créerla pioche commune et indique qu'il n'y a pas encore de domino posé
     * et la partie en marqué en cours.
     * 
     * @param nombreDeJoueursUtilisateurs Indique le nombre de joueurs console à créer.
     * @param nombreDeJoueursAutomatiques Indique le nombre de joueurs automatique à créer.
     */
	public Gestionnaire(int nombreDeJoueursUtilisateurs, int nombreDeJoueursAutomatiques)
    {
        joueurs = new ArrayList<Joueur>();
        pioche = new ArrayList<Domino>();
        
      //Creation Joueurs console
        for(int i=0; i<nombreDeJoueursUtilisateurs;i++){ 
        	Joueur j = new JoueurConsole("CJoueur "+(i+1),creerensembleDomino(7));
        	joueurs.add(j);
        }
        
      //Creation Joueurs automatiques
        for(int i=nombreDeJoueursUtilisateurs; i<nombreDeJoueursUtilisateurs+nombreDeJoueursAutomatiques;i++){
        	Joueur j = new JoueurAutomatique("AJoueur "+(i+1),creerensembleDomino(7));
        	joueurs.add(j);
        }
        //Création pioche 28-la main de tous les joueurs
        pioche = creerensembleDomino(28- 7*(nombreDeJoueursUtilisateurs+nombreDeJoueursAutomatiques));
        
        partiEnCours = true;
        GaucheDeLaChaine = null;
        DroiteDeLaChaine = null;
    }
	
	/**
	 * Méthode du Gestionnaire contrôlant le déroulement du jeu.
	 * @throws IllegalStateException Si jamais le gestionnaire demande à un joueur de joueur alors que sa main est vide.
	 */
    public void jeu () throws IllegalStateException
    {
    	int tour = 1; //Permet d'indiquer si un joueur n'a pas fini son tour
    	int totalJoueurs = joueurs.size(); //Nombre total de joueurs dans le jeu.
    	ArrayList<Joueur> perdants = new ArrayList<Joueur>();//Liste des joueurs ne pouvant plus joueur
    	
    	while (partiEnCours == true)
        {
            for (int i = 0; i < joueurs.size(); i++)
            {
                Joueur joueurActuel = joueurs.get(i);
                if(joueurActuel.getPiocheJoueur().isEmpty()) {
                    throw new IllegalStateException("Plus de domino, ce n'est pas possible");
                 }else{
                	 
	                Domino dominoChoisis = joueurActuel.choisirDominoAposer(GaucheDeLaChaine, DroiteDeLaChaine);
	                //Si le joueur ne peut pas joueur
	                if (dominoChoisis == null){
	                	if(pioche.isEmpty() == true){
	                		perdants.add(joueurActuel);
	                	}
	                	else{
	                		Domino aPiocher = pioche.get(0);
	                		pioche.remove(0);
	                		joueurActuel.getPiocheJoueur().add(aPiocher);
	                	}
	                }else{ //Si on arrive là alors le joueur peut poser le domino choisi
	                		//Vérifier si le domino est dans la pioche du joueur
	                	if (joueurActuel.getPiocheJoueur().contains(dominoChoisis) == false){
	                		perdants.add(joueurActuel); //Si un joueur triche, on l'interdit de jouer
	                	}else{//Le joueur est en règle, on peut poser le domino
	                		while(tour == 1){
		                		//Cas de base, aucun domino n'est encore posé
		                		if (GaucheDeLaChaine==null || DroiteDeLaChaine==null){
		                    		GaucheDeLaChaine= dominoChoisis;
		                    		DroiteDeLaChaine=dominoChoisis;
		                    		joueurActuel.getPiocheJoueur().remove(dominoChoisis);
		                    		tour=0;
		                    		//Si le joueur n'a plus de domino après le premier coup
		                    		if (joueurActuel.getPiocheJoueur().size()== 0) {
		                    			perdants.add(joueurActuel);
		                    		}
		                    	}
		                    	else{
		                		//Vérifier si le domino choisi peut etre joué et le jouer le cas échéant
		                		if (dominoChoisis.getLeft() == DroiteDeLaChaine.getRight()) {
		                			DroiteDeLaChaine= dominoChoisis;
		                			joueurActuel.getPiocheJoueur().remove(dominoChoisis);
		                			tour=0;
		                			if (joueurActuel.getPiocheJoueur().size()== 0) {
		                    			System.out.println("Le gagnant est: "+joueurActuel.name);
		                    			return;
		                    		}
		                		}
		              		
		                		else if (dominoChoisis.getRight() == GaucheDeLaChaine.getLeft()){
		                				GaucheDeLaChaine = dominoChoisis;
		                				joueurActuel.getPiocheJoueur().remove(dominoChoisis);
		                				tour=0;
		                				if (joueurActuel.getPiocheJoueur().size()== 0) {
		                        			System.out.println("Le gagnant est: "+joueurActuel.name);
		                        			return;
		                        		}
		                			}
		                		
		                			else if (dominoChoisis.getRight() == DroiteDeLaChaine.getRight()) {
		                					dominoChoisis.rotate();
		                					DroiteDeLaChaine=dominoChoisis;
		                					joueurActuel.getPiocheJoueur().remove(dominoChoisis);
		                					tour=0;
		                					if (joueurActuel.getPiocheJoueur().size()== 0) {
		                            			System.out.println("Le gagnant est: "+joueurActuel.name);
		                            			return;
		                            		}
		                				}
		                			
		                				else if ( dominoChoisis.getLeft() == GaucheDeLaChaine.getLeft()) {
		                						dominoChoisis.rotate();
		                						GaucheDeLaChaine= dominoChoisis;
		                						joueurActuel.getPiocheJoueur().remove(dominoChoisis);
		                						tour=0;
		                						if (joueurActuel.getPiocheJoueur().size()== 0) {
		                                			System.out.println("Le gagnant est: "+joueurActuel.name);
		                                			return;
		                                		}
		                					}
		                		
		                		
		                				//Si le joueur arrive là alors il a fait une erreur de saisie
		                				else{
		                					tour=1;
		                					System.out.println("Le domino choisit ne peut être placé. Veuillez choisir un domino valide ou 0 pour piocher");
		                					dominoChoisis = joueurActuel.choisirDominoAposer(GaucheDeLaChaine, DroiteDeLaChaine);
		                				}
		                    	}
		                	}tour=1;
	                	}
	                }
	            }
            }
            //retirer de la liste des joueurs ceux ayant perdu au tour précédent
            for (int i = 0; i < perdants.size(); i++){ 
        		joueurs.remove(perdants.get(i));
        	}
            if (perdants.size() == totalJoueurs){
            	finPartie(perdants);
            	partiEnCours = false;
            }
        }
    }
    
    /**
     * Indique le gagnant d'une partie quand plus aucun joueur ne peut poser de domino.
     * @param perdants Liste des joueurs n'ayant pas pu poser de domino à un moment de la partie. 
     */
    private void  finPartie(ArrayList<Joueur> perdants){
    	int scoregagnant=168;//168 = 6*28 le nombre max possible si tous les dominos sont à (6,6) et que le joueur à une main de 28 cartes
    	Joueur gagnant= null; 
    	int score = 0;
    	for ( int i=0; i<perdants.size();i++) {
    		ArrayList<Domino> p = (perdants.get(i)).getPiocheJoueur();
    		for (int j=0; j<p.size();j++) {
    			score = score + p.get(j).getRight() + p.get(j).getLeft();
    		}
    		System.out.println("Joueur "+(i+1)+" a "+score+" points en main.");
    		if (scoregagnant > score) {
    			scoregagnant = score;
    			gagnant = perdants.get(i);							
    		}
    		score=0;
    	}
    	System.out.println("Le gagnant est: "+gagnant.name);
    }
}
