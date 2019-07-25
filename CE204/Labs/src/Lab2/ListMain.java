package Lab2;

public class ListMain {

public static <T> LList<T> presentInBoth(LList<T> listA, LList<T> listB) {
    LList<T> matches = new LList<>();
    T current;
    for (int i = 0; i < listA.length(); i++) {
        current = listA.elementAt(i);
        if (listB.find(current) > -1) {
            if (matches.find(current) == -1) {
                matches.addToBack(current);
            }
        }
    }
    return matches;
}


public static void main(String args[]) {
    LList<Integer> myList = new LList<>(); // <>
    System.out.println(myList);
    System.out.println("length = " + myList.length());
    myList.addToFront(5);     // <5>
    myList.addToFront(4);     // <4 5>
    myList.addToFront(3);     // <3 5 4 5>
    System.out.println(myList);
    myList.addToBack(8);      // <3 4 5 8>
    myList.addToBack(8);      // <3 4 5 8 9>
    myList.addToBack(20);      // <3 4 5 8 9 20>
    myList.addToBack(45);      // <3 4 5 8 9 20 45>

    System.out.println(myList);
    System.out.println("length = " + myList.length());
    System.out.println("Number 8 is at index = " + myList.find(8) +  "(-1 returned if not found)");
    for (int i = 0; i<7; i++)
        try {
        System.out.println(myList.elementAt(i));
        }
        catch (ListException e) {
        System.out.println("ERROR: "+e);
        }

    LList<String> mySList = new LList<>();
    mySList.addToFront("hello");
    mySList.addToBack("goodbye");
    System.out.println(mySList);



    LList<Integer> myTestList = new LList<>(); // <>
    myTestList.addToBack(1);
    myTestList.addToBack(2);
    myTestList.addToBack(3);
    myTestList.addToBack(6);
    myTestList.addToBack(8);
    myTestList.addToBack(11);
    myTestList.addToBack(11);
    myTestList.addToBack(11);
    System.out.println(myTestList);
    System.out.println("Items found in both lists " + presentInBoth(myList, myTestList));

    myTestList.removeAll(11);
    System.out.println("Removed 11 from myTestList\n" + myTestList );
}
}
