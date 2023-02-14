public class Hero extends Entite {

    private String nomHero;
    private Arme [] inventaireArmes;

    public Hero(int posY,int posX, int PV, Arme Arme, int defense, String nomHero)  // constructeur de la class Hero
    {
        super(posY, posX, PV, Arme, defense);
        this.nomHero = nomHero;
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
