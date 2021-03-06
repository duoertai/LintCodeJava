package BestTimeToBuyAndSellStockII;

class Solution {
    /**
     * @param prices: Given an integer array
     * @return: Maximum profit
     */
    public int maxProfit(int[] prices) {
        // write your code here

        if(prices == null || prices.length < 2)
            return 0;

        int res = 0;

        for(int i = 1; i < prices.length; i++){
            if(prices[i] > prices[i - 1])
                res += prices[i] - prices[i - 1];
        }

        return res;
    }
}