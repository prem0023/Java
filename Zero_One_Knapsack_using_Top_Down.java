//0/1 knapSack using top down

//import java.util.*;

class Solution {
	
	
	static int knapSack(int w, int wt[], int val[], int n) 
    { 
         
         int[][] t = new int[n+1][w+1];
         
         for(int i=1;i<n+1;i++){
             for(int j=1;j<w+1;j++){
                 
                 if(j >= wt[i-1]){
                     int p1 = val[i-1] + t[i-1][j-wt[i-1]];
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
		
		int val[] = { 6, 10, 12, 5, 6, 2, 9, 8, 7, 4, 2, 6, 8, 1, 7, 8, 9, 10, 9, 1,8, 7, 4, 2, 6, 8, 1, 10,3, 7 };
	    int wt[] = { 1, 2, 3, 6, 7, 3, 8, 9, 10, 11, 7, 3, 12, 5, 8, 6, 3, 4, 7, 1, 6, 7, 3, 8, 9, 5, 7, 6, 3, 5};
	    int w = 100;

	    //System.out.println(val.length + " "+wt.length);
	    
		System.out.println(knapSack(w,wt,val,val.length));
		
	}
}
