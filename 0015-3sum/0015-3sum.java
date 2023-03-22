class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        HashSet<List<Integer>> set = new HashSet<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = nums.length;
        
        for(int i=0; i<n; i++){
            map.put(nums[i], i);
        }
        
        for(int i=0; i<n-2; i++){
            for(int j=i+1; j<n-1; j++){
                int thirdNum = -1 * (nums[i] + nums[j]);
                if(map.containsKey(thirdNum) && map.get(thirdNum) > j){
                    List<Integer> temp = new ArrayList<>();
                    temp.add(nums[i]);
                    temp.add(nums[j]);
                    temp.add(thirdNum);
                    Collections.sort(temp);
                    set.add(temp);
                }
            }
        }
        ans.addAll(set);
        return ans;
    }
}