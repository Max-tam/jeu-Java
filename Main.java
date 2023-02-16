import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // affichage
        Scanner sc = new Scanner(System.in);
        EntreeSortie titreJeux = new EntreeSortie();
        titreJeux.debutPartie();
        titreJeux.menuPrincipal(sc);
        sc.close();
    }
    
}
