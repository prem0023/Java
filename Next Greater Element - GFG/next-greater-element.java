//{ Driver Code Starts
/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0){
		    int n = Integer.parseInt(br.readLine().trim());
		    String inputLine[] = br.readLine().trim().split(" ");
		    long[] arr = new long[n];
		    for(int i=0; i<n; i++)arr[i]=Long.parseLong(inputLine[i]);
		    Solution ob = new Solution();
		    long[] res = ob.nextLargerElement(arr, n);
		    for (int i = 0; i < n; i++) 
		        System.out.print(res[i] + " ");
		    System.out.println();
		}
	}
}




// } Driver Code Ends



class Solution{
    public static long[] nextLargerElement(long[] arr, int n) { 
        // Your code here
        Stack<Long> st = new Stack<>();
        long[] ans = new long[n];
        
        for(int i=n-1; i>=0; i--){
            while(!st.isEmpty()){
                long l = st.peek();
                if(l > arr[i]){
                    ans[i] = l;
                    st.push(arr[i]);
                    break;
                }
                else
                    st.pop();
            }
            if(ans[i] == 0){
                ans[i] = -1;
                st.push(arr[i]);
            }
        }
        return ans;
    }
}