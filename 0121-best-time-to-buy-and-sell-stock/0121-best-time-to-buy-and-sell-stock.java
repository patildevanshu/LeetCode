class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int profit = 0;
        int buyPrice = prices[0];
        for(int i=0; i<prices.length ; i++){
            
            if(buyPrice < prices[i]){
                profit = prices[i] - buyPrice;
                maxProfit = Math.max(maxProfit , profit);
            }else{
                buyPrice = prices[i];
            }
        }
        return maxProfit;
    }
}