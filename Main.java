import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // creation Scanner
        Scanner sc = new Scanner(System.in);

        // demarrage jeu
        Partie partie = new Partie();
        // Menu principal
        partie.gestionMenuPrincipal(sc);
    }
    
}
