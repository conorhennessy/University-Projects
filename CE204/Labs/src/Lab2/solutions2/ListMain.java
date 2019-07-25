package Lab2.solutions2;

public class ListMain
{ public static void main(String args[])
  { LList<Integer> myList = new LList<Integer>(); // <>
    System.out.println(myList);
    System.out.println("length = " + myList.length());
    myList.addToFront(5);     // <5>
    myList.addToFront(4);     // <45>
    myList.addToFront(3);     // <345>
    System.out.println(myList);
    myList.addToBack(8);      // <3458>
    myList.addToBack(9);      // <34589>
    System.out.println(myList);
    System.out.println("length = " + myList.length());
    for (int i = 0; i<7; i++)
      try
      { System.out.println(myList.elementAt(i));
      }
      catch (ListException e)
      { System.out.println("ERROR: "+e);
      }

    LList<String> mySList = new LList<String>();
    mySList.addToFront("hello");
    mySList.addToBack("goodbye");
    System.out.println(mySList);

    System.out.println("first occurence of 5 at "+myList.find(5));  // should be 2
    System.out.println("first occurence of 7 at "+myList.find(7));  // should be -1

    LList<Integer> otherList = new LList<Integer>();
    otherList.addToBack(4);
    otherList.addToBack(8);
    otherList.addToBack(6);
    otherList.addToBack(4);
    otherList.addToBack(7);
    otherList.addToBack(7);
    otherList.addToBack(3);

    printCommonObjects(otherList, myList);  // 3, 4 and 8 should be output

    otherList.removeAll(7);
    System.out.println(otherList);
    removeCommonObjects(myList,otherList);
    System.out.println(otherList);

  }

  // exercise 3
  public static <T> void printCommonObjects(LList<T> l1, LList<T> l2)
  { for (int i = 0; i<l1.length(); i++)
    { T x = l1.elementAt(i);
      if (l1.find(x)==i && l2.find(x)!=-1)
                      // l1.find(x)==i is used to check if this is the first occurrence of x
                      // if it's not x will have been output already (if it's in l2)
        System.out.println(x);
    }
  }

  // exercise 5
  public static <T> void removeCommonObjects(LList<T> l1, LList<T> l2)
  { for (int i = 0; i<l1.length(); i++)
      l2.removeAll(l1.elementAt(i));
  }
}
