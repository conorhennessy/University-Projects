import java.util.*;

public class LLQueue<T> implements Queue<T>
{ private LinkedList<T> ll;

  public LLQueue()
  { ll = new LinkedList<T>();
  }

  public boolean isEmpty()
  { return ll.isEmpty();
  }

  public void add(T x)
  { ll.addLast(x);
  }

  public T front()
  { if (ll.isEmpty())
      throw new QueueException("front");
    return ll.getFirst();
  }

  public void removeFront()
  { if (ll.isEmpty())
      throw new QueueException("removeFront");
      ll.removeFirst();
  }

  // this displays the qeueu in the format <1,2,3>
  // could use different format
  public String toString()
  { StringBuffer sb = new StringBuffer("<");
    Iterator<T> it = ll.iterator();
    while (it.hasNext())
      sb.append(it.next()+",");
    if (sb.length()>1)
      sb.setLength(sb.length()-1);  // remove last comma
    sb.append(">");
    return sb.toString();
  }
}

