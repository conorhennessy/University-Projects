import javax.swing.*;
import java.awt.*;



public class GamePanel extends JPanel {
    Snake snake;
    PointCircle apple;
    public static JLabel scoreLabel;
    public static int currentScore = 0;
    public static boolean gameOver = false;
    Color background = Color.decode("#3E3C45");


    public GamePanel(Snake snake, PointCircle apple){
        this.snake = snake;
        this.apple = apple;


        //Creation of a score label which will go into the frame
        scoreLabel = new JLabel("Score: " + currentScore);
        //Set formatting: colour, location & size of label
        scoreLabel.setForeground(Color.white);
        scoreLabel.setBounds(900, 50, 100, 100); //TODO EXTRA goto get this formatting working
        add(scoreLabel);
    }

    public static void updateScore() {
        scoreLabel.setText("Score: " + currentScore);
    }


    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        // draw the head square on the board
        g.setColor(snake.snakeColour);

        g.fillRect(snake.head.posX, snake.head.posY, snake.partSize, snake.partSize);
        for (Square p : snake.snakePosArray) {
            System.out.println("Drawing snake part @ x:"+ p.posX +" & y:" + p.posY);
            g.fillRect(p.posX, p.posY, snake.partSize, snake.partSize);
        }

        System.out.println("Drawing apple @ x:"+ apple.posX +" & y:" + apple.posY);
        g.fillOval(apple.posX, apple.posY, apple.radius, apple.radius);

        setBackground(background);
    }

}
