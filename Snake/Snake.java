import javafx.util.Pair;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Snake{
    protected Color snakeColour = Color.decode("#c9c9c9");
    protected int partSize = 20;
    Integer startX;
    Integer startY;
    int currentDir;


    List<Point> snakePosArray = new ArrayList<>();

    public Snake(){
        //Create the initial snake position
        this.startX = 415;
        this.startY = 290;

        this.currentDir = 0;

        // Head of snake is always at pos 0 in Array
        snakePosArray.add(new Point(startX, startY));
    }

    public List<Point> getSnakePosArray() {
        return snakePosArray;
    }

    public int moveSnake(int direction){
        if (direction == 1){ //left
            System.out.println("Snake now heading left");  // these souts are for debugging
            snakePosArray.set(0, new Point((snakePosArray.get(0).x - partSize), (snakePosArray.get(0).y - partSize))); //TODO tidy this
        }
        if (direction == 2){ //up
            System.out.println("Snake now heading up");
        }
        if (direction == 3){ //right
            System.out.println("Snake now heading right");
        }
        if (direction == 4){ //down
            System.out.println("Snake now heading down");
        }
        if (direction == 0){
            //initial state don't move. Also arises when game is paused.
        }
        currentDir = direction;
        return direction;
    }

    public static void addSnakePart(){
        //add extra blob to end
        //coordinateArray[numberOfElements] = coordinate;
        //numberOfElements ++;
    }
}

//class head extends Snake{
  //  public head(List<Integer> snakePos, Color snakeColour) {
        //this.direction = direction;
    //}
//}