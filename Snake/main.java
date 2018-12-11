import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class main {
    public static void main(String[] args) {

        //Init of snake and all the relevant atts
        Snake snake = new Snake();

        //init of apple and triangles, the points which the snake can eat
        PointCircle apple = new PointCircle();
        PointTriangle triangle = new PointTriangle();

        GamePanel tv = new GamePanel(snake, apple, triangle);


        //Creation of a frame to hold all of the game
        GameFrame gameFrame = new GameFrame(tv, "Snake - Submitted by: 1703055", snake);

        gameFrame.add(tv, BorderLayout.CENTER);


        Timer timer = new Timer(snake.tickDelay, new ActionListener() {
            public int tickCount = 0;

            @Override
            public void actionPerformed(ActionEvent e) {
                tickCount += 1;
                // if game start
                if (GamePanel.gameStart){
                    GamePanel.updateCenterText("start");
                }
                //if game paused
                else if (GamePanel.gamePause){
                    GamePanel.updateCenterText("paused");
                }
                else if (!GamePanel.gameOver && !(GamePanel.gameStart || GamePanel.gamePause)) {
                    GamePanel.updateCenterText("play");
                    snake.checkAppleCollision(apple);
                    if (triangle.exists){
                        snake.checkTriangleCollision(triangle);
                        //triangle.newLocation();
                    }
                    if (!triangle.exists && tickCount > 5) {  // so every 5 ticks there is a chance of triangle reappearing
                        tickCount = 0;
                        triangle.newLocation();
                    }
                    triangle.setRandColour();
                    snake.moveSnake();
                    snake.moveHead();
                    snake.checkSnakeCollision();
                    GamePanel.updateScore();
                    tv.repaint();
                }
                else if (GamePanel.holdOver){
                    GamePanel.updateCenterText("over");
                    Scores.getTopTen();
                    snake.head.move(420, 300);
                    snake.snakePosArray.clear();
                    GamePanel.currentScore = 0;
                }
                else {
                    GamePanel.updateCenterText("over");
                    Scores.getTopTen();
                    snake.head.move(420, 300);
                    Scores.saveScore(tv);
                    snake.snakePosArray.clear();
                    GamePanel.currentScore = 0;
                }
            }
        });
        timer.start();

    }
}