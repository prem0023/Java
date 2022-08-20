//Egg Dropping Puzzle

class Solution 
{
    static int[][] t;
    static int eggDrop(int n, int k){
        
        t = new int[n+1][k+1];
        
        return getThreshold(n, k);
    }
    static int getThreshold(int n, int k) 
	{
	    if(t[n][k] != 0)
	        return t[n][k];
	    
	    if(k <= 2 || n == 1)
	        return k;
	        
	    int min = Integer.MAX_VALUE;
	        
	    for(int i=2; i<k; i++){
	        
	        int temp = 1 + Math.max(getThreshold(n-1, i-1), getThreshold(n, k-i));

	        min = Math.min(temp, min);
	        
	    }
	    t[n][k] = min;
	    
	    return min;
	}
	
}

class Solution {
	
    int[][] t;
    public int superEggDrop(int n, int k) {
        
        t = new int[n+1][k+1];
        
        return getThreshold(n, k);
     
	}
    
    int getThreshold(int n, int k) 
	{
	    if(t[n][k] != 0)
	        return t[n][k];
	    
	    if(k <= 2 || n == 1)
	        return k;
	        
        int min = k;
	    int l = 1, h = k;
        
	    while(l<h){
            
            int m = l + (h-l)/2;
	        
	        int left = getThreshold(n-1, m-1);
            int right = getThreshold(n, k-m);
            
            int temp = Math.max(left, right) + 1;

	        min = Math.min(min, temp);
            
            if(left == right)
                break;
            else if(left < right)
                l = m+1;
            else
                h = m;
	        
        }
        
	    t[n][k] = min;
	    
	    return min;
	}
}