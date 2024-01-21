class TreeNode {
    int key;
    TreeNode left, right, parent;

    TreeNode(int item) {
        key = item;
        left = right = parent = null;
    }
}

class BinarySearchTree {
    private TreeNode root;

    public BinarySearchTree() {
        root = null;
    }

    public void insert(int key) {
        TreeNode z = new TreeNode(key);
        TreeNode y = null;
        TreeNode x = this.root;
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
            this.root = z;
        } else if (z.key < y.key) {
            y.left = z;
        } else {
            y.right = z;
        }
    }

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

    private int successor(TreeNode root) {
        root = root.right;
        while (root.left != null) {
            root = root.left;
        }
        return root.key;
    }

    private int predecessor(TreeNode root) {
        root = root.left;
        while (root.right != null) {
            root = root.right;
        }
        return root.key;
    }

    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return root;
        if (key > root.key) {
            root.right = deleteNode(root.right, key);
        } else if (key < root.key) {
            root.left = deleteNode(root.left, key);
        } else {
            if (root.left == null && root.right == null) {
                root = null;
            } else if (root.right != null) {
                root.key = successor(root);
                root.right = deleteNode(root.right, root.key);
            } else {
                root.key = predecessor(root);
                root.left = deleteNode(root.left, root.key);
            }
        }
        return root;
    }

    public void delete(int key) {
        root = deleteNode(root, key);
    }
    
    // Other methods like inorderTreeWalk, etc., would go here
}
//////////////////////////////////////////////////////
class BinarySearchTree {
    private TreeNode root;

    public BinarySearchTree() {
        root = null;
    }

    // insert, search, iterativeSearch, minimum, maximum, successor, predecessor, deleteNode methods...

    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();

        // Inserting nodes
        bst.insert(50);
        bst.insert(30);
        bst.insert(70);
        bst.insert(20);
        bst.insert(40);
        bst.insert(60);
        bst.insert(80);

        // Searching for nodes
        TreeNode found = bst.search(bst.root, 30);
        System.out.println("Search 30: " + (found != null ? "Found" : "Not Found"));
        found = bst.iterativeSearch(bst.root, 100);
        System.out.println("Search 100: " + (found != null ? "Found" : "Not Found"));

        // Deleting nodes
        System.out.println("Deleting node 20");
        bst.delete(20);
        found = bst.search(bst.root, 20);
        System.out.println("Search 20 after deletion: " + (found != null ? "Found" : "Not Found"));

        System.out.println("Deleting node 30");
        bst.delete(30);
        found = bst.search(bst.root, 30);
        System.out.println("Search 30 after deletion: " + (found != null ? "Found" : "Not Found"));

        // Additional operations can be demonstrated similarly...
    }
