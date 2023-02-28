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
        System.out.println( "==| Choix non correct |==\n"+
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

    public void attaqueSurMonstre(Monstre monstre, Hero hero, Scanner sc, int degat) {
        System.out.println("\n----------| Tour de "+hero.getNomHero()+" |----------\n\n"+
                           hero.getNomHero()+" fait "+degat+" de dégât à "+ monstre.getNomMonstre()+
                           "\n\nPv restant à "+ monstre.getNomMonstre()+": "+monstre.getPV()+
                           "\n--------------------------------------------------");

    }

    public void attaqueSurHero(Monstre monstre, Hero hero, Scanner sc, int degat) {
        System.out.println("\n----------| Tour de "+monstre.getNomMonstre()+" |----------\n\n"+
                           monstre.getNomMonstre()+" fait "+degat+" de dégât à "+ hero.getNomHero()+
                           "\n\nPv restant à "+ hero.getNomHero()+": "+hero.getPV()+
                           "\n--------------------------------------------------");
        sc.nextLine();
        entreePourPasser(sc);

    }

    public int menuCombat(Scanner sc) {
        System.out.println();
        System.out.println( "--------| MENU COMBAT |--------\n\n"+
                            "------------------------------|\n"+
                            "|-----< menu potion : 1 >-----|\n"+
                            "|-----<  attaquer : 2   >-----|\n"+
                            "|-----<    fuire : 3    >-----|\n"+
                            "-------------------------------\n\n");
        System.out.print("-> ");
        int choixMenuCombat = sc.nextInt();
        System.out.println();
        return choixMenuCombat;
    }

    public int menuPotion(Scanner sc, Hero hero) {
        System.out.println();
        System.out.println( "------------------------| MENU POTION |-----------------------\n\n"+
                            "-------------------------------------------------------------|\n"+
                            "|-----< potion de vie : 1 (il vous reste "+hero.getInventairePotions().get(2).getNombreDePotion()+" Potion(s) ) >-----|\n"+
                            "|----< potion de bouclier : 2 (il vous reste "+hero.getInventairePotions().get(1).getNombreDePotion()+" Potion ) >----|\n"+
                            "|-----< potion d'attaque : 3 (il vous reste "+hero.getInventairePotions().get(0).getNombreDePotion()+" Potion ) >-----|\n"+
                            "|---------------------< quitter Menu : 4 >-------------------|\n"+
                            "--------------------------------------------------------------\n\n");
        System.out.print("-> ");
        int choixMenuCombat = sc.nextInt();
        System.out.println();
        return choixMenuCombat;
    }

    public void donneeJoueurEtMonstre(Hero hero, Monstre monstre, Scanner sc) {
        System.out.println("\n===============| DONNEE JOUEUR / MONSTRE |===============\n\n"+
                           "\t-----| STAT JOUEUR |-----\n\n"+
                           "PV: "+ hero.getPV()+
                           "\nArme: "+hero.getArme().GetNomArme()+
                           "\ndégât: "+hero.getArme().getDegat()+
                           "\nDefense: "+hero.getDefense()+
                           "\nVelocité: "+hero.getVelocite()+
                           "\n\n\t-----| STAT MONSTRE |-----\n\n"+
                           "nom: "+monstre.getNomMonstre()+
                           "\nPV: "+monstre.getPV()+
                           "\nArme: "+monstre.getArme().GetNomArme()+
                           "\ndégât: "+monstre.getArme().getDegat()+
                           "\nDefense: "+monstre.getDefense()+
                           "\nVelocité: "+monstre.getVelocite());
        System.out.println("\n\n===========================================\n");
        entreePourPasser(sc);
    }
}