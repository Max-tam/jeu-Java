import java.util.ArrayList;
import java.util.List;

public class Hero extends Entite {

    private String nomHero;
    private List<Arme> inventaireArmes = new ArrayList<Arme>();
    private List<Potion> inventairePotions = new ArrayList<Potion>();
    private List<Artefact> inventaireArtefacts = new ArrayList<Artefact>();

    /*=========================| Constructeur |=========================*/

    public Hero(int posY,int posX, int PV, Arme Arme, int defense, String nomHero)  // constructeur de la class Hero
    {
        super(posY, posX, PV, Arme, defense);
        this.nomHero = nomHero;
    }

    /*=========================| Get / Set |=========================*/

    public List<Arme> getInventaireArmes() {
        return inventaireArmes;
    }

    public void setInventaireArmes(List<Arme> inventaireArmes) {
        this.inventaireArmes = inventaireArmes;
    }

    public void setInventairePotions(List<Potion> inventairePotions) {
        this.inventairePotions = inventairePotions;
    }

    public List<Potion> getInventairePotions() {
        return inventairePotions;
    }

    public void setInventaireArtefacts(List<Artefact> inventaireArtefacts) {
        this.inventaireArtefacts = inventaireArtefacts;
    }

    public List<Artefact> getInventaireArtefacts() {
        return inventaireArtefacts;
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

    public String directionPossible(Donjon carte) { // permet de déterminer les directions que peut prendre
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

    public boolean estSurUnCoffre(Coffre coffre) { // permet de determiner si le joueur est sur une case coffre
        if (this.GetPosXHero() == coffre.getPosX() && this.GetPosYHero() == coffre.getPosY()) {
            return true;
        }
        else { return false; }
    }

    public void changementDePositionJoueur(char directionPrise) {
        // si direction retourné est droite (D)
        if (directionPrise == 'D') {
            this.SetPosXHero(this.GetPosXHero()+1);
        }
        // si direction retourné est gauche (G)
        if (directionPrise == 'G') {
            this.SetPosXHero(this.GetPosXHero()-1);
        }
        // si direction retourné est haut (H)
        if (directionPrise == 'H') {
            this.SetPosYHero(this.GetPosYHero()-1);
        }
        // si direction retourné est bas (B)
        if (directionPrise == 'B') {
            this.SetPosYHero(this.GetPosYHero()+1);
        }
    }

    public void transfertArmeDansInventaire(Arme[] listeArme) {
        for (int i = 0; i < listeArme.length; i++) {
            //this.inventaireArmes
        }
    }

    

}
