class Solution {
    Integer dp[][][];
    int M = (int)1e9+7;
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        dp = new Integer[m][n][maxMove+1];
        return solve(m,n,maxMove,startRow,startColumn);
    }
    public int solve(int m,int n,int moves,int row,int col) {
        if(row >= m || col >= n || row<0 || col<0) {
            return 1;
        }
        if(moves<=0){
            return 0;
        }
        if(dp[row][col][moves]!=null){
            return dp[row][col][moves];
        }
        int ans = 0;
        ans = (ans + solve(m,n,moves-1,row-1,col))%M;
        ans = (ans + solve(m,n,moves-1,row+1,col))%M;
        ans = (ans + solve(m,n,moves-1,row,col-1))%M;
        ans = (ans + solve(m,n,moves-1,row,col+1))%M;
        return dp[row][col][moves] = ans;
    }
}