package Lab2;

class ListCell<T>
{ T data;
  ListCell<T> next;

  public ListCell(T x, ListCell<T> c)
  { data = x;
    next = c;
  }
}

class ListException extends RuntimeException
{ public ListException(String s)
  { super(s);
  }
}

public class LList<T>
{ private ListCell<T> front;

  public LList()
  { front = null;
  }

  public void addToFront(T x)
  { front = new ListCell<T>(x, front);
  }

  public void addToBack(T x)
  { if (front==null)
      front = new ListCell<T>(x, front);
    else
    { ListCell<T> c = front;
      while (c.next != null)
        c = c.next;
      c.next = new ListCell<T>(x, null);
    }
  }

  public T elementAt(int n)
  { ListCell<T> c = front;
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
  { ListCell<T> c = front;
    int result = 0;
    while (c != null)
    { result++;
      c = c.next;
    }
    return result;
  }

    public int find(T x){
        ListCell cell = front;
        int index = 0;
        boolean present = false;
        while (cell != null){
            if (cell.data == x){  //if contents of cell is the char we are looking for
                present = true;
                break;
            }
            cell = cell.next;
            index++;
        }
        if (present) return index;
        else return -1;
    }

    public boolean removeAll(T x) {
        if (find(x) == -1) return false;
        else {
            while (find(x) > -1){
                ListCell cell = front;
                for (int i = 0; i < length(); i++){
                    if (elementAt(i + 1) == x){
                        cell.next = cell.next.next;
                    }
                    cell = cell.next;
                }
            }
            return true;
        }
    }
/*            // Remove all occurrences of x from list
            ListCell c = front;
            while (c != front) {
                if (c == x) {
                    c = c.next;
                    System.out.println(c + "has been removed!");

                }
                c = c.next;
            }
            return true;
*/


  public String toString()
  { StringBuffer sb = new StringBuffer("< ");
    ListCell<T> c = front;
    while (c != null)
    { sb.append(c.data + " ");
      c = c.next;
    }
    return(sb+">");
  }
}
