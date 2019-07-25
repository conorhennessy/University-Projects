package ass;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

public class Icosahedron {
    private double edge;
    private static int count = 0;

    public Icosahedron(double edge) {
        this.edge = edge;
        count++;
    }

    public static double surface(double edge) { return 5 * sqrt(3) * pow(edge, 2); }

    public static double volume(double edge) { return ( 5 * (3 + sqrt(5)) / 12 ) * pow(edge, 3); }

    @Override
    public String toString() {
        return String.format("Icosahedron[edge=%s, surface=%s, volume=%s]", String.format("%7.3f", edge), String.format("%7.3f", surface(edge)), String.format("%7.3f", volume(edge)));
    }

    public static int getCount() { return count; }

    public static void main(String[] args) {
        System.out.println("Number of Icosahedron objects created: " + getCount());
        Icosahedron[] icos = new Icosahedron[4];
        for (int i = 0; i < icos.length; i++)
            icos[i] = new Icosahedron(i+1);
        for (int i = 0; i < icos.length; i++)
            System.out.println(icos[i]);
        System.out.println("Number of Icosahedron objects created: " + getCount());
    }
}