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

//TODO Comments for what each method does & what each instance of variable is used for. No comments on what each line does

public class CE203_2018_Ex2 {
    public static void main(String[] args) {
        JFrame mainFrame = new JFrame("CE203 Assignment 2");
        mainFrame.setSize(1250, 400);
        mainFrame.setLayout(new BorderLayout());

        //Initialise LinkedList for use throughout to store words
        LinkedList<String> wordList = new LinkedList<>();

        //Input text field setup
        JPanel inputPanel = new JPanel();
        textValidation inField = new textValidation();
        inField.setColumns(50);
        inputPanel.add(inField);



        //Text output setup
        JPanel innerPanel = new JPanel();
        JPanel textPanel = new JPanel();
        JLabel textLabel = new JLabel("Welcome to the word list store!");
        textLabel.setFont(new Font("Monaco", Font.BOLD, 25));
        textPanel.setLayout(new GridBagLayout());  // Inorder to get the text positioned center to the frame - both vertically and horizontally
        textPanel.add(innerPanel);
        innerPanel.add(textLabel);



        //Button Setup
        // Many event handlers created, with one for each button as each action is quite different and so to simplify code
        JPanel buttonPanel = new JPanel();

        JButton addWord = new JButton("Add Word");   // Button and action listener for when 'Add Word' button is pressed
        addWord.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (inField.validateWord(textLabel)) {
                    textLabel.setText("\"" + inField.getText() + "\" has been added to the list.");
                    wordList.add(inField.getText());
                    inField.setText("");
                }
                else {
                    //Validation of inputted word has failed, show user error message
                    //textLabel.setText("Incorrect input! Words may contain only letters, numbers and hyphens (-) & must begin with a letter.");
                }

            }
        });


        JButton wordsEndingSearch = new JButton("Words Ending Search");   // Button and action listener for when 'Words Ending Search' button is pressed
        wordsEndingSearch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (inField.getText().length() > 1) {
                    textLabel.setText("More than one character inputted for search, please try again below...");
                }

                else if (inField.validateWord(textLabel)) {
                    String searchLetter = inField.getText().toLowerCase();
                    LinkedList<String> tempList = new LinkedList<>();
                    for( String word : wordList){
                        if (word.charAt(word.length() - 1) == searchLetter.charAt(0)){ tempList.add(word); }
                    }
                    if (tempList.size() == 0) {
                        textLabel.setText("No words were found ending in \"" + searchLetter + "\"!");
                    }
                    else {
                        textLabel.setText(tempList.size() + " Words found ending in \"" + searchLetter + "\" : " + Arrays.toString(tempList.toArray()));
                    }
                }
            }
        });


        JButton wordOccurrences = new JButton("Find occurrences");   // Button and action listener for when 'Find occurrences' button is pressed
        wordOccurrences.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (inField.getText().equals("")) {
                    textLabel.setText("There are currently " + wordList.size() + " words in the list.");
                }

                if (inField.validateWord(textLabel)) {
                    int count = 0;
                    ArrayList<Integer> posList = new ArrayList<>();

                    int index = 0;
                    for (String word : wordList) {
                        if (inField.getText().equals(word)) {
                            count++;
                            posList.add(index);  // Add the location of the word in the list to posList for output
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


        JButton removeLast = new JButton("Remove last occurrence");   // Button and action listener for when 'Remove last occurrence' button is pressed
        removeLast.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (inField.validateWord(textLabel)) {
                    if (wordList.removeLastOccurrence(inField.getText())){
                        textLabel.setText("The last occurrence of \"" + inField.getText() + "\" has been removed.");
                    }
                    else {
                        textLabel.setText(inField.getText() + " does not occur in the text & so can not be removed. Please check input and try again!");
                    }
                }

            }
        });


        JButton removeAll = new JButton("Remove all occurrences");   // Button and action listener for when 'Remove all occurrences' button is pressed
        removeAll.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (inField.validateWord(textLabel)) {
                    if (wordList.removeAll(Arrays.asList(inField.getText()))) {
                        textLabel.setText("All occurrences of \"" + inField.getText() + "\" have been removed.");
                    }
                    else {
                        textLabel.setText(inField.getText() + " does not occur in the text & so can not be removed. Please check input and try again!");
                    }
                }

            }
        });


        JButton clearList = new JButton("Clear list");   // Button and action listener for when 'Clear list' button is pressed
        clearList.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                textLabel.setText("The list has now been cleared!");
                wordList.clear();
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
    textValidation() {
        this.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                setText("");   //Clear INPUT label from TextField on click
            }
        });
    }

    boolean validateWord(JLabel label) {
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

            // Value received from this field is raising an error, thus display error
            label.setText("Incorrect input! Words may contain only letters, numbers and hyphens (-) & must begin with a letter.");
            label.setFont(new Font("Monaco", Font.BOLD | Font.ITALIC, 20));
            setText("");
            return false;

        }
    }
}
