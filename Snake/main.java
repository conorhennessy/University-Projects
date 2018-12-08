import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.TimerTask;

public class main {
    public static void main(String[] args) {

        //Creation of a panel which will go into the frame
        JLabel scoreLabel = new JLabel("Score: " + GamePanel.currentScore);

        Snake snake = new Snake();

        //Set location & size of label
        //scoreLabel.setBounds(900, 50, 100, 100); //TODO EXTRA goto get this formatting working
        GamePanel tv = new GamePanel(snake, scoreLabel);


        //Creation of a frame to hold all of the game
        GameFrame gameFrame = new GameFrame(tv, "Snake - Submitted by: 1703055", snake);

        gameFrame.add(tv, BorderLayout.CENTER);


        int time_interval = 750;
        Boolean game_running = GamePanel.gameState;

        Timer timer = new Timer(time_interval, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (game_running){
                    snake.moveSnake(snake.currentDir, tv);
                    System.out.println(snake.snakePosArray);  //to show where the blobs should be
                    tv.repaint();  //instead call repaint method in snake class?
                }
            }
        });
        timer.start();

    }
}