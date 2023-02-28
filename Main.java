/* @Author: Maxtam
 * @Date: 28/02/2023
 * info: à executer sous VS Code
 */
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

/*
 * - permettre d'échanger un item dans le coffre si pas de place
 * - (rester dans le coffre tant qu'on le ferme pas) 
 */