import java.util.*;

class Lab4
{
    public static <T extends Comparable<T>> int smallest(List<T> l) {
        if (l.size()==0) return -1;
        else {
            Iterator<T> it = l.iterator();
            T smallestSoFar = it.next();
            T temp;
            int smallestPos = 0;
            int i = 1;  // used to indicate position in list of next item
            while (it.hasNext()) {
                temp = it.next();
                if (temp.compareTo(smallestSoFar) < 0) {   // compare next item (temp) with smallest so far
                    smallestSoFar = temp;   // if it's smaller update smallestSoFar and smallestPos
                    smallestPos = i;
                }
                i++;
            }
            return smallestPos;
        }
    }

    public static <T extends Comparable<T>> void deleteSmallest(List<T> l) {
        if (l.size() >= 0) {
             l.remove(smallest(l)); // delete smallest item from List
        }
        // else it does nothing if the size of l list is less than or equal to 0
    }

    public static void main(String[] args) {
        Vector<String> vec1 = new Vector<String>();
        vec1.add("Hello");
        vec1.add("world");
        vec1.add("xxxx");
        vec1.add("aardvark");
        int smallPos = smallest(vec1);
        if (smallPos!=-1)
            System.out.println("smallest entry is " + vec1.elementAt(smallPos) + " at position " + smallPos);
        Vector<Integer> vec2 = new Vector<Integer>();
        vec2.add(new Integer(47));
        vec2.add(new Integer(17));
        vec2.add(new Integer(399));
        vec2.add(new Integer(247));
        smallPos = smallest(vec2);
        if (smallPos!=-1)
            System.out.println("smallest entry is " + vec2.elementAt(smallPos) + " at position " + smallPos);
        Vector<Double> vec3 = new Vector<Double>();   //  Additional vector to test the method with other data types, Double in this case
        vec3.add(34.4);
        vec3.add(12.2);
        vec3.add(3434.5);
        vec3.add(1.33453);
        smallPos = smallest(vec3);
        if (smallPos!=-1)
            System.out.println("smallest entry is " + vec3.elementAt(smallPos) + " at position " + smallPos);

        // test of deleteSmallest method
        deleteSmallest(vec1);
        smallPos = smallest(vec1);
        System.out.println("\nSo the previously smallest entry has been removed from vec1.\n Now the smallest entry is " + vec1.elementAt(smallPos) + " at position " + smallPos);
    }
}
