//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;
class GfG
{
    public static void main (String[] args)
    {
        
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int l = sc.nextInt();
            int n = sc.nextInt();
            
            int arr[] =  new int[l];
            
            for(int i = 0;i<l;i++)
                arr[i] = sc.nextInt();
            
            Solution ob = new Solution();
                
            if(ob.findPair(arr, l, n)==true)
                System.out.println(1);
                
            else
                System.out.println(-1);    
                
        }
        
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    public boolean findPair(int arr[], int size, int n)
    {
        //code here.
        Arrays.sort(arr);
        
        int l=0, r = size-1;
        
        for(int i=0; i<size-1; i++){
            if(findElement(arr, size, i+1, size-1, n+arr[i]))
                return true;
        }
        
        return false;
    }
    
    boolean findElement(int[] arr, int n, int l, int r, int target){
        
        while(l<=r){
            int mid = (l+r)/2;
            if(arr[mid] == target)
                return true;
            else if(arr[mid] > target)
                r = mid-1;
            else
                l = mid+1;
        }
        
        return false;
    }
}