class Solution {
    public int[] searchRange(int[] nums, int target) {
        int first = -1;
        int last = -1;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == target) {
                first = i;
                while(i < nums.length && nums[i] == target) {
                    i++;
                }
                last = i - 1;
                return new int[]{first, last};
            }
        }
        return new int[]{first, last};
    }
}