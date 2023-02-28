import java.util.ArrayList;
import java.util.List;

public class Coffre {
    
    private boolean estOuvert;
    private List<Artefact> artefactsDansCoffre = new ArrayList<Artefact>();
    private List<Arme> armesDansCoffre = new ArrayList<Arme>();
    private int posX;
    private int posY;

/*=========================| Constructeur |=========================*/

    public Coffre(List<Artefact> artefactsDansCoffre, List<Arme> armesDansCoffre, int posX, int posY) {// Constucteur de la Class Coffre
        this.estOuvert = false;
        this.artefactsDansCoffre = artefactsDansCoffre;
        this.armesDansCoffre = armesDansCoffre;
        this.posX = posX;
        this.posY = posY;
    }

/*=========================| Get / Set |=========================*/

    public List<Artefact> getArtefactsDansCoffre() {
        return artefactsDansCoffre;
    }

    public void setArtefactsDansCoffre(List<Artefact> artefactsDansCoffre) {
        this.artefactsDansCoffre = artefactsDansCoffre;
    }

    public List<Arme> getArmesDansCoffre() {
        return armesDansCoffre;
    }

    public void setArmesDansCoffre(List<Arme> armesDansCoffre) {
        this.armesDansCoffre = armesDansCoffre;
    }

    public int getPosX() { // retourne la position horizontale du coffre
        return posX;
    }

    public void setPosX(int posX) { // determine la position horizontale du coffre
        this.posX = posX;
    }

    public int getPosY() { // retourne la position verticale du coffre
        return posY;
    }

    public void setPosY(int posY) { // determine la position verticale du coffre
        this.posY = posY;
    }

    public boolean getestOuvert() { // retourne si le coffre est ouvert ou non
        return estOuvert;
    }

    public void setEstOuvert(boolean estOuvert) { // defini si le coffre et ouvert ou non
        this.estOuvert = estOuvert;
    }



/*=========================| Fonction / Procedure |=========================*/

    public void afficheArmesDansCoffre() {// permet d'afficher à l'utilisateur les armes dans le coffre
        for (int i = 0; i < this.armesDansCoffre.size(); i++) {
            System.out.print("\t- ");
            System.out.println(this.armesDansCoffre.get(i).GetNomArme());
        }
    }

    public void afficheArtefactDansCoffre() { // permet d'afficher à l'utilisateur les artefacts dans le coffre
        for (int i = 0; i < this.artefactsDansCoffre.size(); i++) {
            System.out.print("\t- ");
            System.out.println(this.artefactsDansCoffre.get(i).getNomArtefact());
        }
    }

    public void gestionMenuCoffre(int choix) {
        if (choix == 1) {
            
        }
    }

}