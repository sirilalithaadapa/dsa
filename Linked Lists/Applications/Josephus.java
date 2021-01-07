import java.util.ArrayList;
import java.util.Scanner;
import java.lang.Math;   

class Node {
	int value;
	Node next;
	
	public Node(int value) {
		this.value = value;
	}
}

class CircularLL {
	Node head;
	Node tail;
	
	public CircularLL() {
		head = null;
		tail = null;
	}
	
	public void append(int value) {
		Node newNode = new Node(value);
		if (head == null) {
			head = newNode;
		} else {
			tail.next = newNode;
		}
		
		tail = newNode;
		tail.next = head;
	}
	
	public void delete(int value) {
		Node currentNode = head;
		 
	    if (head != null) {
	        if (currentNode.value == value) {
	            head = head.next;
	            tail.next = head;
	        } else {
	            do {
	                Node nextNode = currentNode.next;
	                if (nextNode.value == value) {
	                    currentNode.next = nextNode.next;
	                    break;
	                }
	                currentNode = currentNode.next;
	            } while (currentNode != head);
	        }
	    }
	}
	
	public void print() {
	    Node currentNode = head;
	 
	    if (head != null) {
	        do {
	            System.out.print(currentNode.value + " ");
	            currentNode = currentNode.next;
	        } while (currentNode != head);
	    }
	    
	    System.out.println();
	}
}
public class Josephus {
	
	public static int getJosephusPosition(CircularLL l, int n, int m) {
		
		ArrayList seen = new ArrayList();
		
		if (l.head == null) {
			return -1;
		}
		
		if (l.head == l.tail) {
			return 1;
		}
		
		Node curr = l.head, prev = l.head;
		
		while (curr.next != curr) {
			int count = 1;
			
			while (count != m) {
				prev = curr;
				curr = curr.next;
				count++;
			}
			
			prev.next = curr.next;
			curr = prev.next;
		}
		
		return curr.value;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter n value: ");
		int n = sc.nextInt();
		System.out.print("Enter m value: ");
		int m = sc.nextInt();
		
		CircularLL list = new CircularLL();
		
		for (int i = 1; i <= n; i++) {
			list.append(i);
		}
				
		System.out.println("Josephus Position: " + getJosephusPosition(list, n, m));
	}

}
