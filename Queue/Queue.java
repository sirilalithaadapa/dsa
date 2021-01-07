public class Queue {
	public static final int DEFAULT_SIZE = 5;
	
	private int queue[];
	
	private int index;
	
	public Queue() {
		queue = new int[DEFAULT_SIZE];
	}
	
	public Queue(int size) {
		queue = new int[size];
	}
	
	public boolean isEmpty() {
		return index == 0;
	}
	
	public void enqueue (int num) throws Exception {
		if (index == queue.length - 1) {
			throw new Exception("Queue is full.");
		}
		
		queue[index] = num;
		index++;
	}
	
	public int dequeue() throws Exception {
		if (isEmpty()) {
			throw new Exception("Queue is empty");
		}
		
		int removed = queue[0];
		for (int i = 0; i < queue.length - 1; i++) {
			queue[i] = queue[i + 1];
		}
		
		index--;
		return removed;
	}
	
	public void print() {
        System.out.println(index);
		for (int i = 0; i < index; i++) {
			System.out.print(queue[i] + " ");
		}
		System.out.println();
	}

	// Driver code!
	public static void main(String[] args) throws Exception {
		Queue MyQueue = new Queue(6);
		MyQueue.enqueue(1);
		MyQueue.enqueue(2);
		MyQueue.enqueue(3);
		MyQueue.enqueue(4);
		MyQueue.enqueue(5);  
		MyQueue.print();
        MyQueue.dequeue();
        MyQueue.print();
		MyQueue.enqueue(6);
		MyQueue.print();
		MyQueue.enqueue(7); // throws exception
		
	}
}
