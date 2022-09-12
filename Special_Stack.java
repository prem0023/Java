// Special Stack --> find min element in stack in O(1) Time and Space

class GfG {
	int min = Integer.MAX_VALUE;

	public void push(int a, Stack<Integer> s) {
		// add code here.
		if (a < min) {
			s.push(2 * a - min);
			min = a;
			return;
		}
		s.push(a);
	}

	public int pop(Stack<Integer> s) {
		if (s.isEmpty())
			return -1;
		if (s.peek() < min) {
			int a = s.pop();
			min = 2 * min - a;
			return a;
		}
		return s.pop();
	}

	public int min(Stack<Integer> s) {
		// add code here.
		if(s.isEmpty())
		    return -1;
		return min;
	}

	public boolean isFull(Stack<Integer> s, int n) {
		// add code here.
		return (s.size() == n);
	}

	public boolean isEmpty(Stack<Integer> s) {
		// add code here.
		return (s.size() == 0);
	}
}