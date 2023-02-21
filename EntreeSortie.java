import java.util.Scanner;

public class EntreeSortie {
    
    public void titre() // affichage du titre
    {
        System.out.println("\n|====================================|\n"+
                           "|=====| Bienvenue sur Java RPG |=====|\n"+
                           "|====================================|\n\n");
    }

    public int menuPrincipal(Scanner sc) // affichage menu principal + choix utilisateur
    {
        System.out.println();
        System.out.println( "======| Menu Principal |======\n\n"+
                            "-----------------------------\n"+
                            "|-----|   JOUER : 1   |-----|\n"+
                            "|-----| PARAMETRE : 2 |-----|\n"+
                            "|-----|   CREDIT : 3  |-----|\n"+
                            "|-----|  QUITTER : 4  |-----|\n"+
                            "-----------------------------\n\n");
        System.out.print("-> ");
        int choixMenuPrincipal = sc.nextInt();
        System.out.println();
        return choixMenuPrincipal;
    }

    public String InitalisationPartie(Scanner sc) {

        System.out.println();
        System.out.println("======| Partie |======\n");
        System.out.print("Votre speudo: ");
        String pseudoJoueur = sc.next();
        System.out.println("\n"+
                           "-----------------------------"+
                           "\nBonjour "+pseudoJoueur+", Bienvenue sur java RPG.\n"+
                           "Votre Objectif sera de réunir toutes les armes et artefacts disponible tout en tuant tout les monstres du jeux."+
                           "\n\n"+pseudoJoueur+" bonne chance !"+
                           "\n-----------------------------");
        return pseudoJoueur;
    }

}