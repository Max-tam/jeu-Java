public class Artefact extends Effet {

    private String nomArtefact;

    public Artefact(String effet, String nomArtefact) {
        super(effet);
        this.nomArtefact = nomArtefact;
    }

    public String getNomArtefact() {
        return nomArtefact;
    }

    public void setNomArtefact(String nomArtefact) {
        this.nomArtefact = nomArtefact;
    }

}
