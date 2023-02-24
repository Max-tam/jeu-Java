import java.util.Scanner;

public class Partie {

    private boolean partieEnCours;
    private boolean aGagne;
    private boolean aPerdu;

/*=========================| Constructeur |=========================*/

    public Partie() { // constructeur
        this.partieEnCours = true;
        this.aGagne = false;
        this.aPerdu = false;
    }

/*=========================| Get / Set |=========================*/

    public boolean getEtatPartie() { // recupere l'état de la partie (true pour en cours / false pour fini)
        return partieEnCours;
    }

    public void setEtatPartie(boolean etatPartie) { // permet de modifier l'état de la Partie
        this.partieEnCours = etatPartie;
    }
    
    public boolean getAGagne() { // savoir si le joueur a gagne
        return aGagne;
    }

    public void setAGagne(boolean aGagne) { // permet de changer l'état de si le joueur à gagné
        this.aGagne = aGagne;
    }

    public boolean getAPerdu() { // savoir si joueur à perdu
        return aPerdu;
    }

    public void setAPerdu(boolean aPerdu) { // permet de changer l'état de si le joueur à perdu
        this.aPerdu = aPerdu;
    }

/*=========================| Fonction / Procedure |=========================*/

    public void gestionMenuPrincipal(Scanner sc, EntreeSortie entreeSortie) { // Gestion du Menu Principal

        while (partieEnCours) {

            //affichage titre du jeu
            entreeSortie.titre();
            int choixMenuPrincipal = entreeSortie.menuPrincipal(sc);
            switch (choixMenuPrincipal) {
                case 1:
                    // Lancer l'initialisation du jeu
                    initialisationEtPartie(sc, entreeSortie);
                    break;
                case 2:
                    System.out.println("**Parametre**");
                    // Lancer Menu Parametre
                    break;
                case 3:
                    System.out.println("**Credit**");
                    // Lancer Credit
                    break;
                case 4:
                    // on quitte la partie en mettant en false la boucle
                    this.partieEnCours = false;
                    break;
                default:
                    entreeSortie.choixIncorrect(sc);
                    break;
            }
        }
    }

    public void initialisationEtPartie(Scanner sc, EntreeSortie entreeSortie) { // Initialisation + gestion de la partie

        // ==========| INITIALISATION |==========

        // Initialisation Effet
        Effet effetDefense = new Effet("defense renforcé");
        Effet effetAttaque = new Effet("attaque accrue");
        Effet effetVie = new Effet("vie accrue");

        // Initialisation Arme
        Arme armeMain = new Arme("main nue",5);
        Arme armeArc = new Arme("arc", 10);

        // Initialisation Artefact

        Artefact artefactDefense = new Artefact(effetDefense,"artefact de defense");
        Artefact artefactVie = new Artefact(effetVie, "artefact de vie");
        Artefact artefactAttaque = new Artefact(effetAttaque, "artefact d'attaque");

        // Initialisation Potion
        Potion potionVie = new Potion(effetVie, "potion de gain de vie", 1);
        Potion potionDefense = new Potion(effetDefense, "potion de gain de defense",3);
        Potion potionAttaque = new Potion(effetAttaque, "potion de gain d'attaque",3);

        // Initialisation Coffre

        Artefact [] listeArtefactCoffre1 = {artefactAttaque};
        Arme [] listeArmeCoffre1 = {armeArc};

        Coffre coffre1 = new Coffre(listeArtefactCoffre1, listeArmeCoffre1, 1, 0);

        // Initialisation Joueur
        String pseudoJoueur = entreeSortie.InitalisationPartie(sc);
        Hero hero = new Hero(4,0,100,armeMain,0,pseudoJoueur);

        // Initialisation Carte
        char [][] carte = {{'0','0','0','0','0'},
                           {'0','0','0','0','0'},
                           {'0','0','0','0','0'},
                           {'0','0','0','0','0'},
                           {'0','0','0','0','0'}};

        Donjon Donjon1 = new Donjon(carte);
        
        // Initialisation Monstre
        Monstre zombie = new Monstre("zombie", 2, 2, 50, armeMain, 0);
        Monstre squelette = new Monstre("squelette", 3, 3, 75, armeArc, 0);

        //==========| PENDANT PARTIE |==========

        // procedure introduction du jeu (but)
        entreeSortie.introduction(pseudoJoueur, sc);

        // procedure lancement menu de partie
        boolean menuPartie = true;
        
        //while (menuPartie) {
            
        //}
        Donjon1.getCarte(); // affiche la carte sans modification
        Donjon1.metAJourCarte(hero); // met à jour la carte avec la position du joueur
        Donjon1.getCarte(); // affiche la carte avec la position du joueur
        String directionPossibleHero = hero.directionPossible(Donjon1); // assigne les 4 caractères dans un String qui determines la direction possible
        System.out.println(directionPossibleHero); // affiche la suite des 4 caractères.
        char result = entreeSortie.choixDirectionPossible(directionPossibleHero,sc);
        System.out.println(result);
        /* 
         * - affichage de la map avec position du joueur (0)
         * - joueur peut se déplacer sans sortir de la map (x)
         * - affichage de la map met à jour la position du joueur à chaque fois (0)
         */

    }

}