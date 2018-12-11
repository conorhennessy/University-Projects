import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.*;

public class Scores {
    int currentScore;
    static ArrayList<String> scoresArray = new ArrayList<String>();

    public Scores() {
        this.currentScore = GamePanel.currentScore;

    }

    //Method to read scores file and store all values in scoresArray
    public static void getScores() {
        File scoresFile = new File("scores.txt");
        Scanner scanner = null;

        //Reading of the file
        System.out.println("Reading File!");
        try {
            scanner = new Scanner(scoresFile);
        } catch (FileNotFoundException e) {
            try {
                System.out.println("File not found!  Creating new file");
                scoresFile.createNewFile();
            } catch (IOException e1) {
                System.out.println("Permissions denied to create new file!");
            }
        }


        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            scoresArray.add(line);
        }
    }

    //Method to save the score to the file
    public static void saveScore(GamePanel panel) {
        scoresArray.clear();
        getScores();
        Object[] options = {"Save"};
        String scoreDia;
        scoreDia = (String) JEnhancedOptionPane.showNewInputDialog("Would you like to save your score?\nScore: " + GamePanel.currentScore + "\nName: ", options);

        File scoresFile = new File("scores.txt");

        // Write new score to the file
        if (scoreDia == null){
            //User pressed cancel or closed dialog box so go back to game
            JOptionPane.showMessageDialog(panel, "Score not saved.");
            GamePanel.holdOver = true;
        }
        else if (scoreDia.length() > 0) {
            System.out.println("Save to file!");
            scoresArray.add(scoreDia + " " + GamePanel.currentScore);
            try {  //try writing to file
                BufferedWriter writer = new BufferedWriter(new FileWriter(scoresFile));
                for (String score : scoresArray) {
                    writer.write(score);
                    writer.newLine();
                }
                writer.close();
                JOptionPane.showMessageDialog(panel, "Score saved successfully.");
            } catch (FileNotFoundException e1) {
                System.out.println("File not found!  Creating new file");
                try {
                    scoresFile.createNewFile();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            } catch (IOException e) {
                System.out.println("Permissions denied to create new file!");
            }
            //All writing now complete so to hold game state
            GamePanel.holdOver = true;
        }
    }

    //Method for finding the top ten scores in the file and setting the center text to show this leader board
    //Works by looping through the scoresArray and remapping it as a names&scores objects in order for sorting it to occur
    public static String getTopTen() {
        scoresArray.clear();
        getScores();
        ArrayList<nameAndScore> namesAndScores = new ArrayList<>();
        for (String line : scoresArray){
            try {
                namesAndScores.add(new nameAndScore(line.split(" ")[0], Integer.parseInt(line.split(" ")[1])));
            }
            catch (NumberFormatException e){
                //Nothing required here
            }
        }

        Collections.sort(namesAndScores);

        String topTen = "Top 10 scores...<br/>";

        int bounds = namesAndScores.size() >= 10 ? 10 : namesAndScores.size();  //if the scores file has less than 10 peoples scores the bound for the following for loop is the number of items in the array instead. Otherwise the bound is 10

        for (int i = 0; i < bounds; i++){
            topTen += namesAndScores.get(i).toString();
        }
        topTen +="</html>";

        return topTen;
    }
}

//Extended option pane in order to customise the dialog option buttons and inputs
class JEnhancedOptionPane extends JOptionPane implements ActionListener {
    public static String showNewInputDialog(final Object message, final Object[] options)
            throws HeadlessException {
        final JOptionPane pane = new JOptionPane(message, QUESTION_MESSAGE,
                OK_CANCEL_OPTION, null,
                options, null);
        pane.setWantsInput(true);
        pane.setComponentOrientation((getRootFrame()).getComponentOrientation());
        pane.setMessageType(QUESTION_MESSAGE);
        pane.selectInitialValue();
        final String title = UIManager.getString("Game Over!", null);
        final JDialog dialog = pane.createDialog(null, title);
        dialog.setVisible(true);
        dialog.dispose();
        final Object value = pane.getInputValue();
        return (value == UNINITIALIZED_VALUE) ? null : (String) value;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }
}


