class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n = arr.length;
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);

        return help(arr, k, n, dp);
    }

    private int help(int[] arr, int k, int i, int[] dp) {
        if (i == 0) {
            return 0;
        }

        if (dp[i] != -1) {
            return dp[i];
        }

        int curmaxi = 0, best = 0;

        for (int t = 1; t <= k && t <= i; ++t) {
            curmaxi = Math.max(curmaxi, arr[i - t]);
            best = Math.max(best, help(arr, k, i - t, dp) + curmaxi * t);
        }

        dp[i] = best;
        return best;
    }
}
