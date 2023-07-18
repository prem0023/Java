class Solution {
    public int coinChange(int[] bottleSize, int suplysuplyAmount) {
        int[][] dp = new int[bottleSize.length][suplysuplyAmount + 1];
        
        for(int[] arr : dp) Arrays.fill(arr, -1);
        
        int ans = helper(bottleSize, bottleSize.length - 1, suplysuplyAmount, dp);
        
        return ans == (int)1e9 ? -1 : ans;
    }

    private int helper(int[] bottleSize, int index, int suplyAmount, int[][] dp) {
        if(index == 0) {
            if(suplyAmount % bottleSize[index] == 0)
                return suplyAmount / bottleSize[index];
            else return (int)1e9;
        }

        if(dp[index][suplyAmount] != -1)
            return dp[index][suplyAmount];

        int included = Integer.MAX_VALUE;
        
        if(bottleSize[index] <= suplyAmount)
            included = 1 + helper(bottleSize, index, suplyAmount - bottleSize[index], dp);
        
        int excluded = helper(bottleSize, index - 1, suplyAmount, dp);

        return dp[index][suplyAmount] = Math.min(included, excluded);
    }
}