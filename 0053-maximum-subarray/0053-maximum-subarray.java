class Solution {
    public int maxSubArray(int[] A) {
        int sum = -(int)1e9;
        int maxSum = -(int)1e9;
        int n = A.length;
        for(int i=0; i<n; i++){
            sum= Math.max(A[i], sum+A[i]);
            if(sum >= maxSum){
                maxSum = sum;
            }
        }
        return maxSum;
    }
}