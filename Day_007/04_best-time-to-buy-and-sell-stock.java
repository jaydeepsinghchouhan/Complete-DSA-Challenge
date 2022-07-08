class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int profit = 0;
        int minSoFar = Integer.MAX_VALUE;
        
        for(int i = 0; i < n; i++){
            if(prices[i] < minSoFar){
                minSoFar = prices[i];
            }
            
            int profitIfSoldToday = prices[i] - minSoFar;
            if(profit < profitIfSoldToday){
                profit = profitIfSoldToday;
            }
        }
        
        return profit;
    }
}