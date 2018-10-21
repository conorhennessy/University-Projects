package Assignment1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CE203_2018_Ex1 {
    public CE203_2018_Ex1() {
        JFrame mainFrame = new JFrame("CE203 Assignment 1");
        mainFrame.setSize(400, 400);
        mainFrame.setLayout(new GridLayout(3, 1));

        //Text setup
        JPanel textPanel = new JPanel();
        JLabel text = new JLabel("Text Here");
        textPanel.add(text);

        //Reset button setup
        JPanel resetPanel = new JPanel();
        JButton resetButton = new JButton("Reset");
        resetPanel.add(resetButton);
        resetButton.addActionListener(new ActionListener() {
            //Action for when reset button pressed
            @Override
            public void actionPerformed(ActionEvent e) {
                text.setForeground(Color.BLACK);
            }
        });

        //Colour setup here
        JPanel rgbPanel = new JPanel();
        rgbPanel.setLayout(new GridLayout(1, 4));
        inputValidation red = new inputValidation();
        inputValidation green = new inputValidation();
        inputValidation blue = new inputValidation();
        JButton setButton = new JButton("Set");
        rgbPanel.add(red);
        rgbPanel.add(green);
        rgbPanel.add(blue);
        rgbPanel.add(setButton);
        setButton.addActionListener(new ActionListener() {
            // Action for when Set button is pressed
            @Override
            public void actionPerformed(ActionEvent e) {
                text.setForeground(new Color(red.validateColour(), green.validateColour(), blue.validateColour()));
            }
        });
        mainFrame.add(resetPanel);
        mainFrame.add(textPanel);
        mainFrame.add(rgbPanel);


        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setVisible(true);
    }

    public static void main(String[] args) {
        new CE203_2018_Ex1();
    }
}
