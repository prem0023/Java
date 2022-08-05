// Number of Coin using Memoization

class Solution{

    static int[][] t;
	public int minCoins(int coins[], int M, int V) 
	{ 
	    // Your code goes here
	    t = new int[M+1][V+1];
	    
	    for(int i=0;i<=M;i++){
	        for(int j=0;j<=V;j++){
	            t[i][j] = -1;
	        }
	    }
	    
	    int x = getminCoins(coins, M, V); //2147483647
	    
	    if(x >= Integer.MAX_VALUE - 1)
	        return -1;
	    return x;
	}
	
	static int getminCoins(int[] coins, int m, int v){
	    
	    if(v == 0)
	        return 0;
	    else if(m == 0)
	        return Integer.MAX_VALUE - 1;
	        
	    else if(t[m][v] >= 0)
	        return t[m][v];
	    
	    t[m][v] = getminCoins(coins, m-1,v);
	  
	    
	    if(coins[m-1] <= v)
	        t[m][v] = Math.min((1 + getminCoins(coins,m,v-coins[m-1])), (getminCoins(coins, m-1,v)));
	   
	   
	    return t[m][v];
	}
	
	public static void main(String[] args) {
		
		int S[] = {2,5,3,6};
	    
		System.out.println(minCoins(S, S.length, 8));
		
	}
}