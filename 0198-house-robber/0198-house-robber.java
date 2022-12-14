class Solution {
    public int rob(int[] nums) {
        int temp,max,max1;
        if(nums.length==1)
         return nums[0];
         if(nums.length==2)
           return Math.max(nums[0],nums[1]);
        max=nums[0];
        max1=nums[1];
        for(int i=2;i<nums.length;i++)
        {
            max1=Math.max(max1,max);
            if(max+nums[i]>=max)
               max+=nums[i];
            temp=max;
            max=max1;
            max1=temp;
        }
        return Math.max(max1,max);
    }
}

/*
class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n+1];
        
        for(int i = 0; i<=n; i++)
            dp[i] = -1;
        
        return getMaxMoney(nums, dp, 0, n);  
    }
    
    int getMaxMoney(int[] nums, int[] dp, int prevIncluded, int n){
        if(n == 0)
            return 0;
        
        // if(dp[n] != -1)
        //     return dp[n];
        
        int maxMoney = 0;
        
        if(prevIncluded == 0){
            int included = nums[n-1] + getMaxMoney(nums, dp, 1, n-1);
            int excluded = getMaxMoney(nums, dp, 0, n-1);
            maxMoney = Math.max(included, excluded);
        }
        else
            maxMoney = getMaxMoney(nums, dp, 0, n-1);
        
        dp[n] = maxMoney;
        
        return maxMoney;
    }
}
*/