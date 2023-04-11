class Solution {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum = 0;
            
        for(int i=0; i<n; i++)
            sum += nums[i];
        
        if(sum%2 != 0)
            return false;
        
        sum = (int) sum/2;
        int[][] subsetSum = new int[n+1][sum+1];
        
        for(int i=0; i<=n; i++){
            for(int j=0; j<=sum; j++){
                subsetSum[i][j] = -1;
            }
        }
        
        return helperIsSubsetSum(nums, subsetSum, n, sum);
    }
    
    private boolean helperIsSubsetSum(int arr[], int[][] subsetSum, int N, int sum){
        if(sum ==  0)
            return true;
        
        if(N == 0)
            return false;
        
        if(subsetSum[N][sum] != -1)
            return subsetSum[N][sum] == 1;
            
        boolean include = false, exclude = false;
        
        if(sum >= arr[N-1]){
            include = helperIsSubsetSum(arr, subsetSum, N-1, sum - arr[N-1]);
        }
        
        exclude = helperIsSubsetSum(arr, subsetSum, N-1, sum);
        
        if(include || exclude)
            subsetSum[N][sum] = 1;
        else
            subsetSum[N][sum] = 0;
        
        return subsetSum[N][sum] == 1;
    }
}