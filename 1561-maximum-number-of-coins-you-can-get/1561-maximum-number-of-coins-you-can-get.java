class Solution {
    public int maxCoins(int[] piles) {
        Arrays.sort(piles);
        int sum = 0, j = 0;
        
        for(int i=piles.length-2; i>j; i=i-2){
            sum += piles[i];
            j++;
        }
        
        return sum;
    }
}