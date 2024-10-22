// AVL Tree implementation in Java
class AVLTree {

    // AVL Tree Node class
    static class Node {
        int data;
        Node left, right;
        int height;

        public Node(int data) {
            this.data = data;
            this.height = 1; // New nodes have height 1
        }
    }

    private Node root;

    // Method to get the height of a node
    private int height(Node node) {
        return (node == null) ? 0 : node.height;
    }

    // Method to get the balance factor of a node
    private int getBalance(Node node) {
        return (node == null) ? 0 : height(node.left) - height(node.right);
    }

    // Right rotate utility
    private Node rightRotate(Node y) {
        Node x = y.left;
        Node T2 = x.right;

        // Perform rotation
        x.right = y;
        y.left = T2;

        // Update heights
        y.height = Math.max(height(y.left), height(y.right)) + 1;
        x.height = Math.max(height(x.left), height(x.right)) + 1;

        // Return new root
        return x;
    }

    // Left rotate utility
    private Node leftRotate(Node x) {
        Node y = x.right;
        Node T2 = y.left;

        // Perform rotation
        y.left = x;
        x.right = T2;

        // Update heights
        x.height = Math.max(height(x.left), height(x.right)) + 1;
        y.height = Math.max(height(y.left), height(y.right)) + 1;

        // Return new root
        return y;
    }

    // Method to insert a node in the AVL tree
    public void insert(int data) {
        root = insertRec(root, data);
    }

    // Recursive method to insert a node
    private Node insertRec(Node node, int data) {
        if (node == null) {
            return new Node(data);
        }

        if (data < node.data) {
            node.left = insertRec(node.left, data);
        } else if (data > node.data) {
            node.right = insertRec(node.right, data);
        } else {
            return node; // Duplicates are not allowed
        }

        // Update height of this ancestor node
        node.height = 1 + Math.max(height(node.left), height(node.right));

        // Get the balance factor to check whether this node became unbalanced
        int balance = getBalance(node);

        // Left Left Case
        if (balance > 1 && data < node.left.data) {
            return rightRotate(node);
        }

        // Right Right Case
        if (balance < -1 && data > node.right.data) {
            return leftRotate(node);
        }

        // Left Right Case
        if (balance > 1 && data > node.left.data) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }

        // Right Left Case
        if (balance < -1 && data < node.right.data) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }

        return node; // Return the (unchanged) node pointer
    }

    // Method to perform an inorder traversal of the tree
    public void inorder() {
        inorderRec(root);
    }

    // Recursive method to perform an inorder traversal
    private void inorderRec(Node root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.print(root.data + " ");
            inorderRec(root.right);
        }
    }

    // Main method to test the AVL tree
    public static void main(String[] args) {
        AVLTree tree = new AVLTree();

        // Inserting nodes
        tree.insert(10);
        tree.insert(20);
        tree.insert(30);
        tree.insert(25);
        tree.insert(15);
        tree.insert(5);

        System.out.println("Inorder traversal of the AVL tree:");
        tree.inorder();  // Should print the elements in sorted order
    }
}
