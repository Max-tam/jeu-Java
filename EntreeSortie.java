import java.util.Scanner;

public class EntreeSortie {
    
    public void debutPartie() // affichage du titre
    {
        System.out.println();
        System.out.println("|====================================|");
        System.out.println("|=====| Bienvenue sur Java RPG |=====|");
        System.out.println("|====================================|");
        System.out.println();
    }

    public void menuPrincipal() // affichage menu principal + choix utilisateur
    {
        System.out.println();
        System.out.println("======| Menu Principal |======");
        System.out.println();
        System.out.println("-----------------------------");
        System.out.println("|-----|   JOUER : 1   |-----|");
        System.out.println("|-----| PARAMETRE : 2 |-----|");
        System.out.println("|-----|   CREDIT : 3  |-----|");
        System.out.println("-----------------------------");
        System.out.println();

        Scanner sc1 = new Scanner(System.in);
        System.out.print("-> ");
        int choixMenuPrincipal = sc1.nextInt();
        System.out.println();
        sc1.close();
        switch (choixMenuPrincipal) {
            case 1:
                System.out.println("**Lance le jeu**");
                // Lancer le jeu
                break;
            case 2:
                System.out.println("**Parametre**");
                // Lancer Menu Parametre
                break;
            case 3:
                System.out.println("**Credit**");
                // Lancer Credit
                break;
            default:
                System.out.println("==| Choix non correct |==");
                break;
        }
    }
}
