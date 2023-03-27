class Solution {
    public int removeDuplicates(int[] nums) {
        int uniqNumIndex = 0;
        // int right = 1;
        int n =  nums.length;
        
        // 0,0,1,1,1,2,2,3,3,4
        // 0 1 2 3 4 5 6 7 8 9  
        nums[uniqNumIndex] = nums[0];
        for(int right=1; right<n; right++){
            if(nums[uniqNumIndex] != nums[right])
                nums[++uniqNumIndex] = nums[right];
        }
        
        return uniqNumIndex+1;
    }
}