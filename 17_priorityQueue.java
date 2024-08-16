import java.util.*;

class Node{
    int data;
    int priority;
    Node next;

    public Node(int d, int p){
        data = d;
        priority = p;
        next = null;
    }
}

class priorityQueue{
    Node first;

    public priorityQueue(){
        first = null;
    }


    public void enqueue(int d, int p) {
        Node newNode = new Node(d, p);
        if (first == null || first.priority > p) { 
            newNode.next = first;
            first = newNode;
            return;
        }
        
        Node cur = first;
        while (cur.next != null && cur.next.priority <= p) {
            cur = cur.next;
        }
        
        newNode.next = cur.next; 
        cur.next = newNode;
    }

    public boolean isEmpty(){
        return (first == null);
    }

    public void dequeue(){
        if(!isEmpty()){
            first = first.next;
        }
    }
    public void display(){
        Node cur = first;

        while(cur != null){
            System.out.print(cur.data + " ");
            cur = cur.next;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        priorityQueue q = new priorityQueue();  
        int choice;
        int continu = 1;

        do{
            System.out.println("\n1. enqueue\n2. dequeue\n3. display\n4. stop\nenter your choice: ");
            choice = sc.nextInt();

            switch(choice){
                case 1:
                    System.out.println("enter data and priority: ");
                    int d = sc.nextInt();
                    int p = sc.nextInt();
                    q.enqueue(d, p);
                    break;

                case 2:
                    q.dequeue();
                    break;
                
                case 3:
                    q.display();
                    break;
                
                case 4:
                    continu = 0;
                    System.out.println("exiting...");
                    break;
            }
        }while (continu == 1);


    }
}