import javax.swing.*;
import java.awt.*;



public class GamePanel extends JPanel {
    Snake snake;
    PointCircle apple;

    static JLabel scoreLabel;
    static JLabel centerText;
    static JLabel centerTitle;

    static int currentScore = 0;

    static boolean gameStart = true;
    static boolean gamePause = false;
    static boolean gameOver = false;

    Color background = Color.decode("#3E3C45");

    public GamePanel(Snake snake, PointCircle apple){
        this.snake = snake;
        this.apple = apple;

        //Setup of panel
        setLayout(new BorderLayout());


        //Creation of a score label which will go into the frame
        scoreLabel = new JLabel("Score: " + currentScore+"\n");
        //Set formatting: colour, location & size of label
        scoreLabel.setForeground(Color.white);
        scoreLabel.setFont(new Font("Courier New", Font.BOLD, 15));
        scoreLabel.setHorizontalAlignment(JLabel.CENTER);
        add(scoreLabel, BorderLayout.NORTH);

        centerTitle = new JLabel("");
        centerTitle.setHorizontalAlignment(JLabel.CENTER);
        centerTitle.setFont(new Font("Courier New", Font.ITALIC, 100));
        centerTitle.setVisible(false);
        add(centerTitle, BorderLayout.CENTER);

        centerText = new JLabel("");
        centerText.setForeground(Color.decode("#c1e1e7"));
        centerText.setHorizontalAlignment(JLabel.CENTER);
        centerText.setFont(new Font("Courier New", Font.ITALIC, 20));
        centerText.setVisible(false);
        add(centerText, BorderLayout.SOUTH);
    }

    public static void updateScore() {
        scoreLabel.setText("Score: " + currentScore);
    }

    public static void updateCenterText(String state){
        switch (state) {
            case "start":
                centerTitle.setForeground(Color.decode("#7ea4b3"));
                centerTitle.setText("SNAKE");
                centerText.setText("<html></br>Use the arrow keys to move & Esc to pause.<br/>Click anywhere to start!</html>");
                centerTitle.setVisible(true);
                centerText.setVisible(true);
                break;
            case "paused":
                centerTitle.setForeground(Color.decode("#7ea4b3"));
                centerTitle.setText("PAUSED");
                centerText.setText("Click anywhere to resume...");
                centerTitle.setVisible(true);
                centerText.setVisible(true);
                break;
            case "over":
                centerTitle.setText("Game Over ...");
                centerTitle.setForeground(Color.decode("#f0908a"));
                centerText.setText(Scores.getTopTen());
                centerTitle.setVisible(true);
                centerText.setVisible(false);
                break;
            case "play": //if playing clear center Text
                centerTitle.setVisible(false);
                centerText.setVisible(false);
                break;
        }
    }


    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(snake.snakeColour);

        // Draw the head square on the board
        g.fillRect(snake.head.posX, snake.head.posY, snake.partSize, snake.partSize);
        System.out.println("Drawing snake head @ x:"+ snake.head.posX +" & y:" + snake.head.posY);

        // Drawing of all remaining snake parts
        for (Square p : snake.snakePosArray) {
            System.out.println("Drawing snake body part @ x:"+ p.posX +" & y:" + p.posY);
            g.fillRect(p.posX, p.posY, snake.partSize, snake.partSize);
        }

        // Drawing of all apple parts
        System.out.println("Drawing apple @ x:"+ apple.posX +" & y:" + apple.posY);
        g.fillOval(apple.posX, apple.posY, apple.radius, apple.radius);

        setBackground(background);
    }

}
