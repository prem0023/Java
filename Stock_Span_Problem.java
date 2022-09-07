// Stock span problem

// Method 2 --> Using Stack
class Solution
{
    public static int[] calculateSpan(int price[], int n)
    {

        Stack<Integer> st = new Stack<>();
        st.push(0);
        int[] S = new int[n];
 
        S[0] = 1;
        int c = 1;
    
        for (int i = 1; i < n; i++) {
            if(price[i] < price[i-1]){
                S[i] = 1;
                st.push(i-1);
            }
            else{
                while(!st.isEmpty()){
                    if(st.peek() >= 0 && price[st.peek()] > price[i]){
                        S[i] = i - st.peek();
                        st.push(st.peek());
                        break;
                    }
                    st.pop();
                }
                if(st.isEmpty() || st.peek() == -1){
                    S[i] = i+1;
                    st.push(-1);
                }
            }
            
        }
        
        return S;
    }
    
}

/*
// Method 2 --> Using array
class Solution
{
    //Function to calculate the span of stockâ€™s price for all n days.
    public static int[] calculateSpan(int price[], int n)
    {
        // Your code here
        //Stack<Integer> stack = new Stack<Integer>();
        int[] arr = new int[n];
        int k = 1;
        int c = 1;
        arr[0] = 1;
        
        for(int i=1; i<n; i++){
            c = 1;
            if(price[i] >= price[i-1]){
                c = c + arr[i-1];
                int j = i - arr[i-1] - 1;
                while(j >= 0 && price[j] <= price[i]){
                    c = c + arr[j];
                    j = j - arr[j];
                }
            }
            arr[k++] = c;
        }
        return arr;
    }   
}
*/