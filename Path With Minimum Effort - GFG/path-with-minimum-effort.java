//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String[] S = read.readLine().split(" ");
            int N = Integer.parseInt(S[0]);
            int M = Integer.parseInt(S[1]);
            int Grid[][] = new int[N][M];
            for (int i = 0; i < N; i++) {
                String[] s = read.readLine().split(" ");
                for (int j = 0; j < M; j++) Grid[i][j] = Integer.parseInt(s[j]);
            }
            Solution ob = new Solution();
            System.out.println(ob.MinimumEffort(Grid));
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

class Solution {
    
    int MinimumEffort(int grid[][]) {
        
        PriorityQueue<Pair> pq = new PriorityQueue<>((x,y) -> x.dist - y.dist);
        int n = grid.length;
        int m =  grid[0].length;
        int[][] ans = new int[n][m];
        
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                ans[i][j] = Integer.MAX_VALUE;
            }
        }
        int[] src = {0,0};
        ans[0][0] = 0;
        pq.add(new Pair(0, src));
        
        while(!pq.isEmpty()){
            int dist = pq.peek().dist;
            int i = pq.peek().src[0];
            int j = pq.poll().src[1];
            int[] temp;
            
            if(i == n-1 && j == m-1)
                return ans[n-1][m-1];
            
            if(i>0 && ans[i-1][j] > Math.max(ans[i][j],Math.abs(grid[i][j]-grid[i-1][j]))){
                ans[i-1][j] = Math.max(ans[i][j],Math.abs(grid[i][j]-grid[i-1][j]));
                temp = new int[2];
                temp[0] = i-1;
                temp[1] = j;
                pq.offer(new Pair(ans[i-1][j], temp));
            }
            if(i+1<n && ans[i+1][j] > Math.max(ans[i][j],Math.abs(grid[i][j]-grid[i+1][j]))){
                ans[i+1][j] = Math.max(ans[i][j],Math.abs(grid[i][j]-grid[i+1][j]));
                temp = new int[2];
                temp[0] = i+1;
                temp[1] = j;
                pq.offer(new Pair(ans[i+1][j], temp));
            }
            if(j>0 && ans[i][j-1] > Math.max(ans[i][j],Math.abs(grid[i][j]-grid[i][j-1]))){
                ans[i][j-1] = Math.max(ans[i][j],Math.abs(grid[i][j]-grid[i][j-1]));
                temp = new int[2];
                temp[0] = i;
                temp[1] = j-1;
                pq.offer(new Pair(ans[i][j-1], temp));
            }
            if(j+1<m && ans[i][j+1] > Math.max(ans[i][j],Math.abs(grid[i][j]-grid[i][j+1]))){
                ans[i][j+1] = Math.max(ans[i][j],Math.abs(grid[i][j]-grid[i][j+1]));
                temp = new int[2];
                temp[0] = i;
                temp[1] = j+1;
                pq.offer(new Pair(ans[i][j+1], temp));
            }
        }
        return -1;
    }
}