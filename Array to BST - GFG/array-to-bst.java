//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            int[] nums = new int[n];
            String[] S = br.readLine().trim().split(" ");
            for(int i = 0; i < n; i++){
                nums[i] = Integer.parseInt(S[i]);
            }
            Solution obj = new Solution();
            int[] ans = obj.sortedArrayToBST(nums);
            for(int i = 0; i < ans.length; i++)
                System.out.print(ans[i] + " ");
            System.out.println();
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    int x = 0;
    public int[] sortedArrayToBST(int[] nums){
        int n = nums.length;
        int[] ans = new int[n];
        
        findPreorder(nums, 0, n-1, ans);
        
        return ans;
    }
    
    private void findPreorder(int[] nums, int i, int j, int[] ans){
        if(i > j)
            return;
        
        int mid = (i+j)/2;
        ans[x++] = nums[mid];
        
        findPreorder(nums, i, mid-1, ans);
        findPreorder(nums, mid+1, j, ans);
        
    }
}