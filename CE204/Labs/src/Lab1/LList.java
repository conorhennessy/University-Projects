package Lab1;

class ListCell
{ char data;
    ListCell next;

    public ListCell(char x, ListCell c)
    { data = x;
        next = c;
    }
}

class ListException extends RuntimeException
{ public ListException(String s)
{ super(s);
}
}

// interface for exercise 6
interface LListIterator
{ public boolean hasNext();
    public char next();
    public void remove();
}

public class LList
{ private ListCell front;

    public LList()
    { front = null;
    }

    public void addToFront(char x)
    { front = new ListCell(x, front);
    }

    public void addToBack(char x)
    { if (front==null)
        front = new ListCell(x, front);
    else
    { ListCell c = front;
        while (c.next != null)
            c = c.next;
        c.next = new ListCell(x, null);
    }
    }

    public char elementAt(int n)
    { ListCell c = front;
        if (n<0)
            throw new ListException("elementAt called with negative argument");
        for (int i = 0; i<n; i++)
        { if (c == null)
            throw new ListException("no element at position "+n);
            c = c.next;
        }
        if (c == null)
            throw new ListException("no element at position "+n);
        return c.data;
    }

    public int length()
    {
        int count = 0;
        ListCell c = front;
        while (c != null) {
            count += 1;
            c = c.next;
        }
        return count;
    }

    public int occs(char c)
    {
        int occs = 0;
        ListCell cell = front;
        while (cell != null){
            if (cell.data == c){  //if contents of cell is the char we are looking for
                occs += 1;
            }
            cell = cell.next;
        }
        return occs;
    }

    public void removeFront()
    {
        if (length() == 0) System.out.println("The list is empty and so unable to remove the front!");
        front = front.next;
    }

    public void removeBack() {
        if (length() == 0) System.out.println("The list is empty and so unable to remove the front!");
        if (front.next == null) { // treat a one-element list as a special case
            front = null;
        }
        ListCell cell = front.next;
        while (cell != null) {
            if (cell.next.next == null) {
                cell.next = null;
            }
            cell = cell.next;
        }
    }

    public boolean remove(char c)
    {
        boolean status = false;
        if (occs(c) == 0) {
            System.out.println("Char '" + c + "' does not occur in the list and so unable to remove.");
        }
        else {
            ListCell cell = front;
            for (int i = 0; i < length(); i++){
                if (elementAt(i + 1) == c){
                    cell.next = cell.next.next;
                    status = true;
                    System.out.println("Char '" + c + "' removed");
                    break;
                }
                cell = cell.next;
            }
        }
        return status;
    }



    public String toString()
    { StringBuffer sb = new StringBuffer("<");
        ListCell c = front;
        while (c != null)
        { sb.append(c.data);
            c = c.next;
        }
        return(sb+">");
    }

    // main method to test the class - expected list contents shown as comments

    public static void main(String args[])
    { LList myList = new LList(); // <>
        System.out.println(myList);
        System.out.println("Length of list: " + myList.length());
        myList.addToFront('c');     // <c>
        myList.addToFront('b');     // <bc>
        myList.addToFront('a');     // <abc>
        System.out.println(myList);
        System.out.println("Length of list: " + myList.length());
        myList.addToBack('d');      // <abcd>
        myList.addToBack('e');      // <abcde>
        System.out.println(myList);
        System.out.println("Length of list: " + myList.length());

        System.out.println("Remove front of list...");
        System.out.println("Old list: " + myList);
        myList.removeFront(); // <bcde>
        System.out.println("New list: " +  myList);
        System.out.println("New length of list: " + myList.length());

        System.out.println("Remove back of list...");
        System.out.println("Old list: " + myList);
        myList.removeBack(); // <bcd>
        System.out.println("New list: " +  myList);
        System.out.println("New length of list: " + myList.length());

        System.out.println("Remove the letter e");
        myList.addToBack('e');      // <bcde>
        myList.addToBack('e');      // <bcdee>
        myList.addToBack('e');      // <bcdeee>
        myList.addToBack('f');      // <bcdeeef>
        myList.addToBack('e');      // <bcdeeefe>
        myList.addToBack('g');      // <bcdeeefeg>
        myList.addToBack('e');      // <bcdeeefege>
        System.out.println("Old list now: " + myList);
        myList.remove('f');  // <bcdeeeege>
        System.out.println("New list now: " + myList);


        System.out.println("\n Number of occurrences of b: " + myList.occs('b'));  //1
        System.out.println("Number of occurrences of h: " + myList.occs('h'));  //0

        System.out.println();
        for (int i = -1; i<7; i++)
            try
            { System.out.println(myList.elementAt(i));
            }
            catch (ListException e)
            { System.out.println("ERROR: "+e);
            }
    }
}