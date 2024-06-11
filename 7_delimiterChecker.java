import java.util.*;

class DelimiterChecker{
    Scanner sc = new Scanner(System.in);

    private char a[] = new char[50];
    private int size;
    private int top;

    public DelimiterChecker(){
        size = 50;
        top = -1;
    }

    public void push(char c){
        if(!isFull()){
            top = top + 1;
            a[top] = c;
        }
    }

    public char pop(){
        if(!isEmpty()){
            top = top - 1;
            return a[top + 1];
        }
        return ' ';
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

    public char peek(){
        if(!isEmpty()){
            return a[top];
        }
        return ' ';
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DelimiterChecker s = new DelimiterChecker();

        System.out.println("enter string: ");
        String exp = sc.nextLine();
        Boolean valid = true;

        for(int i = 0; i < exp.length(); i++){
            if(exp.charAt(i) == '{' || exp.charAt(i) == '(' || exp.charAt(i) == '['){
                s.push(exp.charAt(i));
            } else if(exp.charAt(i) == '}' || exp.charAt(i) == ')' || exp.charAt(i) == ']'){
                if(s.isEmpty()){
                    valid = false;
                }
                else {
                    if((exp.charAt(i) == '}' && s.peek() != '{')  || (exp.charAt(i) == ')' && s.peek() != '(') || (exp.charAt(i) == ']' && s.peek() != '[')){
                        valid = false;
                    }
                    s.pop();
                }
            }
        }
        if(!(s.isEmpty())){
            valid = false;
        }

        if(valid == true){
            System.out.println("valid demlimiter");
        } else {
            System.out.println("invalid delimiter");
        }
    }
}