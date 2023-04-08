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

            Solution ob = new Solution();
            int ans = ob.countDistinctIslands(grid);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java
class Pair
{
    int x, y;
    Pair(int _x, int _y){
        this.x = _x;
        this.y = _y;
    }
}

class Solution {

    int countDistinctIslands(int[][] grid) {
        // Your Code here
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] vis = new boolean[n][m];
        HashSet<ArrayList<Integer>> set = new HashSet<>();
        
        for(int i=0; i<n ;i++){
            for(int j=0; j<m; j++){
                if(grid[i][j] == 1 && !vis[i][j]){
                    ArrayList<Integer> list = new ArrayList<Integer>();
                    bfs(grid, vis, list, i, j, n, m);
                    set.add(list);
                }
            }
        }
        return set.size();
    }
    
    private void bfs(int[][] grid, boolean[][] vis, ArrayList<Integer> list, int i, int j, int n, int m){
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(i, j));
        vis[i][j] = true;
        int x_ = i;
        int y_ = j;
        
        while(!q.isEmpty()){
            Pair p = q.poll();
            int x = p.x;
            int y = p.y;
            list.add(x-x_);
            list.add(y-y_);
            
            if(x > 0 && grid[x-1][y] == 1 && !vis[x-1][y]){
                vis[x-1][y] = true;
                q.offer(new Pair(x-1, y));
            }
            if(x+1 < n && grid[x+1][y] == 1 && !vis[x+1][y]){
                vis[x+1][y] = true;
                q.offer(new Pair(x+1, y));
            }
            if(y > 0 && grid[x][y-1] == 1 && !vis[x][y-1]){
                vis[x][y-1] = true;
                q.offer(new Pair(x, y-1));
            }
            if(y+1 < m && grid[x][y+1] == 1 && !vis[x][y+1]){
                vis[x][y+1] = true;
                q.offer(new Pair(x, y+1));
            }
        }
    }
}
