//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

public class DriverClass
{
	public static void main(String args[]) 
	{
	   Scanner sc = new Scanner(System.in);
	   int t = sc.nextInt();
	   int range[];
	   while(t-- >0)
	   {
	     int n = sc.nextInt();
	     int k = sc.nextInt();
	     int arr[][] = new int[k][n];
	       for(int i = 0; i < k; i++)
	       {
	        for(int j = 0; j < n; j++)
	               arr[i][j] = sc.nextInt();
	       }
	       range = new Solution().findSmallestRange(arr, n, k);
	       System.out.println(range[0] + " " + range[1]);
	   }
	}
}

// } Driver Code Ends

class Tuple
{
    int num, x, y;
    Tuple(int _num, int _x, int _y){
        this.num = _num;
        this.x = _x;
        this.y = _y;
    }
}

class Solution
{
	static int[] findSmallestRange(int[][] KSortedArray,int n,int k)
	{
	    int[] arr = new int[k];
	    int[] ans = new int[2];
	    int minDiff = Integer.MAX_VALUE;
	    int min = Integer.MAX_VALUE;
	    int max = -1;
	    PriorityQueue<Tuple> pq = new PriorityQueue<>((a,b) -> a.num - b.num);
	    
	    for(int i=0; i<k; i++){
	        arr[i] = KSortedArray[i][0];
	        pq.offer(new Tuple(KSortedArray[i][0], i, 0));
	        min = Math.min(min, KSortedArray[i][0]);
	        max = Math.max(max, KSortedArray[i][0]);
	    }
	    
	    minDiff = max - min;
	    ans[0] = min;
	    ans[1] = max;
	    
	    while(!pq.isEmpty()){
	        int num = pq.peek().num;
	        int x = pq.peek().x;
	        int y = pq.poll().y;
	        
	        if(y+1 < n){
	            pq.offer(new Tuple(KSortedArray[x][y+1], x, y+1));
	            arr[x] = KSortedArray[x][y+1];
	        }
	        min = Integer.MAX_VALUE;
		    max = -1;
	        for(int i=0; i<k; i++){
	            min = Math.min(min, arr[i]);
	            max = Math.max(max, arr[i]);
	        }
	        if(max - min < minDiff){
	            minDiff = max - min;
	            ans[0] = min;
	            ans[1] = max;
	        }
	    }
	    
	    return ans;
	}
}