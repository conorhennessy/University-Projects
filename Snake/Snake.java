import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Snake{
    Color snakeColour = Color.decode("#c9c9c9");
    int partSize = 20;
    int currentDir;
    Integer startX;
    Integer startY;
    Square head;
    Component comp;

    List<Square> snakePosArray = new ArrayList<>();

    public Snake(){
        //Create the initial snake position
        this.startX = 420;
        this.startY = 300;

        this.currentDir = 0;

        // Head of snake created
        head = new Square(startX, startY, partSize);
    }


    public void moveSnake() {
        //Shuffle all snake parts along. As the next part just inherits the part at index i-1
        if (snakePosArray.size() > 0) {
            for (int i = snakePosArray.size() - 1; i >= 1; i--) {
                System.out.println("Shuffelllll");
                //snakePosArray.set(i, snakePosArray.get(i - 1));
                snakePosArray.get(i).posX = snakePosArray.get(i-1).posX;
                snakePosArray.get(i).posY = snakePosArray.get(i-1).posY;

            }
            snakePosArray.get(0).posY=head.posY;
            snakePosArray.get(0).posX=head.posX;
        }
    }

    boolean boundaryHit = false;
    public int moveHead(int direction){
        //Move head based on direction intended
        switch (direction) {
            case 1: //left
                System.out.println("Snake heading left");  // these souts are for debugging
                head.move(head.posX - partSize, head.posY);
                break;
            case 2: //up
                System.out.println("Snake heading up");
                head.move(head.posX, head.posY - partSize);
                break;
            case 3: //right
                System.out.println("Snake heading right");
                head.move(head.posX + partSize, head.posY);
                break;
            case 4: //down
                System.out.println("Snake heading down");
                head.move(head.posX, head.posY + partSize);
                break;
        }

        //Check if the snake is about to move out of the frame
        // If so correct the x or y values as appropriate
        System.out.println();
        if (!boundaryHit) {
            if (head.posX < 0) {
                System.out.println("HIT left");
                head.move(840 , head.posY);
                boundaryHit = true;
            }
            if (head.posX > 840) {
                System.out.println("HIT right");
                head.move(0, head.posY);
                boundaryHit = true;
            }
            if (head.posY < 0) {
                System.out.println("HIT top");
                head.move(head.posX, 560);
                boundaryHit = true;
            }
            if (head.posY > 560) {
                System.out.println("HIT bottom");
                head.move(head.posX, 0);
                boundaryHit = true;
            }
        }
        else boundaryHit = false;


        currentDir = direction;
        return direction;
    }


    public void addSnakePart(){
        // Add extra blob to end by adding a square which is at the current head position
        // Then move the old head by calling move snake?
        Square newPart;
        if (snakePosArray.size() == 0){
            newPart = new Square(head.posX, head.posY, partSize);
        }
        else {
            newPart = new Square(snakePosArray.get(snakePosArray.size()-1).posX, snakePosArray.get(snakePosArray.size()-1).posY, partSize);
        }
        snakePosArray.add(newPart);
    }

    public boolean checkAppleCollision(PointCircle apple) {
        if (head.posX.equals(apple.posX) && head.posY.equals(apple.posY)){
            System.out.println("NOM NOM NOM Snek eat apple");
            GamePanel.currentScore++;
            apple.newLocation();
            addSnakePart();
            return true;
        }
        else return false;
    }

    public boolean checkSnakeCollision() {
        for (int i = 1; i < snakePosArray.size(); i++) {
            if (head.posX.equals(snakePosArray.get(i).posX) && head.posY.equals(snakePosArray.get(i).posY)){
                System.out.println("YOU DEAD");
                GamePanel.gameOver = true;
            }
        }
        return GamePanel.gameOver;
    }

}