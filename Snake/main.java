import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class main {
    public static void main(String[] args) {

        //Init of snake & apple and triangles - the points which the snake can eat
        Snake snake = new Snake();
        PointCircle apple = new PointCircle();
        PointTriangle triangle = new PointTriangle();

        //Creation of panel which houses the game items - snake, an apple and sometimes a triangle
        GamePanel tv = new GamePanel(snake, apple, triangle);


        GameFrame gameFrame = new GameFrame(tv, "Snake - Submitted by: 1703055", snake);   //a frame to hold all of the game. See to class for how all actions are handled

        gameFrame.add(tv, BorderLayout.CENTER);

        //Timer to handle each frame of the game.  Where methods called depend on current state of the game
        Timer timer = new Timer(snake.tickDelay, new ActionListener() {
            public int tickCount = 0;  //variable used to count the time since the bonus triangle last appeared so that only every 5 frames can the triangle reappear

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
                //if game is greatly in a state for play
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
                //if the game needs to be held in the over state.  This is necessary as the 'over' state needs to be held once the save dialog is complete. Only leaves over when the user clicks to do so.
                else if (GamePanel.holdOver){
                    GamePanel.updateCenterText("over");
                    snake.head.move(420, 300);
                    snake.snakePosArray.clear();
                    GamePanel.currentScore = 0;
                }
                else {
                    GamePanel.updateCenterText("over");
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