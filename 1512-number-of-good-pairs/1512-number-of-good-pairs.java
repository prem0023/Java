class Solution {
    public int numIdenticalPairs(int[] nums) {
        int[] freq = new int[101];
        int ans = 0;
        
        for(int i=0; i<nums.length; i++){
            freq[nums[i]]++;
            
            if(freq[nums[i]] > 1)
                ans += freq[nums[i]]-1;
        }
        
        
        return ans;
    }
}