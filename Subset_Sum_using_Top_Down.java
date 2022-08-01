// Subset Sum Problem using Top Down

//import java.util.*;

class Solution {
	
	//static boolean[][] t = new boolean[101][(int) Math.pow(10,5)];
	static boolean subsetSum(int w, int wt[], int n) 
    { 
	    // code here
        
	      boolean[][] t = new boolean[wt.length+1][w+1];
	      
	       for(int i=0;i<=wt.length;i++){
			    for(int j=0;j<=w;j++){
			        if( j == 0)
			            t[i][j] = true;
			        else if(i == 0)
			            t[i][j] = false;
			        else
			            break;
			    }
	       }
	       
			for(int i=1;i<=wt.length;i++){
			    for(int j=1;j<=w;j++){
			        
			        boolean p1 = t[i-1][j];
			        boolean p2 = false;
			        
			        if(wt[i-1] <= j){
			            p2 = t[i-1][j-wt[i-1]];
			        }
			        
			        if(p2)
			            t[i][j] = p2;
			        else
			            t[i][j] = p1;
			    }
			}
			
			return t[n][w];
           
    } 


	
	public static void main(String[] args) {
		
		int wt[] = {3, 5, 7, 1, 6, 2};
	    int w = 11;
	    
		System.out.println(subsetSum(w,wt,wt.length));
		
	}
}
