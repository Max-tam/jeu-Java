public class Donjon 
{
    private char [][] carte; // carte du jeu
    
    public Donjon(char[][] carte) // constructeur
    {
        this.carte = carte;
    }

    public void setCarte(char[][] carte) // definir une carte
    {
        this.carte = carte;
    }

    public void getCarte() // recuper le tableau de la carte
    {
        for (int axeVertical = 0; axeVertical < carte.length; axeVertical++) {
            for (int axeHorizontal = 0; axeHorizontal < carte[axeVertical].length; axeHorizontal++) {
                System.out.print(carte[axeVertical][axeHorizontal]+"\t");
            }
            System.out.println();
        }
        System.out.println();
    }

    public void metAJourCarte(Hero joueur, Coffre coffre1, Coffre coffre2, Monstre zombie, Monstre squelette) {
        for (int axeVertical = 0; axeVertical < carte.length; axeVertical++) {
            for (int axeHorizontal = 0; axeHorizontal < carte[axeVertical].length; axeHorizontal++) {
                if (carte[axeVertical][axeHorizontal] == 'X') {
                    carte[axeVertical][axeHorizontal] = '0';
                }
            }
            
        }
        // en priorité les objets fixes
        carte[coffre1.getPosY()][coffre1.getPosX()] = 'C'; // coffre 1
        carte[coffre2.getPosY()][coffre2.getPosX()] = 'C'; // coffre 2

        carte[zombie.getPosY()][zombie.getPosX()] = 'M'; // monstre 1
        carte[squelette.getPosY()][squelette.getPosX()] = 'M'; // monstre 2

        // en secondaire les objets objets mobile (pour les voir toujours en premier plan)
        carte[joueur.getPosY()][joueur.getPosX()] = 'X';
    }

    public int getTailleY() { // renvoie la taille de la map en hauteur
        return carte.length;
    }

    public int getTailleX() { // renvoie la taille de la map en largeur
        return carte[0].length; // comme la carte est un carré, peut importe la valeur de Y, la valeur max de X sera la même
    }
}