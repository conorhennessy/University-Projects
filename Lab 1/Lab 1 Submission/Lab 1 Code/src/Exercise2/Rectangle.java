package Exercise2;

public class Rectangle extends Shape {
    protected int centerX;
    protected int centerY;
    protected int length;
    protected int width;
    protected double area;

    public Rectangle(int centerX, int centerY, int length, int width) {
        this.name = "circle";
        this.centerX = centerX;
        this.centerY = centerY;
        this.length = length;
        this.width = width;
        this.area = length * width;
    }

    public void draw() {
        System.out.println("\n This is a rectangle with center(" + centerX + ", " + centerY + ") and size of: length " + length + " & width " + width + ".\nAlso the circle has an area of: " + area);
    }
}
