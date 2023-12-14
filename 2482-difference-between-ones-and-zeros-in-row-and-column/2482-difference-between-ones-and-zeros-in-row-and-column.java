class Solution {
    public int[][] onesMinusZeros(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        int[] oneRow = new int[n];
        int[] oneCol = new int[m];
        
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                oneRow[i] += grid[i][j];
                oneCol[j] += grid[i][j];
            }
        }
        
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                grid[i][j] = 2 * (oneRow[i] + oneCol[j]) - (n + m);
            }
        }
        
        return grid;
    }
}