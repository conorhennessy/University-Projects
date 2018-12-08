import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Snake extends Shape{
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

    boolean boundaryHit = false;
    public int moveSnake(int direction, Component comp){

        //Check if the snake is about to move out of the frame
        // If so correct the x or y values as appropriate
        System.out.println();
        if (!boundaryHit) {
            if (snakePosArray.get(0).x < 0) {
                System.out.println("HIT left");
                snakePosArray.set(0, new Point(820 + partSize, snakePosArray.get(0).y));
                boundaryHit = true;
            }
            if (snakePosArray.get(0).x > 840) {
                System.out.println("HIT right");
                snakePosArray.set(0, new Point(0 - partSize, snakePosArray.get(0).y));
                boundaryHit = true;
            }
            if (snakePosArray.get(0).y < 0) {
                System.out.println("HIT top");
                snakePosArray.set(0, new Point(snakePosArray.get(0).x, 520 + partSize));
                boundaryHit = true;
            }
            if (snakePosArray.get(0).y > 540) {
                System.out.println("HIT bottom");
                snakePosArray.set(0, new Point(snakePosArray.get(0).x, 0 - partSize));
                boundaryHit = true;
            }
        }
        else boundaryHit = false;



        switch (direction) {
            case 1: //left
                System.out.println("Snake now heading left");  // these souts are for debugging
                snakePosArray.set(0, new Point(snakePosArray.get(0).x - partSize, snakePosArray.get(0).y));
                break;
            case 2: //up
                System.out.println("Snake now heading up");
                snakePosArray.set(0, new Point(snakePosArray.get(0).x, snakePosArray.get(0).y - partSize));
                break;
            case 3: //right
                System.out.println("Snake now heading right");
                snakePosArray.set(0, new Point(snakePosArray.get(0).x + partSize, snakePosArray.get(0).y));
                break;
            case 4: //down
                System.out.println("Snake now heading down");
                snakePosArray.set(0, new Point(snakePosArray.get(0).x, snakePosArray.get(0).y + partSize));
                break;
            case 0: //initial state don't move. Also arises when game is paused.
                break;
        }

        comp.repaint();  //as the snake is moved, repaint

        currentDir = direction;
        return direction;
    }

    public static void addSnakePart(){
        //add extra blob to end
        //coordinateArray[numberOfElements] = coordinate;
        //numberOfElements ++;
    }

    @Override
    public void setSize(int x) {

    }

    @Override
    public void rotateShape(int rotation) {

    }
}

//class head extends Snake{
  //  public head(List<Integer> snakePos, Color snakeColour) {
        //this.direction = direction;
    //}
//}