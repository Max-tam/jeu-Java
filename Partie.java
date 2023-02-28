import java.util.ArrayList;
import java.util.List;
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

        entreeSortie.titre();
        while (partieEnCours) {

            //affichage titre du jeu
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
        Arme armeEpee = new Arme("épee",20);

        // Initialisation Artefact

        Artefact artefactDefense = new Artefact(effetDefense,"artefact de defense");
        Artefact artefactVie = new Artefact(effetVie, "artefact de vie");
        Artefact artefactAttaque = new Artefact(effetAttaque, "artefact d'attaque");

        // Initialisation Potion
        Potion potionVie = new Potion(effetVie, "potion de gain de vie", 1,3);
        Potion potionDefense = new Potion(effetDefense, "potion de gain de defense",3,1);
        Potion potionAttaque = new Potion(effetAttaque, "potion de gain d'attaque",3,1);

        // Initialisation Coffre - 1
        
        List<Artefact> listeArtefactCoffre1 = new ArrayList<Artefact>();
        listeArtefactCoffre1.add(artefactAttaque);
        listeArtefactCoffre1.add(artefactDefense);
        
        List<Arme> listeArmeCoffre1 = new ArrayList<Arme>();
        listeArmeCoffre1.add(armeArc);

        Coffre coffre1 = new Coffre(listeArtefactCoffre1, listeArmeCoffre1, 1, 0);

        // Initialisation Coffre - 2

        List<Artefact> listeArtefactCoffre2 = new ArrayList<Artefact>();
        listeArtefactCoffre2.add(artefactVie);
        
        List<Arme> listeArmeCoffre2 = new ArrayList<Arme>();
        listeArmeCoffre2.add(armeEpee);

        Coffre coffre2 = new Coffre(listeArtefactCoffre2,listeArmeCoffre2, 4,2);

        // Initialisation Joueur
        String pseudoJoueur = entreeSortie.InitalisationPartie(sc);
        Hero hero = new Hero(4,0,100,armeMain,0,pseudoJoueur);

        List<Potion> listePotionHero = new ArrayList<Potion>();
        listePotionHero.add(potionAttaque);
        listePotionHero.add(potionDefense);
        listePotionHero.add(potionVie);

        hero.setInventairePotions(listePotionHero);

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

        // procedure lancement partie
        boolean Partie = true;
        int nombreDeTours = 0;
        
        while (Partie) {
            // gestion affichage de la carte
            System.out.println("Voici votre position sur la carte:");
            Donjon1.metAJourCarte(hero,coffre1,coffre2,zombie,squelette); // met à jour la carte avec la position du joueur
            Donjon1.getCarte(); // affiche la carte avec la position du joueur
            System.out.println("\nVous pouvez identifier votre position avec le symbole X, les cases C sont des coffres et les case 0 sont des cases vides");

            // gestion mouvement du joueur
            String directionPossibleHero = hero.directionPossible(Donjon1); // assigne les 4 caractères dans un String qui determines la direction possible
            char choixDirectionUtilisateur = entreeSortie.choixDirectionPossible(directionPossibleHero,sc); // choix des direction possible
            hero.changementDePositionJoueur(choixDirectionUtilisateur); // change les coordonnées du joueur

            // gestion interaction coffre 1
            boolean estSurLeCoffre1 = hero.estSurUnCoffre(coffre1); // si joueur su le coffre
            if (estSurLeCoffre1) {
                entreeSortie.contenuCoffre(coffre1,sc); // affichage contenue coffre
                int reponseMenuCoffre = entreeSortie.menuInteractionCoffre(sc); // réponse au menu du coffre

                if (reponseMenuCoffre == 1) {  // transfert les armes dans l'inventaire du joueur
                    hero.transfertArmeDansInventaire(coffre1.getArmesDansCoffre());
                    entreeSortie.affichageInventaireArme(sc, hero);
                    sc.nextLine();
                    entreeSortie.entreePourPasser(sc);
                }
                if (reponseMenuCoffre == 2) { // transfert les artefacts dans l'inventaire du joueur
                    hero.transfertArtefactDansInventaire(coffre1.getArtefactsDansCoffre());
                    entreeSortie.affichageInventaireArtefact(sc, hero);
                    sc.nextLine();
                    entreeSortie.entreePourPasser(sc);     
                }
                if (reponseMenuCoffre == 3) { // transfert les artefacts et les armes dans l'inventaire du joueur 
                    hero.transfertArtefactDansInventaire(coffre1.getArtefactsDansCoffre());
                    hero.transfertArmeDansInventaire(coffre1.getArmesDansCoffre());
                    entreeSortie.affichageInventaireGlobal(sc, hero);
                    sc.nextLine();
                    entreeSortie.entreePourPasser(sc);
                }
            }

            // gestion interaction coffre 2
            boolean estSurLeCoffre2 = hero.estSurUnCoffre(coffre2); // si joueur su le coffre
            if (estSurLeCoffre2) {
                entreeSortie.contenuCoffre(coffre2,sc); // affichage contenue coffre
                int reponseMenuCoffre = entreeSortie.menuInteractionCoffre(sc); // réponse au menu du coffre

                if (reponseMenuCoffre == 1) {  // transfert les armes dans l'inventaire du joueur
                    hero.transfertArmeDansInventaire(coffre2.getArmesDansCoffre());
                    entreeSortie.affichageInventaireArme(sc, hero);
                    sc.nextLine();
                    entreeSortie.entreePourPasser(sc);
                }
                if (reponseMenuCoffre == 2) { // transfert les artefacts dans l'inventaire du joueur
                    hero.transfertArtefactDansInventaire(coffre2.getArtefactsDansCoffre());
                    entreeSortie.affichageInventaireArtefact(sc, hero);
                    sc.nextLine();
                    entreeSortie.entreePourPasser(sc);     
                }
                if (reponseMenuCoffre == 3) { // transfert les artefacts et les armes dans l'inventaire du joueur 
                    hero.transfertArtefactDansInventaire(coffre2.getArtefactsDansCoffre());
                    hero.transfertArmeDansInventaire(coffre2.getArmesDansCoffre());
                    entreeSortie.affichageInventaireGlobal(sc, hero);
                    sc.nextLine();
                    entreeSortie.entreePourPasser(sc);
                }
            }

            // gestion Monstre Zombie
            boolean estSurMonstreZombie = hero.estSurUnMonstre(zombie);
            if (estSurMonstreZombie) {
                //introduction au combat
                entreeSortie.introCombat(zombie, hero, sc);
                //lancement combat
            }


            // gestion menu en jeux
            if (nombreDeTours % 5 == 0) { // permet de ne pas avoir le menu d'affiché à tout les tours (ici tout les 5 tours)
                int choixMenuEnPartie = entreeSortie.menuEnPartie(sc);
                if (choixMenuEnPartie == 4) { // si le joueur demande à quitter
                    Partie = false;    
                }
                else if (choixMenuEnPartie == 2) { // si le joueur veut voir son inventaire
                    entreeSortie.affichageInventaireGlobal(sc, hero);
                    sc.nextLine();
                    entreeSortie.entreePourPasser(sc);
                }
                else if (choixMenuEnPartie == 3) {
                    entreeSortie.changerArmeEquipeHero(sc, hero);
                }
                else if (choixMenuEnPartie != 1) { // si le joueur ne demande pas à continuer non plus
                    entreeSortie.choixIncorrect(sc);
                }
            }
            ++nombreDeTours;
        }

    }

}