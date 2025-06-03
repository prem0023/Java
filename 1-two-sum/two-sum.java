class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> arrayInteger = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            if(arrayInteger.containsKey(target-nums[i])){
                int[] twoSumIndex = {arrayInteger.get(target-nums[i]), i};
                return twoSumIndex;
            }
            arrayInteger.put(nums[i], i);
        }
        return new int[0];
    }
}