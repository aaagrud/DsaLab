import java.util.*; 

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
        
    public void display(){
        Node cur = first;

        while(cur.next != null){
            System.out.print(cur.data + " -> ");
            cur = cur.next;
        }
    }

    public void deleteFirst(){
        first = first.next;
    }

    public LinkedList(){
        first = null;
    }

    public boolean  isEmpty(){
        return first == null;
    }

    public void insertFirst(int d){
        Node cur = first;
        Node newNode = new Node(d);
        if(first == null){
            first = newNode;
            return;
        }
        newNode.next = first;
        first = newNode;        
    }

    public void deleteLast(){
        if(first == null){
            return;
        }

        if(first.next == null){
            first = null;
            return;
        }

        Node cur = first;
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

class queue{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LinkedList d = new LinkedList();
        int choice;
        int continu = 1;
        
        do{
            System.out.println("\n1. enqueue\n2. dequeue\n3. view top of queue\n4. display\n5. stop\nenter your choice: ");
            choice = sc.nextInt();

            switch(choice){
                case 1:
                    System.out.println("enter data: ");
                    int data = sc.nextInt();
                    d.insertFirst(data);
                    break;
                case 2:
                    if(!d.isEmpty()){
                        d.deleteLast();
                    }
                    break;
                case 3:
                    d.viewLast();
                    break;
                case 4:
                    d.display();
                    break;
                case 5:
                    System.out.println("exiting...");
                    continu = 0;
                    break;
            }
        }while(continu == 1);
    }
}

