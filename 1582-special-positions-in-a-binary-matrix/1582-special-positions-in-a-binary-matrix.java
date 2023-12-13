class Solution {
    public int numSpecial(int[][] mat) {
        int n = mat.length, m = mat[0].length, ans = 0;
        
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(mat[i][j] == 0)
                    continue;
                if(isSpecial(mat, i, j, n, m))
                    ans++;
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