class Node {
    int coeff;  // Coefficient of the term
    int exp;    // Exponent of the term
    Node next;  // Pointer to the next node
    Node prev;  // Pointer to the previous node

    public Node(int coeff, int exp) {
        this.coeff = coeff;
        this.exp = exp;
        this.next = null;
        this.prev = null;
    }
}

class LinkedList {
    Node first; 
    Node last;   

    public LinkedList() {
        this.first = null;
        this.last = null;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public void insertLast(Node newNode) {
        if (isEmpty()) {
            first = last = newNode;
        } else {
            last.next = newNode;
            newNode.prev = last;
            last = newNode;
        }
    }

    public void display() {
        Node cur = first;
        while (cur != null) {
            System.out.print(cur.coeff + "x^" + cur.exp);
            if (cur.next != null && cur.next.coeff >= 0) {
                System.out.print(" + ");
            }
            cur = cur.next;
        }
        System.out.println();
    }
}

public class PolynomialAddition {

    public static LinkedList polynomialAddition(LinkedList p, LinkedList q) {
        Node curP = p.first;
        Node curQ = q.first;
        LinkedList op = new LinkedList();

        while (curP != null && curQ != null) {
            if (curP.exp == curQ.exp) {
                if (curP.coeff + curQ.coeff != 0) {
                    Node nl = new Node(curP.coeff + curQ.coeff, curP.exp);
                    op.insertLast(nl);
                }
                curP = curP.next;
                curQ = curQ.next;
            } else if (curP.exp > curQ.exp) {
                Node nl = new Node(curP.coeff, curP.exp);
                op.insertLast(nl);
                curP = curP.next;
            } else {
                Node nl = new Node(curQ.coeff, curQ.exp);
                op.insertLast(nl);
                curQ = curQ.next;
            }
        }

        while (curP != null) {
            Node nl = new Node(curP.coeff, curP.exp);
            op.insertLast(nl);
            curP = curP.next;
        }

        while (curQ != null) {
            Node nl = new Node(curQ.coeff, curQ.exp);
            op.insertLast(nl);
            curQ = curQ.next;
        }

        return op;
    }

    public static void main(String[] args) {
        LinkedList p = new LinkedList();
        LinkedList q = new LinkedList();

        p.insertLast(new Node(3, 3));
        p.insertLast(new Node(2, 2));
        p.insertLast(new Node(5, 0));

        q.insertLast(new Node(4, 3));
        q.insertLast(new Node(1, 2));
        q.insertLast(new Node(-5, 0));

        System.out.print("Polynomial p: ");
        p.display();

        System.out.print("Polynomial q: ");
        q.display();

        LinkedList result = polynomialAddition(p, q);

        System.out.print("Resultant Polynomial after Addition: ");
        result.display();
    }
}
