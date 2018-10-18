package Exercise2;

public class Rectangle extends Shape {
    protected int    centerX;
    protected int centerY;
    protected int length;
    protected int width;

    public Rectangle(int centerX, int centerY, int length, int width) {
        this.name = "circle";
        this.centerX = centerX;
        this.centerY = centerY;
        this.length = length;
        this.width = width;
    }

    public void draw() {
        System.out.println("This is a rectangle with center(" + centerX + "," + centerY + ")and size of: length " + length + " & width " + width);
    }
}
