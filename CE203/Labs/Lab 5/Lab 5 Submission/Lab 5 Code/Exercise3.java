import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Exercise3 {
    // a method that sorts a list (of Comparable /Integer ) in ascending order by using the selection sort method
    static List<Integer> listSort(List<Integer> list){

        List<Integer> sortedList = new ArrayList<>();

        // Sort of list using a selection sort algorithm
        for (int i = 0; i < list.size() - 1; i++){
            int pos = i;
            for (int j = i + 1; j < list.size(); j++){
                //find lowest index
                if (list.get(j) < list.get(pos))
                    pos = j;
                int smallest = list.get(pos);
                list.set(pos, list.get(i));
                list.set(i, smallest);
            }
        }

        return list;
    }

    //Similar method which uses Collections.sort to sort rather than comparable
    static  List<Integer> collectionsListSort(List<Integer> list){

        Collections.sort(list);

        return list;
    }

    public static void main(String[] args) {
        // Creation of an ArrayLists to use for testing this sort method
        List<Integer> firstList = new ArrayList<>();
        firstList.add(5);
        firstList.add(3);
        firstList.add(10);
        firstList.add(8);
        firstList.add(9);

        //Test output showing the workings of the two methods as the action upon the list.
        System.out.println("First test list of: " + firstList);
        System.out.println("Sorted in ascending order by Comparable: " + listSort(firstList));

        List<Integer> secondList = new ArrayList<>();
        secondList.add(4);
        secondList.add(7);
        secondList.add(6);
        secondList.add(5);
        secondList.add(8);

        System.out.println("\nSecond test list of: " + secondList);
        System.out.println("Sorted in ascending order by Collections.sort: " + collectionsListSort(secondList));
    }
}
