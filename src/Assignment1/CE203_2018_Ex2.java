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
        JFrame mainFrame = new JFrame("CE203 Assignment 2");
        mainFrame.setSize(1000, 400);
        mainFrame.setLayout(new BorderLayout());

        //Initialise LinkedList and set all that up
        LinkedList<String> wordList = new LinkedList<>();

        //Input text field setup
        JPanel inputPanel = new JPanel();
        inValidation inField = new inValidation();
        //TODO JTextField to be extended like in EX 1 to ensure only contain letters, numbers and hyphens.  Input Must begin with letter
        //TODO ensure appropriate error displayed for incorrect inputs
        inField.setColumns(50);
        inputPanel.add(inField);


        //System text output setup
        JPanel innerPanel = new JPanel();
        JPanel textPanel = new JPanel();
        JLabel textLabel = new JLabel("Welcome to the word list store!");
        textLabel.setFont(new Font("Monaco", Font.BOLD, 25));
        textPanel.setLayout(new GridBagLayout());  // Inorder to get the text positioned center to the frame - both vertically and horizontally
        textPanel.add(innerPanel);
        innerPanel.add(textLabel);



        //Button Setup
        // Many event handlers with one for each button as each is quite different and to show the coe more simply
        //TODO get each anonymous action listener to do stuff
        //TODO Ensure appropriate message and output is displayed in textLabel for each button press
        JPanel buttonPanel = new JPanel();
        JButton addWord = new JButton("Add Word");
        addWord.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {   // Action for when 'Add Word' button is pressed
                textLabel.setText("\"" + inField.getText() + "\" has been added to the list.");
                if (inField.validateInput(textLabel)) {
                    wordList.add(inField.getText());
                }
            }
        });
        JButton wordsEndingSearch = new JButton("Words Ending Search");
        wordsEndingSearch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {   // Action for when 'Add Word' button is pressed
                if (inField.getText().length() != 1) {
                    textLabel.setText("More than one character inputted, please try again...");
                    textLabel.setForeground(Color.RED);  //TODO fix colouring of this to go back to black
                }
                else if (inField.validateInput(textLabel)) {
                    String searchLetter = inField.getText().toLowerCase();
                    LinkedList<String> tempList = new LinkedList<String>();
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
        JButton wordOccurrences = new JButton("Find occurrences");  //TODO fix positions of where found
        wordOccurrences.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {   // Action for when 'Add Word' button is pressed
                if (inField.validateInput(textLabel)) {
                    if (inField.getText().length() == 0) {
                        textLabel.setText("There are currently " + wordList.size() + " words in the list.");
                    }
                    else {
                        int count = 0;
                        ArrayList<Integer> posList = new ArrayList<>();
                        for (String word : wordList) {
                            if (inField.getText().equals(word)) {
                                count++;
                                posList.add(wordList.indexOf(word));
                            }
                        }
                        textLabel.setText("\"" + inField.getText() + "\" occurs " + count + " time(s) in the list. At position(s): " + Arrays.toString(posList.toArray()));
                    }
                }
            }
        });
        JButton removeLast = new JButton("Remove last occurrences");
        removeLast.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {   // Action for when 'Add Word' button is pressed
                textLabel.setText("The last occurrence of \"" + inField.getText() + "\" Has been removed");
                if (inField.validateInput(textLabel)) {
                    wordList.removeLastOccurrence(inField.getText());

                }
            }
        });
        JButton removeAll = new JButton("Remove all occurrences");
        removeAll.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {   // Action for when 'Add Word' button is pressed
                textLabel.setText("All occurrences of " + inField.getText() + " have been removed.");
                if (inField.validateInput(textLabel)) {
                    wordList.removeAll(Arrays.asList(inField.getText()));
                }
            }
        });
        JButton clearList = new JButton("Clear list");
        clearList.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {   // Action for when 'Add Word' button is pressed
                textLabel.setText("The list has now been cleared!");
                if (inField.validateInput(textLabel)) {
                    wordList.clear();
                }
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

class inValidation extends JTextField {
    public inValidation() {
        this.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                setText("");   //Clear INPUT label from TextField on click
            }
        });
    }

    public boolean validateInput(JLabel label) {
        try{
            // TODO Handling for ensuring words are the structure as required. May only letters, numbers, and hyphens (-) and must begin with a letter
            String regEx = "^[a-zA-Z][a-zA-Z1-9-]*";
            if (this.getText().matches(regEx)) {
                return true;
            }
            else return false;
        }
        catch (Exception e){
            // Value received from this field is raising an error
            label.setText("Invalid input in input field! Please try again below!");
            label.setFont(new Font("Monaco", Font.BOLD | Font.ITALIC, 20));
            setText("");
            label.setForeground(Color.RED);
            return false;
        }
    }
}

