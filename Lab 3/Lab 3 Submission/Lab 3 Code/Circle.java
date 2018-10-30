public class Circle extends Shape {
    Integer radius;

    public Circle(Integer posX, Integer posY, Integer radius){
        this.posX = posX;
        this.posY = posY;
        this.radius = radius;
    }

    @Override
    public void setLength(int x) {
        radius = x;
    }

    @Override
    public double getArea(){
        double area = Math.PI * (radius * radius);
        return area;
    }
}
