// Minimum number of deletions and insertions

class Solution
{
    static int[][] t = new int[1001][1001];
    
	public int minOperations(String str1, String str2) 
	{ 
	    // Your code goes here
	    int n = str1.length();
	    int m = str2.length();
	    
	    for(int i=0;i<=n;i++){
	        for(int j=0;j<=m;j++)
	            t[i][j] = -1;
	    }
	    
	    int l = getLCS(str1, str2, n, m);
	    
	    return n + m - 2*l;
	} 
	
	static int getLCS(String str1, String str2, int n, int m){
	    
	    if(n == 0 || m == 0)
	        return 0;
	        
	    if(t[n][m] != -1)
	        return t[n][m];
	    
	    if(str1.charAt(n-1) == str2.charAt(m-1))
	        t[n][m] = 1 + getLCS(str1, str2, n-1, m-1);
	        
	    else
	        t[n][m] = Math.max(getLCS(str1, str2, n-1, m), getLCS(str1, str2, n, m-1));
	        
	    
	    return t[n][m];
	}
}