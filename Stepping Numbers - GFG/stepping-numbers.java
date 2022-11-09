//{ Driver Code Starts
//Initial Template for Java


//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String input_line[] = read.readLine().trim().split("\\s+");
            int  N = Integer.parseInt(input_line[0]);
            int  M = Integer.parseInt(input_line[1]);
            
            Solution ob = new Solution();
            int ans = ob.steppingNumbers(N, M);
            System.out.println(ans);
        }
    }
}



// } Driver Code Ends


//User function Template for Java

class Solution{
    int ans;
    int steppingNumbers(int n, int m){
        // code here
        ans = 0;
        if(n == 0)
            ans++;
        for(int i = 1; i <= 9; i++)
            find(i, i, n, m);
        return ans;
    }
    
    void find(int prev, int num, int lo, int hi){
        if(num >= lo && num <= hi)
            ans++;
        if(num > hi)
            return;
        if(prev != 0)
            find(prev - 1, num * 10 + prev - 1, lo, hi);
        if(prev != 9)
            find(prev + 1, num * 10 + prev + 1, lo, hi);
    }
}