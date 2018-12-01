import java.awt.*;
import java.util.List;

class Snake{
    List<Integer> snakePos;
    protected Color snakeColour = Color.decode("#c9c9c9");

    public Snake(List<Integer> snakePos){
        this.snakePos = snakePos;
    }
}

class head extends Snake{
    public head(List<Integer> snakePos, Color snakeColour) {
        super(snakePos);
        //this.direction = direction;
    }
}


