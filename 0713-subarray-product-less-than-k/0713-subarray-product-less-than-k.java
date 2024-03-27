class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int i=0;
        int j=0;
        int n=nums.length;
        int ans=0;
        int product=1;
        while(j<n){
            product*=nums[j];
            while(i<=j && product>=k){
                product=product/nums[i];
                i++;
            }
            ans+=(j-i+1);
            j++;
        }
        return ans;
    }
}