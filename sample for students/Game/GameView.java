package myGame;

// code copied from Simon Lucas
// code copied by Udo Kruschwitz


import javax.swing.*;
import java.awt.*;
// import all the Colors
import static java.awt.Color.*;

public class GameView extends JComponent
{
    public static Color[] colors =
            {black, green, blue, red,
                    yellow, magenta, pink, cyan};
    int[][] a;
    int w, h;
    static int size = 20;

    public GameView(int[][] a)
    {
        this.a = a;
        w = a.length;
        h = a[0].length;
    }


public void paintComponent(Graphics g)
{
        for (int i = 0; i < w; i++)
        {
            for (int j = 0; j < h; j++)
            {
                    g.setColor(colors[a[i][j]]);
                    g.fill3DRect(i * size, j * size,
                            size, size, true);
            }
        }
    }

    public Dimension getPreferredSize() {
        return new Dimension(w * size, h * size);
    }
}
