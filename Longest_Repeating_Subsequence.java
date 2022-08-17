//Longest Repeating Subsequence

class Solution
{
    int[][] t;
    public int LongestRepeatingSubsequence(String str)
    {
        // code here
        int n = str.length();
        t = new int[n+1][n+1];
        
        for(int i=0; i<=n; i++){
            for(int j=0; j<=n; j++)
                t[i][j] = -1;
        }
        
        return getLRS(str, str, n, n);
    }
    
    int getLRS(String s1, String s2, int n, int m){
        
        if(n == 0 || m == 0)
            return 0;
            
        if(t[n][m] != -1)
            return t[n][m];
            
        if(s1.charAt(n-1) == s2.charAt(m-1) && m != n)
            t[n][m] = 1 + getLRS(s1, s2, n-1, m-1);
            
        else
            t[n][m] = Math.max(getLRS(s1, s2, n-1, m), getLRS(s1, s2, n, m-1));
            
        return t[n][m];
    }
}