//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;


class GFG
{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        int n;
        while(t-- > 0){
            n = sc.nextInt();
    
            Solution obj = new Solution();
            for(int i = 1; i <= n; i++)
            {
                int x =sc.nextInt();
                obj.insertHeap(x);
                System.out.println((int)Math.floor(obj.getMedian()));
            }
        }
        
        
    }
}


// } Driver Code Ends




class Solution
{
    //Function to insert heap.
    static PriorityQueue<Integer> min = new PriorityQueue<>();
    static PriorityQueue<Integer> max = new PriorityQueue<>((a,b) -> b-a);
    
    public static void insertHeap(int x)
    {
        // add your code here
        if(max.isEmpty() || max.peek() >= x)
            max.offer(x);
        else
            min.offer(x);
        
        balanceHeaps();
    }
    
    //Function to balance heaps.
    public static void balanceHeaps()
    {
        if(Math.abs(min.size() - max.size()) <= 1)
            return;
        
        if(min.size() > max.size()){
            int temp = min.poll();
            max.offer(temp);
        }
        else{
            int temp = max.poll();
            min.offer(temp);
        }
    }
    
    //Function to return Median.
    public static double getMedian()
    {
        // add your code here
        if(min.size() > max.size())
            return min.peek();
        
        else if(min.size() < max.size())
            return max.peek();
        
        double x = min.peek();
        double y = max.peek();
        
        return (x+y)/2;
    }
    
}