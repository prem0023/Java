class Solution {
    public int getLastMoment(int n, int[] left, int[] right) {
        int maxTime = 0;
        
        for(int i=0; i<left.length; i++){
            maxTime = Math.max(maxTime, left[i]-0);
        }
        
        for(int i=0; i<right.length; i++){
            maxTime = Math.max(maxTime, n-right[i]);
        }
        
        return maxTime;
    }
}