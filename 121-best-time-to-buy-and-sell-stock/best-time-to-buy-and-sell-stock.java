class Solution {
    public int maxProfit(int[] prices) {
        int buy=prices[0], maxProfit = 0;

        for(int i=1; i<prices.length; i++){
            int profit = prices[i] - buy;
            maxProfit = profit > maxProfit ? profit : maxProfit;
            if(prices[i] < buy){
                buy = prices[i];
            }
        }
        return maxProfit;
    }
}