import java.util.*;

class Node{
    int data;
    Node next;
    Node prev;

    public Node(int d){
        data = d;
        next = prev = null;
    }

    public void display(){
        System.out.print(data + " ");
    }
}

class dqueue{
    Node first;
    Node last;

    public dqueue(){
        first = null;
        last = null;
    }

    public boolean isEmpty(){
        return first == null;
    }

    public void display(){
        Node cur = first;

        while(cur != null){
            System.out.print(cur.data + " ");
            cur = cur.next;
        }
    }

    public void insertFirst(int d){
        Node newNode = new Node(d);
        if(isEmpty()){
            first = last = newNode;
            return;
        }
        newNode.next = first;
        first.prev = newNode;
        first = newNode;
    }

    public void insertLast(int d){
        Node newNode = new Node(d);
    
        if(isEmpty()){
            first = last = newNode;
        } else {
            last.next = newNode;
            newNode.prev = last;
            last = newNode;
        }
    }
    

    public void deleteFirst(){
        if(!isEmpty()){
            first = first.next;
        }
    }

    public void deleteLast(){
        if(!isEmpty()){
            if(first.next == null){
                first = last = null;
            }
            else {
                last = last.prev;
                last.next = null;
            }
        }
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        dqueue deque = new dqueue();
        int choice, value;

        do {
            System.out.println("\n--- Deque Operations Menu ---");
            System.out.println("1. Insert First");
            System.out.println("2. Insert Last");
            System.out.println("3. Delete First");
            System.out.println("4. Delete Last");
            System.out.println("5. Display Deque");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter value to insert at the beginning: ");
                    value = scanner.nextInt();
                    deque.insertFirst(value);
                    System.out.println("Inserted " + value + " at the beginning.");
                    break;
                case 2:
                    System.out.print("Enter value to insert at the end: ");
                    value = scanner.nextInt();
                    deque.insertLast(value);
                    System.out.println("Inserted " + value + " at the end.");
                    break;
                case 3:
                    deque.deleteFirst();
                    System.out.println("Deleted the first element.");
                    break;
                case 4:
                    deque.deleteLast();
                    System.out.println("Deleted the last element.");
                    break;
                case 5:
                    System.out.print("Deque elements: ");
                    deque.display();
                    System.out.println();
                    break;
                case 6:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
                    break;
            }
        } while (choice != 6);

        scanner.close();
    }
}