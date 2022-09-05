// Kadane's Algorithm

class Solution{

    // arr: input array
    // n: size of array
    //Function to find the sum of contiguous subarray with maximum sum.
    long maxSubarraySum(int arr[], int n){
        
        // Your code here
        long max = (long)Integer.MIN_VALUE;
        
        long sum = 0; 
        
        for(int i=0; i<n; i++){
            sum = sum + arr[i];
            max = Math.max(sum, max);
            
            if(sum < 0)
                sum = 0;
        }
        
        return max;
    }
    
}