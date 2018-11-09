package Assignment1;

import javax.swing.*;
import java.awt.*;

public class CE203_2018_Ex2 {
    public static void main(String[] args) {
        JFrame mainFrame = new JFrame("CE203 Assignment 2");
        mainFrame.setSize(750, 300);
        mainFrame.setLayout(new BorderLayout());

        //Button Setup
        //

        //Text setup
        JPanel textPanel = new JPanel();
        JLabel textLabel = new JLabel("Welcome to the word emporium!");
        textLabel.setFont(new Font("Monaco", Font.BOLD, 25));

        //Input field setup
        //

        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setVisible(true);
    }
}
