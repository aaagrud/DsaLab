import java.util.*;

class Stack{
    Scanner sc = new Scanner(System.in);

    private int a[] = new int[50];
    private int size;
    private int top;

    public Stack(){
        size = 10;
        top = -1;
    }

    public void push(){
        if(!isFull()){
            System.out.println("enter to push: ");
            top = top + 1;
            a[top] = sc.nextInt();
        }
    }

    public int pop(){
        if(!isEmpty()){
            top = top - 1;
            return a[top + 1];
        }
        return 0;
    }

    public boolean isEmpty(){
        if(top == -1){
            return true;
        }
        return false;
    }

    public boolean isFull(){
        if(top == size){
            return true;
        }
        return false;
    }

    public int peek(){
        if(!isEmpty()){
            return a[top];
        }
        return 0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack s = new Stack();
        int c = 0;
        do{  
            System.out.println("1. push\n2. pop\n3. peek\n4. exit\nenter your choice: ");
            int choice = sc.nextInt();

            if(choice == 1){
                if(!(s.isFull())){
                    s.push();
                }
            }

            else if(choice == 2){
                if(!(s.isEmpty())){
                    s.pop();
                }
            }

            else if(choice == 3){
                if(!(s.isEmpty())){
                    System.out.println(s.peek());
                }
            }

            else{
                c = 1;
            }
        } while(c == 0);
    }
}