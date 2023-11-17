class Solution {
    public int minPairSum(int[] nums) {
        Arrays.sort(nums);
        int maxSum = 0, n = nums.length;
        
        for(int i=0; i<n/2; i++){
            maxSum = Math.max(maxSum, nums[i]+nums[n-i-1]);
        }
        
        return maxSum;
    }
}