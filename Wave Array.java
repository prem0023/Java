// Wave Array

class Solution {
    public static void convertToWave(int n, int[] arr) {
        // code here
        for(int i=1; i<n; i=i+2){
            int x = arr[i];
            arr[i] = arr[i-1];
            arr[i-1] = x;
        }
    }
}