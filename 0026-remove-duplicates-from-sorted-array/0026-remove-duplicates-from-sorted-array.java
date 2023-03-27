class Solution {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        //int[] arr = new int[n];
        int j=0;
        for(int i=1;i<n;i++){
            if(nums[i]!=nums[j]){  
                j++;
                int t = nums[i];
                nums[i] = nums[j];
                nums[j] = t;
            }
        }
        j++;
        return (j++);
    }
}