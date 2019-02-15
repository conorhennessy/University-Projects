// this static implementation of a queue of objects copies the contents of the array into a larger one if it becomes full
// (if we wait until an attempt is made to add another element there will be problems distinguishing between full and empty queues)


public class ArrayQueue<T> implements Queue<T>
{ private T[] arr;
  private int frontPos, backPos;

  public ArrayQueue()
  { arr = (T[]) new Object[5];
    frontPos = 0;
    backPos = -1;
  }

  public boolean isEmpty()
  { return frontPos==(backPos+1)%arr.length;
  }

  public void removeFront()
  { if (frontPos==(backPos+1)%arr.length)
      throw new QueueException("removeFront");
    frontPos++;
  }

  public T front()
  { if (frontPos==(backPos+1)%arr.length)
      throw new QueueException("front");
    return arr[frontPos];
  }

  public String toString()
  { if (frontPos==(backPos+1)%arr.length)
      return "<>";

    StringBuffer sb = new StringBuffer();

    sb.append('<');

    int pos = frontPos;
    while (pos!=backPos)
    { sb.append(arr[pos]);
      sb.append(',');
      pos = (pos+1)%arr.length;
    }

    sb.append(arr[backPos]);
    sb.append('>');

    return(sb.toString());
  }

  public void add(T o)
  { backPos = (backPos+1)%arr.length;
    arr[backPos] = o;

    // if the array is full copy it to a larger one
    if ((backPos+1)%arr.length==frontPos)
    { T[] newarr = (T[])new Object[arr.length*2];
      int i;
      for (i = 0; i<arr.length; i++)
        newarr[i] = arr[(frontPos+i)%arr.length];
      arr = newarr;
      frontPos = 0;
      backPos = i-1;

      // should remove the following line in the final version
      System.out.println("Array size increased to "+arr.length);
    }
  }

}
