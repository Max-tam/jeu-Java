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
        for (int y = 0; y < carte.length; y++) {
            for (int x = 0; x < carte[y].length; x++) {
                System.out.print(carte[y][x]+"\t");
            }
            System.out.println();
        }
        System.out.println();
    }

    public void metAJourCarte(Hero joueur) {
        for (int y = 0; y < carte.length; y++) {
            for (int x = 0; x < carte[y].length; x++) {
                if (carte[y][x] == 'X') {
                    carte[y][x] = '0';
                }
            }
            
        }
        carte[joueur.GetPosYHero()][joueur.GetPosXHero()] = 'X';
    }

    public int getTailleY() { // renvoie la taille de la map en hauteur
        return carte.length;
    }

    public int getTailleX() { // renvoie la taille de la map en largeur
        return carte[0].length; // comme la carte est un carré, peut importe la valeur de Y, la valeur max de X sera la même
    }
}