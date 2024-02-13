class Solution {
    public int cherryPickup(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        int[][][] dp = new int[n+1][m+1][m+1];
        
        for(int i=0; i<=n; i++){
            for(int j=0; j<=m; j++){
                for(int k=0; k<=m; k++)
                    dp[i][j][k] = -1;
            }
        }
        
        return getTotalCherry(grid, grid.length, grid[0].length, 0, 0, grid[0].length-1, dp);
    }
    
    private int getTotalCherry(int[][] grid, int n, int m, int i, int j, int y, int[][][] dp){
        if(i == n)
            return 0;
        
        if(dp[i][j][y] != -1)
            return dp[i][j][y];
        
        int maxCherry = 0;
        
        if(j-1 >= 0){
            if(j-1 != y-1 && y-1 >= 0)
                maxCherry = Math.max(maxCherry, getTotalCherry(grid, n, m, i+1, j-1, y-1, dp));
            if(j-1 != y)
                maxCherry = Math.max(maxCherry, getTotalCherry(grid, n, m, i+1, j-1, y, dp));
            if(j-1 != y+1 && y+1 < m)
                maxCherry = Math.max(maxCherry, getTotalCherry(grid, n, m, i+1, j-1, y+1, dp));
        }
        
        if(j+1 < m){
            if(j+1 != y-1 && y-1 >= 0)
                maxCherry = Math.max(maxCherry, getTotalCherry(grid, n, m, i+1, j+1, y-1, dp));
            if(j+1 != y)
                maxCherry = Math.max(maxCherry, getTotalCherry(grid, n, m, i+1, j+1, y, dp));
            if(j+1 != y+1 && y+1 < m)
                maxCherry = Math.max(maxCherry, getTotalCherry(grid, n, m, i+1, j+1, y+1, dp));
        }

        if(j != y-1 && y-1 >= 0)
            maxCherry = Math.max(maxCherry, getTotalCherry(grid, n, m, i+1, j, y-1, dp));
        if(j != y)
            maxCherry = Math.max(maxCherry, getTotalCherry(grid, n, m, i+1, j, y, dp));
        if(j != y+1 && y+1 < m)
            maxCherry = Math.max(maxCherry, getTotalCherry(grid, n, m, i+1, j, y+1, dp));
        
        dp[i][j][y] = maxCherry + grid[i][j] + grid[i][y];
        
        return dp[i][j][y];
    }
}