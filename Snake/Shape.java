import java.util.Random;

public abstract class Shape {
    Integer posX;
    Integer posY;

    public void move(int x, int y){
            posX = x;
            posY = y;
    }

    public abstract void setSize(int x);

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

}


class PointCircle extends Shape{  //Circles will be one of the points that player needs to pick up, worth 1 point
    Integer radius;
    Random generator = new Random();

    public PointCircle() {
        //range bound divided by 20 and then random value multiplied by 20 to ensure that the random x / y is a multiple of 20 so snake can catch it
        this.posX = generator.nextInt(850 / 20 ) * 20;
        this.posY = generator.nextInt(560 / 20 ) * 20;
        this.radius = 18;
    }

    public void newLocation(){
        posX = generator.nextInt(850 / 20 ) * 20;
        posY = generator.nextInt(560 / 20 ) * 20;
    }

    @Override
    public void setSize(int x) {
        radius = x;
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

    public void rotateShape(int rotation) {

    }

}