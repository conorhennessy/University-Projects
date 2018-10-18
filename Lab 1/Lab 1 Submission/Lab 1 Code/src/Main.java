import Exercise3.*;
import Exercise2.*;

public class Main {

    public static void main(String[] args) {
        //Main for Exercise 2 for Shapes
        Shape[] shapes = new Shape[3];
        shapes[0] = new Circle(300,100,20);
        shapes[1] = new Rectangle(100,100,40,60);
        shapes[2] = new RedRectangle(200,200,20,30);

        for(Shape shape:shapes)

        {
            shape.printName();
            shape.draw();
        }



        //Main for Exercise 3 for Employee
        employee[] employees =  new employee[3];
        employees[0] = new managers("Bob", 50000, "15/01/1986", "National HQ", 67, 12);
        employees[1] = new sales("James", 18000, "23/10/1984", "London Office", 53, 75);
        employees[2] = new development("Patrick", 28000,"18/8/1978", "new payment system", "finance",7);

        for(employee employee:employees)

        {
            employee.details();
            employee.information();
        }

    }
}