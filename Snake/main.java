import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class main {
    public static void main(String[] args) {
        List<Integer> snakeArray = new ArrayList<>();
        Snake snake = new Snake(snakeArray);  //Passes an array for storing the pos of snake parts

        //Creation of a panel which will go into the frame
        GamePanelHandler tv = new GamePanelHandler(snake);


        //Creation of a frame to hold all of the game
        GameFrame gameFrame = new GameFrame(tv, "Snake - Submitted by: 1703055");


        gameFrame.add(tv, BorderLayout.CENTER);
        

    }
}