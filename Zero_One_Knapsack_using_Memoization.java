//0/1 Knapsack using Memoization

//Memoization
class Solution {
	
	static int[][] t = new int[102][32];
	
    public static int ZeroOneKnapsack(int[] wt, int[] val, int w, int i, int p) {

    	if(i == val.length || w == 0)
    		return 0;    // or return 0 as for this condition we have zero profit
    	
    	
    	if(t[w][i] != -1) {  //150
    		return t[w][i];
    	}
    	
    	int p1 = ZeroOneKnapsack(wt,val,w,i+1,p);
    	
    	int p2 = 0;
    	
    	if(w-wt[i]>=0) 
    		p2 = val[i] + ZeroOneKnapsack(wt,val,w-wt[i],i+1,p);
    	
    	if(p2>p1)
    		t[w][i] = p2;
    	else
    		t[w][i] = p1;
    	
    	return t[w][i];
    	
    }


	
	public static void main(String[] args) {
		
		int val[] = { 6, 10, 12, 5, 6, 2, 9, 8, 7, 4, 2, 6, 8, 1, 7, 8, 9, 10, 9, 1,8, 7, 4, 2, 6, 8, 1, 10,3, 7 };
	    int wt[] = { 1, 2, 3, 6, 7, 3, 8, 9, 10, 11, 7, 3, 12, 5, 8, 6, 3, 4, 7, 1, 6, 7, 3, 8, 9, 5, 7, 6, 3, 5};
	    int w = 100;
	    //System.out.println(val.length + " "+wt.length);
	    
	    for(int i=0;i<102;i++) {
			for(int j=0;j<32;j++)
				t[i][j] = -1;
		}
		
		System.out.println(ZeroOneKnapsack(wt,val,w, 0,0));
		
		//System.out.println(profit);
	}
}