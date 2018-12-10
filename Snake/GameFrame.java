import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


public class GameFrame extends JFrame implements KeyListener, MouseListener {
    public Component comp;
    Snake snake;
    static Dimension currentScreenSize;

    public GameFrame(Component comp, String title, Snake snake) {
        super(title);
        this.comp = comp;  // The component passed is the TV panel
        this.snake = snake;


        getContentPane().add(BorderLayout.CENTER, comp);
        pack();

        this.setVisible(true);
        this.setResizable(false);
        setSize(845, 610);
        Color background = Color.decode("#3E3C45");
        setBackground(background);
        ImageIcon icon = new ImageIcon(getClass().getResource("icon.png"));
        setIconImage(icon.getImage());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        repaint();

        //To get frame to launch in center - Archive of book I used: https://web.archive.org/web/20080921040824/http://blog.codebeach.com/2008/02/center-dialog-box-frame-or-window-in.html
        //First get screen size
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        GameFrame.currentScreenSize = toolkit.getScreenSize();

        //Figure out the location frame should now be
        int x = (currentScreenSize.width - getWidth()) / 2;
        int y = (currentScreenSize.height - getHeight()) / 2;

        //Now set the frame's start location
        setLocation(x, y);


        //Add and state the button handler stuff
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
        addKeyListener(this);
        addMouseListener(this);
    }



    //Key action handlers
    //Appropriate actions for when any of the arrow keys or escape is pressed.
    @Override
    public void keyPressed(KeyEvent e) {
        //Handling the actions of the arrow keys
        int keyCode = e.getKeyCode();
        switch (keyCode){
            case 37: snake.currentDir = 1; //left
                break;
            case 38: snake.currentDir = 2; //up
                break;
            case 39: snake.currentDir = 3; //right
                break;
            case 40: snake.currentDir = 4; //down
                break;
            case 27: GamePanel.gamePause = true;  //game now paused
        }
    }

    //The following are methods for the KeyListener that must be implemented.  However they are redundant
    @Override
    public void keyReleased(KeyEvent e) {
        //Handling the actions of the arrow keys
    }
    @Override
    public void keyTyped(KeyEvent e) {
        //Handling the actions of the arrow keys
    }



    //Mouse action handlers
    //When mouse is interacted with, leave start of game state
    @Override
    public void mouseClicked(MouseEvent e) {
        GamePanel.gameStart = false; //leave start state as mouse has been interacted with
        GamePanel.gamePause = false; //also leave pause state as this may arise
    }

    @Override
    public void mousePressed(MouseEvent e) {
        GamePanel.gameStart = false; //leave start state as mouse has been interacted with
        GamePanel.gamePause = false; //also leave pause state as this may arise

    }

    //The following are methods for the mouseListener that must be implemented.  However they are redundant
    @Override
    public void mouseEntered(MouseEvent e) {
    }
    @Override
    public void mouseReleased(MouseEvent e) {
    }
    @Override
    public void mouseExited(MouseEvent e) {
    }
}
