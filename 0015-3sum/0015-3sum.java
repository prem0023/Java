class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        HashSet<List<Integer>> set = new HashSet<>();
        List<List<Integer>> ans = new ArrayList<>();
        int n = nums.length;
        // -1,0,1,2,-1,-4
        Arrays.sort(nums);
        // -4 -1 -1 0 1 2
        
        for(int i=0; i<n; i++){
            int firstNum = nums[i];
            int secIndex = i+1;
            int thirdIndex = n-1;
            
            while(secIndex < thirdIndex){
                if(firstNum + nums[secIndex] + nums[thirdIndex] == 0){
                    List<Integer> temp = new ArrayList<>();
                    temp.add(firstNum);
                    temp.add(nums[secIndex]);
                    temp.add(nums[thirdIndex]);
                    set.add(temp);
                    secIndex++;
                }
                else if(firstNum + nums[secIndex] + nums[thirdIndex] > 0)
                    thirdIndex--;
                else
                    secIndex++;
            }
        }
        ans.addAll(set);
        return ans;
    }
}