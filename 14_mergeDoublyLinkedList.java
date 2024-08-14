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

class doublyLinkedListMerge{
    Node first;
    Node last;

    public doublyLinkedListMerge(){
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

    public void merge(doublyLinkedListMerge d){
        Node cur = first;
        Node dcur = d.first;

        if(cur == null && dcur == null){
            return;
        }
        else if(cur == null && dcur != null){
            first = d.first;
            last = d.last;
        }
        else if(cur != null && dcur == null){
            return;
        }
        else{
            Node cur1 = first;
            Node cur2 = d.first;

            Node next1, next2;

            while(cur1 != null){
                next1 = cur1.next;
                next2 = cur2.next;

                cur1.next = cur2;
                cur2.prev= cur1;

                if(next1 != null){
                    cur2.next = next1;
                    next1.prev = cur2;
                }
                else{
                    this.last = cur2;
                }

                cur1 = next1;
                cur2 = next2;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        doublyLinkedListMerge d1 = new doublyLinkedListMerge();
        doublyLinkedListMerge d2 = new doublyLinkedListMerge();

        System.out.println("creating list 1\nenter length: ");
        int l1 = sc.nextInt();

        for(int i = 0; i < l1; i++){
            System.out.print("enter data: ");
            d1.insert(sc.next().charAt(0));
        }

        System.out.println("creating list 2\nenter length: ");
        int l2 = sc.nextInt();

        for(int i = 0; i < l2; i++){
            System.out.println("enter data: ");
            d2.insert(sc.next().charAt(0));
        }

        d1.merge(d2);
        System.out.println("merged list: ");
        d1.display();
    }
}