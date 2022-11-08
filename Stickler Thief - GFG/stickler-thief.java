//{ Driver Code Starts
import java.util.*;
import java.io.*;

class GFG
 {
	public static void main (String[] args)
	 {
	  
	  //taking input using Scanner class
	  Scanner sc = new Scanner(System.in);
	  
	  //taking count of testcases
	  int t = sc.nextInt();
	  while(t-- > 0){
	      
	      //taking count of houses
	      int n = sc.nextInt();
	      int arr[] = new int[n];
	      
	      //inserting money present in 
	      //each house in the array
	      for(int i = 0; i<n; ++i)
	           arr[i] = sc.nextInt();
  	      
  	      //calling method FindMaxSum() of class solve
  	      System.out.println(new Solution().FindMaxSum(arr, n));
	 }
   }
}
// } Driver Code Ends


class Solution
{
    //Function to find the maximum money the thief can get.
    public int FindMaxSum(int arr[], int n)
    {
        // Your code here
        int[] dp = new int[n+1];
        
        for(int i=0; i<=n; i++)
            dp[i] = -1;
        
        return getMaxSum(arr, dp, n);
    }
    
    int getMaxSum(int[] arr, int[] dp, int n){
        
        if(n == 0)
            return 0;
        if(n == 1)
            return arr[n-1];
        
        if(dp[n] != -1)
            return dp[n];
        
        int x = getMaxSum(arr, dp, n-1);
        int y = getMaxSum(arr, dp, n-2) + arr[n-1];
        
        if(x > y)
            dp[n] = x;
        else
            dp[n] = y;
        
        return dp[n];
    }
}

/*

class Solution
{
    //Function to find the maximum money the thief can get.
    public int FindMaxSum(int arr[], int n)
    {
        // Your code here
        
        int prev2=0,prev1=arr[0];
        
        for(int i=1;i<n;i++){
            int pick=arr[i]+prev2;
            int not_pick=prev1;
            
            int curr=Math.max(pick,not_pick);
            prev2=prev1;
            prev1=curr;
        }
        
        return prev1;
    }
}

*/
