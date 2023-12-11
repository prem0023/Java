class Solution {
    public int findSpecialInteger(int[] arr) {
        int n = arr.length, thresholdCount = n/4, count = 1;
        
        for(int i=1; i<n; i++){
            if(arr[i] == arr[i-1])
                count++;
            else{
                if(count > thresholdCount)
                    return arr[i-1];
                count = 1;
            }
        }
        
        return arr[n-1];
    }
}