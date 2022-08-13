//Shortest Common Supersequence using Memoization

class Solution
{
    static int[][] t = new int[101][101];
    public static int shortestCommonSupersequence(String X,String Y,int m,int n)
    {
        for(int i=0;i<=m;i++){
            for(int j=0;j<=n;j++)
                t[i][j] = -1;
        }
        //System.out.println(getLCS(X, Y, m, n));
        return X.length() + Y.length() - getLCS(X, Y, m, n);
        
    }
    
    static int getLCS(String X, String Y, int m, int n){
        
        if(m == 0 || n == 0)
            return 0;
            
        if(t[m][n] != -1)
            return t[m][n];
        
        if(X.charAt(m-1) == Y.charAt(n-1))
            t[m][n] = 1 + getLCS(X, Y, m-1, n-1);
            
        else
            t[m][n] = Math.max(getLCS(X, Y, m-1, n), getLCS(X, Y, m, n-1));
            
        return t[m][n];
    }
	
	public static void main(String[] args) {
		
		String s1 = "ASDFGH";
		String s2 = "ASDFQWE";
	    
		System.out.println(shortestCommonSupersequence(s1, s2, s1.length(), s2.length()));
		
	}
}