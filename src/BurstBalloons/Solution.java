package BurstBalloons;

public class Solution {
    /**
     * @param nums a list of integer
     * @return an integer, maximum coins
     */
    public int maxCoins(int[] nums) {
        if(nums == null || nums.length == 0)
            return 0;

        int n = nums.length;
        int[] numbers = new int[n + 2];
        numbers[0] = 1;
        numbers[n + 1] = 1;

        for(int i = 1; i <= n; i++)
            numbers[i] = nums[i - 1];

        int[][] dp = new int[n + 2][n + 2];

        for(int i = 0; i <= n + 1; i++)
            dp[i][i] = numbers[i];

        for(int i = n - 1; i >= 1; i--){
            for(int j = i; j <= n; j++){
                dp[i][j] = Integer.MIN_VALUE;

                for(int k = i; k <= j; k++){
                    dp[i][j] = Math.max(dp[i][j], numbers[i - 1] * numbers[k] * numbers[j + 1] + dp[i][k - 1] + dp[k + 1][j]);
                }
            }
        }

        return dp[1][n];
    }
}

