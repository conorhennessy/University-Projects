import java.util.List;
import java.util.Vector;

public class Exercise3 {
    static void replaceNegList(List<Integer> l){
        int i = 0;
        for (Integer x:l){
            l.set(i, new Integer(Math.abs(x)));
            i++;
        }
    }

    public static void main(String[] args) {
        Vector<Integer> vec = new Vector<Integer>();
        vec.add(45);
        vec.add(-80);
        vec.add(3);
        vec.add(-23);
        vec.add(-345);
        replaceNegList(vec);
        System.out.println("The list has had all negative values replaced.  The list now shows as " + vec);
    }
}
