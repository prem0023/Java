class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums.length < 3)
            return nums.length;
        
        int freq = 1, left = 0, right = 1;
        
        while(right < nums.length){
            if(nums[left] == nums[right]){
                if(freq >= 2){
                    left--;
                }
                freq++;
            }
            else
                freq = 1;

            nums[left + 1] = nums[right];
            
            left++;
            right++;
        }
        return left+1;
    }
}