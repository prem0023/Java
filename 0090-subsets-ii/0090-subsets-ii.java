class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        HashSet<List<Integer>> set = new HashSet<>();
        List<Integer> temp = new ArrayList<>();
        Arrays.sort(nums);
        
        helper(nums, set, temp, 0, nums.length, true);
        
        List<List<Integer>> ans  = new ArrayList<>(set);
        
        return ans;
    }
    
    private void helper(int[] nums, HashSet<List<Integer>> set, List<Integer> temp, int i, int n, boolean flag){
        if(i == n){
            if(flag)
                set.add(new ArrayList<>(temp));
            
            return;
        }
        
        if(flag)
            set.add(new ArrayList<>(temp));
        
        temp.add(nums[i]);
        helper(nums, set, temp, i+1, nums.length, true);
        temp.remove(temp.size()-1);
        
        int x = nums[i];
        while(i<n && nums[i] == x)
            i++;
        
        if(i == n)
            return;
        
        i--;
        
        helper(nums, set, temp, i+1, nums.length, false);
    }
}