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
        setSize(850, 600);
        Color background = Color.decode("#3E3C45");
        setBackground(background);
        ImageIcon icon = new ImageIcon(getClass().getResource("icon.png"));
        setIconImage(icon.getImage());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        repaint();

        //To get frame to launch in center - Archive of book I used: https://web.archive.org/web/20080921040824/http://blog.codebeach.com/2008/02/center-dialog-box-frame-or-window-in.html
        //First get screen size
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension currentScreenSize = toolkit.getScreenSize();

        //Figure out the location frame should now be
        int x = (currentScreenSize.width - getWidth()) / 2;
        int y = (currentScreenSize.height - getHeight()) / 2;

        //Now set the frame's location
        setLocation(x, y);  //TODO possible fix of the flicer that appears


    }

}
