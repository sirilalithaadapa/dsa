import java.util.Scanner;

class DoublyLinkedList {
    Node head, tail;
    Scanner input = new Scanner(System.in);

    /**Node class (Node => component of DLL) */
    class Node {
        Node prev;
        int data;
        Node next;
    
        /**Node Constructor */
        Node (int d) {
            data = d;
            next = prev = null;
        }
    }

    /**DLL Constructor */
    DoublyLinkedList() {
        head = tail = null;
    }

    /*Creates a DLL with given number of nodes*/
    void create (int n) {
        Node temp;
        for (int i = 0; i < n; i++) {
            System.out.print("Enter data: ");
            int data = input.nextInt();

            temp = new Node(data);
            if (head == null) {
                head = tail = temp;
                head.prev = null;
            } else {
                tail.next = temp;
                temp.prev = tail;
                tail = temp;
            }
        }
    }

    /* Prints the Doubly Linked List*/
    void displayForward() {
        Node temp;
        for (temp = head; temp != null; temp = temp.next) {
            System.out.print(temp.data + " -> ");
        }
        System.out.println("null");
    }

    //* Prints the Doubly Linked List in reverse order*/
    void displayBackward() {
        Node temp;
        for (temp = tail; temp != null; temp = temp.prev) {
            System.out.print(temp.data + " -> ");
        }
        System.out.println("null");
    }
    
    void insertFront() {
        System.out.print("Enter data: ");
        int data = input.nextInt();
        Node temp = new Node(data);

        head.prev = temp;
        temp.next = head;
        head = temp;

    }

    void insertEnd() {
        System.out.print("Enter data: ");
        int data = input.nextInt();
        Node temp = new Node(data);

        tail.next = temp;
        temp.prev = tail;
        tail = temp;
    }

    void insertAt(int k) {
        System.out.print("Enter data: ");
        int data = input.nextInt();
        Node temp = new Node(data);

        int i;
        Node curr;
        for (curr = head, i = 0; i < k - 1 && curr != null; i++, curr = curr.next) {
            // jus traverse
        }

        temp.next = curr.next;
        temp.prev = curr;

        curr.next.prev = temp;
        curr.next = temp;
    }

    void deleteFront () {
        Node temp = head;
        head = temp.next;
        head.prev = null;
        temp = null;
    }

    void deleteEnd() {
        Node temp = tail;
        tail = temp.prev;
        tail.next = null;
        temp = null;
    }

    void deleteInd (int k) {
        int i;
        Node curr;
        for (curr = head, i = 0; i < k - 1 && curr != null; i++, curr = curr.next) {
            // jus traverse
        }

        Node temp;
        temp = curr.next;
        curr.next = temp.next;
        temp.next.prev = curr;
        temp = null;
    }

}


public class DoublyLinkedListDemo {
    public static void displayMenu() {
        System.out.println("*********OPERATIONS**************");
        System.out.println("1.Insert At Front\n2.Insert At index\n3.Insert At End");
        System.out.println("4.Delete At Front\n5.Delete particular index\n6. Delete At End");
        System.out.println("7.Display List\n8. Display list in reverse order");
        System.out.println("9.Exit");
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        DoublyLinkedList dll = new DoublyLinkedList();

        System.out.print("Enter size of list: ");
        int size = scan.nextInt();

        dll.create(size);

        while (true) {
            displayMenu();
            boolean quit = false;
            System.out.print("Enter you choice: ");
            int choice = scan.nextInt();
            switch  (choice) {
                case 1: {
                    dll.insertFront();
                    break;
                }
                case 2: {
                    System.out.print("Enter index: ");
                    int indx = scan.nextInt();
                    dll.insertAt(indx);
                    break;
                }
                case 3: {
                    dll.insertEnd();
                    break;
                }
                case 4: {
                    dll.deleteFront();
                    break;
                }
                case 5: {
                    System.out.print("Enter index: ");
                    int indx = scan.nextInt();
                    dll.deleteInd(indx);
                    break;
                }
                case 6: {
                    dll.deleteEnd();
                    break;
                }
                case 7: {
                    dll.displayForward();
                    break;
                }
                case 8: {
                    dll.displayBackward();
                    break;
                }
                case 9 : {
                    quit = true;
                    break;
                }
                default : {
                    System.out.println("Enter one of the given choices");
                }
            }

            if (quit) {
                break;
            }
        }
        scan.close();
    }
}
