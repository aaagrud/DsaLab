import java.util.*; 

class LinkedList{
    Node first;
    Scanner sc = new Scanner(System.in);
        
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LinkedList s = new LinkedList();
        int c = 0;
        do{  
            System.out.println("\n1. push\n2. pop\n3. peek\n4. add node at nth position\n5. delete 1st node\n6. replace nth node\n7. view\n8. exit\nenter your choice: ");
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
            else if(choice == 4){
                System.out.println("enter position: ");
                int n = sc.nextInt();
                s.nodeAtn(n);
            }
            else if(choice == 5){
                s.deleteFirst();
            }
            else if(choice == 6){
                System.out.println("enter position: ");
                int a = sc.nextInt();
                s.replace(a);
            }
            else if(choice == 7){
                s.display();
            }
            else{
                c = 1;
            }
        } while(c == 0);
    }

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

    public void replace(int n){
        Node cur = first;

        for(int i = 0; i < n - 1; i++){
            cur = cur.next;
        }

        System.out.println("enter value to replace with: ");
        cur.data = sc.nextInt();
    }

    public void nodeAtn(int n){
        Node cur = first;

        for(int i = 0; i < n - 2; i++){
            cur = cur.next;
        }

        System.out.println("enter element to insert: ");
        int b = sc.nextInt();

        Node oldCurNext = cur.next;
        cur.next = new Node(b);
        cur = cur.next;
        cur.next = oldCurNext;
    }

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

    public void removeDuplicates(){
        Node cur = first;

        while(cur != null){
            Node others = cur.next;
            Node prevOthers = cur;
            while (others != null){
                if(cur.data == others.data){
                    prevOthers.next = others.next;
                }
                else{
                    prevOthers = prevOthers.next;
                }
                others = others.next;
            }
            cur = cur.next;
        }
    }

    public void frequency(int key){
        Node cur = first;
        int freq = 0;

        while(cur != null){
            if(cur.data == key){
                freq = freq + 1;
            }
            cur = cur.next;
        }

        System.out.println("frequency: " + freq);
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

class Node{
    int data;
    Node next;

    public Node(int n){
        data = n;
        next = null;
    }
}
