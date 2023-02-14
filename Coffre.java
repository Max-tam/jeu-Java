public class Coffre {
    
    private boolean estOuvert;
    private Artefact [] artefactsDansCoffre;
    private Arme [] armesDansCoffre;

    public Coffre(boolean estOuvert, Artefact[] artefactsDansCoffre, Arme[] armesDansCoffre) { // Constucteur de la Class Coffre
        this.estOuvert = estOuvert;
        this.artefactsDansCoffre = artefactsDansCoffre;
        this.armesDansCoffre = armesDansCoffre;
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

}
