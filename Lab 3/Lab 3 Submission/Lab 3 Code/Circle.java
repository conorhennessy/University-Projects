    public class Circle extends Shape {
    Integer radius;

    public Circle(Integer posX, Integer posY, Integer radius){
        this.posX = posX;
        this.posY = posY;
        this.radius = radius;
    }

    @Override
    public void setSize(int x) {
        radius = x;
    }

    @Override
    public double getArea(){
        double area = Math.PI * (radius * radius);
        return area;
    }

    public String info(){
        return "Circle with radius: "+radius+" & area of "+getArea();
    }
}
