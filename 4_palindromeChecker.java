import java.util.*;
import java.io.*;

class PalindromeChecker{
    public static void main(String[] args) {
        String s;
        Scanner sc = new Scanner(System.in);

        System.out.println("enter string: ");
        s = sc.nextLine();
        boolean palindrome = true;
        int j = s.length() - 1;

        for(int i = 0; i < s.length() ; i++){
            if(s.charAt(i) != s.charAt(j)){
                palindrome = false;
                break;
            }
            else{
                j = j - 1;
            }
        }

        System.out.println("checking...");

        if(palindrome == true){
            System.out.print("palindrome");
        } else {
            System.out.print("not palindrome");
        }
    }
}