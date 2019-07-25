package Lab2.solutions2;

import java.io.*;

public class Reverse
{ public static void main(String[] args)
  { Stack mystack = new ArrayStack<Character>();
    String textline;

    BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
    try
    { textline = buff.readLine().trim();
    }
    catch (IOException e)
    { textline = "";
	}

    int i;
    for (i=0; i<textline.length(); i++)
      mystack.push(textline.charAt(i));

    while (!mystack.isEmpty())
    { System.out.print(mystack.top());
      mystack.pop();
    }
    System.out.println();
  }
}