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
            int[][] matrix = new int[n][n];
            for(int i = 0; i < n; i++){
                String[] S = br.readLine().trim().split(" ");
                for(int j = 0; j < n; j++)
                    matrix[i][j] = Integer.parseInt(S[j]);
            }
            Solution ob = new Solution();
            long ans = ob.MissingNo(matrix);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public long  MissingNo(int[][] matrix)
    {
        int n = matrix.length;
        long rsum[] = new long[n];
        long csum[] = new long[n];
        
        int z_x=0, z_y=0;
        
        for(int i=0; i<n; i++)
        {
            for(int j=0; j<n; j++)
            {
                rsum[i] += matrix[i][j];
                csum[j] += matrix[i][j];
                if(matrix[i][j]==0)
                {
                    z_x=i;
                    z_y=j;
                }
            }
        }
        
        long d1 = 0, d2 = 0;
        
        for(int i=0; i<n; i++)
        {
            d1 += matrix[i][i];
            d2 += matrix[i][n-i-1];
        }
        
        
        boolean on_d1 = z_x==z_y;
        boolean on_d2 = z_x==(n-z_y-1);
        
        long ex_sum = -1;
        
        for(int i=0; i<n; i++)
        {
            if(i!=z_x && i!=z_y)
            {
                if(rsum[i]!=csum[i]) return -1;
                if(!on_d1 && rsum[i]!=d1) return -1;
                if(!on_d2 && rsum[i]!=d2) return -1;
                
                if(ex_sum>-1 && rsum[i]!=ex_sum) return -1;
                
                ex_sum = rsum[i];
                
            }
        }
        
        long ans = ex_sum - rsum[z_x];
        
        if(on_d1) d1 += ans;
        if(on_d2) d2 += ans;
        
        rsum[z_x] += ans;
        csum[z_y] += ans;
        
        if(d1!=d2) return -1;
        if(rsum[z_x]!=csum[z_y]) return -1;
        if(ans<=0) return -1;
        
        return ans;
        
        
    }
}