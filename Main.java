import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // creation Scanner
        Scanner sc = new Scanner(System.in);

        // Class partie
        Partie partie = new Partie();

        // Class EntreeSortie
        EntreeSortie entreeSortie = new EntreeSortie();

        // Menu principal
        partie.gestionMenuPrincipal(sc,entreeSortie);

        // fermeture du Scanner
        sc.close();
    }
}
