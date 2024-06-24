import java.util.*; 

class LinkedList{
    Node first;
    Scanner sc = new Scanner(System.in);
        
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LinkedList s = new LinkedList();
        int c = 0;
        do{  
            System.out.println("1. push\n2. pop\n3. peek\n4. remove duplicate\n5. find frequency\n6. exit\nenter your choice: ");
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
                s.removeDuplicates();
            }
            else if(choice == 5){
                System.out.println("enter element to find frequency: ");
                int n = sc.nextInt();
                s.frequency(n);
            }
            else{
                c = 1;
            }
        } while(c == 0);
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
