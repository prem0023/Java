// N Stack

// Method 1

public class NStack {
    int[] arr;
    int[] top;
    int[] next;
    int freeStart;

    NStack(int N, int S) {
        arr = new int[S];
        top = new int[N + 1];
        next = new int[S];

        for (int i = 0; i < N + 1; i++) {
            top[i] = -1;
        }
        for (int i = 0; i < S - 1; i++) {
            next[i] = i + 1;
        }
        next[S - 1] = -1;
        freeStart = 0;
    }

    boolean push(int x, int m) {
        if (freeStart == -1) {
            return false;
        }
        int index = freeStart;
        freeStart = next[index];
        arr[index] = x;
        next[index] = top[m - 1];
        top[m - 1] = index;

        return true;
    }
    int pop(int m) {
        if (top[m - 1] == -1)
            return -1;
   
        int index = top[m - 1];
        top[m - 1] = next[index];
        next[index] = freeStart;
        freeStart = index;
        return arr[index];
    }
}


/*
// Method 2

//import java.util.Stack;

class NStack {
    // Initialize your data structure.
    int[] top;
    int[][] array;
    int size = 0;
    public NStack(int N, int S) {
        // Write your code here.
        array = new int[N][S];
        top = new int[N];
        for(int i=0; i<N; i++)
            top[i] = -1;
        size = S;
    }

    // Pushes 'X' into the Mth stack. Returns true if it gets pushed into the stack, and false otherwise.
    public boolean push(int x, int m) {
        if(size == 0)
            return false;
        //top[m] += 1;
        array[m-1][++top[m-1]] = x;
        size--;
        return true;
    }

    // Pops top element from Mth Stack. Returns -1 if the stack is empty, otherwise returns the popped element.
    public int pop(int m) {
        if(top[m-1] == -1 || size == array[0].length)
            return -1;
        size++;
//         top[m] -= 1;
        return array[m-1][top[m-1]--];
    }
}
public class Solution
{
	public static void main(String[] args) {
/*
15 30 10
2 10
1 33 3
2 9
2 15
1 13 1
2 3
2 5
1 12 12
1 44 12
1 12 12
*/
		NStack st = new NStack(15, 30);
		
		System.out.println(st.pop(10));
		System.out.println(st.push(33, 3));
		System.out.println(st.pop(9));
		System.out.println(st.pop(15)); //
		System.out.println(st.push(13, 1));
		System.out.println(st.pop(3));
		System.out.println(st.pop(5));
		System.out.println(st.push(12, 12));
		System.out.println(st.push(44, 12));
		System.out.println(st.push(12, 12));

	}
}
*/