import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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


        int time_interval = 150;

        Timer timer = new Timer(time_interval, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // if game start
                if (GamePanel.gameStart){
                    GamePanel.updateCenterText("start");
                }
                //if game paused
                else if (GamePanel.gamePause){
                    GamePanel.updateCenterText("paused");
                }
                else if (!GamePanel.gameOver && !(GamePanel.gameStart || GamePanel.gamePause)){
                    GamePanel.updateCenterText("play");
                    snake.checkAppleCollision(apple);
                    snake.moveSnake();
                    snake.moveHead();
                    snake.checkSnakeCollision();
                    GamePanel.updateScore();
                    tv.repaint();
                }
                else if (GamePanel.holdOver){
                    //TODO add additional state that will just show the scoreboard kinda like pause
                    GamePanel.updateCenterText("over");
                    System.out.println("GAME OVER");
                    Scores.getTopTen();
                }
                else {
                    GamePanel.updateCenterText("over");
                    System.out.println("GAME OVER");
                    Scores.getTopTen();
                    Scores.saveScore(tv);
                    snake.head.move(420, 300);
                    snake.snakePosArray.clear();
                    GamePanel.currentScore = 0;
                    //timer.stop();
                }
            }
        });
        timer.start();

    }
}