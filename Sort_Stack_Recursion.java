// Sort Stack using Recursion

class MyStack {
	private int maxSize;
	private int[] stackArray;
	private int top;

	public MyStack(int s) {
		maxSize = s;
		stackArray = new int[maxSize];
		top = -1;
	}

	public void push(int j) {
		stackArray[++top] = j;
	}

	public int pop() {
		return stackArray[top--];
	}

	public int peek() {
		return stackArray[top];
	}

	public boolean isEmpty() {
		return (top == -1);
	}

	public boolean isFull() {
		return (top == maxSize - 1);
	}
}

public class Sort_Stack_Recursion {

	static MyStack sortStack(MyStack stack) {
		
		if(stack.isEmpty())
			return stack;
		
		int p = stack.pop();
		stack = sortStack(stack);
		
		MyStack temp = insertElement(stack,p);
		
		return temp;
	}
	
	static MyStack insertElement(MyStack stack, int p) {
		if(stack.isEmpty() || stack.peek() > p) {
			stack.push(p);
			return stack;
		}
	
		int x = stack.pop();
		MyStack s = insertElement(stack,p);
		s.push(x);
		
		return s;
	}
	
	public static void main(String[] args) {
		MyStack theStack = new MyStack(10);
		theStack.push(6);
		theStack.push(2);
		theStack.push(1);
		theStack.push(4);
		theStack.push(5);
		
		MyStack temp = sortStack(theStack);
		
		while (!temp.isEmpty()) {
			int value = temp.pop();
			System.out.print(value);
			System.out.print(" ");
		}
		System.out.println("");
	}
}