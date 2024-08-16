import java.io.*;

class Node {
    int data;
    Node left, right;

    public Node(int item) {
        data = item;
        left = right = null;
    }
}

class BST {
    Node root;

    public BST() {
        root = null;
    }

    public void insert(int key) {
        root = insertRec(root, key);
    }

    Node insertRec(Node root, int key) {
        if (root == null) {
            root = new Node(key);
            return root;
        }
        if (key < root.data)
            root.left = insertRec(root.left, key);
        else if (key > root.data)
            root.right = insertRec(root.right, key);

        return root;
    }

    int minValue(Node root) {
        int minValue = root.data;
        while (root.left != null) {
            minValue = root.left.data;
            root = root.left;
        }
        return minValue;
    }

    // In-order traversal without a helper function
    public void inorder() {
        System.out.print("In-order traversal: ");
        Node current = root;
        inorderRec(current);
        System.out.println();
    }

    private void inorderRec(Node root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.print(root.data + " ");
            inorderRec(root.right);
        }
    }

    // Pre-order traversal without a helper function
    public void preorder() {
        System.out.print("Pre-order traversal: ");
        Node current = root;
        preorderRec(current);
        System.out.println();
    }

    private void preorderRec(Node root) {
        if (root != null) {
            System.out.print(root.data + " ");
            preorderRec(root.left);
            preorderRec(root.right);
        }
    }

    // Post-order traversal without a helper function
    public void postorder() {
        System.out.print("Post-order traversal: ");
        Node current = root;
        postorderRec(current);
        System.out.println();
    }

    private void postorderRec(Node root) {
        if (root != null) {
            postorderRec(root.left);
            postorderRec(root.right);
            System.out.print(root.data + " ");
        }
    }
}

public class TreeTraversal {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BST bst = new BST();
        int choice, value;

        do {
            System.out.println("\nBinary Search Tree Operations Menu:");
            System.out.println("1. Insert a node");
            System.out.println("2. Delete a node");
            System.out.println("3. In-order traversal");
            System.out.println("4. Pre-order traversal");
            System.out.println("5. Post-order traversal");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            choice = Integer.parseInt(br.readLine());

            switch (choice) {
                case 1:
                    System.out.print("Enter value to insert: ");
                    value = Integer.parseInt(br.readLine());
                    bst.insert(value);
                    System.out.println("Node inserted.");
                    break;
                case 2:
                    System.out.print("Enter value to delete: ");
                    value = Integer.parseInt(br.readLine());
                    bst.delete(value);
                    System.out.println("Node deleted.");
                    break;
                case 3:
                    bst.inorder();
                    break;
                case 4:
                    bst.preorder();
                    break;
                case 5:
                    bst.postorder();
                    break;
                case 6:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        } while (choice != 6);
    }
}
