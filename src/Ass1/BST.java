import java.util.*;

public class BST {
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

    /** An recursive function to find number of nodes greater than given value.
     * @param n - The supplied number to overall find number of nodes containing data greater than n
     * @return count - A count of how many nodes are values which are greater than n
     **/
    public int greater(int n) {
        return inOrder(root, n);
    }

    //This is a modified version of the toString method in slides for BTree class
    int count = 0;
    private int inOrder(BTNode node, int n) {
        if (node == null) {
            return 0;
        }
        inOrder(node.left, n);
        if((int) node.data > n){
            count++;
        }
        inOrder(node.right, n);

        return count;
    }

    /** Added an recursive function to find position in 'Array' as for your cup or what not appears to Intelij.
     * @param i - The supplied number to overall find number of nodes containing data greater than n
     * @return nthLocation - A int of here the BST.
     **/
    public int nth(int i) {
        if ( i < 0 || i > count){
            throw new NoSuchElementException("Element does can not exist in tree! As 'i' is not in range 0 to count-1");
        }
        return nthInOrder(root, i);
    }

    int nthLocation = -1; //null
    private int nthInOrder(BTNode node, int i) {
        int loc = 0;
        if (node == null) {
            return 0;
        }
        loc++;
        nthInOrder(node.left, i);
        if((int) node.data == i){
            nthLocation = loc;
        }
        nthInOrder(node.right, i);

        //Returning location as the end of search is complete
        return nthLocation;

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
