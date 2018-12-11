import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


public class GameFrame extends JFrame implements KeyListener, MouseListener {
    Component comp;
    Snake snake;
    static Dimension currentScreenSize;

    public GameFrame(Component comp, String title, Snake snake) {
        super(title);
        this.comp = comp;  // The component passed is the TV panel
        this.snake = snake;


        getContentPane().add(BorderLayout.CENTER, comp);
        pack();


        // formatting and setup of the GameFrame
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

        //Figure out the location for where frame should now be
        int x = (currentScreenSize.width - getWidth()) / 2;
        int y = (currentScreenSize.height - getHeight()) / 2;

        //Now set the frame's start location
        setLocation(x, y);


        //Add and state the keyboard & mouse listeners
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
            case 37:  //left
                if (snake.currentDir == 3) break;
                snake.currentDir = 1; //left
                break;
            case 38:  //up
                if (snake.currentDir == 4) break;
                snake.currentDir = 2; //up
                break;
            case 39:  //right
                if (snake.currentDir == 1) break;
                snake.currentDir = 3; //right
                break;
            case 40: //down
                if (snake.currentDir == 2) break;
                snake.currentDir = 4; //down
                break;
            case 27: //game now paused
                GamePanel.gamePause = true;
                break;
            case 81:  //quit game
                GamePanel.gameOver = true;
                break;
        }
    }

    //The following are methods for the KeyListener that must be implemented.  However they are redundant
    @Override
    public void keyReleased(KeyEvent e) {
    }
    @Override
    public void keyTyped(KeyEvent e) {
    }



    //Mouse action handlers
    //When mouse is interacted with, leave start of game state
    @Override
    public void mouseClicked(MouseEvent e) {
        if (snake.currentDir == 0){
            snake.currentDir = 3;
        }
        GamePanel.gameStart = false; //leave start state as mouse has been interacted with
        GamePanel.gamePause = false; //also leave pause state as this may arise
        GamePanel.gameOver = false;
        GamePanel.holdOver = false;
    }


    //The following are methods for the mouseListener that must be implemented.  However they are redundant
    @Override
    public void mousePressed(MouseEvent e) {
    }
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
