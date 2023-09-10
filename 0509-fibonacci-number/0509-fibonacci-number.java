class Solution {
    public int fib(int n) {
        int[] dp = new int[n+1];
        
        return findFib(n, dp);
    }
    
    private int findFib(int n, int[] dp){ // 1 1 2 3
        if(n <= 0)
            return 0;
        
        if(n == 1)
            return 1;
        
        if(dp[n-1] != 0)
            return dp[n-1];
        
        int sum = findFib(n-1, dp) + findFib(n-2, dp);
        
        dp[n-1] = sum;
        
        return sum;
    }
}