class Solution {
    public int findKthLargest(int[] nums, int k) {
        int ans=0;
        int min = nums[0];
        int max = nums[0];
        for(int i:nums){
            min=Math.min(min,i);
            max=Math.max(max,i);
        }

        int temp[] = new int[max-min+1];
        for(int i:nums){
            temp[i-min]++;
        }

        for(int i=temp.length-1;i>=0;i--){
            k-=temp[i];
            if(k<=0) return i+min;
        }

        return min;
    }
}