class Solution {
    public int findDuplicate(int[] nums) {
        for(int i=0; i<nums.length; i++){
            int x = nums[Math.abs(nums[i])];
            if(x < 0){
                return Math.abs(nums[i]);
            }
            nums[Math.abs(nums[i])] = -1 * x;
        }
        return 0;
    }
}