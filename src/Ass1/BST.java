package Ass1;

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

    int count;

    public int greater(int n) {
        count = 0;
        return inOrder(root, n);
    }

    //This is a modified version of the toString method in slides for BTree class
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

    public int nth(int i) {
        count = 0;
        return nthInOrder(root, i);
    }

    private int nthInOrder(BTNode node, int i) {
        if (node == null) {
            return 0;
        }
        count++;
        nthInOrder(node.left, i);
        if((int) node.data == i){
            System.out.println("BEEP" + count);
            return count;
        }
        nthInOrder(node.right, i);
        return count;
    }

    public static void main(String[] args) {
        BST t = new BST();
        System.out.println("New tree:");
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
