import Exercise3.*;
import shapes.*;

public class Main {

    public static void main(String[] args) {
        Shape[] shapes = new Shape[3];
        shapes[0] = new Circle(300,100,20);
        shapes[1] = new Rectangle(100,100,40,60);
        shapes[2] = new RedRectangle(200,200,20,30);

        for(Shape shape:shapes)

        {
            shape.printName();
            shape.draw();
        }


        employee[] employees =  new employee[3];
        //add employees here
    }
}