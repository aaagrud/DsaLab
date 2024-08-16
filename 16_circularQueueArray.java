import java.util.*;

class circularQueueArray{
    int n, rear, front;
    int arr[];
    public circularQueueArray(int size){
        n = size;
        arr = new int[size];
        rear = -1;
        front = 0;
    }

    public boolean isEmpty(){
        return (rear + 1) % n == front;
    }

    public boolean isFull(){
        return ((rear + 2) % n == front);
    }

    public void enqueue(int x){
        if(isFull()){
            System.out.println("the queue is full");
            return;
        }
        rear = (rear + 1) % n;
        arr[rear] = x;
    }

    public void dequeue(){
        if(isEmpty()){
            System.out.println("the queue is empty");
        }
        else{
            front = (front + 1) % n;
        }
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("The queue is empty");
            return;
        }
    
        System.out.println("The queue is: ");
        int i = front;
        while (true) {
            System.out.print(arr[i] + " ");
            if (i == rear) {
                break;
            }
            i = (i + 1) % n;
        }
        System.out.println();
    }
    

    public static void main(String[] args) {
        circularQueueArray q = new circularQueueArray(10);
        Scanner sc = new Scanner(System.in);
        int choice;
        int continu = 1;

        do{
            System.out.println("\n1. enqueue\n2. dequeue\n3. display\n4. exit\nenter your choice: ");
            choice = sc.nextInt();

            switch(choice){
                case 1:
                    System.out.println("enter data: ");
                    int d = sc.nextInt();
                    q.enqueue(d);
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
        }while(continu == 1);
    }
}