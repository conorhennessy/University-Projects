import javax.swing.*;
import java.awt.*;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

public class Scores {
    int currentScore;

    public Scores(){
        this.currentScore = GamePanel.currentScore;

    }



    public static void saveScore(GamePanel panel){
        Object[] options = {"Save", "Cancel"};
        String scoreDia = (String)JEnhancedOptionPane.showNewInputDialog("        Game over    :( \n\nDo you want to save your score?\nScore: " + GamePanel.currentScore + "\nName: ", options);
        //if (scoreDia == JOptionPane.YES_OPTION) { TODO
            try {
                PrintWriter writer = new PrintWriter("scores.txt", "UTF-8");
                writer.println(scoreDia + "   " + GamePanel.currentScore);
            } catch (FileNotFoundException e1) {
                e1.printStackTrace();
            } catch (UnsupportedEncodingException e1) {
                e1.printStackTrace();
            }
        //}
        //if cancel button TODO
    }
}

class JEnhancedOptionPane extends JOptionPane {
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
}


