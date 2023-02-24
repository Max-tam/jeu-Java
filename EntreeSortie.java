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

    public void entreePourPasser(Scanner sc) { // procedure qui met en place la fonctionnalité appuyer sur entrée pour aller à la suite
        System.out.println("\nAppuyer sur Entree pour continuer");
        sc.nextLine(); // Entree bloquant jusqu'à ce que l'on saute de ligne.
    }

    public void choixIncorrect(Scanner sc) {
        System.out.println( "==| Choix non correct |=="+
                            "\nAppuyer sur Entree pour refaire un choix");
        sc.nextLine(); // Entree bloquant jusqu'à ce que l'on saute de ligne.
    } 

    public String InitalisationPartie(Scanner sc) {

        System.out.println();
        System.out.println("======| Partie |======\n");
        System.out.print("Votre speudo: ");
        String pseudoJoueur = sc.next(); // pseudo du joueur
        return pseudoJoueur;
    }

    public void introduction(String pseudoJoueur, Scanner sc) {
        System.out.println("\n"+
                           "-----------------------------"+
                           "\nBonjour "+pseudoJoueur+", Bienvenue sur java RPG.\n"+
                           "Votre Objectif sera de réunir toutes les armes et artefacts disponible tout en tuant tout les monstres du jeux."+
                           "\n\nbonne chance !"+
                           "\n-----------------------------\n");
        sc.nextLine(); // Entree texte à vide (non prise en compte car celui ci prend la saisi du pseudo du joueur)
        entreePourPasser(sc);
    }
    public char choixDirectionPossible(String directionPossible, Scanner sc) { // possibilité determiné grace au code DGHB
        System.out.println("\nVoici vos possibilités de déplacement:\n");
        if (directionPossible.charAt(0) == 'D') { // .charAt(int indice) permet de récuperer le caractère d'un String
            System.out.println("\n\t- Droite");
        }
        if (directionPossible.charAt(1) == 'G') {
            System.out.println("\n\t- Gauche");
        }
        if (directionPossible.charAt(2) == 'H') {
            System.out.println("\n\t- Haut");
        }
        if (directionPossible.charAt(3) == 'B') {
            System.out.println("\n\t- Bas");
        }
        char direction = '0';
        boolean choixDirectionNonPris = true;
        while (choixDirectionNonPris) 
        {
            System.out.print("\nvotre choix (initiale de la direction:\n\n-> ");
            direction = sc.next().charAt(0);
            // première verification si la saisie prend la valeur D,G,H ou B
            if (direction == 'D' || direction == 'G' || direction == 'H' || direction == 'B') {
                // deuxième verification si la saisie correspon à un choix possible
                if (directionPossible.charAt(0) == direction || directionPossible.charAt(1) == direction || directionPossible.charAt(2) == direction || directionPossible.charAt(3) == direction) {
                    choixDirectionNonPris = false;
                    entreePourPasser(sc);
                    return direction;   
                }
                else {
                    choixIncorrect(sc);
                }
            }
            else {
                choixIncorrect(sc);
            }
        }
    return direction;
    }
}