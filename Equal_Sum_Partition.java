// Equal Sum Partition Problem

//import java.util.*;

class Solution {
	
	static boolean equalSumPartition(int wt[], int n) 
    { 
	    
		if(n <2)
			return false;
		
		int w = 0;
		for(int i=0;i<n;i++) {
			w = w + wt[i];
		}
		
		if(w%2 != 0)
			return false;
		
		w = w/2;
        
	      boolean[][] t = new boolean[wt.length+1][w+1];
	      
	       for(int i=0;i<=n;i++){
			    for(int j=0;j<=w;j++){
			        if(i == 0 || j == 0)
			            t[i][j] = true;
			        else
			            break;
			    }
	       }
	       
			for(int i=2;i<=wt.length;i++){
			    for(int j=1;j<=w;j++){
			    	
			    	boolean p1 = t[i-1][j];
			    	boolean p2 = false;
			    	
			    	if(wt[i-1] <= j) {
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
		
		int wt[] = {478, 757, 314, 471, 729, 100, 459, 618};
	    
		System.out.println(equalSumPartition(wt, wt.length));
		
	}
}
