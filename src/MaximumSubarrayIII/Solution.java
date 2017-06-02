package MaximumSubarrayIII;

public class Solution {
    /**
     * @param nums: A list of integers
     * @param k: An integer denote to find k non-overlapping subarrays
     * @return: An integer denote the sum of max k non-overlapping subarrays
     */
    public int maxSubArray(int[] nums, int k) {
        if(nums == null || nums.length == 0 || k < 0 || k > nums.length)
            return 0;

        int n = nums.length;
        int[][] dp = new int[k + 1][n + 1];
        dp[0][0] = 0;

        for(int i = 1; i <= k; i++)
            for(int j = i; j <= n; j++)
                dp[i][j] = Integer.MIN_VALUE;

        for(int i = 1; i <= k; i++){
            for(int j = i; j <= n; j++){
                int end = j;
                int sum = nums[end - 1];
                int max = nums[end - 1];
                dp[i][end] = Math.max(dp[i][end], dp[i - 1][j - 1] + max);
                end++;

                while(end <= n){
                    if(sum < 0)
                        sum = 0;

                    sum += nums[end - 1];

                    max = Math.max(max, sum);

                    dp[i][end] = Math.max(dp[i][end], dp[i - 1][j - 1] + max);
                    end++;
                }
            }
        }

        return dp[k][n];
    }
}
