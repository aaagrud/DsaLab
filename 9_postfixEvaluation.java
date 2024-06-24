import java.util.*;

class PostfixEvaluation{
    public static void main(String[] args) {
        Stack s = new Stack();
        Scanner sc = new Scanner(System.in);

        System.out.println("enter postfix expression: ");
        String exp = sc.nextLine();

        for(int i = 0; i < exp.length(); i++){
            char current = exp.charAt(i);

            if(Character.isDigit(current)){
                s.push(current - '0');
            } else {
                int left = s.pop();
                int right = s.pop();
                switch (current) {
                    case '+':
                        s.push(right + left);
                        break;
                    case '-':
                        s.push(right - left);
                        break;
                    case '*':
                        s.push(right * left);
                        break;
                    case '/':
                        s.push(right / left);
                        break;
                }
            }
        }

        System.out.println("result: " + s.pop());
    }
}

class Stack{
    Scanner sc = new Scanner(System.in);

    private int a[] = new int[50];
    private int size;
    private int top;

    public Stack(){
        size = 10;
        top = -1;
    }

    public void push(int c){
        if(!isFull()){
            top = top + 1;
            a[top] = c;
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
}