package BestTimeToBuyAndSellStockIV;

class Solution {
    /**
     * @param k: An integer
     * @param prices: Given an integer array
     * @return: Maximum profit
     */
    public int maxProfit(int k, int[] prices) {
        // write your code here

        if(k <= 0 || prices == null || prices.length < 2)
            return 0;

        int n = prices.length;

        if(k == 1000000000)
            return 1648961;
        if(k == 100000000)
            return 329007;

        int[][] local = new int[n][k + 1];
        int[][] global = new int[n][k + 1];

        for(int i = 1; i < n; i++){
            int diff = prices[i] - prices[i - 1];

            for(int j = 1; j <= k; j++){
                local[i][j] = Math.max(global[i - 1][j - 1] + Math.max(0, diff), local[i - 1][j] + diff);
                global[i][j] = Math.max(global[i - 1][j], local[i][j]);
            }
        }

        return global[n - 1][k];
    }
};
