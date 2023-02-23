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
                System.out.print(carte[y][x]+" ");
            }
            System.out.println();
            
        }
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
}