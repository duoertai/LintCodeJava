package PerfectSquares;

public class Solution {
    /**
     * @param n a positive integer
     * @return an integer
     */
    public int numSquares(int n) {
        // Write your code here

        int[] dp = new int[n + 1];
        for(int i = 0; i <= n; i++)
            dp[i] = i;

        for(int i = 0; i <= n; i++){
            for(int j = 1; i + j * j <= n; j++){
                dp[i + j * j] = Math.min(dp[i + j * j], dp[i] + 1);
            }
        }

        return dp[n];
    }
}
