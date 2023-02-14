public class Potion extends Effet{

    private String nomPotion;
    private int duree;

    public Potion(String effet, String nomPotion, int duree) { // Constructeur de la Class Potion
        super(effet);
        this.nomPotion = nomPotion;
        this.duree = duree;
    }

    public String getNomPotion() { // recupere le nom de la potion
        return nomPotion;
    }
    public void setNomPotion(String nomPotion) { // defini le nom de la potion
        this.nomPotion = nomPotion;

    }

    public int getDuree() { // recupere la duree de la Potion
        return duree;
    }
    public void setDuree(int duree) { // determine la duree de la Potion
        this.duree = duree;
    }    
    
}
