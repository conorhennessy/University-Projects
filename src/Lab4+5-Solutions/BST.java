public class BST<T extends Comparable<T>>
{ private BTNode<T> root;

  public BST()
  { root = null;
  }

  public boolean find(T i)
  { BTNode<T> n = root;
    boolean found = false;

    while (n!=null && !found)
    { int comp = i.compareTo(n.data);
      if (comp==0)
        found = true;
      else if (comp<0)
        n = n.left;
      else
        n = n.right;
	}

    return found;
  }

  public boolean insert(T i)
  { BTNode<T> parent = root, child = root;
    boolean goneLeft = false;

    while (child!=null && i.compareTo(child.data)!=0)
    { parent = child;
      if (i.compareTo(child.data)<0)
	  { child = child.left;
	    goneLeft = true;
	  }
	  else
	  { child = child.right;
	    goneLeft = false;
      }
	}

    if (child!=null)
      return false;  // number already present
    else
    { BTNode<T> leaf = new BTNode<T>(i);
      if (parent==null) // tree was empty
        root = leaf;
      else if (goneLeft)
        parent.left = leaf;
      else
        parent.right = leaf;
      return true;
    }
  }

  // this method assumes its argument is not null)
  private T getLeftMost(BTNode<T> n)
  { if (n.left==null)
      return n.data;
    else
      return getLeftMost(n.left);
  }

  public boolean delete(T i)
  { BTNode<T> parent = null, child = root;
    boolean goneLeft = false;

    while (child!=null && i.compareTo(child.data)!=0)
    { parent = child;
      if (i.compareTo(child.data)<0)
      { child = child.left;
	    goneLeft = true;
      }
      else
      { child = child.right;
	    goneLeft = false;
      }
    }

    if (child==null)
      return false;  // number to be deleted was not in the tree
    else
    { if (child.left==null && child.right==null)
      // it's a leaf so just remove reference from parent
      { if (parent==null)
          root = null;
        else if (goneLeft)
          parent.left = null;
        else
          parent.right = null;
      }
      else if (child.right==null)
      // make grandparent 'adopt' left child
      { if (parent==null)
          root = child.left;
        else if (goneLeft)
          parent.left = child.left;
        else
          parent.right = child.left;
      }
      else if (child.left==null)
      // make grandparent 'adopt' right child
      { if (parent==null)
          root = child.right;
        else if (goneLeft)
          parent.left = child.right;
        else
          parent.right = child.right;
      }
      else
      // move up smallest value in child's right child to fill the gap left by deleted item
      { T leftMost = getLeftMost(child.right);
        delete(leftMost);  // could do this more efficiently - we don't really need to search the whole tree again
        child.data = leftMost;  // fill the gap
      }
      return true;
    }
  }



  public String toString() //same as toString method in slides for BTree class
  { return getString(root);
  }

  private String getString(BTNode<T> n)
  { if (n==null)
      return("");
    else
    { String s1 = getString(n.left);
      String s2 = getString(n.right);
      return s1+" "+n.data+" "+s2;
	}
  }
}

class BTNode<T>
{ T data;
  BTNode<T> left, right;

  BTNode(T o)
  { data = o; left = right = null;
  }

  BTNode(T o, BTNode<T> l, BTNode<T> r)
  { data = o; left = l; right = r;
  }
}
