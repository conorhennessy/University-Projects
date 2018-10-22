package Assignment1.Exercise1;

import javax.swing.*;

public class inputValidation extends JTextField {
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
        // value received is not an integer
            setText("");
        }
        return value;
    }
}
