public class Artefact extends Effet {

    private String nomArtefact;

    public Artefact(String effet, String nomArtefact) { // constructeur de la Class Artefact
        super(effet);
        this.nomArtefact = nomArtefact;
    }

    public String getNomArtefact() { // recupere le nom de l'artefact
        return nomArtefact;
    }

    public void setNomArtefact(String nomArtefact) { // defini le nom de l'artefact
        this.nomArtefact = nomArtefact;
    }

}
