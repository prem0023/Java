class Solution {
    public int[] twoSum(int[] nums, int target) {
        int a[] = new int[2];
        int index= 0;
        int num=0;
        for(int i=0;i<nums.length;i++){
            index=i;
            num = nums[i];
            for(int j=i+1;j<nums.length;j++){
                if(num+nums[j] == target){
                    a[0]=i;
                    a[1]=j;
                    return a;
                }
            }
        }
        return a;
    }
}
