import javax.swing.*;
import java.awt.*;


public class GamePanelHandler extends JPanel {
    Snake snake;

    public GamePanelHandler(Snake snake){
        this.snake = snake;
    }

    public void paintComponent(Graphics g) {
        // draw a black squares across the board
        g.setColor(snake.snakeColour);
        g.fillRect( 100,  100, 20, 20);
    }

}
