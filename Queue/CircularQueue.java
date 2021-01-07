public class CircularQueue {

    private int[] queue;
    private int rear;
    private int front;
    private int size;

    public CircularQueue (int n) {
        size = n;
        queue = new int[size];
        rear = front = -1;
    }
    
	private int delete() {
		int elem = -1;
		if (front == -1 || rear ==-1) {
			System.out.println("Queue is Empty :(");
		} else if (rear == front) {
			elem = queue[front];
			rear = front = -1;
		} else if (front == size - 1) {
			elem = queue[front];
			front = 0;
		} else {
			elem = queue[front];
			front++;
		}
		
		return elem;
		
	}

	private void insert(int i) {
		if (front == rear + 1 || size == rear + 1) {
			System.out.println("Queue is Full :(");
			
		} else if (front == -1 && rear == -1) {
			front = rear = 0;
			queue[rear] = i;
		} else if (rear == size - 1) {
			rear = 0;
			queue[rear] = i;
			
		} else {
			rear++;
			queue[rear] = i;
		}
		
	}
	
	private void print() {
		if (front == -1) {
			System.out.println("Queue is Empty!");
			return;
		}
		
		if (rear >= front) {
			for (int i = front; i <= rear; i++) {
				System.out.print(queue[i] + " ");
			}
		} else {
				
			for (int i = front; i < size; i++) {
				System.out.print(queue[i] + " ");
			}	
		
			for (int i = 0; i <= rear; i++) {
				System.out.print(queue[i] + " ");
			}
		}
		
		System.out.println();
	}

	// Driver Code
    public static void main(String[] args) {
    	CircularQueue cqueue = new CircularQueue(5);
    	cqueue.print();     
        cqueue.insert(0);
        cqueue.print();
        cqueue.insert(10);
        cqueue.print();
        cqueue.insert(20);
        cqueue.print();
        cqueue.insert(30);
        cqueue.print();
        cqueue.delete();
        cqueue.print();
        cqueue.insert(40);
        cqueue.print();
        
        /* Output:
            Queue is Empty!
			0 
			0 10 
			0 10 20 
			0 10 20 30 
			10 20 30 
			10 20 30 40 
         */
    }

}
