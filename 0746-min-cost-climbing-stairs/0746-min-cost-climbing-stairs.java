class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length+1];
        
        for(int i=0; i<=cost.length; i++){
            dp[i] = -1;
        }
        
        int zero = getMinCost(cost, 0, dp);
        int one = getMinCost(cost, 1, dp);
        
        return Math.min(zero, one);
    }
    
    private int getMinCost(int[] cost, int i, int[] dp){
        if(i >= cost.length)
            return 0;
        
        if(dp[i] != -1)
            return dp[i];
        
        int next = cost[i] + getMinCost(cost, i+1, dp);
        int nextToNext = cost[i] + getMinCost(cost, i+2, dp);
        
        dp[i] = Math.min(next, nextToNext);
        return dp[i];
    }
}