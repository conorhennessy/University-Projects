public abstract class Shape {
    Integer posX;
    Integer posY;

    public void move(int x, int y){
            posX = x;
            posY = y;
    }

    public abstract void setSize(int x);

    public abstract void rotateShape(int rotation);
}



class Square extends Shape {  // Squares will make up the snake
    int sideLength;

    public Square(Integer posX, Integer posY, Integer sideLength){
        this.posX = posX;
        this.posY = posY;
        this.sideLength = sideLength;
    }

    @Override
    public void setSize(int x) {
        sideLength = x;
    }

    @Override
    public void rotateShape(int rotation) {
        //rotate shape somehow
    }
}


class PointCircle extends Shape{  //Circles will be one of the points that player needs to pick up, worth 1 point
    Integer radius;

    public PointCircle(Integer posX, Integer posY, Integer radius) {
        this.posX = posX;
        this.posY = posY;
        this.radius = radius;
    }

    @Override
    public void setSize(int x) {
        radius = x;
    }

    @Override
    public void rotateShape(int rotation) {

    }
}


class PointTriangle extends Shape{ // Triangles will be another shape the snake player will go for, more rare and worth 3 points
    Integer sideLength;

    public PointTriangle(Integer posX, Integer posY, Integer sideLength){
        this.posX = posX;
        this.posY = posY;
        this.sideLength = sideLength;
    }

    @Override
    public void setSize(int x) {
        sideLength = x;
    }

    @Override
    public void rotateShape(int rotation) {

    }

}