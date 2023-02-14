public class Coffre {
    
    private boolean estOuvert;
    private Artefact [] artefactsDansCoffre;
    private Arme [] armesDansCoffre;

    public Coffre(boolean estOuvert, Artefact[] artefactsDansCoffre, Arme[] armesDansCoffre) {
        this.estOuvert = estOuvert;
        this.artefactsDansCoffre = artefactsDansCoffre;
        this.armesDansCoffre = armesDansCoffre;
    }

}
