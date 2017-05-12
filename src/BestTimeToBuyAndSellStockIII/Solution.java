package BestTimeToBuyAndSellStockIII;

class Solution {
    /**
     * @param prices: Given an integer array
     * @return: Maximum profit
     */
    public int maxProfit(int[] prices) {
        // write your code here

        if(prices == null || prices.length < 2)
            return 0;

        int n = prices.length;
        int[] l2r = new int[n];
        int[] r2l = new int[n];
        l2r[0] = 0;
        r2l[n - 1] = 0;

        int min = prices[0];
        int max = prices[n - 1];

        for(int i = 1; i < prices.length; i++){
            min = Math.min(min, prices[i]);
            l2r[i] = Math.max(l2r[i - 1], prices[i] - min);
        }
        for(int i = n - 2; i >= 0; i--){
            max = Math.max(max, prices[i]);
            r2l[i] = Math.max(r2l[i + 1], max - prices[i]);
        }

        int res = 0;

        for(int i = 0; i < n - 1; i++){
            res = Math.max(res, l2r[i] + r2l[i + 1]);
        }
        res = Math.max(res, l2r[n - 1]);

        return res;
    }
}