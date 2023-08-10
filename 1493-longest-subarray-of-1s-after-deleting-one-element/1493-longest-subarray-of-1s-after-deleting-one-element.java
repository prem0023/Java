class Solution {
    public int longestSubarray(int[] nums) {
        int n = nums.length;
        int max = 0, prevZero = -1, count = 0;
        
        for(int i=0; i<n; i++){
            if(nums[i] == 1){
                count++;
                max = Math.max(count, max);
                continue;
            }
            if(prevZero == -1){
                prevZero = i;
                continue;
            }
            count = i-prevZero-1;
            prevZero = i;
            
            if(count == 0)
                prevZero = -1;
        }
        
        if(max == n)
            max--;
        
        return max;
    }
}