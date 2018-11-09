package Assignment1;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

public class CE203_2018_Ex2 {
    public static void main(String[] args) {
        JFrame mainFrame = new JFrame("CE203 Assignment 2");
        mainFrame.setSize(1000, 400);
        mainFrame.setLayout(new BorderLayout());

        //Button Setup
        JPanel buttonPanel = new JPanel();
        JButton addWord = new JButton("Add Word");  //To add a word to the list from inField
        JButton wordsEndingSearch = new JButton("Words Ending Search");  //To display all words in list that end with a specific letter, case-insensitive
        JButton wordOccurrences = new JButton("Find occurrences");  //To search list for word and display occurrences & positions in list where it is found.  If input empty - display total number of words in list and a nice message
        JButton removeLast = new JButton("Remove last occurrences");  //To remove last occurrence of input from the list
        JButton removeAll = new JButton("Remove all occurrences");  ///To remove all occurrences of input from the list
        JButton clearList = new JButton("Clear list");  //To simply clear the list
        ArrayList<JButton> buttonList = new ArrayList<JButton>(Arrays.asList(addWord, wordsEndingSearch, wordOccurrences, removeLast, removeAll, clearList));
        for (JButton button :buttonList ){
            buttonPanel.add(button);
        }  //A quick for ArrayList and loop to make adding buttons to the panel a bit more efficient - rather than many many (6) individual buttonPanel.add(...) lines.



        //System text output setup
        JPanel textPanel = new JPanel();
        JLabel textLabel = new JLabel("Welcome to the word list store!");
        textLabel.setFont(new Font("Monaco", Font.BOLD, 25));
        textPanel.add(textLabel);

        //Input text field setup
        JPanel inputPanel = new JPanel();
        JTextField inField = new JTextField();
        inField.setText("INPUT");
        inputPanel.add(inField);

        //Frame set up and place all elements into frame
        mainFrame.add(buttonPanel, BorderLayout.NORTH);
        mainFrame.add(textPanel, BorderLayout.CENTER);
        mainFrame.add(inputPanel, BorderLayout.SOUTH);

        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setVisible(true);
    }
}
