public class Artefact{

    private String nomArtefact;
    private Effet nomEffet;

    public Artefact(Effet effet, String nomArtefact) { // constructeur de la Class Artefact
        this.nomEffet = effet;
        this.nomArtefact = nomArtefact;
    }

    public String getNomArtefact() { // recupere le nom de l'artefact
        return nomArtefact;
    }

    public void setNomArtefact(String nomArtefact) { // defini le nom de l'artefact
        this.nomArtefact = nomArtefact;
    }

}
