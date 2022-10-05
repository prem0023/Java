// Get minimum element from stack

class GfG
{
    int minEle = Integer.MAX_VALUE;
    Stack<Integer> s = new Stack<Integer>();

    /*returns min element from stack*/
    int getMin()
    {
	// Your code here
	    if(minEle == Integer.MAX_VALUE)
	        return -1;
	    return minEle;
    }
    
    /*returns poped element from stack*/
    int pop()
    {
	// Your code here
	    if(s.isEmpty())
	        return -1;
	    if(minEle > s.peek()){
	        int x = minEle;
	        minEle = 2*minEle - s.pop();
	        return x;
	    }
	    return s.pop();
    }

    /*push element x into the stack*/
    void push(int x)
    {
	// Your code here
	    if(x < minEle){
	        s.push(2*x-minEle);
	        minEle = x;
	    }
	    else
	        s.push(x);
	
    }	
}