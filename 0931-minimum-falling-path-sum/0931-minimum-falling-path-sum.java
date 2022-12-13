class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int minSum = Integer.MAX_VALUE;

        if(n == 1) {
            return matrix[0][0];
        }

        for(int i = 1; i<n; i++) {
            for(int j = 0; j<n; j++) {
                int minTop = matrix[i-1][j];
                if(j>0) {
                    minTop = Math.min(minTop, matrix[i-1][j-1]);
                } if(j<n-1) {
                    minTop = Math.min(minTop, matrix[i-1][j+1]);
                }
                
                matrix[i][j] += minTop;
                if(i == n-1) {
                    minSum = Math.min(minSum, matrix[i][j]);
                }
            }
        }

        return minSum;
    }
}