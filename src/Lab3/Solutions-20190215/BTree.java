public class BTree<T>
{ private BTNode<T> root;

  public BTree()
  { root = null;
  }

  public BTree(T o, BTree<T> l, BTree<T> r)
  { root = new BTNode<T>(o, l.root, r.root);
  }

  private BTree(BTNode<T> n)
  { root = n;
  }

  public boolean isEmpty()
  { return root==null;
  }

  public T value()
  { if (root==null)
      throw new TreeException("value");
    else
      return root.data;
  }

  public BTree<T> leftChild()
  { if (root==null)
      throw new TreeException("leftChild");
    else
      return new BTree<T>(root.left);
  }

  public BTree<T> rightChild()
  { if (root==null)
      throw new TreeException("rightChild");
    else
      return new BTree<T>(root.right);
  }

  public String toString()
  { return getString(root);
  }

  private static <T> String getString(BTNode<T> n)
  { if (n==null)
      return("");
    else
    { String s1 = getString(n.left);
      String s2 = getString(n.right);
      return s1+" "+n.data+" "+s2;
	}
  }

  public int numNodes()
  { if (root==null)
      return 0;
    else
      return root.nodes();
  }

  // main method to test numNodes
  public static void main(String args[])
  { BTree<Character> emptyTree = new BTree<Character>();
    System.out.println("emptyTree has " + emptyTree.numNodes() + " nodes");
    BTree<Character> leaf1 = new BTree<Character>('a', emptyTree, emptyTree);
    System.out.println("leaf1 has " + leaf1.numNodes() + " nodes");
    BTree<Character> leaf2 = new BTree<Character>('c', emptyTree, emptyTree);
    BTree<Character> t1 = new BTree<Character>('b', leaf1, leaf2);
    System.out.println("t1 has " + t1.numNodes() + " nodes");
    BTree<Character> leaf3 = new BTree<Character>('d', emptyTree, emptyTree);
    BTree<Character> t2 = new BTree<Character>('e', leaf3, emptyTree);
    System.out.println("t2 has " + t2.numNodes() + " nodes");
    BTree<Character> bigTree = new BTree<Character>('x', t1, t2);
    System.out.println("bigTree has " + bigTree.numNodes() + " nodes");
  }
}

class BTNode<T>
{ T data;
  BTNode<T> left, right;

  BTNode(T i)
  { data = i;
    left = null;
    right = null;
  }

  BTNode(T o, BTNode<T> l, BTNode<T> r)
  { data = o;
    left = l;
    right = r;
  }

  int nodes()
  { int leftNodes = 0;
    if (left!=null)
      leftNodes = left.nodes();
    int rightNodes = 0;
    if (right!=null)
      rightNodes = right.nodes();
    return leftNodes + rightNodes + 1;
  }

  /* more concise version
  // could write this method even more concisely using nested conditional expressions (...?...:...)
  int nodes()
  { int answer = 1;
    if (left!=null)
      answer += left.nodes();
    if (right!=null)
      answer += right.nodes();
    return answer;
  }
  */
}

class TreeException extends RuntimeException
{ public TreeException(String s)
  { super("Tried to apply "+s+" to empty tree");
  }
}

