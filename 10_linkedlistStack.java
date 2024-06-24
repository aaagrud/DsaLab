import java.util.*; 

class Stack{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LinkedList s = new LinkedList();
        int c = 0;
        do{  
            System.out.println("1. push\n2. pop\n3. peek\n4. exit\nenter your choice: ");
            int choice = sc.nextInt();

            if(choice == 1){
                s.insertLast();
            }

            else if(choice == 2){
                if(!(s.isEmpty())){
                    s.deleteLast();
                }
            }

            else if(choice == 3){
                if(!(s.isEmpty())){
                    s.viewLast();
                }
            }

            else{
                c = 1;
            }
        } while(c == 0);
    }
}
class Node{
    int data;
    Node next;

    public Node(int n){
        data = n;
        next = null;
    }
}

class LinkedList{
    Node first;
    Scanner sc = new Scanner(System.in);

    public LinkedList(){
        first = null;
    }

    public boolean  isEmpty(){
        return first == null;
    }

    public void insertLast(){
        Node cur = first;

        if(first == null){
            System.out.println("enter number: ");
            first = new Node(sc.nextInt());
            return;
        }

        while(cur.next != null){
            cur = cur.next;
        }

        System.out.println("enter number: ");
        cur.next = new Node(sc.nextInt());
    }

    public void deleteLast(){
        Node cur = first;

        if(first == null){
            return;
        }

        if(first.next == null){
            first = null;
            return;
        }

        while(cur.next.next != null){
            cur = cur.next;
        }
        cur.next = null;
    }

    public void viewLast(){
        Node cur = first;

        if(first == null){
            System.out.println("empty");
            return;
        }

        while(cur.next != null){
            cur = cur.next;
        }
        System.out.println("last item: " + cur.data);
    }
}