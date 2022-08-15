// Longest Palindromic Subsequence

class Solution
{
    static int[][] t = new int[1001][1001];
    static int len = 0; 
    public int longestPalinSubseq(String S)
    {
        //code here
        len = S.length();
        
        for(int i=0;i<=len;i++){
            for(int j=0;j<=len;j++){
                t[i][j] = -1;
            }
        }
        
        return getlongestPalinSubseq(S, len, 1);
        
    }
    
    static int getlongestPalinSubseq(String S, int n, int m){
        
        if(n == 0 || m == len + 1)
            return 0;
        
        if(t[n][m] != -1)
            return t[n][m];
            
        if(S.charAt(n-1) == S.charAt(m-1))
            t[n][m] = 1 + getlongestPalinSubseq(S, n-1, m+1);
            
        else
            t[n][m] = Math.max(getlongestPalinSubseq(S,n-1,m), getlongestPalinSubseq(S, n, m+1));
            
        
        return t[n][m];
    }
}