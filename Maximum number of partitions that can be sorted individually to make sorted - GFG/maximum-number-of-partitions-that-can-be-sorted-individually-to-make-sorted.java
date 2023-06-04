//{ Driver Code Starts
//Initial Template for Java

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
		    int sizeOfArray = Integer.parseInt(element[0]);
		     
		    int arr [] = new int[sizeOfArray];
		    
		    line = br.readLine();
		    String[] elements = line.trim().split("\\s+");
		    for(int i = 0;i<sizeOfArray;i++){
		        arr[i] = Integer.parseInt(elements[i]);
		    }
		    Complete obj = new Complete();
		    int ans = obj.maxPartitions(arr, sizeOfArray);
		    System.out.println(ans);
		}
	}
}




// } Driver Code Ends



class Complete{
    
    // Function for finding maximum and value pair
    public static int maxPartitions (int arr[], int n) {
        int count = 0;
        int maxNum = arr[0];
        int i = 0;
        
        while(i <= maxNum && i < n){
            maxNum = Math.max(maxNum, arr[i]);
            if(i == maxNum){
                count++;
                if(i+1 < n){
                    maxNum = arr[i+1];
                }
            }
            i++;
        }
        return count;
    }   
}