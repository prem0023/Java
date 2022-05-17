class Stock_BuyOrSale {
    public int maxProfit(int[] prices) {
        
        int n = prices.length;
        
        if(n<2)
            return 0;
        
        int buy = prices[0];
        int sell = 0;
        int max_profit = 0;
        
        for(int i=1;i<n;i++){
            
            if(prices[i]<buy)
                buy = prices[i];
        
            else if(sell<prices[i]){
                if(prices[i]-buy > max_profit)
                    max_profit = prices[i] - buy;
            }
        }
        
        return max_profit;
    }
}