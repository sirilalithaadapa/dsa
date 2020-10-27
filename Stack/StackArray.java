// Stack ADT using arrays in Java

class StackArray {

    private int[] stack;
    private int size;

    // creating a stack
    public StackArray () {
        stack = new int[10];
        size = 0;
    }

    // checks if stack is empty or not
    public boolean isEmpty () {
        if (size == 0) {
            return true;
        }
        return false;
    }

    public int[] copy (int[] stack, int size) {
        int[] copyStack = new int[2 * size];
        for (int i = 0; i < size; i++) {
            copyStack[i] = stack[i];
        }
        return copyStack;
    }

    // pushing an element into a stack
    public void push (int num) {
        if (stack.length <= size) {
            stack = copy(stack, size);
        }
        stack[size++] = num;
    }

    // pop an element from a stack
    public int pop () {
        int popedNum = stack[size];
        stack[size--] = 0;
        return popedNum;
    }

    // peek the top element in the stack
    public int peek () {
        return stack[size - 1];
    }

    // gives the size of the stack
    public int size () {
        return size;
    }

    // printing the stack
    public void print() {
        for (int i = 0; i < size; i++) {
            System.out.print(stack[i] + " ");
        }
        System.out.println();
    }
    
    // Driver code
    public static void main(String[] args) {
        StackArray stck = new StackArray();

        System.out.println("Is stack empty? " + stck.isEmpty()); // true

        stck.push(1);
        stck.push(2);
        stck.push(3);
        stck.push(4);
        stck.push(4);
        stck.pop();
        stck.push(5);
        stck.push(6);
        stck.push(7);
        stck.push(7);
        stck.pop();
        stck.push(8);
        stck.push(9);
        stck.push(10);
        stck.push(11);
        stck.push(12);
        stck.push(13);
        stck.push(14);
        stck.push(15);
        stck.print();

        System.out.println("Top element: " + stck.peek());      // 15
        System.out.println("Size: " + stck.size());             // 15
        System.out.println("Is stack empty? " + stck.isEmpty());// false
    }
}
