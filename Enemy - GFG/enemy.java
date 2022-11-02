//{ Driver Code Starts
import java.io.*;
import java.util.*;


class IntArray
{
    public static int[] input(BufferedReader br, int n) throws IOException
    {
        String[] s = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for(int i = 0; i < n; i++)
            a[i] = Integer.parseInt(s[i]);
        
        return a;
    }
    
    public static void print(int[] a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }
    
    public static void print(ArrayList<Integer> a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }
}


class IntMatrix
{
    public static int[][] input(BufferedReader br, int n, int m) throws IOException
    {
        int[][] mat = new int[n][];
        
        for(int i = 0; i < n; i++)
        {
            String[] s = br.readLine().trim().split(" ");
            mat[i] = new int[s.length];
            for(int j = 0; j < s.length; j++)
                mat[i][j] = Integer.parseInt(s[j]);
        }
        
        return mat;
    }
    
    public static void print(int[][] m)
    {
        for(var a : m)
        {
            for(int e : a)
                System.out.print(e + " ");
            System.out.println();
        }
    }
    
    public static void print(ArrayList<ArrayList<Integer>> m)
    {
        for(var a : m)
        {
            for(int e : a)
                System.out.print(e + " ");
            System.out.println();
        }
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            int[] a = IntArray.input(br, 3);
            int n = a[0],m=a[1],k=a[2];
            
            int[][] e = IntMatrix.input(br, a[2], 2);
            
            Solution obj = new Solution();
            int res = obj.largestArea(n,m,k,e);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends


       

class Solution {
    public static int largestArea(int n,int m,int k,int[][] enemy) {
         List<Integer> rows = new ArrayList<Integer>();
         List<Integer> cols = new ArrayList<Integer>();
         rows.add(0);
         cols.add(0);
         for(int[] ene : enemy)
         {
             rows.add(ene[0]);
             cols.add(ene[1]);
         }
         Collections.sort(rows);
         Collections.sort(cols);
         rows.add(n+1);
         cols.add(m+1);
         
         int maxRow = 0;
         //Taking two Consecutive row those have max Distance Between Them 
         int prev = 0;
         for(int row : rows)
         {
             
             
             maxRow = Math.max( maxRow , row-prev-1);
             prev = row;
         }
         int maxCol = 0;
         //Taking two Consecutive COl those have max Distance Between Them 
         prev = 0;
         for(int col : cols)
         {
             maxCol = Math.max( maxCol , col-prev-1);
             prev = col;
         }
         return maxRow*maxCol;
         
    }
}