import java.util.Scanner;

class PolyNode {
    int coeff, exp;
    PolyNode next;

    PolyNode() {}
    
    PolyNode(int c, int p) {
        coeff = c;
        exp = p;
        next = null;
    }
}

public class Polynomial {
    Scanner in = new Scanner(System.in);
    PolyNode head, tail;

    Polynomial () {
        head = tail = null;
    }

    /** Creating a polynomial with n terms */
    void create (int n) {
        PolyNode temp;

        for (int i = 0; i < n; i++) {
            System.out.print("Enter coefficient and exponent: ");

            int c = in.nextInt();
            int p = in.nextInt();

            temp = new PolyNode(c, p);

            if (head == null) {
                head = tail = temp;
            } else {
                tail.next = temp;
                tail = temp;
            }
        }

    }

    /**
     * Adding two polynomials
     * 
     * @return PolyNode
     */
    Polynomial add(Polynomial p) {

        PolyNode node1 = this.head;
        PolyNode node2 = p.head;

        Polynomial addPoly = new Polynomial();
        PolyNode node3;

        while (node1 != null && node2 != null) {

            node3 = new PolyNode();
            if (node1.exp == node2.exp) {
                node3.coeff = node1.coeff + node2.coeff;
                node3.exp = node1.exp;

                node1 = node1.next;
                node2 = node2.next;
            }
            
            else if (node1.exp > node2.exp) {
                node3.coeff = node1.coeff ;
                node3.exp = node1.exp;

                node1 = node1.next;
            }

            else {
                node3.coeff = node2.coeff ;
                node3.exp = node2.exp;

                node2 = node2.next;
            }

            if (addPoly.head == null) {
                addPoly.head = addPoly.tail = node3;
            } else {
                addPoly.tail.next = node3;
                addPoly.tail = node3;
            }

        }

        while (node1 != null) {
            node3 = new PolyNode();

            node3.coeff = node1.coeff ;
            node3.exp = node1.exp;

            node1 = node1.next;
            
            if (addPoly.head == null) {
                addPoly.head = addPoly.tail = node3;
            } else {
                addPoly.tail.next = node3;
                addPoly.tail = node3;
            }
        }

        while (node2 != null) {
            node3 = new PolyNode();

            node3.coeff = node2.coeff ;
            node3.exp = node2.exp;

            node2 = node2.next;
            
            if (addPoly.head == null) {
                addPoly.head = addPoly.tail = node3;
            } else {
                addPoly.tail.next = node3;
                addPoly.tail = node3;
            }
        }

        return addPoly;
        
    }

    void display() {
        PolyNode temp;

        for (temp = head; temp != null; temp = temp.next) {
            if (temp.next != null) {
                System.out.print(temp.coeff + "x ^ " + temp.exp + " + ");
            } else {
                System.out.println(temp.coeff);
            }
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        Polynomial p1 = new Polynomial();
        Polynomial p2 = new Polynomial();

        System.out.print("No of terms in polynomial 1: ");
        int n1 = input.nextInt();
        p1.create(n1);

        System.out.print("No of terms in polynomial 2: ");
        int n2 = input.nextInt();
        p2.create(n2);

        Polynomial  p3 = p1.add(p2);

        p1.display();
        p2.display();
        p3.display();

        /*
        Sample Output:
        
        No of terms in polynomial 1: 3
        Enter coefficient and exponent: 2 2
        Enter coefficient and exponent: 4 1
        Enter coefficient and exponent: 1 0
        No of terms in polynomial 2: 3
        Enter coefficient and exponent: 6 2
        Enter coefficient and exponent: 3 1
        Enter coefficient and exponent: 3 0
        2x ^ 2 + 4x ^ 1 + 1
        6x ^ 2 + 3x ^ 1 + 3
        8x ^ 2 + 7x ^ 1 + 4
        */
    }
}
