//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    int n = sc.nextInt();
                    int A[] = new int[n];
                    for(int i = 0;i<n;i++)
                        A[i] = sc.nextInt();
                    Solution ob = new Solution();
                    System.out.println(ob.minDifference(A,n));
                }
        }
}    
// } Driver Code Ends


//User function Template for Java

class Solution
{

	public int minDifference(int arr[], int n) 
	{ 
	    if(n == 0)
	        return 0;
	    else if(n == 1)
	        return arr[0];
	    
	    int w = 0;
	    
	    for(int i=0;i<n;i++){
	        w = w + arr[i];
	    }
	    
	    int w1 = w/2;
	    if(w%2 == 0)
	        w = w1;
	    else
	        w = w1 + 1;
	    
        int sum = 0;
	    int[][] t = new int[n+1][w+1];
	    
	    for(int i=0;i<=n;i++){
	        for(int j=0;j<=w;j++){
	            if(i == 0)
	                t[i][j] = j;
	            else if(j == 0){
	                sum = sum + arr[i-1];
	                t[i][j] = sum;
	            }
	            else
	                break;
	        }
	        
	    }
	    
	    for(int i=1;i<=n;i++){
	        for(int j=1;j<=w;j++){
	            
	            int p1 = t[i-1][j];
	            int p2 = Integer.MAX_VALUE;
	    
	            if(arr[i-1] <= j){
	                p2 = t[i-1][j-arr[i-1]];
	                
	                if(p1<p2)
	                    t[i][j] = p1;
	                else
	                    t[i][j] = p2;
	            }
	            else
	                t[i][j] = p1;
	            
	        }
	    }
	    return Math.abs(w1 - w + 2 * t[n][w]); 
	    
	} 
}