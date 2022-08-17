// Minimum number of deletion in a string to make it a palindrome

class Solution 
{ 
    int[][] t;
    int minDeletions(String str, int n)
    {
        // code here
        t = new int[n][n];
        
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++)
                t[i][j] = -1;
        }
        
        return n - getPalindromeLength(str, 0, n-1);
        
    }
    int getPalindromeLength(String s, int n, int m){
        
        if(n == s.length() || m < 0)
            return 0;
        
        if(t[n][m] != -1)
            return t[n][m];
            
        if(s.charAt(n) == s.charAt(m))
            t[n][m] = 1 + getPalindromeLength(s, n+1, m-1);
            
        else
            t[n][m] = Math.max(getPalindromeLength(s, n+1, m), getPalindromeLength(s, n, m-1));
            
        return t[n][m];
    }
} 