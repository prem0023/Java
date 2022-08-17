// Is SubSequence using DP (LCS)

class Solution{
    int l = 0;
    int[][] t;
    boolean isSubSequence(String A, String B){
        
        int n = A.length();
        int m = B.length();
        
        t = new int[n+1][m+1];
        
        for(int i=0; i<=n; i++){
            for(int j=0; j<=m; j++)
                t[i][j] = -1;
        }
        
        int l = LCS(A, B, n, m);
        
        if(l == n)
            return true;
        return false;
    }
    
    int LCS(String s1, String s2, int n, int m){
        
        if(n == 0 || m == 0)
            return 0;
            
        if(t[n][m] != -1){
            return t[n][m];
        }
            
        if(s1.charAt(n-1) == s2.charAt(m-1))
            t[n][m] = 1 + LCS(s1, s2, n-1, m-1);
            
        else
            t[n][m] = Math.max(LCS(s1, s2, n-1, m), LCS(s1, s2, n, m-1));
        
        return t[n][m];
    }
}