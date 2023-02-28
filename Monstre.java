public class Monstre extends Entite{
    
    private String nomMonstre;

    public Monstre(String nomMonstre,int posY,int posX, int PV, Arme Arme, int defense)  // constructeur de la class Monstre
    {
        super(posY, posX, PV, Arme, defense);
        this.nomMonstre = nomMonstre;
    }

    public String getNomMonstre() // recuperer le nom du monstre
    {
        return nomMonstre;
    }

    public void setNomMonstre(String nomMonstre) // definir nom du monstre
    {
        this.nomMonstre = nomMonstre;
    }

}
