class Solution {
    public int[] sortArrayByParity(int[] nums) {
        int n = nums.length, even=0, odd = 1;
        
        while(even < n && nums[even] % 2 == 0){
            even++;
        }
        odd = even+1;
        
        while(odd < n){
            if(nums[odd] % 2 == 0){
                int temp = nums[even];
                nums[even] = nums[odd];
                nums[odd] = temp;
                even++;
            }
            odd++;
        }
        
        return nums;
    }
}