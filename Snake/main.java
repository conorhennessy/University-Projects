import javax.swing.*;
import java.awt.*;
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



        int time_interval = 3;
        Boolean game_running = GamePanel.gameState;

        // TODO Move currently active block at fixed intervals. Well get timer working
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                if (game_running){
                    snake.moveSnake(snake.currentDir);
                    tv.repaint();
                }
            }
        };
        //Timer timer = new Timer(0, );
        //timer.scheduleAtFixedRate(task, 0, time_interval);

    }
}