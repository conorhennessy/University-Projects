import javax.swing.*;
import java.awt.*;



public class GamePanel extends JPanel {
    Snake snake;
    PointCircle apple;

    public static JLabel scoreLabel;
    public static JLabel centerText;
    public static int currentScore = 0;

    public static boolean gameStart = true;
    public static boolean gamePause = false;
    public static boolean gameOver = false;

    Color background = Color.decode("#3E3C45");

    public GamePanel(Snake snake, PointCircle apple){
        this.snake = snake;
        this.apple = apple;

        //Setup of panel
        setLayout(new GridBagLayout());


        //Creation of a score label which will go into the frame
        scoreLabel = new JLabel("Score: " + currentScore+"\n");
        //Set formatting: colour, location & size of label
        scoreLabel.setForeground(Color.white);
        scoreLabel.setFont(new Font("Courier New", Font.BOLD, 15));
        scoreLabel.setBounds(900, 50, 100, 100); //TODO EXTRA goto get this formatting working
        add(scoreLabel);

        centerText = new JLabel("");
        centerText.setForeground(Color.decode("#c1e1e7"));
        centerText.setFont(new Font("Courier New", Font.ITALIC, 25));
        centerText.setVisible(false);
        add(centerText);
    }

    public static void updateScore() {
        scoreLabel.setText("Score: " + currentScore);
    }

    public static void updateCenterText(String state){
        switch (state) {
            case "start":
                centerText.setText("<html>SNAKE<br/></br>Use the arrow keys to move & Esc to pause<br/>Click anywhere to start!</html>");
                centerText.setVisible(true);
                break;
            case "paused":
                centerText.setText("<html>PAUSED<br/>Click anywhere to resume...</html>");
                centerText.setVisible(true);
                break;
            case "over":
                centerText.setText("Game Over :(");
                centerText.setForeground(Color.decode("#f0908a"));
                centerText.setVisible(true);
                break;
            case "play": //if playing clear center Text
                centerText.setText("");
                break;
        }
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
