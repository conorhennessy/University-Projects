package Lab3.solutions3;

public class BST // non-generic version
{
    private BTNode<Integer> root;

    public BST() {
        root = null;
    }

    public boolean find(Integer i) {
        BTNode<Integer> n = root;
        boolean found = false;

        while (n != null && !found) {
            int comp = i.compareTo(n.data);
            if (comp == 0)
                found = true;
            else if (comp < 0)
                n = n.left;
            else
                n = n.right;
        }

        return found;
    }

    public boolean insert(Integer i) {
        BTNode<Integer> parent = root, child = root;
        boolean goneLeft = false;

        while (child != null && i.compareTo(child.data) != 0) {
            parent = child;
            if (i.compareTo(child.data) < 0) {
                child = child.left;
                goneLeft = true;
            } else {
                child = child.right;
                goneLeft = false;
            }
        }

        if (child != null)
            return false;  // number already present
        else {
            BTNode<Integer> leaf = new BTNode<Integer>(i);
            if (parent == null) // tree was empty
                root = leaf;
            else if (goneLeft)
                parent.left = leaf;
            else
                parent.right = leaf;
            return true;
        }
    }

    public String toString() //same as toString method in slides for BTree class
    {
        return getString(root);
    }

    private static String getString(BTNode<Integer> n) {
        if (n == null)
            return ("");
        else {
            String s1 = getString(n.left);
            String s2 = getString(n.right);
            return s1 + " " + n.data + " " + s2;
        }
    }

    private static int evens(BTNode<Integer> n) {
        int leftAns = 0;
        if (n.left != null)
            leftAns = evens(n.left);
        int rightAns = 0;
        if (n.right != null)
            rightAns = evens(n.right);
        int answer = leftAns + rightAns;
        if (n.data.intValue() % 2 == 0)
            answer++;
        return answer;
    }

  /* more concise version, although marginally less efficient since it makes recursive calls with null arguments
  private static int evens(BTNode<Integer> n)
  { int (n == null)
      return 0;
    int answer = evens(n.left) + evens(n.right);
    if n.data.intValue()%2 == 0;
      answer++;
    return answer;
  }*/

    public int numEvens() {
        if (root == null)
            return 0;
        else
            return evens(root);
    }

    // maim method to test evens
    public static void main(String args[]) {
        BST t = new BST();
        System.out.println("New tree: " + t.numEvens() + " evens");
        t.insert(4);
        t.insert(7);
        t.insert(6);
        System.out.println("Inserted 4,6,7: " + t.numEvens() + " evens");
        t.insert(2);
        t.insert(3);
        System.out.println("Inserted 2,3: " + t.numEvens() + " evens");
        t.insert(1);
        t.insert(5);
        System.out.println("Inserted 1,5: " + t.numEvens() + " evens");
        t.insert(54);
        t.insert(28);
        t.insert(112);
        t.insert(999);
        t.insert(888);
        System.out.println("Inserted 54,28,112,999,888: " + t.numEvens() + " evens");
    }


}

class BTNode<T> {
    T data;
    BTNode<T> left, right;

    BTNode(T o) {
        data = o;
        left = right = null;
    }
}
