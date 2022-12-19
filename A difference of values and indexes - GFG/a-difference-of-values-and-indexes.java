//{ Driver Code Starts
//Initial Template for Java

//Initial Template for Java


/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;


class Array {
    
    // Driver code
	public static void main (String[] args) throws IOException{
		// Taking input using buffered reader
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testcases = Integer.parseInt(br.readLine());
		
		// looping through all testcases
		while(testcases-- > 0){
		    String line = br.readLine();
		    String[] element = line.trim().split("\\s+");
		    int n = Integer.parseInt(element[0]);
		     
		    int arr [] = new int[n];
		    
		    line = br.readLine();
		    String[] elements = line.trim().split("\\s+");
		    for(int i = 0;i<n;i++){
		        arr[i] = Integer.parseInt(elements[i]);
		    }
		    Solution obj = new Solution();
		    int ans = obj.maxDistance(arr, n);
		    System.out.println(ans);
		}
	}
}




// } Driver Code Ends


//User function Template for Java


class Solution{
    
   
    // Function for finding maximum and value pair
    public static int maxDistance (int arr[], int n) {
        //Complete the function
        int sum[] = new int[n];
        int diff[] = new int[n];
        
        for(int i=0;i<n;i++){
            sum[i]=(arr[i]+i);
            diff[i]=(arr[i]-i);
        }
        
        int max_sum=sum[0], min_sum=sum[0], max_diff=diff[0], min_diff=diff[0];
        
        for(int i=0;i<n;i++){
            if(max_sum<sum[i]){
                max_sum=sum[i];
            }
            if(min_sum>sum[i]){
                min_sum=sum[i];
            }
            if(max_diff<diff[i]){
                max_diff=diff[i];
            }
            if(min_diff>diff[i]){
                min_diff=diff[i];
            }
            
        }
        return Math.max(Math.abs(max_sum-min_sum), Math.abs(max_diff-min_diff));
    } 
    
}


