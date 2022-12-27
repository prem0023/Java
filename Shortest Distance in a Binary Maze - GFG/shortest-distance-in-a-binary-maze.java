//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

// Position this line where user code will be pasted.

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[][] grid = new int[n][m];

            for (int i = 0; i < n; i++) {

                for (int j = 0; j < m; j++) {
                    grid[i][j] = sc.nextInt();
                }
            }
            int[] source = new int[2];
            for (int i = 0; i < 2; i++) {
                int x = sc.nextInt();
                source[i] = x;
            }
            int[] dest = new int[2];
            for (int i = 0; i < 2; i++) {
                int x = sc.nextInt();
                dest[i] = x;
            }
            Solution ob = new Solution();
            int ans = ob.shortestPath(grid, source, dest);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends

class Pair
{
    int dist;
    int[] src;
    Pair(int dist, int[] src){
        this.dist = dist;
        this.src = src;
    }
}

// User function Template for Java

class Solution {

    static int shortestPath(int[][] grid, int[] src, int[] dest) {

        // Your code here
        Queue<Pair> pq = new LinkedList<>();
        int n = grid.length;
        int m =  grid[0].length;
        int[][] ans = new int[n][m];
        
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                ans[i][j] = Integer.MAX_VALUE;
            }
        }
        ans[src[0]][src[1]] = 0;
        pq.add(new Pair(0, src));
        
        while(!pq.isEmpty()){
            int dist = pq.peek().dist;
            int i = pq.peek().src[0];
            int j = pq.poll().src[1];
            int[] temp;
            
            if(i>0 && grid[i-1][j] == 1 && ans[i-1][j] > dist+1){
                ans[i-1][j] = dist+1;
                temp = new int[2];
                temp[0] = i-1;
                temp[1] = j;
                pq.offer(new Pair(ans[i-1][j], temp));
            }
            if(i+1<n && grid[i+1][j] == 1 && ans[i+1][j] > dist+1){
                ans[i+1][j] = dist+1;
                temp = new int[2];
                temp[0] = i+1;
                temp[1] = j;
                pq.offer(new Pair(ans[i+1][j], temp));
            }
            if(j>0 && grid[i][j-1] == 1 && ans[i][j-1] > dist+1){
                ans[i][j-1] = dist+1;
                temp = new int[2];
                temp[0] = i;
                temp[1] = j-1;
                pq.offer(new Pair(ans[i][j-1], temp));
            }
            if(j+1<m && grid[i][j+1] == 1 && ans[i][j+1] > dist+1){
                ans[i][j+1] = dist+1;
                temp = new int[2];
                temp[0] = i;
                temp[1] = j+1;
                pq.offer(new Pair(ans[i][j+1], temp));
            }
        }
        if(ans[dest[0]][dest[1]] == Integer.MAX_VALUE)
            return -1;
        
        return ans[dest[0]][dest[1]];
    }
}
