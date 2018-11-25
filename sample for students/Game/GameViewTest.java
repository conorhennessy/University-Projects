package myTetris;

// code copied from Simon Lucas
// code copied by Udo Kruschwitz
// code updated by Ian Daly


import utilities.JEasyFrame;
import java.util.Random;


public class GameViewTest
{
    public static void main(String[] args)
    {
        // test the view component
        Random r = new Random();
        int w = 10;
        int h = 20;
        int[][] a = new int[w][h];
        for (int i = 0; i < w; i++)
        {
            for (int j = h/2; j < h; j++)
            {
                a[i][j] =
                r.nextInt(myGame.GameView.colors.length);
            }
        }
        myGame.GameView tv = new myGame.GameView(a);
        new JEasyFrame(tv, "Game View");
    }
}