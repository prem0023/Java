//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Main {
    
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim()); //Inputting the testcases
		while(t-->0){
		    int n = Integer.parseInt(br.readLine().trim()); // size of array
		    int arr[] = new int[n];
		    String inputLine[] = br.readLine().trim().split(" ");
		    for(int i=0; i<n; i++){
		        arr[i] = Integer.parseInt(inputLine[i]); // input elements of array
		    }
		    
		    Solution ob = new Solution();
		    
		    System.out.println(ob.maxIndexDiff(arr, n)); // print the result
		}
	}
}
// } Driver Code Ends


class Solution{
    
    // A[]: input array
    // N: size of array
    // Function to find the maximum index difference.
    static int maxIndexDiff(int A[], int N)
    {
        int[] maxend = new int[N];
        maxend[N-1] = A[N-1];
        for(int i = N-2; i>=0;i--)
        {
            maxend[i] = Math.max(maxend[i+1], A[i]);
        }
        int i = 0; int j= 0; int max_i_diff = 0;
        while(i<N && j<N)
        {
            if(A[i]<=maxend[j])
            {
                max_i_diff = Math.max(max_i_diff, j-i);
                j++;
            }
            else i++;
        }
        return max_i_diff;
    }
}


