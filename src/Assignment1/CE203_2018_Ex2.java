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
        LinkedList<String> wordList = new LinkedList<String>();

        //Input text field setup
        JPanel inputPanel = new JPanel();
        inValidation inField = new inValidation();
        //TODO JTextField to be extended like in EX 1 to ensure only contain letters, numbers and hyphens.  Input Must begin with letter
        //TODO ensure appropriate error displayed for incorrect inputs
        inField.setText("INPUT");
        inField.setColumns(50);
        inputPanel.add(inField);


        //System text output setup
        JPanel textPanel = new JPanel();
        JLabel textLabel = new JLabel("Welcome to the word list store!");
        textLabel.setFont(new Font("Monaco", Font.BOLD, 25));
        textPanel.add(textLabel);


        //Button Setup
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
                textLabel.setText("Word Search");
                if (inField.validateInput(textLabel)) {
                    //TODO display all words in list that end with a specific letter, case-insensitive
                }
            }
        });
        JButton wordOccurrences = new JButton("Find occurrences");
        wordOccurrences.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {   // Action for when 'Add Word' button is pressed
                if (inField.validateInput(textLabel)) {
                    int count = 0;
                    //for (word:wordList){
                      //  if (inField.getText().equals(word))
                        //count++;
                    //}  //TODO this mess of a for loop needs fixing  see to Unit 4: Weeks 5 to 6 lecture notes
                    textLabel.setText("\"" + inField.getText() + "\" occurs " + count + " times in the list.");
                    //TODO search list for word and display occurrences & positions in list where it is found.  If input empty - display total number of words in list and a nice message
                }
            }
        });
        JButton removeLast = new JButton("Remove last occurrences");
        removeLast.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {   // Action for when 'Add Word' button is pressed
                textLabel.setText("The last occurence of \"" + inField.getText() + "\" Has been removed");
                if (inField.validateInput(textLabel)) {
                    wordList.removeLastOccurrence(inField.getText());

                }
            }
        });
        JButton removeAll = new JButton("Remove all occurrences");
        removeAll.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {   // Action for when 'Add Word' button is pressed
                textLabel.setText("Remove all occurrences");
                if (inField.validateInput(textLabel)) {
                    //TODO remove all occurrences of input from the list
                }
            }
        });
        JButton clearList = new JButton("Clear list");
        clearList.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {   // Action for when 'Add Word' button is pressed
                textLabel.setText("The list has now been cleared");
                if (inField.validateInput(textLabel)) {
                    //TODO simply clear the list
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
    public boolean validateInput(JLabel label) {
        this.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                setText("");   //Clear INPUT label from TextField on click
            }
        });

        try{
            // TODO Error handling for ensuring words are the structure as required
            return true;
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
