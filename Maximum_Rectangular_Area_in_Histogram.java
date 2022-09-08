// Maximum Rectangular Area in a Histogram

//Method 1
class Solution {
     public int largestRectangleArea(int[] heights) {
        int[] value = new int[heights.length];
        int[] indexs = new int[heights.length];

        int index = -1;
        int max = 0;
        for (int i = 0; i < heights.length; i++) {
            if (index == -1 || value[index] < heights[i]) {
                index++;
                value[index] = heights[i];
                indexs[index] = i;
            } 
            else if (value[index] > heights[i]) {
                while (index >= 0 && value[index] >= heights[i]) {
                    max = Math.max(max, value[index] * (i - indexs[index]));
                    index--;
                }
                index++;
                value[index] = heights[i];
            }
        }

        while (index >= 0) {
            max = Math.max(max, value[index] * (heights.length - indexs[index]));
            index--;
        }

        return max; 
    }
}

/*
//Method 2
class Solution
{
    //Function to find largest rectangular area possible in a given histogram.
    public static long getMaxArea(long hist[], long n) 
    {
        // your code here
        long max_area = hist[0];

        long[] left = new long[(int)n];
        left = nextSmallerLeft(hist, (int)n, left);
        
        long[] right = new long[(int)n];
        right = nextSmallerRight(hist, (int)n, right);
        
        for(int i=0; i<n; i++){
            max_area = Math.max(max_area, hist[i]*(right[i]-left[i]-1));
        }
        
        return max_area;
    }
    public static long[] nextSmallerLeft(long hist[], int n, long[] left){
        
        Stack<Integer> st = new Stack<Integer>();
        left[0] = -1;
        st.push(0);
        
        for(int i=1; i<n; i++){
            if(hist[i] > hist[i-1]){
                left[i] = i-1;
            }
            else{
                left[i] = -1;
                while(!st.isEmpty()){
                    if(hist[st.peek()] < hist[i]){
                        left[i] = st.peek();
                        break;
                    }
                    st.pop();
                }
            }
            st.push(i);
        }
        return left;
    }
    
    public static long[] nextSmallerRight(long hist[], int n, long[] right){
        
        Stack<Integer> st = new Stack<Integer>();
        st.push(n-1);
        right[n-1] = n;
        
        for(int i=n-2; i>=0; i--){
            if(hist[i] > hist[i+1])
                right[i] = i+1;
            else{
                right[i] = n;
                while(!st.isEmpty()){
                    if(hist[st.peek()] < hist[i]){
                        right[i] = st.peek();
                        break;
                    }
                    st.pop();
                }
            }
            st.push(i);
        }
        return right;
    }
}
*/