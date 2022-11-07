//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Geeks
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n =sc.nextInt();
            int arr[] = new int[n];
            
            for(int i = 0; i < n; i++)
             arr[i] = sc.nextInt();
             
           System.out.println(new Solution().majorityElement(arr, n)); 
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    static int majorityElement(int a[], int size)
    {
        // your code here
        int count=0, ele=0;
        
        for(int num : a){
            if(count==0)
                ele = num;
            if(num == ele)
                count++;
            else
                count--;
        }
        //System.out.println(ele);
        int c=0;
        
        for(int i=0;i<size;i++){
            if(a[i]==ele)
                c++;
            if(c> size/2)
                return ele;
        }
        
        return -1;
    }
}