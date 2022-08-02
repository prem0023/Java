// Subset Sum Problem using Top Down

//import java.util.*;

class Solution {
	
	//static boolean[][] t = new boolean[101][(int) Math.pow(10,5)];
	static boolean subsetSum(int w, int wt[], int n) 
    { 
	    // code here
        
	      boolean[][] t = new boolean[wt.length+1][w+1];
	      
	       int mod = 1000000007;
	    
	       int[][] t = new int[wt.length+1][w+1];
	      
	       for(int i=0;i<=n;i++){
			    for(int j=0;j<=w;j++){
			        if(j == 0)
			            t[i][j] = 1;
			        else
			            break;
			    }
	       }
	       
			for(int i=1;i<=wt.length;i++){
			    for(int j=0;j<=w;j++){
			    	
			    	int p1 = t[i-1][j] % mod;
			    	
			    	
			    	if(wt[i-1] <= j) {
			    		p1 = (p1 + t[i-1][j-wt[i-1]]) % mod;
			    	}
			    	
			    	
			    	t[i][j] = p1;
			    }
			}
		   
			
			return (t[n][w]);
           
    } 


	
	public static void main(String[] args) {
		
		int wt[] = {3, 5, 7, 1, 6, 2};
	    int w = 11;
	    
		System.out.println(subsetSum(w,wt,wt.length));
		
	}
}
