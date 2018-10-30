import java.awt.*;

public class Square extends Shape {
    int sideLength;

    public Square(Integer posX, Integer posY, Integer sideLength) {
        this.posX = posX;
        this.posY = posY;
        this.sideLength = sideLength;
    }

    @Override
    public void setSize(int x) {
        sideLength = x;
    }

    @Override
    public double getArea() {
        double area = Math.pow(sideLength, 2);
        return area;
    }

    public String info(){
        return "Square with length: "+sideLength+" & area of "+getArea();
    }

}