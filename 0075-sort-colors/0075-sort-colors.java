class Solution {
    public void sortColors(int[] nums) {
        int zero=0, one=0, two = nums.length-1;
        
        while(one <= two){
            if(nums[one] == 0){
                swap(nums, zero, one);
                zero++;
            }
            else if(nums[one] == 2){
                swap(nums, one, two);
                two--;
                continue;
            }
            one++;
        }
    }
    
    private void swap(int[] nums, int x, int y){
        int temp = nums[x];
        nums[x] = nums[y];
        nums[y] = temp;
    }
}