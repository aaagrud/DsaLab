
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

    public void delete(int key) {
        root = deleteRec(root, key);
    }

    Node deleteRec(Node root, int key) {
        if (root == null)
            return root;

        if (key < root.data)
            root.left = deleteRec(root.left, key);
        else if (key > root.data)
            root.right = deleteRec(root.right, key);
        else {
            if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;

            root.data = minValue(root.right);
            root.right = deleteRec(root.right, root.data);
        }

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

    public void inorder() {
        inorderRec(root);
        System.out.println();
    }

    void inorderRec(Node root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.print(root.data + " ");
            inorderRec(root.right);
        }
    }

    public void preorder() {
        preorderRec(root);
        System.out.println();
    }

    void preorderRec(Node root) {
        if (root != null) {
            System.out.print(root.data + " ");
            preorderRec(root.left);
            preorderRec(root.right);
        }
    }

    public void postorder() {
        postorderRec(root);
        System.out.println();
    }

    void postorderRec(Node root) {
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
                    System.out.println("In-order traversal:");
                    bst.inorder();
                    break;
                case 4:
                    System.out.println("Pre-order traversal:");
                    bst.preorder();
                    break;
                case 5:
                    System.out.println("Post-order traversal:");
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
