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
        System.out.print("Votre pseudo: ");
        String pseudoJoueur = sc.next(); // pseudo du joueur
        return pseudoJoueur;
    }

    public void introduction(String pseudoJoueur, Scanner sc) {
        System.out.println("\n"+
                           "-------------------------------------------------------------------------------------------------------------------\n"+
                           "| Bonjour "+pseudoJoueur+", Bienvenue sur java RPG.                                                                \n"+
                           "| Votre Objectif sera de réunir toutes les armes et artefacts disponible tout en tuant tout les monstres du jeux.  \n"+
                           "|                                                                                                                  \n"+
                           "| bonne chance !                                                                                                   \n"+
                           "-------------------------------------------------------------------------------------------------------------------\n");
        sc.nextLine(); // Entree texte à vide (non prise en compte car celui ci prend la saisi du pseudo du joueur)
        entreePourPasser(sc);
    }
    public char choixDirectionPossible(String directionPossible, Scanner sc) { // possibilité determiné grace au code DGHB
        System.out.println("\nVoici vos possibilités de déplacement:\n");
        if (directionPossible.charAt(0) == 'D') { // .charAt(int indice) permet de récuperer le caractère d'un String
            System.out.println("\t- Droite");
        }
        if (directionPossible.charAt(1) == 'G') {
            System.out.println("\t- Gauche");
        }
        if (directionPossible.charAt(2) == 'H') {
            System.out.println("\t- Haut");
        }
        if (directionPossible.charAt(3) == 'B') {
            System.out.println("\t- Bas");
        }
        char direction = '0'; // code 0 correspond à ne bouge pas
        boolean choixDirectionNonPris = true;
        while (choixDirectionNonPris) 
        {
            System.out.print("\nvotre choix = initiale de la direction (D/G/H/B):\n\n-> ");
            direction = sc.next().charAt(0);
            // première verification si la saisie prend la valeur D,G,H ou B
            if (direction == 'D' || direction == 'G' || direction == 'H' || direction == 'B') {
                // deuxième verification si la saisie correspond à un choix possible
                if (directionPossible.charAt(0) == direction || directionPossible.charAt(1) == direction || directionPossible.charAt(2) == direction || directionPossible.charAt(3) == direction) {
                    choixDirectionNonPris = false;
                    return direction;   
                }
                else {
                    choixIncorrect(sc); // si second teste passe pas
                }
            }
            else {
                choixIncorrect(sc); // si premier teste passe pas
            }
        }
    return direction;
    }

    public int menuEnPartie(Scanner sc) {
        System.out.println();
        System.out.println( "--------| MENU EN JEUX |--------\n\n"+
                            "-------------------------------|\n"+
                            "|-----<  continuer : 1   >-----|\n"+
                            "|-----<  inventaire : 2  >-----|\n"+
                            "|-----< changer arme : 3 >-----|\n"+
                            "|-----<   quitter : 4    >-----|\n"+
                            "--------------------------------\n\n");
        System.out.print("-> ");
        int choixMenuEnPartie = sc.nextInt();
        System.out.println();
        return choixMenuEnPartie;
    }

    public void contenuCoffre(Coffre coffre,Scanner sc) {
        System.out.println();
        System.out.println("------------------------------------------------------------\n"+
                           "Vous êtes sur une case coffre, voici son contenu:\n\n");
        System.out.println("              -| arme(s) dans le coffre |-                  \n");
        coffre.afficheArmesDansCoffre();
        System.out.println("\n           -| artefact(s) dans le coffre |-                \n");
        coffre.afficheArtefactDansCoffre();
        System.out.println("------------------------------------------------------------");
        sc.nextLine();
        this.entreePourPasser(sc);
    }

    public int menuInteractionCoffre(Scanner sc) {
        System.out.println();
        System.out.println( "------------| MENU COFFRE |------------\n\n"+
                            "--------------------------------------|\n"+
                            "|-----<   prendre arme(s) : 1   >-----|\n"+
                            "|-----< prendre artefact(s) : 2 >-----|\n"+
                            "|-----<     tout prendre : 3    >-----|\n"+
                            "|-----<   ne rien prendre : 4   >-----|\n"+
                            "---------------------------------------\n\n");
        System.out.print("-> ");
        int choixMenuCoffre = sc.nextInt();
        System.out.println();
        return choixMenuCoffre;
    }

    public void affichageInventaireArme(Scanner sc ,Hero hero) {
        System.out.println( "\n------------| Inventaire Arme |------------\n");
        System.out.println( "                -| Equipé |-                \n");
        System.out.print("\t- ");
        System.out.println(hero.getArme().GetNomArme());
        System.out.println( "\n               -| Inventaire |-            \n");
        if (hero.getInventaireArmes().size() == 0) {
            System.out.print("\t- ");
            System.out.println("Aucun");
        }
        else {
            for (int indexArme = 0; indexArme < hero.getInventaireArmes().size(); indexArme++) {
                System.out.print("\t- ");
                System.out.println(hero.getInventaireArmes().get(indexArme).GetNomArme());
            }
        }
        System.out.println();
    }

    public void affichageInventaireArtefact(Scanner sc ,Hero hero) {
        System.out.println( "\n------------| Inventaire Artefact |------------\n");
        System.out.println( "               -| Inventaire |-              \n");
        if (hero.getInventaireArtefacts().size() == 0) {
            System.out.print("\t- ");
            System.out.println("Aucun");
        }
        else {
            for (int indexArme = 0; indexArme < hero.getInventaireArtefacts().size(); indexArme++) {
                System.out.print("\t- ");
                System.out.println(hero.getInventaireArtefacts().get(indexArme).getNomArtefact());
            }
        }
        System.out.println();
    }

    public void affichageInventaireGlobal(Scanner sc, Hero hero) {
        System.out.println("\n===============| INVENTAIRE GLOBAL |===============\n");
        affichageInventaireArme(sc, hero);
        affichageInventaireArtefact(sc, hero);
        System.out.println("\n===================================================\n");
    }

    public void changerArmeEquipeHero(Scanner sc, Hero hero) {
        System.out.println("\n===============| CHANGER D'ARME |===============\n");
        if (hero.getInventaireArmes().size() == 0) {
            System.out.println("\n\t-| Aucune Arme disponible |-\n");
        }
        else {
            for (int indexArme = 0; indexArme < hero.getInventaireArmes().size(); indexArme++) {
                System.out.print(indexArme+"\t- ");
                System.out.println(hero.getInventaireArmes().get(indexArme).GetNomArme());
            }
            System.out.print("\nchoix en fonction du numéro:\n\n-> ");
            int choixChangementArme= sc.nextInt();
            if (choixChangementArme >= 0 && choixChangementArme <= hero.getInventaireArmes().size()) // permet de verifier que le choix est correct
        {
            hero.changementArme(choixChangementArme);
            System.out.println("\nchangement d'arme: "+hero.getInventaireArmes().get(choixChangementArme).GetNomArme()+" -> "+hero.getArme().GetNomArme());
        }
        }
        System.out.println("\n=================================================\n");
        sc.nextLine();
        entreePourPasser(sc);
    }

    public void introCombat(Monstre monstre, Hero hero, Scanner sc) {
        System.out.println("\n===============| ATTENTION |===============\n\n"+
                           "Attention "+hero.getNomHero()+ "!\n"+
                           "Vous entrez dans une zone de combat avec un "+monstre.getNomMonstre()+
                           "\nPreparez vous au combat jeune Hero!\n");
        System.out.println("\n===========================================\n");
        sc.nextLine();
        entreePourPasser(sc);
    }

}