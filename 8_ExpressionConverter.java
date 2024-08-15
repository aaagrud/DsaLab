import java.util.Scanner;
import java.util.Stack;

public class ExpressionConverter {
    private static Stack<Character> stack = new Stack<>();

    private static int precedence(char operator) {
        switch (operator) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
            default:
                return -1;
        }
    }

    private static boolean isOperand(char ch) {
        return Character.isLetterOrDigit(ch);
    }

    private static String infixToPostfix(String infix) {
        StringBuilder postfix = new StringBuilder();
        for (char ch : infix.toCharArray()) {
            if (isOperand(ch)) {
                postfix.append(ch);
            } else if (ch == '(') {
                stack.push(ch);
            } else if (ch == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    postfix.append(stack.pop());
                }
                if (!stack.isEmpty() && stack.peek() != '(') {
                    return "Invalid Expression";
                } else {
                    stack.pop();
                }
            } else {
                while (!stack.isEmpty() && precedence(ch) <= precedence(stack.peek())) {
                    postfix.append(stack.pop());
                }
                stack.push(ch);
            }
        }
        while (!stack.isEmpty()) {
            postfix.append(stack.pop());
        }
        return postfix.toString();
    }

    private static String infixToPrefix(String infix) {
        StringBuilder prefix = new StringBuilder();
        for (int i = infix.length() - 1; i >= 0; i--) {
            char ch = infix.charAt(i);
            if (isOperand(ch)) {
                prefix.insert(0, ch);
            } else if (ch == ')') {
                stack.push(ch);
            } else if (ch == '(') {
                while (!stack.isEmpty() && stack.peek() != ')') {
                    prefix.insert(0, stack.pop());
                }
                if (!stack.isEmpty() && stack.peek() != ')') {
                    return "Invalid Expression";
                } else {
                    stack.pop();
                }
            } else {
                while (!stack.isEmpty() && precedence(ch) < precedence(stack.peek())) {
                    prefix.insert(0, stack.pop());
                }
                stack.push(ch);
            }
        }
        while (!stack.isEmpty()) {
            prefix.insert(0, stack.pop());
        }
        return prefix.toString();
    }

    private static String prefixToPostfix(String prefix) {
        StringBuilder infix = new StringBuilder(prefix).reverse();
        for (int i = 0; i < infix.length(); i++) {
            if (infix.charAt(i) == '(') {
                infix.setCharAt(i, ')');
            } else if (infix.charAt(i) == ')') {
                infix.setCharAt(i, '(');
            }
        }
        String postfix = infixToPostfix(infix.toString());
        return postfix;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;
        String expression;
        do {
            System.out.println("\nMenu:");
            System.out.println("1. Infix to Postfix");
            System.out.println("2. Infix to Prefix");
            System.out.println("3. Prefix to Postfix");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            switch (choice) {
                case 1:
                    System.out.print("Enter the infix expression: ");
                    expression = scanner.nextLine();
                    System.out.println("Postfix expression: " + infixToPostfix(expression));
                    break;
                case 2:
                    System.out.print("Enter the infix expression: ");
                    expression = scanner.nextLine();
                    System.out.println("Prefix expression: " + infixToPrefix(expression));
                    break;
                case 3:
                    System.out.print("Enter the prefix expression: ");
                    expression = scanner.nextLine();
                    System.out.println("Postfix expression: " + prefixToPostfix(expression));
                    break;
                case 4:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 4);
        scanner.close();
    }
}
