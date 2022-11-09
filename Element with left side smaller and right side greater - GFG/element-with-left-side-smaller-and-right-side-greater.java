//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
	public static void main(String[] args) throws IOException
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while(t-- > 0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            int[] a = new int[n];
            String[] inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(inputLine[i]);
            }
            
            Compute obj = new Compute();
            System.out.println(obj.findElement(a, n));
            
        }
	}
}
// } Driver Code Ends


//User function Template for Java

class Compute {
    public int findElement(int arr[], int n){
        int minFromRight[] = new int[n-2];
        int maxLeft = arr[0], minRight = Integer.MAX_VALUE;
        for(int i=n-1;i>1;--i) {
            if(arr[i] < minRight) {
                minRight = arr[i];
            }
            minFromRight[i-2] = minRight;
        }
        for(int i=1;i<n-1;++i) {
            if(arr[i] >= maxLeft) {
                maxLeft = arr[i];
                if(arr[i] <= minFromRight[i-1]) {
                    return arr[i];
                }
            }
        }
        return -1;
    }
}