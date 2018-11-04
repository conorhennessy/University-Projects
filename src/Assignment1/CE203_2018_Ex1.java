package Assignment1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//TODO ensure exceptions are handled by program



public class CE203_2018_Ex1 {
    public CE203_2018_Ex1() {
        JFrame mainFrame = new JFrame("CE203 Assignment 1");
        mainFrame.setSize(600, 300);
        mainFrame.setLayout(new BorderLayout());

        //Text setup
        JPanel textPanel = new JPanel();
        JLabel text = new JLabel("CE203 Assignment 1, submitted by: 1703055");  //TODO position this vertical center
        text.setFont(new Font("Monaco", Font.BOLD, 25));
        text.setForeground(Color.BLUE);
        textPanel.add(text);

        //Reset button setup
        JPanel resetPanel = new JPanel();
        JButton resetButton = new JButton("Reset");
        resetPanel.add(resetButton);
        resetButton.addActionListener(new ActionListener() {  //TODO button actually need to clear stuff
            //Action for when reset button pressed
            @Override
            public void actionPerformed(ActionEvent e) {
                text.setForeground(Color.BLACK);
            }
        });

        //Colour setup here
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
        setButton.addActionListener(new ActionListener() {  //TODO when incorrect input is typed (non integer in any field) - error displayed, red text by default
            // Action for when Set button is pressed
            @Override
            public void actionPerformed(ActionEvent e) {
                text.setText("1703055");
                text.setFont(new Font("Monaco", Font.BOLD, 30));
                text.setForeground(new Color(red.validateColour(), green.validateColour(), blue.validateColour()));
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
