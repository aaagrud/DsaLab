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

class doubly{
    Node first;
    Node last;

    public doubly(){
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
        Node cur = first;

        if(isEmpty()){
            first = last = newNode;
            return;
        }
        last.next = newNode;
        newNode.prev = last;
        last = newNode;
    }

    public void deleteFirst(){
        if(!isEmpty()){
            first = first.next;
            if(first != null){
                first.prev = null;
            } else{
                last = null;
            }
        }
    }

    public void deleteLast(){
        if(!isEmpty()){
            if(first.next == null){
                first = last = null;
                return;
            }
            else {
                last = last.prev;
                last.next = null;
            }
        }
    }

    public void insertAtnthFromEnd(int pos, int d) {
        Node newNode = new Node(d);
        if (pos == 1 || isEmpty()) {
            insertLast(d);
            return;
        }
        Node cur = last;
        for (int i = 1; i < pos - 1 && cur.prev != null; i++) {
            cur = cur.prev;
        }
        newNode.prev = cur.prev;
        newNode.next = cur;
        if (cur.prev != null) {
            cur.prev.next = newNode;
        } else {
            first = newNode;
        }
        cur.prev = newNode;
    }

    public void deletenthFromBeginning(int pos){
        if(!isEmpty()){
            if(first == last && pos == 1){
                first = last = null;
                return;
            }
            Node cur = first;
            while(pos > 1){
                cur = cur.next;
                pos = pos - 1;
            } 
            if(cur != null){
                if(first.next.next == null){
                    first = last = cur;
                    return;
                }
                if(cur.next == last){
                    cur.next = null;
                    last = cur;
                    return;
                }
                cur.next.next.prev = cur;
                cur.next = cur.next.next;
            }
        }
    }

    public void deleteReplaceMiddle(int d){
        Node cur = first;
        Node middle = first;
        int i = 1;
        while(cur.next != null){
            if(i % 2 == 0){
                middle = middle.next;
            }
            i = i + 1;
            cur = cur.next;
        }
        System.out.println("middle is: " + middle.data + "\nmiddle replaced...");
        middle.data = d;
    }
    public void oddEven(){
        doubly odd = new doubly();
        doubly even = new doubly();

        Node cur = first;
        while(cur.next != null){
            if(cur.data % 2 == 0){
                even.insertLast(cur.data);
            }
            else{
                odd.insertLast(cur.data);
            }
            cur = cur.next;
        }
        if(!odd.isEmpty() && !even.isEmpty()){  
            first = odd.first;
            odd.last.next = even.first;
            last = even.last;
            return;
        }
        if(even.isEmpty() || odd.isEmpty()){
            return;
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        doubly deque = new doubly();
        int choice, value, pos;

        do {
            System.out.println("\n--- Deque Operations Menu ---");
            System.out.println("1. Insert First");
            System.out.println("2. Insert Last");
            System.out.println("3. Delete First");
            System.out.println("4. Delete Last");
            System.out.println("5. Insert at nth position from End");
            System.out.println("6. Delete nth from Beginning");
            System.out.println("7. Replace Middle Element");
            System.out.println("8. Rearrange Deque (Odd-Even)");
            System.out.println("9. Display Deque");
            System.out.println("10. Exit");
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
                    System.out.print("Enter position from the end: ");
                    pos = scanner.nextInt();
                    System.out.print("Enter value to insert: ");
                    value = scanner.nextInt();
                    deque.insertAtnthFromEnd(pos, value);
                    System.out.println("Inserted " + value + " at position " + pos + " from the end.");
                    break;
                case 6:
                    System.out.print("Enter position from the beginning to delete: ");
                    pos = scanner.nextInt();
                    deque.deletenthFromBeginning(pos);
                    System.out.println("Deleted element at position " + pos + " from the beginning.");
                    break;
                case 7:
                    System.out.print("Enter value to replace the middle element: ");
                    value = scanner.nextInt();
                    deque.deleteReplaceMiddle(value);
                    break;
                case 8:
                    deque.oddEven();
                    System.out.println("Deque rearranged with odd numbers first, followed by even numbers.");
                    break;
                case 9:
                    System.out.print("Deque elements: ");
                    deque.display();
                    System.out.println();
                    break;
                case 10:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
                    break;
            }
        } while (choice != 10);

        scanner.close();
    }
}