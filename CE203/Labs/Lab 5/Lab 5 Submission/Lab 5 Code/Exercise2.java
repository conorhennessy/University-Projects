import java.util.ArrayList;
import java.util.List;

public class Exercise2 {
    // SharedItems method which compares two lists in order to find terms which are found in both lists. Returns sharedList of all terms matching
    static List<Integer> sharedItems(List<Integer> list1, List<Integer> list2) {
        System.out.println("List 1: " + list1 + "\nList 2: " + list2);
        List<Integer> sharedList = new ArrayList<>();
        try {
            for (Integer x : list1) {
                for (Integer y : list2){
                    if (x == y) {
                        sharedList.add(x);
                    }
                }
            }
            System.out.println("\nThe shared item(s) between these two lists are... " + sharedList);
        }
        catch (Exception e){
            System.out.println("Unable to find any matches between the two lists...");
        }

        return sharedList;
    }

    public static void main(String[] args) {
        // Creation of two ArrayLists to be used for testing
        List<Integer> firstList = new ArrayList<>();
        firstList.add(5);
        firstList.add(3);
        firstList.add(7);
        firstList.add(2);
        firstList.add(4);

        List<Integer> secondList = new ArrayList<>();
        secondList.add(4);
        secondList.add(7);
        secondList.add(6);
        secondList.add(5);
        secondList.add(8);

        // Call of method to make comparison between lists
        sharedItems(firstList, secondList);

    }
}
