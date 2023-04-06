class Solution {
    public int closedIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int count = 0;
        boolean[][] visited = new boolean[m][n];
        
        for (int i = 1; i < m - 1; i++) {
            for (int j = 1; j < n - 1; j++) {
                if (grid[i][j] == 0 && !visited[i][j]) { 
                    boolean isClosed = dfs(grid, visited, i, j); 
                    if (isClosed) {
                        count++; 
                    }
                }
            }
        }
        return count;
    }
    
    private boolean dfs(int[][] grid, boolean[][] visited, int i, int j) {
        int m = grid.length;
        int n = grid[0].length;
        if (i < 0 || i >= m || j < 0 || j >= n) {
            return false;
        }
        if (visited[i][j]) { 
            return true;
        }
        visited[i][j] = true;
        if (grid[i][j] == 1) {
            return true;
        }
        boolean isClosed = true; 
        isClosed &= dfs(grid, visited, i - 1, j);
        isClosed &= dfs(grid, visited, i + 1, j); 
        isClosed &= dfs(grid, visited, i, j - 1);
        isClosed &= dfs(grid, visited, i, j + 1);
        return isClosed;
    }
}