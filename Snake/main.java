import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

public class main {
    public static void main(String[] args) {

        //Init of snake and all the relevant atts
        Snake snake = new Snake();

        //init of apple, the point which the snake will eat
        PointCircle apple = new PointCircle();

        GamePanel tv = new GamePanel(snake, apple);


        //Creation of a frame to hold all of the game
        GameFrame gameFrame = new GameFrame(tv, "Snake - Submitted by: 1703055", snake);

        gameFrame.add(tv, BorderLayout.CENTER);


        int time_interval = 300;

        Timer timer = new Timer(time_interval, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!GamePanel.gameOver){
                    snake.checkSnakeCollision();
                    snake.checkAppleCollision(apple);
                    snake.moveSnake();
                    snake.moveHead(snake.currentDir);
                    GamePanel.updateScore();
                    tv.repaint();
                }
                else {
                    System.out.println("GAME OVER");
                    Scores.saveScore(tv);
                    //timer.stop();
                }
            }
        });
        timer.start();

    }
}