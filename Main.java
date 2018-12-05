package projetDomino;

import java.util.Scanner;

/**
	*La classe Main est la classe de lancement du jeu.
	*<p>
	*Elle demande de selectionner via le clavier le nombre de joueur console,<p>
	*Génère aléatoirement un nombre de joueur automatique (tel que le nombre total de joueur
	*soit entre 2 et 4 inclus), <p>Crée un gestionnaire
	*et demande au gestionnaire de lancer le jeu.
	*@see Gestionnaire
	*@author Hind Dadoun
 */
public class Main {

	public static void main(String[] args) {
    	
        System.out.println("Veuillez entrer le nombre de joueur utilisateur :");
        Scanner scanner = new Scanner(System.in);
        int nombreJoueursUtilisateurs = scanner.nextInt();
        
        
        
        //Demande du nombre de joueurs console
        while (nombreJoueursUtilisateurs < 1 || nombreJoueursUtilisateurs > 4)
        {
        	System.out.println("Veuillez entrer le nombre de joueur utilisateur (compris entre 1 et 4) :");
            nombreJoueursUtilisateurs = scanner.nextInt();
        }
        
      //Choix aléatoire du nombre de joueurs automatiques.
        
        int nombreJoueursAutomatiques = (int)(Math.random() * (4-nombreJoueursUtilisateurs));
        while (nombreJoueursAutomatiques + nombreJoueursUtilisateurs == 1) // Le nombre total de joueurs doit etre supérieur à 1
        {
        	nombreJoueursAutomatiques = (int)(Math.random() * (4-nombreJoueursUtilisateurs));
        }
        
        Gestionnaire gestionnaire = new Gestionnaire(nombreJoueursUtilisateurs, nombreJoueursAutomatiques);
        gestionnaire.jeu();
    }

}