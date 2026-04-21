class Solution {
    public int maxProfit(int[] prices) {
        int buy=prices[0], maxProfit = 0;

        for(int i=1; i<prices.length; i++){
            maxProfit = Math.max(prices[i] - buy, maxProfit);
            if(prices[i] < buy){
                buy = prices[i];
            }
        }
        return maxProfit;
    }
}