public class Monstre extends Entite{
    
    private String nomMonstre;
    private boolean estMort;

    public Monstre(String nomMonstre,int posY,int posX, int PV, Arme Arme, int defense,int velocite)  // constructeur de la class Monstre
    {
        super(posY, posX, PV, Arme, defense,velocite);
        this.nomMonstre = nomMonstre;
        this.estMort = false;
    }

    public boolean getEstMort() {
        return estMort;
    }

    public void setEstMort(boolean estMort) {
        this.estMort = estMort;
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
