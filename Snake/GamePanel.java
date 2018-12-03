import javax.swing.*;
import java.awt.*;



public class GamePanel extends JPanel {
    Snake snake;
    JLabel score;
    public static int currentScore = 0;
    public static boolean gameState = true;

    //Timer t = new Timer(10, this);


    public GamePanel(Snake snake, JLabel score){
        this.snake = snake;
        this.score = score;

        add(score);
        score.setForeground(Color.white);
    }

    public void paintComponent(Graphics g) {
        // draw the head square on the board
        g.setColor(snake.snakeColour);

        for (Point p : snake.snakePosArray) {
            g.fillRect(p.x, p.y, snake.partSize, snake.partSize);
        }
    }

    //TODO next, Update score TODO

}
