/*  CE203 2018 Ex2 - Submitted by 1703055  */


package Assignment1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;


public class CE203_2018_Ex2 {
    public static void main(String[] args) {
        JFrame mainFrame = new JFrame("CE203 Assignment 1 Exercise 2, submitted by: 1703055");  // mainFrame created as basis of UI which houses all other panels and elements within
        mainFrame.setSize(1400, 400);
        mainFrame.setLayout(new BorderLayout());


        //Initialise LinkedList for use throughout to store words
        LinkedList<String> wordList = new LinkedList<>();


        //Input text field setup and addition of it to the inputPanel
        JPanel inputPanel = new JPanel();
        textValidation inField = new textValidation();
        inField.setColumns(50);
        inputPanel.add(inField);


        //Text output panel setup with a Jlabel within, to show the relevant outputs with button presses
        JPanel innerPanel = new JPanel();
        JPanel textPanel = new JPanel();
        JLabel textLabel = new JLabel("Welcome to the word list store!   CE203 Assignment 1 Exercise 2, submitted by: 1703055");
        textLabel.setFont(new Font("Monaco", Font.BOLD, 25));
        textPanel.setLayout(new GridBagLayout());  // Inorder to get the text positioned center to the frame - both vertically and horizontally
        textPanel.add(innerPanel);
        innerPanel.add(textLabel);



        //Button Setup
        // Many event handlers created, with one for each button as each action is quite different and so to simplify code viewing
        JPanel buttonPanel = new JPanel();

        JButton addWord = new JButton("Add Word");   // Button and action listener initialised for when 'Add Word' button is pressed
        addWord.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (inField.getText().equals("")) {  // text field empty, display appropriate message
                    textLabel.setText("Unable to add a blank input to the list. Please check input and try again!");
                }

                else if (inField.validateWord(textLabel)) { // .validate() word method called inorder to ensure text field input is of the format as required.
                    textLabel.setText("\"" + inField.getText() + "\" has been added to the list.");
                    wordList.add(inField.getText());
                    inField.setText("");
                }

            }
        });


        JButton wordsEndingSearch = new JButton("Words Ending Search");   // Button and action listener initialised for when 'Words Ending Search' button is pressed
        wordsEndingSearch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (inField.getText().equals("")) {  // text field empty, display appropriate message
                    textLabel.setText("Unable to search for words ending in a blank input. Please check input and try again!");
                }
                if (inField.getText().length() > 1) {  // Extra Credit: Only one letter required for finding words from the list that end with a specified letter. So here show relevant message regarding their incorrect input
                    textLabel.setText("More than one character inputted for search, please try again below...");
                }

                else if (inField.validateWord(textLabel)) {
                    String searchLetter = inField.getText().toLowerCase(); // a string to hold the imputed letter in lower case, for repeated use.
                    LinkedList<String> tempList = new LinkedList<>();  // a temporary list created to hold all the words found ending in the inputted 'searchLetter'
                    // Searching of words ending in the 'searchLetter' and the relevant outputs as found necessary
                    for( String word : wordList){
                        if (word.charAt(word.length() - 1) == searchLetter.charAt(0))  tempList.add(word);
                    }
                    if (tempList.size() == 0) {
                        textLabel.setText("No words were found ending in \"" + searchLetter + "\"!");
                    }
                    else {
                        textLabel.setText(tempList.size() + " Word() found ending in \"" + searchLetter + "\" : " + Arrays.toString(tempList.toArray()));
                    }
                }

            }
        });


        JButton wordOccurrences = new JButton("Find occurrences");   // Button and action listener initialised for when 'Find occurrences' button is pressed
        wordOccurrences.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (inField.getText().equals("")) {  // text field empty, display total number of words in the list
                    textLabel.setText("There are currently " + wordList.size() + " words in the list.");
                }

                else if (inField.validateWord(textLabel)) {
                    int count = 0; // an int to count occurrences of a word in the linked list
                    ArrayList<Integer> posList = new ArrayList<>(); // a list to store the positions of all the particular words found
                    int index = 0; // an int that will be iterated to count the index location of the words found

                    // Searching of the word required in the 'searchLetter' and for the relevant outputs as found necessary
                    for (String word : wordList) {
                        if (inField.getText().equals(word)) {
                            count++;
                            posList.add(index);  // Add the location of the searched word in the list to posList for later output
                        }
                        index++;
                    }
                    if (count == 0) {
                        textLabel.setText("\"" + inField.getText() + "\" Does not occur in the list!");
                    }
                    else {
                        textLabel.setText("\"" + inField.getText() + "\" occurs " + count + " time(s) in the list. At position(s): " + Arrays.toString(posList.toArray()));
                    }
                }

            }
        });


        JButton removeLast = new JButton("Remove last occurrence");   // Button and action listener initialised for when 'Remove last occurrence' button is pressed
        removeLast.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (inField.getText().equals("")) {  // text field empty, display appropriate message
                    textLabel.setText("Unable to remove blank input from the list. Please check input and try again!");
                }

                // Removal of inputted word and for the relevant outputs as required
                else if (inField.validateWord(textLabel)) {
                    if (wordList.removeLastOccurrence(inField.getText())){
                        textLabel.setText("The last occurrence of \"" + inField.getText() + "\" has been removed.");
                    }
                    else {
                        textLabel.setText(inField.getText() + " does not occur in the text & so can not be removed. Please check input and try again!");
                    }
                }

            }
        });


        JButton removeAll = new JButton("Remove all occurrences");   // Button and action listener initialised for when 'Remove all occurrences' button is pressed
        removeAll.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (inField.getText().equals("")) {  // text field empty, display appropriate message
                    textLabel.setText("Unable to remove blank input from the list. Please check input and try again!");
                }

                // Validation and removal of all occurrences of a word from the list and the relevant outputs as required
                else if (inField.validateWord(textLabel)) {
                    if (wordList.removeAll(Arrays.asList(inField.getText()))) {
                        textLabel.setText("All occurrences of \"" + inField.getText() + "\" have been removed.");
                    }
                    else {
                        textLabel.setText(inField.getText() + " does not occur in the text & so can not be removed. Please check input and try again!");
                    }
                }

            }
        });


        JButton clearList = new JButton("Clear list");   // Button and action listener initialised when 'Clear list' button is pressed
        clearList.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                // Full clearing of the linkedList and an appropriate message displayed to user
                textLabel.setText("The list has now been cleared!");
                wordList.clear();
                inField.setText("");
            }

        });


        ArrayList<JButton> buttonList = new ArrayList<>(Arrays.asList(addWord, wordsEndingSearch, wordOccurrences, removeLast, removeAll, clearList));
        for (JButton button :buttonList ){
            buttonPanel.add(button);
        }  //A quick for loop with an ArrayList to make adding buttons to the panel a bit more efficient - rather than many many (6) individual buttonPanel.add(...) lines.



        //Frame set up and place all elements into frame
        mainFrame.add(buttonPanel, BorderLayout.NORTH);
        mainFrame.add(textPanel, BorderLayout.CENTER);
        mainFrame.add(inputPanel, BorderLayout.SOUTH);

        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setVisible(true);
    }
}

class textValidation extends JTextField {
    textValidation() {  //  a method to clear the text field when clicked, to remove any previous typing into text field
        this.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                setText("");   //Clear INPUT label from TextField on click
            }
        });
    }

    boolean validateWord(JLabel label) {  // method to validate that the word inputted is of the format required of only letters, numbers and hyphens (-) & must begin with a letter - Return value determines what action is taken on each button press
        try{

            String regEx = "^[a-zA-Z][a-zA-Z1-9-]*";
            if (this.getText().matches(regEx)){
                return true;
            }
            else {             //Validation of inputted word has failed, show user error message on formatting
                label.setText("Incorrect input! Words may contain only letters, numbers and hyphens (-) & must begin with a letter.");
                setText("");
                return false;
            }

        }
        catch (Exception e){

            // Value received from the field is raising an error, thus display error...
            label.setText("Incorrect input! Words may contain only letters, numbers and hyphens (-) & must begin with a letter.");
            label.setFont(new Font("Monaco", Font.BOLD | Font.ITALIC, 20));
            setText("");
            return false;

        }
    }
}
