//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
class GFG {
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		sc.nextLine();
		while(t-->0)
		{
		    int n;
		    n=sc.nextInt();
		    
		    long arr[]=new long[n];
	
		    
		    for(int i=0;i<n;i++)
		    {
		        arr[i]=sc.nextLong();
		    }
            Solution ob = new Solution();
		    System.out.println(ob.findSubarray(arr,n));
		}
		
	}
}

// } Driver Code Ends


//User function Template for Java

class Solution{
    //Function to count subarrays with sum equal to 0.
    public static long findSubarray(long[] arr ,int n) 
    {
        //Your code here
        HashMap<Long,Integer> hm = new HashMap<Long, Integer>();
        long count = 0;
        
        hm.put(arr[0], 1);
        
        for(int i=1; i<n; i++){

            arr[i] = arr[i] + arr[i-1];
            
            if(hm.containsKey(arr[i]))
                hm.put(arr[i], hm.get(arr[i])+1);
            else
                hm.put(arr[i], 1);
        }
        
        for(Map.Entry<Long, Integer> entry : hm.entrySet()){
            int x = entry.getValue();
            
            if(entry.getKey() == 0)
                count = count + (x *(x+1))/2 ;
            else if(x > 1)
                count = count + (x *(x-1))/2 ;
        }
        
        return count;
    }
}