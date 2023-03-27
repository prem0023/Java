class Solution {
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        int k = n-1;
        
        int i = 0, j = n-1;
        
        while(i <= j && i < n && j >= 0){
            if(nums[i]*nums[i] >= nums[j]*nums[j])
                ans[k--] = nums[i]*nums[i++];
            else
                ans[k--] = nums[j]*nums[j--];
        }
        
        return ans;
    }
}