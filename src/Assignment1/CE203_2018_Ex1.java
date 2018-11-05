package Assignment1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//TODO ensure exceptions are handled by program



public class CE203_2018_Ex1 {
    public CE203_2018_Ex1() {
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
        setButton.addActionListener(new ActionListener() {                                //TODO when incorrect input is typed error text to be RED
            @Override
            public void actionPerformed(ActionEvent e) {   // Action for when Set button is pressed
                textLabel.setText("1703055");
                textLabel.setFont(new Font("Monaco", Font.BOLD, 30));
                textLabel.setForeground(new Color(red.validateColour(textLabel), green.validateColour(textLabel), blue.validateColour(textLabel)));  //Here the label is also passed to the method in order to change it
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

    public static void main(String[] args) {
        new CE203_2018_Ex1();
    }
}
