public class MyLinkedList <T>{
	Node head; // Head of list
	
	class Node {
		T data;
		Node next;
		
		// Constructors
		
		Node (T d) {
			data = d;
			next = null;
		}
	}
	
	public MyLinkedList() { // Linked List HeaderNode
		head = new Node(null);
	}
	
	public MyLinkedList(T data) { // Linked List HeaderNode
		head = new Node(data);
	}
	
	// Defining the method to Insert at front => O(1)
	public void insertFront(T data) {
		
		Node newNode = new Node(data);
		newNode.next = this.head.next;
		this.head.next = newNode;
		
	}
	
	public void insertEnd(T data) {
		Node newNode = new Node(data);
		
		// If LL is empty then make the new node as head
		if (this.head.data == null) {
			this.head = newNode;
		}
		else {
			// Else traverse till last node & insert the new node
			Node currNode = this.head;
			while (currNode.next != null) {
				currNode = currNode.next;
			}
			currNode.next = newNode;
		}
	}
	
	public void insertKey(T data, T key) {
		Node newNode = new Node(data);
		newNode.next = null;
		Node temp = this.head;
		
		boolean status = false;
		
		while (temp != null) {
			if (temp.data == key) {
				status = true;
				break;
			}
			temp = temp.next;
		}
		
		if (status) {
			newNode.next = temp.next;
			temp.next = newNode;
		}
	}

	
	// Removes the value in the list
	public void deleteKey(T key) {
		Node currNode = this.head;
		Node prev = null;
		
		if (currNode != null && currNode.data == key) {
			this.head = currNode.next;
			
			System.out.println(key + " found and deleted");
		}
		
		while (currNode != null && currNode.data != key) {
			prev =currNode;
			currNode = currNode.next;
		}
		
		if (currNode != null) {
			prev.next= currNode.next;
			
			System.out.println(key + " found and deleted"); 
		}
		
		if (currNode == null) {
			System.out.println(key + " not found");
		}
	}
	
	// Removes the element at certain index
	public void pop(int index) {
		Node currNode = this.head, prev = null;
		
		if (index == 1 && currNode != null) {
			this.head = currNode.next;
			
			System.out.println(index + " position element deleted");
		}
		
		int counter = 0;
		
		while(currNode != null) {
			if (counter == index) {
				prev.next = currNode.next;
				
				System.out.println(index + " position element deleted");
				break;
			} else {
				prev = currNode;
				currNode = currNode.next;
				counter++;
			}
		}
		
		if (currNode == null) {
			System.out.println(index + " position element not found"); 
		}
	}
	
	
	public void concatenate(MyLinkedList<T> l2) {
		Node l1Node = this.head;
		Node l2Node = l2.head;
		
		while (l1Node.next != null) {
			l1Node = l1Node.next;
		}
		
		l1Node.next = l2Node;
		//free(l2.head);
	}
	
	public MyLinkedList<T> merge(MyLinkedList<T> l2) {
		Node l1Node = this.head;
		Node l2Node = l2.head;
		
		MyLinkedList l3 = new MyLinkedList();
		
		while (l1Node != null && l2Node != null) {
			l3.insertEnd(l1Node.data);
			l3.insertEnd(l2Node.data);
			
			l1Node = l1Node.next;
			l2Node = l2Node.next;
		}
		
		while (l1Node != null) {
			l3.insertEnd(l1Node.data);
			l1Node = l1Node.next;
		}
		
		while (l2Node != null) {
			l3.insertEnd(l2Node.data);
			l2Node = l2Node.next;
		}
		return l3;
	}
	
	public void printList() {
		Node currNode = this.head;
		
		while (currNode != null) {
			System.out.print(currNode.data + " ");
			currNode = currNode.next;
		}
		System.out.println();
	}
	
	
}
