class Node {
    int data;
    Node left, right;

    public Node(int item) {
        data = item;
        left = right = null;
    }
}

class BST {

    // Function to insert a new node with given key in BST
    Node insert(Node root, int key) {
        // If the tree is empty, return a new node
        if (root == null) {
            return new Node(key);
        }

        // Otherwise, recur down the tree
        if (key < root.data) {
            root.left = insert(root.left, key);
        } else if (key > root.data) {
            root.right = insert(root.right, key);
        }

        // return the (unchanged) node pointer
        return root;
    }

    // A utility function to do inorder traversal of BST
    void inorder(Node root) {
        if (root != null) {
            inorder(root.left);
            System.out.print(root.data + " ");
            inorder(root.right);
        }
    }
    
    public static void main(String[] args) {
        BST tree = new BST();
        Node root = null;

        // Inserting nodes
        root = tree.insert(root, 50);
        root = tree.insert(root, 30);
        root = tree.insert(root, 20);
        root = tree.insert(root, 40);
        root = tree.insert(root, 70);
        root = tree.insert(root, 60);
        root = tree.insert(root, 80);

        // Print inorder traversal of the BST
        tree.inorder(root);
    }
}
