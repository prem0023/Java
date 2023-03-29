class Solution {
    public int maxSatisfaction(int[] satisfaction) {
        int n = satisfaction.length;
        Arrays.sort(satisfaction);

        int sum = satisfaction[n-1];
        int val = satisfaction[n-1];
        int max = val;
        
        for(int i=n-2; i>= 0; i--){
            sum += satisfaction[i];
            val += sum;
            max = Math.max(max, val);
        }
        
        return max > 0 ? max : 0;
    }
}