import java.util.Scanner;

public class Combat {

    private boolean nePrendPasLaFuite;
    private int bonusAttaqueJoueur;
    private int nombreTourAvecBonusAttaque;
    private int nombreTourAvecBonusDefense;

    public int gestionCombat(Monstre monstre,Hero hero, Scanner sc, EntreeSortie entreeSortie) { // Si monstre plus rapide que le joueur
        entreeSortie.donneeJoueurEtMonstre(hero, monstre, sc);
        if (monstre.getVelocite() > hero.getVelocite()) {
            System.out.println(monstre.getNomMonstre()+" commence à attaquer car il a un une velocité supérieur à "+hero.getNomHero());
            //tour du monstre avant le joueur
            tourCombatMonstre(monstre, hero, entreeSortie, sc);
        }

        else { // si monstre plus lent que le joueur
            System.out.println(hero.getNomHero()+" commence à attaquer car il a un une velocité supérieur à "+monstre.getNomMonstre());
        }
        this.nePrendPasLaFuite = true;
        while (hero.getPV() > 0 && monstre.getPV() > 0 && this.nePrendPasLaFuite) {
            tourCombatHero(monstre, hero, entreeSortie, sc);
            tourCombatMonstre(monstre, hero, entreeSortie, sc);
            // gestion des 3 tours avec bonus attaque
            if (this.bonusAttaqueJoueur > 0) {
                ++this.nombreTourAvecBonusAttaque;
                if (this.nombreTourAvecBonusAttaque%4 == 0) {
                    this.bonusAttaqueJoueur = 0;
                }
            }
            // gestion des 3 tours avec bonus de defense
            if (hero.getDefense() > 0) {
                ++this.nombreTourAvecBonusDefense;
                if (this.nombreTourAvecBonusDefense%4 == 0) {
                    hero.setDefense(0);
                }
            }
            for (int indexEffetArtefact = 0; indexEffetArtefact < hero.getInventaireArtefacts().size(); indexEffetArtefact++) {
                if (hero.getInventaireArtefacts().get(indexEffetArtefact).getNomEffet().getEffet().equals("vie accrue")) {
                    hero.setPV(hero.getPV()+5);
                    if (hero.getPV() > 100) {
                        hero.setPV(100);
                    }
                    System.out.println("\n Régénération de 5 PV grace à l'aterfact de vie");
                }
              
            }
        }
        if (!nePrendPasLaFuite) {
            System.out.println("\n==========| VOUS AVEZ PRIS LA FUITE |==========\n");
            entreeSortie.entreePourPasser(sc);
            return 0; // fuite sans conséquence
        }
        else if (hero.getPV() == 0) {
            System.out.println("\n==========| VOUS AVEZ PERDU |==========\n");
            entreeSortie.entreePourPasser(sc);
            return 1; // code perdu
        }
        else if (monstre.getPV() == 0) {
            System.out.println("\n==========| VOUS AVEZ GAGNE |==========\n");
            entreeSortie.entreePourPasser(sc);
            hero.setExperience(hero.getExperience()+1);
            monstre.setEstMort(true);
            return 2; // code gagné
        }
        this.nePrendPasLaFuite = true;
        return -1; // code erreur
    }
    public int calculDefenseHero(Hero hero) {
        for (int indexEffetArtefact = 0; indexEffetArtefact < hero.getInventaireArtefacts().size(); indexEffetArtefact++) {
            if (hero.getInventaireArtefacts().get(indexEffetArtefact).getNomEffet().getEffet().equals("defense renforcé")) {
                return hero.getDefense() + 10;
            }
        }
        return hero.getDefense();
    }

    public int calculAttaqueHero(Hero hero) {
        for (int indexEffetArtefact = 0; indexEffetArtefact < hero.getInventaireArtefacts().size(); indexEffetArtefact++) {
            if (hero.getInventaireArtefacts().get(indexEffetArtefact).getNomEffet().getEffet().equals("attaque accrue")) {
                return hero.getArme().getDegat() + 10;
            }
            System.out.println("\n\nTESTE: "+hero.getInventaireArtefacts().get(indexEffetArtefact).getNomEffet());
        }
        return hero.getArme().getDegat();
    }

    public int calculDegatARetirerMonstre(Monstre monstre, Hero hero) {
        int degat = calculAttaqueHero(hero) + this.bonusAttaqueJoueur - monstre.getDefense();
        if (degat > 0) { 
            return degat;
        }
        else {
            return 0;
        }
    }

    public int calculDegatARetirerHero(Monstre monstre, Hero hero) {
        int degat = monstre.getArme().getDegat() - calculDefenseHero(hero);
        if (degat > 0) { 
            return degat;
        }
        else {
            return 0;
        }
    }

    public void retireVieHero(Hero hero,int degat) {
        hero.setPV(hero.getPV()-degat);
        if (hero.getPV() < 0) {
            hero.setPV(0);
        }
    }

    public void retireVieMonstre(Monstre monstre,int degat) {
        monstre.setPV(monstre.getPV()-degat);
        if (monstre.getPV() < 0) {
            monstre.setPV(0);
        }
    }

    public void tourCombatMonstre(Monstre monstre, Hero hero, EntreeSortie entreeSortie , Scanner sc) {
        int degat = calculDegatARetirerHero(monstre, hero);
        retireVieHero(hero, degat);
        entreeSortie.attaqueSurHero(monstre, hero, sc, degat);
    }

    public void tourCombatHero(Monstre monstre, Hero hero, EntreeSortie entreeSortie , Scanner sc) {
        int choixMenuCombatJoueur = entreeSortie.menuCombat(sc);
        if (choixMenuCombatJoueur == 1) {
            int choixMenuPotion = entreeSortie.menuPotion(sc, hero);
            if (choixMenuPotion == 1) { // potion de gain de vie
                if (hero.getInventairePotions().get(2).getNombreDePotion() > 0) {
                    hero.setPV(hero.getPV()+20);
                    if (hero.getPV() > 100) {
                        hero.setPV(100);
                    }
                    hero.getInventairePotions().get(2).setNombreDePotion(hero.getInventairePotions().get(2).getNombreDePotion()-1);
                }
                else {
                    sc.nextLine();
                    entreeSortie.choixIncorrect(sc);
                }
            }
            else if (choixMenuPotion == 2) { // potion de bouclier (faire en sorte que l'effet se dissipe après 3 tours)
                if (hero.getInventairePotions().get(1).getNombreDePotion() > 0) {
                    hero.setDefense(hero.getDefense()+20);
                    hero.getInventairePotions().get(1).setNombreDePotion(hero.getInventairePotions().get(1).getNombreDePotion()-1);
                }
                else {
                    sc.nextLine();
                    entreeSortie.choixIncorrect(sc);
                }
            }
            else if (choixMenuPotion == 3) { // potion d'attaque (faire en sorte que l'effet se dissipe après 3 tours)
                if (hero.getInventairePotions().get(0).getNombreDePotion() > 0) {
                    this.bonusAttaqueJoueur = 20;
                    hero.getInventairePotions().get(0).setNombreDePotion(hero.getInventairePotions().get(0).getNombreDePotion()-1);
                }
                else {
                    sc.nextLine();
                    entreeSortie.choixIncorrect(sc);
                }
            }
        }
        else if (choixMenuCombatJoueur == 2) {
            int degat = calculDegatARetirerMonstre(monstre, hero);
            retireVieMonstre(monstre, degat);
            entreeSortie.attaqueSurMonstre(monstre, hero, sc, degat);
        }
        else if (choixMenuCombatJoueur == 3) {
            this.nePrendPasLaFuite = false;
        }   
    }
}