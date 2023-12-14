class Solution {
    public int[][] onesMinusZeros(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        int[] oneRow = new int[n];
        int[] oneCol = new int[m];
        int[] zeroRow = new int[n];
        int[] zeroCol = new int[m];
        int[][] ans = new int[n][m];
        
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(grid[i][j] == 0){
                    zeroRow[i]++;
                    zeroCol[j]++;
                }
                else{
                    oneRow[i]++;
                    oneCol[j]++;
                }
            }
        }
        
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                ans[i][j] = (oneRow[i] + oneCol[j]) - (zeroRow[i] + zeroCol[j]);
            }
        }
        
        return ans;
    }
}