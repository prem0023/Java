class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        // HashSet<List<Integer>> set = new HashSet<>();
        List<Integer> temp = new ArrayList<>();
        Arrays.sort(candidates);
        
        helper(candidates, target, ans, temp, 0, 0);
        // ans.addAll(set);
        
        return ans;
    }
    
    private static void helper(int[] candidates, int target, List<List<Integer>> ans, List<Integer> temp, int i, int sum){
        if(sum == target){
            ans.add(new ArrayList<>(temp));
            return;
        }
        
        if(i >= candidates.length){
            if(sum == target)
                ans.add(new ArrayList<>(temp));
            return;
        }
        
        if(sum + candidates[i] <= target){
            temp.add(candidates[i]);
            helper(candidates, target, ans, temp, i+1, sum + candidates[i]);
            int a = temp.remove(temp.size()-1);
            
            while(i != candidates.length && candidates[i] == a)
                i++;
            
            if(i != candidates.length)
                i--;
        }
        else{
            return;
        }
        
        helper(candidates, target, ans, temp, i+1, sum);
        
    }
}