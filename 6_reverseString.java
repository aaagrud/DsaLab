import java.util.*;

class ReverseString{
    Scanner sc = new Scanner(System.in);

    private char a[] = new char[50];
    private int size;
    private int top;

    public ReverseString(){
        size = 10;
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
        ReverseString s = new ReverseString();

        System.out.println("enter string: ");
        String original = sc.nextLine();
        String reverse = "";
        for(int i = 0; i < original.length(); i++){
            s.push(original.charAt(i));
        }

        for(int i = 0; i < original.length(); i++){
            reverse += s.pop();
        }

        if(reverse.equals(original)){
            System.out.println("palindrome");
        } else {
            System.out.println("not palindrome");
        }
        
    }
}