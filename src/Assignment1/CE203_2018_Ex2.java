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
        //TODO Extend each button with anonymous action listeners to make appropriate actions to list
        //TODO Ensure appropriate message and output is displayed in textLabel for each button press

        JPanel buttonPanel = new JPanel();
        JButton addWord = new JButton("Add Word");  //TODO add a word to the list from inField
        JButton wordsEndingSearch = new JButton("Words Ending Search");  //TODO display all words in list that end with a specific letter, case-insensitive
        JButton wordOccurrences = new JButton("Find occurrences");  //TODO search list for word and display occurrences & positions in list where it is found.  If input empty - display total number of words in list and a nice message
        JButton removeLast = new JButton("Remove last occurrences");  //TODO remove last occurrence of input from the list
        JButton removeAll = new JButton("Remove all occurrences");  //TODO remove all occurrences of input from the list
        JButton clearList = new JButton("Clear list");  //TODO simply clear the list
        ArrayList<JButton> buttonList = new ArrayList<>(Arrays.asList(addWord, wordsEndingSearch, wordOccurrences, removeLast, removeAll, clearList));
        for (JButton button :buttonList ){
            buttonPanel.add(button);
        }  //A quick for loop with an ArrayList to make adding buttons to the panel a bit more efficient - rather than many many (6) individual buttonPanel.add(...) lines.



        //System text output setup
        JPanel textPanel = new JPanel();
        JLabel textLabel = new JLabel("Welcome to the word list store!");
        textLabel.setFont(new Font("Monaco", Font.BOLD, 25));
        textPanel.add(textLabel);

        //Input text field setup
        JPanel inputPanel = new JPanel();
        JTextField inField = new JTextField();
        //TODO JTextField to be extended like in EX 1 to ensure only contain letters, numbers and hyphens.  Input Must begin with letter
        //TODO ensure appropriate error displayed for incorrect inputs
        inField.setText("INPUT");
        //inField.setPreferredSize(1000, 200);
        //TODO make input text field appear across full frame
        inputPanel.add(inField);

        //Frame set up and place all elements into frame
        mainFrame.add(buttonPanel, BorderLayout.NORTH);
        mainFrame.add(textPanel, BorderLayout.CENTER);
        mainFrame.add(inputPanel, BorderLayout.SOUTH);

        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setVisible(true);

        //TODO initilaise LinkedList and set all that up
    }
}
