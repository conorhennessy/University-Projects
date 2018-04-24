package ass;

import javax.swing.*;
import java.awt.*;

public class Exercise6 extends JComponent {
    public static JFrame f;
    public static void SetGrid() {
        //Frame setup stuff
        f = new JFrame("Board");
        f.setLayout(new GridLayout(8, 8));
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
        f.setSize(400, 400);
        JPanel[] jp = new JPanel[64]; //init panes

        // Colours
        Color c1 = Color.WHITE;
        Color c2 = Color.LIGHT_GRAY;
        Color tempC;

        //Create grid with panels and set individual panel colours
        for (int i = 0; i  < 64; i++) {
            jp[i] = new JPanel();
            f.add(jp[i]);
            if (i % 8 == 0 ){ // For each row swap the 1st and 2nd colour around - to create checkers pattern
                tempC = c1;
                c1 = c2;
                c2 = tempC;
            }
            if (i % 2 == 1 ){
                jp[i].setBackground(c1); //set odd grid squares to c1
            }
            else jp[i].setBackground(c2); //set even grid squares to c2
        }
    }

    public static void main(String[] args) {
        SetGrid();
    }
}