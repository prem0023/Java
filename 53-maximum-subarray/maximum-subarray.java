class Solution {
    public int maxSubArray(int[] nums) {
        int sum = nums[0], maxSum = nums[0], n = nums.length;

        for(int i=1; i<n; i++){
            if(sum < 0){
                sum = 0;
            }
            sum += nums[i];
            if(sum > maxSum){
                maxSum = sum;
            }
        }
        return maxSum;
    }
}