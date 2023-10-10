//{ Driver Code Starts
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
            int N = Integer.parseInt(read.readLine());
            String input_line[] = read.readLine().trim().split("\\s+");
            int arr[]= new int[N];
            for(int i = 0; i < N; i++)
                arr[i] = Integer.parseInt(input_line[i]);
            int sum = Integer.parseInt(read.readLine());

            Solution ob = new Solution();
            if(ob.isSubsetSum(N, arr, sum))
            System.out.println(1);
            else
            System.out.println(0);

            
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution{


    static Boolean isSubsetSum(int N, int arr[], int sum){
        // code here
        int[][] dp = new int[N+1][sum+1];
        
        for(int i=0; i<=N; i++){
            for(int j=0; j<=sum; j++){
                dp[i][j] = -1;
            }
        }
        
        return helper(arr, N, sum, dp);
    }
    
    private static boolean helper(int[] arr, int n, int sum, int[][] dp){
        if(sum == 0)
            return true;
        
        if(n == 0)
            return false;
        
        if(dp[n][sum] != -1)
            return dp[n][sum] == 1;
        
        if(sum >= arr[n-1]){
            boolean include = helper(arr, n-1, sum-arr[n-1], dp);
            boolean exclude = helper(arr, n-1, sum, dp);
            
            if(include || exclude){
                dp[n][sum] = 1;
            }
            else{
                dp[n][sum] = 0;
            }
            return include || exclude;
        }
        
        boolean exclude =  helper(arr, n-1, sum, dp);
        
        if(exclude){
            dp[n][sum] = 1;
        }
        else{
            dp[n][sum] = 0;
        }
        
        return dp[n][sum] == 1;
    }
}