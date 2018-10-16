package shapes;

public class Circle extends Shape {
    protected int centerX;
    protected int centerY;
    protected int radius;

    public Circle(int centerX, int centerY, int radius) {
        this.name = "circle";
        this.centerX = centerX;
        this.centerY = centerY;
        this.radius = radius;
    }

    public void draw() {
        System.out.println("This is a circle with center(" + centerX + "," + centerY + ")and radius" + radius);
    }
}