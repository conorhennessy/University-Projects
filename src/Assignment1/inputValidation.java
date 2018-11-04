package Assignment1;

import javax.swing.*;
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
    public int validateColour(){
        try {
            value = Integer.parseInt(getText());
            if (value < 0) {
                value = 200;
                setText("200");
            } else if (value > 255){
                value = 255;
                setText("255");
            }
            return value;
        }
        catch (Exception e) {
            // Value received from this field is not an integer
            setText("");
        }
        return value;
    }
}
