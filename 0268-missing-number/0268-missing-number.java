class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int except = -1;
        
        for(int i=0; i<n; i++){
            int x = Math.abs(nums[i]);
            if(x >= n)
                continue;
            nums[x] = -1 * nums[x];
            if(nums[x] == 0)
                except = x;
        }
        
        for(int i=0; i<n; i++){
            if(nums[i] >= 0 && i != except)
                return i;
        }
        
        return n;
    }
}