// Binary Search Tree Implementation
class BinarySearchTree {

    // Node class to represent each node in the tree
    static class Node {
        int data;
        Node left, right;

        // Constructor to create a new node
        public Node(int data) {
            this.data = data;
            left = right = null;
        }
    }

    Node root;

    // Constructor to initialize the root
    public BinarySearchTree() {
        root = null;
    }

    // Method to insert a new node with the given data
    public void insert(int data) {
        root = insertRec(root, data);
    }

    // Recursive method to insert a new node
    private Node insertRec(Node root, int data) {
        if (root == null) {
            root = new Node(data);
            return root;
        }

        if (data < root.data) {
            root.left = insertRec(root.left, data);
        } else if (data > root.data) {
            root.right = insertRec(root.right, data);
        }

        return root;
    }

    // Method to delete a node with the given data
    public void delete(int data) {
        root = deleteRec(root, data);
    }

    // Recursive method to delete a node
    private Node deleteRec(Node root, int data) {
        if (root == null) {
            return root;
        }

        // If data to be deleted is smaller than the root's data, then it lies in the left subtree
        if (data < root.data) {
            root.left = deleteRec(root.left, data);
        }
        // If data to be deleted is greater than the root's data, then it lies in the right subtree
        else if (data > root.data) {
            root.right = deleteRec(root.right, data);
        }
        // If data is the same as the root's data, then this is the node to be deleted
        else {
            // Node with only one child or no child
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }

            // Node with two children: Get the inorder successor (smallest in the right subtree)
            root.data = minValue(root.right);

            // Delete the inorder successor
            root.right = deleteRec(root.right, root.data);
        }

        return root;
    }

    // Method to find the smallest value in the tree (used for finding the inorder successor)
    private int minValue(Node root) {
        int minValue = root.data;
        while (root.left != null) {
            minValue = root.left.data;
            root = root.left;
        }
        return minValue;
    }

    // Inorder traversal of the tree
    public void inorder() {
        inorderRec(root);
    }

    // Recursive method for inorder traversal
    private void inorderRec(Node root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.print(root.data + " ");
            inorderRec(root.right);
        }
    }

    // Main method to test the Binary Search Tree implementation
    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();

        // Inserting nodes
        tree.insert(50);
        tree.insert(30);
        tree.insert(20);
        tree.insert(40);
        tree.insert(70);
        tree.insert(60);
        tree.insert(80);

        System.out.println("Inorder traversal of the tree:");
        tree.inorder(); // Output will be sorted order of inserted elements
        System.out.println();

        // Deleting a node
        System.out.println("Delete 20:");
        tree.delete(20);
        tree.inorder(); // After deletion
        System.out.println();

        // Deleting a node with two children
        System.out.println("Delete 30:");
        tree.delete(30);
        tree.inorder(); // After deletion
        System.out.println();

        // Deleting the root node
        System.out.println("Delete 50:");
        tree.delete(50);
        tree.inorder(); // After deletion
        System.out.println();
    }
}
