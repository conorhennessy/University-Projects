package Assignment1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class inputValidation extends JTextField {
    public inputValidation(String t){
        super(t);
        this.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                setText("");   //Clear colour label (R,G,B) from TextField on click
            }
        });
    }

    int value;
    public int validateColour(JLabel label){
        if (getText().length() > 7) { setText("255"); }    // Error handling to deal with strings that are too large to be integers!  Thus set to be 255.
        try {
            value = Integer.parseInt(getText());
            if (value < 0) {
                value = 200;
                setText("200");
            } else if (value > 255){
                value = 255;
                setText("255");
            }
        } catch (Exception e) {
            // Value received from this field is not an integer
            label.setText("Invalid input in colour field(s)! Please try again below!");
            label.setFont(new Font("Monaco", Font.BOLD | Font.ITALIC, 20));
            setText("");
            label.setForeground(Color.RED);  //TODO Actually set it as RED :/
        }
        return value;
    }
}
