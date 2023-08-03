class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        
        helper(candidates, target, ans, temp, candidates.length-1, 0);
        
        return ans;
    }
    
    private static void helper(int[] candidates, int target, List<List<Integer>> ans, List<Integer> temp, int i, int sum){
        if(i < 0){
            if(sum == target){
                ans.add(temp);
            }
            return;
        }
        if(sum == target){
            List<Integer> list = new ArrayList<>();
            list.addAll(temp);
            ans.add(list);
            return;
        }
        
        if(sum + candidates[i] <= target){
            temp.add(candidates[i]);
            helper(candidates, target, ans, temp, i, sum + candidates[i]);
            temp.remove(temp.size()-1);
        }
        
        helper(candidates, target, ans, temp, i-1, sum);
    }
}