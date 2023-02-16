public class Partie {

    private boolean etatPartie;
    private boolean aGagne;
    private boolean aPerdu;

    public Partie() { // constructeur
        this.etatPartie = true;
        this.aGagne = false;
        this.aPerdu = false;
    }

    public boolean getEtatPartie() {
        return etatPartie;
    }

    public void setEtatPartie(boolean etatPartie) {
        this.etatPartie = etatPartie;
    }
    
    public boolean getAGagne() {
        return aGagne;
    }

    public void setAGagne(boolean aGagne) {
        this.aGagne = aGagne;
    }

    public boolean getAPerdu() {
        return aPerdu;
    }

    public void setAPerdu(boolean aPerdu) {
        this.aPerdu = aPerdu;
    }
}
