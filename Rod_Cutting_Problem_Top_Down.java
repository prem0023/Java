//Rod Cutting Problem using top down

//import java.util.*;

class Solution {
	
	
	static int rodCutting(int w, int wt[], int val[], int n) 
    { 
         
         int[][] t = new int[n+1][w+1];
         
         for(int i=1;i<n+1;i++){
             for(int j=1;j<w+1;j++){
                 
                 if(j >= wt[i-1]){
                     int p1 = val[i-1] + t[i][j-wt[i-1]];
                     int p2 = t[i-1][j];
                     
                     if(p1>p2)
                        t[i][j] = p1;
                    else
                        t[i][j] = p2;
                 }
                 else{
                     t[i][j] = t[i-1][j];
                 }
             }
         }
         
    	return t[n][w];
    } 


	
	public static void main(String[] args) {
		
		int val[] = {1,   5,   8,   9,  10,  17,  17,  20};
		int wt[] =  {1,   2,   3,   4,   5,   6,   7,   8};
		int w = 8;

	    //System.out.println(val.length + " "+wt.length);
	    
		System.out.println(rodCutting(w,wt,val,val.length));
		
	}
}
