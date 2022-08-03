// Coin Change using Memoization

class Solution {
    static long[][] t;
    public long count(int S[], int m, int n) {
        // code here.
        t = new long[m+1][n+1];
        
        for(int i=0;i<=m;i++){
            for(int j=0;j<=n;j++){
                t[i][j] = -1;
            }
        }
        
        return findWays(S,m,n);
    }
    
    static long findWays(int[] s, int m, int n){
        
        if( n == 0)
            return 1;
            
        else if(m == 0)
            return 0;
            
        else if(t[m][n] >=0)
            return t[m][n];
        
        long p1 = findWays(s,m-1,n);
        
        long p2 = 0;
        
        if(s[m-1] <= n)
            p2 = findWays(s,m,n-s[m-1]);
        
        t[m][n] = p1+p2;
        
        return t[m][n];
        
    }
	
	public static void main(String[] args) {
		
		int S[] = {2,5,3,6};
	    
		System.out.println(rodCutting(S, S.length, 10));
		
	}
}