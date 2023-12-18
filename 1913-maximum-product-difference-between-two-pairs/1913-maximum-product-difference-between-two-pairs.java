class Solution {
    public int maxProductDifference(int[] nums) {
        int secHigh = -1, high = -1;
        int secLow = Integer.MAX_VALUE, low = Integer.MAX_VALUE;
        
        for(int i=0; i<nums.length; i++){
            if(nums[i] > high){
                secHigh = high;
                high = nums[i];
            }
            else if(nums[i] > secHigh)
                secHigh = nums[i];
            
            if(nums[i] < low){
                secLow = low;
                low = nums[i];
            }
            else if(nums[i] < secLow)
                secLow = nums[i];
        }
        
        return (high * secHigh) - (low * secLow);
    }
}