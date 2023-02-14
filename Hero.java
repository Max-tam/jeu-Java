public class Hero extends Entite {

    private String nomHero;
    private Arme [] inventaireArmes;
    private Potion [] inventairePotions;

    public Hero(int posY,int posX, int PV, Arme Arme, int defense, String nomHero,Arme [] inventaireArmes,Potion [] inventairePotions)  // constructeur de la class Hero
    {
        super(posY, posX, PV, Arme, defense);
        this.nomHero = nomHero;
        this.inventaireArmes = inventaireArmes;
        this.inventairePotions = inventairePotions;
    }

    public Potion[] getInventairePotions() {
        return inventairePotions;
    }

    public void setInventairePotions(Potion[] inventairePotions) {
        this.inventairePotions = inventairePotions;
    }

    public Arme[] getInventaireArmes() 
    {
        return inventaireArmes;
    }

    public void setInventaireArmes(Arme[] inventaireArmes) 
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

}
