//Delete Middle Element of Stack using Recursion

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

public class Solution {

	static MyStack deleteMiddle(MyStack stack, int n, int i) {
		
		if(n <= i+1) {
			@SuppressWarnings("unused")
			int x = stack.pop();
			return stack;
		}
		int k = stack.pop();
		
		MyStack s = deleteMiddle(stack,n-1,i+1);
		s.push(k);
		return s;
		
	}
		
	
	public static void main(String[] args) {
		MyStack theStack = new MyStack(10);
		theStack.push(6);
		theStack.push(2);
		theStack.push(1);
		theStack.push(4);
		theStack.push(5);
		//theStack.push(9);
		
		MyStack temp = deleteMiddle(theStack,5,0);
		
		while (!temp.isEmpty()) {
			int value = temp.pop();
			System.out.print(value);
			System.out.print(" ");
		}
		System.out.println("");
	}
}