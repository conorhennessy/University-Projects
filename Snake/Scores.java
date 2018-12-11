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

    public static void getScores() {
        File scoresFile = new File("scores.txt");
        Scanner scanner = null;

        //Reading of the file
        System.out.println("Reading File!");
        try {  //try reading the file
            scanner = new Scanner(scoresFile);
        } catch (FileNotFoundException e) {
            try {
                scoresFile.createNewFile();
            } catch (IOException e1) {
                System.out.println("Permissions denied to create new file");
            }
        }


        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            scoresArray.add(line);
        }
    }

    public static void saveScore(GamePanel panel) {
        scoresArray.clear();
        getScores();
        Object[] options = {"Save"};
        String scoreDia;
        scoreDia = (String) JEnhancedOptionPane.showNewInputDialog("Would you like to save your score?\nScore: " + GamePanel.currentScore + "\nName: ", options);

        File scoresFile = new File("scores.txt");

        // Write new score to the file
        if (!(scoreDia != null)){ //TODO Handle cancel or dialog box close
            //User pressed cancel or closed dialog box so go back to game
            JOptionPane.showMessageDialog(panel, "Score not saved.");
            //TODO change this so that it now holds in game over screen to show scoreboard
            GamePanel.holdOver = true;
            //GamePanel.gameStart = true;
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
                e1.printStackTrace();
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            //All writing now complete so go back to game
            //TODO change this so that it now holds in game over screen to show scoreboard
            GamePanel.holdOver = true;
            //GamePanel.gameStart = true;
        }
    }

    public static void getTopTen() {
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

        Collections.sort(namesAndScores); //TODO goto get this sorting working

        String topTen = "<html><br/>Click anywhere to try again!<br/><br/><br/><br/>Top 10 scores...<br/>";
        int bound = namesAndScores.size() >= 10 ? 10 : namesAndScores.size();

        for (int i = 0; i < bound; i++){
            topTen += namesAndScores.get(i).toString();
        }
        topTen +="</html>";
        System.out.println(topTen);

        GamePanel.centerText.setText(topTen);
    }
}


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


