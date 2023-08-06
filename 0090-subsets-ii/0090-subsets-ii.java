class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans  = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        Arrays.sort(nums);
        
        helper(nums, ans, temp, 0, nums.length, true);
        
        return ans;
    }
    
    private void helper(int[] nums, List<List<Integer>> ans, List<Integer> temp, int i, int n, boolean flag){
        if(i == n){
            if(flag)
                ans.add(new ArrayList<>(temp));
            return;
        }
        
        if(flag){
            ans.add(new ArrayList<>(temp));
        }
        
        temp.add(nums[i]);
        helper(nums, ans, temp, i+1, nums.length, true);
        temp.remove(temp.size()-1);
        
        int x = nums[i];
        while(i<n && nums[i] == x)
            i++;
        
        if(i == n)
            return;
        
        i--;
        
        helper(nums, ans, temp, i+1, nums.length, false);
    }
}