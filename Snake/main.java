import java.util.ArrayList;
import java.util.List;

public class main {
    public static void main(String[] args) {
        int w = 20;
        int h = 20;
        int[][] gridArray = new int[w][h];
        GameView tv = new GameView(gridArray);

        List<Integer> snakeArray = new ArrayList<>();
        Snake snake = new Snake(snakeArray);  //Passes an array for storing the pos of snake parts

        new GameFrame(tv, "Snake - Submitted by: 1703055");
    }
}