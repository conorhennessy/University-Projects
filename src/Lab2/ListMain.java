package Lab2;

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
  }
}
