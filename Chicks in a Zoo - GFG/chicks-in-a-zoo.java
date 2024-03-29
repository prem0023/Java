//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int N = Integer.parseInt(br.readLine().trim());
            Solution obj = new Solution();
            long ans = obj.NoOfChicks(N);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public long NoOfChicks(int N)
    {
        // Code here
        long[] arr = new long[N+1];
        
        return getChicks(N, arr);
    }
    
    long getChicks(int n, long[] arr){
        if(n == 1)
            return 1;
        if(arr[n] != 0)
            return arr[n];
        
        if(n <= 6)
            arr[n] = 3 * getChicks(n-1, arr);
        else if(n == 7)
            arr[n] = 3 * (getChicks(n-1, arr)-1);
        else
            arr[n] = 3 * getChicks(n-1, arr) - 2 * getChicks(n-6, arr);
        
        return arr[n];
    }
}