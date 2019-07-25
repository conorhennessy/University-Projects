/*  CE203 2018 Ex1 - Submitted by xxxxxxx  */

package Assignment1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;



public class CE203_2018_Ex1 {
    public static void main(String[] args) {
        JFrame mainFrame = new JFrame("CE203 Assignment 1 Exercise 1, submitted by: xxxxxxx");
        mainFrame.setSize(750, 300);
        mainFrame.setLayout(new BorderLayout());

        //Text setup with panels initialised and JLabel added to panel
        JPanel innerPanel = new JPanel();
        JPanel textPanel = new JPanel();
        JLabel textLabel = new JLabel("CE203 Assignment 1 Exercise 1, submitted by: xxxxxxx");
        textLabel.setFont(new Font("Monaco", Font.BOLD, 25));
        textLabel.setForeground(Color.BLUE);
        textPanel.setLayout(new GridBagLayout());  // Inorder to get the text positioned center to the frame - both vertically and horizontally
        textPanel.add(innerPanel);
        innerPanel.add(textLabel);


        //Colour fields setup with all panels and extended JFields added to panel
        JPanel rgbPanel = new JPanel();
        rgbPanel.setLayout(new GridLayout(1, 4));
        inputValidation red = new inputValidation("R");
        inputValidation green = new inputValidation("G");
        inputValidation blue = new inputValidation("B");
        JButton setButton = new JButton("Set");
        rgbPanel.add(red);
        rgbPanel.add(green);
        rgbPanel.add(blue);
        rgbPanel.add(setButton);
        setButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {   // Full anonymous listener for action for when Set button is pressed, to set the texts colour
                textLabel.setText("xxxxxxx");
                textLabel.setFont(new Font("Monaco", Font.BOLD, 30));
                if ((red.validateColour(textLabel) && green.validateColour(textLabel) && blue.validateColour(textLabel))) {
                    textLabel.setForeground(new Color(Integer.parseInt(red.getText()), Integer.parseInt(green.getText()), Integer.parseInt(blue.getText())));
                }
            }
        });


        //Reset button setup;  panels initialised and button added for reset
        JPanel resetPanel = new JPanel();
        JButton resetButton = new JButton("Reset");
        resetPanel.add(resetButton);
        resetButton.addActionListener(new ActionListener() {
            //Action for when reset button pressed
            @Override
            public void actionPerformed(ActionEvent e) {  // Anonymous listener for full reset of UI
                textLabel.setText("CE203 Assignment 1, submitted by: xxxxxxx");
                textLabel.setForeground(Color.BLUE);
                red.setText("");
                green.setText("");
                blue.setText("");
            }
        });

        mainFrame.add(resetPanel, BorderLayout.NORTH);
        mainFrame.add(textPanel, BorderLayout.CENTER);
        mainFrame.add(rgbPanel, BorderLayout.SOUTH);

        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setVisible(true);
    }
}

class inputValidation extends JTextField {
    inputValidation(String t) { //  a method to clear the text field when clicked, to remove any previous typing into text field
        super(t);
        this.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                setText("");   //Clear colour label (R,G,B) from TextField on click
            }
        });
    }


    boolean validateColour(JLabel label) {  //  Method for validation of values inputted for the colour objects creation. Ensuring values are following required format and values.
        if (getText().length() > 7) {
            setText("255"); // Error handling to deal with strings that are too large to become integers!  Thus set to be 255.
        }
        try {
            int value = Integer.parseInt(getText());
            if (value < 0) {
                setText("200");
            } else if (value > 255) {
                setText("255");
            }
            return true;
        } catch (Exception e) {
            // Value received from this field is not an integer
            label.setText("Invalid input in colour field(s)! Please try again below!");
            label.setFont(new Font("Monaco", Font.BOLD | Font.ITALIC, 20));
            setText("");
            label.setForeground(Color.RED);
            return false;
        }
    }
}