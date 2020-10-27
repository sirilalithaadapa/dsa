package ds;

public class MinStack {
	int capacity;
	int numElements;
	int[] stackArr;
	int[] minStackArr;
	
	MinStack(int size) {
        capacity = size;
        stackArr = new int[size];
        minStackArr = new int[size];
        assert(stackArr != null);
        numElements = 0;
    }
	
	int getTop() {
        return (numElements == 0 ? -1 : stackArr[numElements - 1]);
    }
    
    int min() {
        return (numElements == 0 ? -1 : minStackArr[numElements - 1]);
    }
    
    
    boolean push(int value) {
        if (numElements >= capacity) {
            System.out.println("Stack Full.");
            return false;
        }
        
        if (numElements == 0) {
            stackArr[numElements] = value;
            minStackArr[numElements] = value;
        } else {
            stackArr[numElements] = value;
            if (value >= min()) {
                minStackArr[numElements] = min();
            } else {
               minStackArr[numElements] = value; 
            }
        }
        
        numElements++;
        return true;
    }
    
    int pop() {
        if (numElements == 0) {
        	System.out.println("Stack Empty.");
            return -1;
        } else {
            numElements--;
            return stackArr[numElements];
        }
    }
    
    boolean isEmpty() {
    	return (numElements == 0);
    }

    
    int getSize() {
    	return numElements;
    }

    
    void showStack() {
    	int i = 0;
    	while (i < numElements) {
    		System.out.print(stackArr[numElements - 1 - i]);
    	i++;
    	}
    	System.out.println();
    }
    
    // Test
    public static void main(String[] args) {
    	MinStack stack = new MinStack(6);
        stack.push(5);
        stack.push(2);
        stack.push(4);
        stack.push(1);
        stack.push(3);
        stack.push(9);
        
        System.out.println(stack.min());
        
        stack.pop();
        stack.pop();
        stack.pop();
        
        System.out.println(stack.min());
    }

}
