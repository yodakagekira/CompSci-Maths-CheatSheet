class TreeNode {
    int key;
    TreeNode left, right, parent;

    TreeNode(int item) {
        key = item;
        left = right = parent = null;
    }
}

class BinarySearchTree {
    TreeNode root;
    private TreeNode prev;

    public TreeNode search(TreeNode x, int key) {
        if (x == null || key == x.key) {
            return x;
        }
        if (key < x.key) {
            return search(x.left, key);
        } else {
            return search(x.right, key);
        }
    }

    public TreeNode iterativeSearch(TreeNode x, int key) {
        while (x != null && key != x.key) {
            if (key < x.key) {
                x = x.left;
            } else {
                x = x.right;
            }
        }
        return x;
    }

    public TreeNode minimum(TreeNode x) {
        while (x.left != null) {
            x = x.left;
        }
        return x;
    }

    public TreeNode maximum(TreeNode x) {
        while (x.right != null) {
            x = x.right;
        }
        return x;
    }

    public TreeNode successor(TreeNode x) {
        if (x.right != null) {
            return minimum(x.right);
        }
        TreeNode y = x.parent;
        while (y != null && x == y.right) {
            x = y;
            y = y.parent;
        }
        return y;
    }

    public TreeNode predecessor(TreeNode x) {
        if (x.left != null) {
            return maximum(x.left);
        }
        TreeNode y = x.parent;
        while (y != null && x == y.left) {
            x = y;
            y = y.parent;
        }
        return y;
    }

    public void insert(int key) {
        TreeNode z = new TreeNode(key);
        TreeNode y = null;
        TreeNode x = root;
        while (x != null) {
            y = x;
            if (z.key < x.key) {
                x = x.left;
            } else {
                x = x.right;
            }
        }
        z.parent = y;
        if (y == null) {
            root = z;
        } else if (z.key < y.key) {
            y.left = z;
        } else {
            y.right = z;
        }
    }

    private boolean isBSTUtil(TreeNode node) {
      // Base case: An empty tree is a BST
      if (node == null) {
          return true;
      }

      // Check the left subtree
      if (!isBSTUtil(node.left)) {
          return false;
      }

      // Check current node: the previous node must be less than the current node's key
      if (prev != null && node.key <= prev.key) {
          return false;
      }

      // Update prev to current node
      prev = node;

      // Check the right subtree
      return isBSTUtil(node.right);
  }

  public boolean isBST() {
      prev = null; // Reset prev for subsequent calls to isBST
      return isBSTUtil(root);
  }

    public void treeDelete(TreeNode z) {
    TreeNode y, x;
    
    // Step 1: Determine the node y to remove from the tree.
    if (z.left == null || z.right == null) {
        y = z;
    } else {
        y = treeSuccessor(z);
    }
    
    // Step 2: Determine the child x of y.
    if (y.left != null) {
        x = y.left;
    } else {
        x = y.right;
    }
    
    // Step 3: Reassign the parent of x if x is not null.
    if (x != null) {
        x.parent = y.parent;
    }
    
    // Step 4: If y's parent is null, then x is the new root; otherwise, reattach x to y's parent.
    if (y.parent == null) {
        root = x;
    } else if (y == y.parent.left) {
        y.parent.left = x;
    } else {
        y.parent.right = x;
    }
    
    // Step 5: If y is not z, copy y's data into z.
    if (y != z) {
        z.key = y.key;
        // Copy other satellite data if necessary
    }
}
////////////////////////////////////////////////////////////////////
public class Main {
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();

        // Insert elements into the BST
        bst.insert(15);
        bst.insert(10);
        bst.insert(20);
        bst.insert(8);
        bst.insert(12);
        bst.insert(17);
        bst.insert(25);

        // Check if 20 is in the tree
        TreeNode found = bst.search(bst.root, 20);
        System.out.println("Search for 20: " + (found != null ? "Found" : "Not Found"));

        // Find the minimum and maximum
        TreeNode minNode = bst.minimum(bst.root);
        TreeNode maxNode = bst.maximum(bst.root);
        System.out.println("Minimum value: " + (minNode != null ? minNode.key : "Tree is empty"));
        System.out.println("Maximum value: " + (maxNode != null ? maxNode.key : "Tree is empty"));

        // Find successor and predecessor of 10
        TreeNode node10 = bst.search(bst.root, 10);
        TreeNode succOf10 = bst.successor(node10);
        TreeNode predOf10 = bst.predecessor(node10);
        System.out.println("Successor of 10: " + (succOf10 != null ? succOf10.key : "No successor"));
        System.out.println("Predecessor of 10: " + (predOf10 != null ? predOf10.key : "No predecessor"));

        // Delete element 20 and check the tree structure
        TreeNode node20 = bst.search(bst.root, 20);
        if (node20 != null) {
            bst.delete(node20);
            TreeNode check20 = bst.search(bst.root, 20);
            System.out.println("After deletion, search for 20: " + (check20 != null ? "Found" : "Not Found"));
        } else {
            System.out.println("Node 20 not found for deletion.");
        }
      System.out.println("Is valid BST: " + bst.isBST());

    }
}
