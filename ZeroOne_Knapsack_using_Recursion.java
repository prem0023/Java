// 0/1 Knapsack using Recursion

import java.util.*;



//Recursion
class Solution {
	
	//static int profit = 0;
    public static int ZeroOneKnapsack(int[] wt, int[] val, int w, int i, int p) {

    	if(i == val.length || w == 0)
    		return p;  // or return 0 as for this condition we have zero profit
    	
    	
    	int p1 = ZeroOneKnapsack(wt,val,w,i+1,p);
    	
    	int p2 = 0;
    	
    	if(w-wt[i]>=0) 
    		p2 = val[i] + ZeroOneKnapsack(wt,val,w-wt[i],i+1,p);
    	
    	if(p2>p1)
    		return p2;
    	
    	return p1;
    	
    }


	
	public static void main(String[] args) {
		
		int val[] = { 60, 100, 120 };
	    int wt[] = { 10, 20, 30 };
	    int w = 50;
		
		
		System.out.println(ZeroOneKnapsack(wt,val,w, 0,0));
		
		//System.out.println(profit);
	}
}

