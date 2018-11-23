import java.util.ArrayList;
import java.util.Iterator;

public class Statistics {
    //Exercise 1
    //Three methods for finding the maximum, minimum and average as requested using iterators
    static int maximum(ArrayList<Integer> list){
        Iterator iter = list.iterator();
        Integer max = Integer.MIN_VALUE;
        while (iter.hasNext()){
            Integer value = (Integer) iter.next();
            if (value > max){
                max = (Integer) iter.next();
            }
        }
        return max;
    }

    static int minimum(ArrayList<Integer> list){
        Iterator iter = list.iterator();
        Integer min = Integer.MAX_VALUE;
        while (iter.hasNext()){
            Integer value = (Integer) iter.next();
            if (value < min){
                min = (Integer) iter.next();
            }
        }
        return min;
    }

    static double average(ArrayList<Integer> list){
        Iterator iter = list.iterator();
        Integer sum = 0;
        while (iter.hasNext()){
            Integer value = (Integer) iter.next();
            sum += value;
        }
        return sum / list.size();
    }

    //Three methods again for finding the minimum, maximum and average values but with for loops instead
    static int maximumWithFor(ArrayList<Integer> list){
        Integer max = Integer.MIN_VALUE;
        for (int i = 0; i < list.size(); i++)
            if (list.get(i) > max){
                max = list.get(i);
            }
        return max;
    }

    static int minimumWithFor(ArrayList<Integer> list){
        Integer min = Integer.MAX_VALUE;
        for (int i = 0; i < list.size(); i++)
            if (list.get(i) < min){
                min = list.get(i);
            }
        return min;
    }

    static double averageWithFor(ArrayList<Integer> list){
        Integer sum = 0;
        for (int i = 0; i < list.size(); i++){
            sum += list.get(i);
        }
        return sum / list.size();
    }


    // Main method to test the implementations of methods created
    public static void main(String[] args) {
        // Creation of an ArrayList to be used for testing
        ArrayList test = new ArrayList<>();
        test.add(5);
        test.add(1);
        test.add(7);
        test.add(9);
        test.add(3);

        //Output of the results found with iterator methods
        System.out.println("Values found with the use of iterators... \nMaximum value: "+maximum(test)+"\nMinimum value: "+minimum(test)+"\nAverage of list: "+average(test));

        //Output of the results found with the use of for loops methods
        System.out.println("\nValues found with the use of for loops... \nMaximum value: "+maximumWithFor(test)+"\nMinimum value: "+minimumWithFor(test)+"\nAverage of list: "+averageWithFor(test));

    }
}
