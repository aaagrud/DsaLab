//create list of letters and implement 
//1. reverse list
//2. sort list
import java.util.*;

class Node{
    char data;
    Node next;
    Node prev;

    public Node(char d){
        data = d;
        next = prev = null;
    }

    public void display(){
        System.out.print(data + " ");
    }
}

class doublyLinkedList{
    Node first;
    Node last;

    public doublyLinkedList(){
        first = null;
        last = null;
    }

    public void insert(char d){
        Node cur = first;
        Node newNode = new Node(d);

        if(first == null){
            first = last = newNode;
        }

        else if(cur.next == null){
            first.next = newNode;
            newNode.prev = first;
            last = newNode;
        }

        else{
            while(cur.next != null){
                cur = cur.next;
            }
            cur.next = newNode;
            newNode.prev = cur;
            last = newNode;
        }
    }

    public void peek(){
        Node cur = first;

        while(cur.next != null){
            cur = cur.next;
        }

        System.out.println("top element is: " + cur.data);
    }

    public void delete(){
        if(first.next == null){
            first = last = null;
        }
        last = last.prev;
        last.next = null;
    }

    public boolean isEmpty(){
        return (first == null) && (last == null);
    }

    public void display(){
        if(isEmpty()){
            System.out.println("empty list");
        }
        else{
            Node cur = first;
            while(cur != null){
                System.out.print(cur.data + "->");
                cur = cur.next;
            }
            System.out.println("null");
        }
    }

    public void reverseList(){
        if(last == first || isEmpty()){
            return;
        }
        
        Node cur = first;
        Node temp = null;

        while(cur != null){
            temp = cur.next;
            cur.next = cur.prev;
            cur.prev = temp;

            cur = cur.prev;
        }

        temp = first;
        first = last;
        last = temp;
    }

    public void sort(){
        Node cur = first;
        Node after;

        while(cur != null){
            after = cur.next;
            while(after != null){
                if(cur.data > after.data){
                    char temp = cur.data;
                    cur.data = after.data;
                    after.data = temp;
                }
                after = after.next;
            }
            cur = cur.next;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        doublyLinkedList d = new doublyLinkedList();
        int choice;
        int continu = 1;
        
        do{
            System.out.println("1. insert\n2. delete\n3. peek\n4. display\n5. sort\n6. reverse\n7. stop\nenter your choice: ");
            choice = sc.nextInt();

            switch(choice){
                case 1:
                    System.out.println("enter data: ");
                    char data = sc.next().charAt(0);
                    d.insert(data);
                    break;
                case 2:
                    if(!d.isEmpty()){
                        d.delete();
                    }
                    break;
                case 3:
                    d.peek();
                    break;
                case 4:
                    d.display();
                    break;
                case 5:
                    d.sort();
                    break;
                case 6:
                    d.reverseList();
                    break;
                case 7:
                    System.out.println("exiting...");
                    continu = 0;
                    break;
            }
        }while(continu == 1);
    }
}