class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n+1];
        
        for(int i=0; i<=n; i++)
            dp[i] = -1;
        
        return getMaxMoney(nums, dp, n);
    }
    
    private int getMaxMoney(int[] nums, int[] dp, int n){
        if(n <= 0)
            return 0;
        
        if(dp[n-1] != -1)
            return dp[n-1];
        
        int include = getMaxMoney(nums, dp, n-2) + nums[n-1];
        int exclude = getMaxMoney(nums, dp, n-1);
        
        dp[n-1] = Math.max(include, exclude);
        
        return dp[n-1];
    }
}