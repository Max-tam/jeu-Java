public class Hero extends Entite {

    private String nomHero;
    private Arme [] inventaireArmes;
    private Potion [] inventairePotions;

    /*=========================| Constructeur |=========================*/

    public Hero(int posY,int posX, int PV, Arme Arme, int defense, String nomHero)  // constructeur de la class Hero
    {
        super(posY, posX, PV, Arme, defense);
        this.nomHero = nomHero;
    }

    /*=========================| Get / Set |=========================*/

    public Potion[] getInventairePotions() {
        return inventairePotions;
    }

    public void setInventairePotions(Potion[] inventairePotions) {
        this.inventairePotions = inventairePotions;
    }

    public Arme[] getInventaireArmes() // recuperer l'inventaire d'arme
    {
        return inventaireArmes;
    }

    public void setInventaireArmes(Arme[] inventaireArmes) // l'inventaire d'arme
    {
        this.inventaireArmes = inventaireArmes;
    }

    public String getNomHero() // recuperer le nom du hero
    {
        return nomHero;
    }

    public void setNomHero(String nomHero) // definir nom du hero
    {
        this.nomHero = nomHero;
    }

/*=========================| Fonction / Procedure |=========================*/

    public String directionPossible(Donjon carte) {
        String directionPossible; // ordre DGHB (droite / Gauche / Haut / Bas), prend la valeur 0 si pas possible
        
        // Regarde si le bloc à droite et possible
        if (this.GetPosXHero() < carte.getTailleX()-1) { // D pour Droite
            directionPossible = "D";            
        }
        else {
            directionPossible = "0";
        }

        // Regarde si le bloc à gauche est possible
        if (this.GetPosXHero() > 0) {
            directionPossible = directionPossible + "G";
        }
        else {
            directionPossible = directionPossible + "0";
        }

        // Regarde si le bloc en Haut est possible
        if (this.GetPosYHero() > 0) {
            directionPossible = directionPossible + "H";
        } 
        else {
            directionPossible = directionPossible + "0";
        }

        // Regarde si le bloc en Bas est possible
        if (this.GetPosYHero() < carte.getTailleY()-1 ) {
            directionPossible = directionPossible + "B";
        }
        else {
            directionPossible = directionPossible + "0";
        }
        return directionPossible;
    }
}
