//Next Right Greater Element

// Method 1 --> Time O(n), Space O(n)
class Solution
{
    
    //Function to find the next greater element for each element of the array.
    public static long[] nextLargerElement(long[] arr, int n)
    { 
        // Your code here
        Stack<Long> st = new Stack<Long>();
        //int[] ans = new int[n];
        long a = 0;
        for(int i=n-1;i>=0;i--){
            a = arr[i];
            if(st.isEmpty())
                arr[i] = -1;
                
            else{
                while(!st.isEmpty()){
                    if(a < st.peek()){
                        arr[i] = st.peek();
                        break;
                    }
                    else
                        st.pop();
                    arr[i] = -1;
                }
            }
            st.push(a);
            //j--;
        }
        return arr;
    } 
}

/*
Method 2 --> Time O(n) space O(2*n)
class Solution
{
    //Function to find the next greater element for each element of the array.
    public static long[] nextLargerElement(long[] arr, int n)
    { 
        // Your code here
        Stack<Long> st = new Stack<Long>();
        long[] l = new long[n];
        
        for(int i=n-1;i>=0;i--){
            if(st.isEmpty())
                l[i] = -1;
                
            else{
                while(!st.isEmpty()){
                    if(arr[i] < st.peek()){
                        l[i] = st.peek();
                        break;
                    }
                    else
                        st.pop();
                    l[i] = -1;
                }
            }
            st.push(arr[i]);
        }
        return l;
    } 
}
*/
