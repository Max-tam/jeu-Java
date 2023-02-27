public class Coffre {
    
    private boolean estOuvert;
    private Artefact [] artefactsDansCoffre;
    private Arme [] armesDansCoffre;
    private int posX;
    private int posY;

/*=========================| Constructeur |=========================*/

    public Coffre(Artefact[] artefactsDansCoffre, Arme[] armesDansCoffre,int posX,int posY) { // Constucteur de la Class Coffre
        this.estOuvert = false;
        this.artefactsDansCoffre = artefactsDansCoffre;
        this.armesDansCoffre = armesDansCoffre;
        this.posX = posX;
        this.posY = posY;
    }

/*=========================| Get / Set |=========================*/

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

    public Artefact[] getArtefactsDansCoffre() { // retourne la liste des artefacts dans le coffre
        return artefactsDansCoffre;
    }

    public void setArtefactsDansCoffre(Artefact[] artefactsDansCoffre) { // defini la liste des artefacts dans le coffre
        this.artefactsDansCoffre = artefactsDansCoffre;
    }

    public Arme[] getArmesDansCoffre() { // retourne la liste des armes dans le coffre
        return armesDansCoffre;
    }

    public void setArmesDansCoffre(Arme[] armesDansCoffre) { // defini la liste des armes dans le coffre
        this.armesDansCoffre = armesDansCoffre;
    }

/*=========================| Fonction / Procedure |=========================*/

    public void armesDansCoffre() {// permet d'afficher à l'utilisateur les armes dans le coffre
        for (int i = 0; i < this.armesDansCoffre.length; i++) {
            System.out.print("\t- ");
            System.out.println(this.armesDansCoffre[i].GetNomArme());
        }
    }

    public void artefactDansCoffre() { // permet d'afficher à l'utilisateur les artefacts dans le coffre
        for (int i = 0; i < this.artefactsDansCoffre.length; i++) {
            System.out.print("\t- ");
            System.out.println(this.artefactsDansCoffre[i].getNomArtefact());
        }
    }

    public void objetDansCoffre() { // permet d'afficher à l'utilisateur les armes et artefacts dans le coffre
        System.out.println("\nArme(s) dans le coffre:\n");
        for (int i = 0; i < this.armesDansCoffre.length; i++) {
            System.out.print("\t- ");
            System.out.println(this.armesDansCoffre[i].GetNomArme());
        }
        System.out.println("\nArtefact(s) dans le coffre:\n");
        for (int i = 0; i < this.artefactsDansCoffre.length; i++) {
            System.out.print("\t- ");
            System.out.println(this.artefactsDansCoffre[i].getNomArtefact());
        }
        System.out.println();
    }

}