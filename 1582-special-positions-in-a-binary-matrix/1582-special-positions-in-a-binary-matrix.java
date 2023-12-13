class Solution {
    public int numSpecial(int[][] mat) {
        int n = mat.length, m = mat[0].length, ans = 0;
        int[] row = new int[n];
        int[] col = new int[m];
        
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(mat[i][j] == 0 || row[i] == 1 || col[j] == 1)
                    continue;
                if(isSpecial(mat, i, j, n, m)){
                    ans++;
                    row[i] = 1;
                    col[j] = 1;
                }
            }
        }
        return ans;
    }
    
    private boolean isSpecial(int[][] mat, int i, int j, int n, int m){
        for(int k=0; k<m; k++){
            if(k == j)
                continue;
            if(mat[i][k] == 1)
                return false;
        }
        
        for(int k=0; k<n; k++){
            if(k == i)
                continue;
            if(mat[k][j] == 1)
                return false;
        }
        
        return true;
    }
}