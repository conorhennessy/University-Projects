package Exercise2;

public abstract class Shape {
    protected String name = "shape";
    protected String color = "black";

    public void printName() {
        System.out.println("I am a " + color + " " + name);
    }

    public abstract void draw();
}