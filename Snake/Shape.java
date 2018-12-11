import java.awt.*;
import java.util.ArrayList;
import java.util.List;
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


class PointTriangle extends Shape{ // Triangles will be another shape the snake player will go for, more rare and worth 3 points  TODO
    Integer sideLength;

    int Xpositions[];
    int Ypositions[];

    Random generator = new Random(System.currentTimeMillis());

    Color randColour;

    Boolean exists;


    public PointTriangle() {
        this.posX = generator.nextInt(850 / 20) * 20;
        this.posY = generator.nextInt(560 / 20) * 20;
        this.sideLength = 20;

        this.exists = true;

        this.Xpositions = new int[]{posX + 10, posX + 20, posX};
        this.Ypositions = new int[]{posY, posY + 20, posY + 20};

        setRandColour();
    }

    public void newLocation() {
        float chance = generator.nextFloat();

        if (!exists && chance <= 0.08) {  //if triangle dose not exist that there is a chance of triangle coming back
            System.out.println("triangle on screen");
            posX = generator.nextInt(850 / 20) * 20;
            posY = generator.nextInt(560 / 20) * 20;
            exists = true;
        } else exists = false;


        Xpositions = new int[]{posX + 10, posX + 20, posX};
        Ypositions = new int[]{posY, posY + 20, posY + 20};

        setRandColour();
    }

    public void setRandColour(){
        int r = generator.nextInt(255);
        int g = generator.nextInt(225);
        int b = generator.nextInt(255);

        this.randColour = new Color(r, g, b).brighter();
    }



    @Override
    public void setSize(int x) {
        sideLength = x;
    }

}