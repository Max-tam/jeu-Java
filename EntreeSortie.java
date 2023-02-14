import java.util.Scanner;

public class EntreeSortie {
    
    public void debutPartie() // affichage du titre
    {
        System.out.println();
        System.out.println("======================================");
        System.out.println("======| Bienvenue sur Java RPG |======");
        System.out.println("======================================");
        System.out.println();
    }

    public void menuPrincipal() // affichage menu principal + choix utilisateur
    {
        System.out.println();
        System.out.println("======| Menu Principal |======");
        System.out.println();
        System.out.println("------|   JOUER : 1   |------");
        System.out.println("------| PARAMETRE : 2 |------");
        System.out.println("------|   CREDIT : 3  |------");
        System.out.println();

        Scanner sc1 = new Scanner(System.in);
        int choixMenuPrincipal = sc1.nextInt();
        sc1.close();
        switch (choixMenuPrincipal) {
            case 1:
                // Lancer le jeu
                break;
            case 2:
                // Lancer Menu Parametre
                break;
            case 3:
                // Lancer Credit
                break;
            default:
                System.out.println("==| Choix non correct |==");
                break;
        }
    }
}
