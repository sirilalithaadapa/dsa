class Stack
{
	int stk[];
	int top;
	final int MAX = 6;
	public Stack()// Constructor initializes Stack & top
	{
		stk = new int[MAX];
		top = 0;	
	}
	public void push(int e)
	{
		if(isFull())
		{
			System.out.println("Stack is Overflow ..!");
			return;
		}
		stk[++top] = e;
		System.out.println("Item "+e+" pushed...");
	}

	public int pop()
	{
		if(isEmpty())
		{
			System.out.println("Stack is Underflow..!");
			return -1;
		}
		int k = stk[top--];
		return k;
	}

	public boolean isFull()
	{
		return (top==MAX-1)? true : false ;		
	}

	public boolean isEmpty()
	{
		return (top == 0)? true : false ;
	}

	public int peek()
	{
		return stk[top]; // returns topmost element in the stack
	}

	public void viewStack()
	{
		if(isEmpty())
		{
			System.out.println("No Data in Stack...!");
			return;
		}

		System.out.println("\n The Content of Stack is...\n");
		for(int i = top; i>0;i--)
			System.out.print(stk[i]+"  ");
	}
}


public class StackADT
{
	public static void main(String args[])
	{
		Stack obj = new Stack();
		obj.push(77);	
		obj.push(57);
		obj.push(47);
		obj.push(67);
		obj.push(12);
		obj.push(80);
		obj.viewStack();

		System.out.println("Topmost element = "+obj.peek());
		System.out.println("Popped..."+obj.pop());
		System.out.println("Popped..."+obj.pop());
		System.out.println("Popped..."+obj.pop());
		System.out.println("Topmost element = "+obj.peek());
		obj.push(100);
		obj.viewStack();
	}
}	