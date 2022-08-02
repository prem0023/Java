//Count Subset Sum

class Solution{

	public int perfectSum(int wt[],int n, int w) 
	{ 
	    // Your code goes here
	    
	    boolean[][] t = new boolean[wt.length+1][w+1];
	      
	       for(int i=0;i<=n;i++){
			    for(int j=0;j<=w;j++){
			        if(j == 0)
			            t[i][j] = true;
			        else
			            break;
			    }
	       }
	       int count = 0;
	       
			for(int i=1;i<=wt.length;i++){
			    for(int j=1;j<=w;j++){
			    	
			    	boolean p1 = t[i-1][j];
			    	boolean p2 = false;
			    	
			    	if(wt[i-1] <= j) {
			    		p2 = t[i-1][j-wt[i-1]];
			    	}
			    	
			    	if(p2) {
			    		//count++;
			    		t[i][j] = p2;
			    	}
			    	else
			    	    t[i][j] = p1;
			    }
			}
		
			
			return count;
	} 
	
	public static void main(String[] args) {
		
		int wt[] = {3, 5, 7, 1, 6, 2};
		int w = 11;
	    
		System.out.println(equalSumPartition(wt, wt.length, w));
		
	}
}