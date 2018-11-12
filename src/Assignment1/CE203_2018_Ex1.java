package Assignment1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

//TODO ensure exceptions are handled by program



public class CE203_2018_Ex1 {
    public static void main(String[] args) {
        JFrame mainFrame = new JFrame("CE203 Assignment 1");
        mainFrame.setSize(750, 300);
        mainFrame.setLayout(new BorderLayout());

        //Text setup
        JPanel textPanel = new JPanel();
        JLabel textLabel = new JLabel("CE203 Assignment 1, submitted by: 1703055");  //TODO position this vertical center maybe?
        textLabel.setFont(new Font("Monaco", Font.BOLD, 25));
        textLabel.setForeground(Color.BLUE);
        textPanel.add(textLabel);


        //Colour setup
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
            public void actionPerformed(ActionEvent e) {   // Action for when Set button is pressed
                textLabel.setText("1703055");
                textLabel.setFont(new Font("Monaco", Font.BOLD, 30));
                if ((red.validateColour(textLabel) && green.validateColour(textLabel) && blue.validateColour(textLabel))) {
                    textLabel.setForeground(new Color(Integer.parseInt(red.getText()), Integer.parseInt(green.getText()), Integer.parseInt(blue.getText())));
                }
            }
        });

        //Reset button setup
        JPanel resetPanel = new JPanel();
        JButton resetButton = new JButton("Reset");
        resetPanel.add(resetButton);
        resetButton.addActionListener(new ActionListener() {
            //Action for when reset button pressed
            @Override
            public void actionPerformed(ActionEvent e) {
                textLabel.setText("CE203 Assignment 1, submitted by: 1703055");
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
    public inputValidation(String t) {
        super(t);
        this.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                setText("");   //Clear colour label (R,G,B) from TextField on click
            }
        });
    }



    public boolean validateColour(JLabel label) {
        if (getText().length() > 7) {  // Error handling to deal with strings that are too large to be integers!  Thus set to be 255.
            setText("255");
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
            label.setForeground(Color.RED);  //TODO Actually set it as RED :/
            return false;
        }
    }
}
