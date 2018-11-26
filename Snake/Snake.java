import java.util.List;

class Snake{
    List<Integer> snakePos;

    public Snake(List<Integer> snakePos){
        this.snakePos = snakePos;
    }
}

class head extends Snake{
    public head(List<Integer> snakePos) {
        super(snakePos);
        //this.direction = direction;
    }
}


