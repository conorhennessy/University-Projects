import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Snake{
    protected Color snakeColour = Color.decode("#c9c9c9");
    protected int partSize = 20;
    Integer startX;
    Integer startY;
    int currentDir;
    Square head;

    List<Square> snakePosArray = new ArrayList<>();

    public Snake(){
        //Create the initial snake position
        this.startX = 415;
        this.startY = 290;

        this.currentDir = 0;

        // Head of snake is always at pos 0 in Array
        snakePosArray.add(new Square(startX, startY, partSize));
        head = snakePosArray.get(0);
    }

    public List<Square> getSnakePosArray() {
        return snakePosArray;
    }

    boolean boundaryHit = false;
    public int moveSnake(int direction, Component comp){

        //Check if the snake is about to move out of the frame
        // If so correct the x or y values as appropriate
        System.out.println();
        if (!boundaryHit) {
            if (head.posX < 0) {
                System.out.println("HIT left");
                //snakePosArray.set(0, new Square(820 + partSize, snakePosArray.get(0).posY, partSize));
                head.move(820 + partSize, head.posY);
                boundaryHit = true;
            }
            if (head.posX > 840) {
                System.out.println("HIT right");
                //snakePosArray.set(0, new Square(0 - partSize, snakePosArray.get(0).posY, partSize));
                head.move(0 - partSize, head.posY);
                boundaryHit = true;
            }
            if (head.posY < 0) {
                System.out.println("HIT top");
                //snakePosArray.set(0, new Square(snakePosArray.get(0).posX, 520 + partSize, partSize));
                head.move(head.posX, 520 + partSize);
                boundaryHit = true;
            }
            if (head.posY > 540) {
                System.out.println("HIT bottom");
                //snakePosArray.set(0, new Square(snakePosArray.get(0).posX, 0 - partSize, partSize));
                head.move(head.posX, 0 - partSize);
                boundaryHit = true;
            }
        }
        else boundaryHit = false;



        switch (direction) {
            case 1: //left
                System.out.println("Snake now heading left");  // these souts are for debugging
                //snakePosArray.set(0, new Square(snakePosArray.get(0).posX - partSize, snakePosArray.get(0).posY, partSize));
                head.move(head.posX - partSize, head.posY);
                break;
            case 2: //up
                System.out.println("Snake now heading up");
                //snakePosArray.set(0, new Square(snakePosArray.get(0).posX, snakePosArray.get(0).posY - partSize, partSize));
                head.move(head.posX, head.posY - partSize);
                break;
            case 3: //right
                System.out.println("Snake now heading right");
                //snakePosArray.set(0, new Square(snakePosArray.get(0).posX + partSize, snakePosArray.get(0).posY, partSize));
                head.move(head.posX + partSize, head.posY);
                break;
            case 4: //down
                System.out.println("Snake now heading down");
                //snakePosArray.set(0, new Square(snakePosArray.get(0).posX, snakePosArray.get(0).posY + partSize, partSize));
                head.move(head.posX, head.posY + partSize);
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
}

//class head extends Snake{
  //  public head(List<Integer> snakePos, Color snakeColour) {
        //this.direction = direction;
    //}
//}