class Solution {
    public boolean isMonotonic(int[] nums) {
        int n = nums.length;
        
        if(n <= 2)
            return true;
        
        if(nums[0] <= nums[n-1]){
            for(int i=1; i<n; i++){
                if(nums[i] < nums[i-1])
                    return false;
            }
            return true;
        }
        for(int i=1; i<n; i++){
            if(nums[i] > nums[i-1])
                return false;
        }
        
        return true;
    }
}

//  1 2 2 6 9 21 26
// 17 11 9 3 2 0