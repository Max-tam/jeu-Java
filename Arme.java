public class Arme {

    private String typeArme;
    private String nomArme;
    private int degat;

    public Arme(String typeArme,String nomArme,int degat) // constructeur de la class Arme
    {
        this.typeArme = typeArme;
        this.nomArme = nomArme;
        this.degat = degat;
    }

    public int getDegat() // recuperer le nombre de dégat de l'arme
    {
        return degat;
    }

    public void setDegat(int degat) // definir le nombre de dégat de l'arme
    {
        this.degat = degat;
    }

    public String GetTypeArme() // recuperer type d'arme
    {
        return this.typeArme;
    }

    public void SetTypeArme(String typeArme) // definir type d'arme
    {
        this.typeArme = typeArme;
    }

    public String GetNomArme() // recuperer nom de l'arme
    {
        return this.nomArme;
    }

    public void SetNomArme(String nomArme) // defom de l'arme
    {
        this.nomArme = nomArme;
    }

}
