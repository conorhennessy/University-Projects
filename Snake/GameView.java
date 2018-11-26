import javax.swing.*;
import java.awt.*;
import static java.awt.Color.*; // import all the Colours


public class GameView extends JComponent {
    public static Color[] colors = {black, green, blue, red, yellow, magenta, pink, cyan};
    int[][] gridArray;
    int w, h;
    static int size = 20;

    public GameView(int[][] array) {
        this.gridArray = array;
        w = array.length;
        h = array[0].length;
    }



    public void paintComponent(Graphics g) {
        // using supplied grid process, draw all black squares across the board
        for (int i = 0; i < w; i++) {
            for (int j = 0; j < h; j++) {
                g.setColor(Color.BLUE);
                g.fill3DRect(i * size, j * size, size, size, true);
            }
        }
    }

    public Dimension getPreferredSize() {
        return new Dimension(w * size, h * size);
    }
}
