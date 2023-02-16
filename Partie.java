import java.util.Scanner;

public class Partie {

    private boolean etatPartie;
    private boolean aGagne;
    private boolean aPerdu;

    public Partie() { // constructeur
        this.etatPartie = true;
        this.aGagne = false;
        this.aPerdu = false;
    }

    public boolean getEtatPartie() { // recupere l'état de la partie (true pour en cours / false pour fini)
        return etatPartie;
    }

    public void setEtatPartie(boolean etatPartie) { // permet de modifier l'état de la Partie
        this.etatPartie = etatPartie;
    }
    
    public boolean getAGagne() { // savoir si le joueur a gagne
        return aGagne;
    }

    public void setAGagne(boolean aGagne) { // permet de changer l'état de si le joueur à gagné
        this.aGagne = aGagne;
    }

    public boolean getAPerdu() { // savoir si joueur à perdu
        return aPerdu;
    }

    public void setAPerdu(boolean aPerdu) { // permet de changer l'état de si le joueur à perdu
        this.aPerdu = aPerdu;
    }

    public void gestionPartie() {

        // creation Scanner
        Scanner sc = new Scanner(System.in);

        // creation objet de la class EntreSortie
        EntreeSortie entreeSortie = new EntreeSortie();
        entreeSortie.titre();
        entreeSortie.menuPrincipal(sc);
        sc.close();
    }

}
