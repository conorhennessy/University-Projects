package Exercise2;

public class Circle extends Shape {
    // Def attributes for Circle objects
    protected int centerX;
    protected int centerY;
    protected int radius;
    protected double area;


    public Circle(int centerX, int centerY, int radius) {
        //Constructor for Circle objects
        this.name = "circle";
        this.centerX = centerX;
        this.centerY = centerY;
        this.radius = radius;
        this.area = Math.PI * Math.pow(radius, 2);   //
    }

    public void draw() {
        System.out.println("\n This is a circle with center(" + centerX + ", " + centerY + ") and radius" + radius + ".\nAlso the circle has an area of: " + String.format("%.1f",area));
    }
}