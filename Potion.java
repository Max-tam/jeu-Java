public class Potion extends Effet{

    private String nomPotion;
    private int duree;

    public Potion(String effet, String nomPotion, int duree) {
        super(effet);
        this.nomPotion = nomPotion;
        this.duree = duree;
    }

    public String getNomPotion() {
        return nomPotion;
    }
    public void setNomPotion(String nomPotion) {
        this.nomPotion = nomPotion;

    }

    public int getDuree() { // recupere la duree de la Potion
        return duree;
    }
    public void setDuree(int duree) { // determine la duree de la Potion
        this.duree = duree;
    }    
    
}
