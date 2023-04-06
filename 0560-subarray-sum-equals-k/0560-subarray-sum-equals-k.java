class Solution {
    public int subarraySum(int[] nums, int k) {
        int ans = 0;
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        
        for(int i=0; i<n; i++){
            if(i != 0)
                nums[i] = nums[i] + nums[i-1];
            
            if(map.containsKey(nums[i]-k)){
                ans += map.get(nums[i]-k);
            }
            int t = map.getOrDefault(nums[i], 0);
            map.put(nums[i], t+1);
        }
        
        return ans;
    }
}