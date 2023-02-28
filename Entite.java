public class Entite {

    private int posX; // coordonnee axe x
    private int posY; // coordonnee axe y
    private int PV; // point de vie du hero
    private Arme Arme;
    private int defense;

    public Entite(int posY,int posX, int PV, Arme Arme, int defense) // constructeur de la class Entite
    {
        this.posX = posX;
        this.posY = posY;
        this.PV = PV;
        this.Arme = Arme;
        this.defense = defense;
    }

    public Arme getArme() {
        return Arme;
    }

    public void setArme(Arme arme) {
        Arme = arme;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public void setPosX(int x) // definir coordonnée axe x
    {
        this.posX = x;
    }

    public int getPosX() // recuperer coordonnée axe x
    {
        return this.posX;
    }

    public void setPosY(int y) // definir coordonnée axe y
    {
        this.posY = y;
    }

    public int getPosY() // recuperer coordonnée axe y
    {
        return this.posY;
    }

    public void setPV(int PV) // definir le nombre de point de vie du Hero
    {
        this.PV = PV;
    }

    public int getPV() // recuperer nombre de point de vie
    {
        return PV;
    }
}
