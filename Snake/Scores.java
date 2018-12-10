import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Scores {
    int currentScore;
    static ArrayList<String> scoresArray = new ArrayList<String>();

    public Scores() {
        this.currentScore = GamePanel.currentScore;

    }


    public static void saveScore(GamePanel panel) {
        File scoresFile = new File("scores.txt");
        Scanner scanner = null;



        Object[] options = {"Save", "Cancel"};
        String scoreDia = null;
        scoreDia = (String) JEnhancedOptionPane.showNewInputDialog("Would you like to save your score?\nScore: " + GamePanel.currentScore + "\nName: ", options);

        if (scoreDia.length() > 0) { //TODO
            System.out.println("SAVING");
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
            scoresArray.add(scoreDia + "   " + GamePanel.currentScore);

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
            GamePanel.gameOver = false;
            GamePanel.gameStart = true;
        } else { //TODO Handle cancel or dialog box close
            //User pressed cancel or closed dialog box so go back to game
            JOptionPane.showMessageDialog(panel, "Score not saved.");
            GamePanel.gameOver = false;
            GamePanel.gameStart = true;

        }
}

    public static String getTopTen() {

        return "bla";
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


