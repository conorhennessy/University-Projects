import javax.swing.*;
import java.awt.*;



public class GamePanel extends JPanel {
    Snake snake;
    JLabel score;
    public static int currentScore = 0;
    public static boolean gameState = true;


    public GamePanel(Snake snake, JLabel score){
        this.snake = snake;
        this.score = score;

        add(score);
        score.setForeground(Color.white);
    }

    public void paintComponent(Graphics g) {
        // draw the head square on the board
        g.setColor(snake.snakeColour);

        System.out.println(snake.snakePosArray);
        for (Point p : snake.snakePosArray) {
            System.out.println("x:"+ p.x +" & y:" + p.y);
            g.fillRect(p.x, p.y, snake.partSize, snake.partSize);
        }
    }

    //TODO next, Update score TODO

}
