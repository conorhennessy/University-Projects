import javax.swing.*;
import java.awt.*;


public class GameFrame extends JFrame {
    public Component comp;
    public GameFrame(Component comp, String title) {
        super(title);
        this.comp = comp;

        getContentPane().add(BorderLayout.CENTER, comp);
        pack();
        
        this.setVisible(true);
        this.setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBackground(Color.BLACK);
        repaint();
    }
}
