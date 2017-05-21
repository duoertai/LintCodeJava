package PartitionEqualSubsetSum;

public class Solution {
    /**
     * @param nums a non-empty array only positive integers
     * @return return true if can partition or false
     */
    public boolean canPartition(int[] nums) {
        // Write your code here
        if(nums == null || nums.length <= 1)
            return false;

        int sum = 0;
        for(int n: nums)
            sum += n;

        if(sum % 2 == 1)
            return false;

        int target = sum / 2;
        int n = nums.length - 1;

        boolean[][] dp = new boolean[n + 1][target + 1];
        dp[0][0] = true;

        for(int i = 1; i <= n; i++){
            for(int j = 0; j <= target; j++){
                if(j >= nums[i - 1] && dp[i - 1][j - nums[i - 1]])
                    dp[i][j] = true;
                else if(dp[i - 1][j])
                    dp[i][j] = true;
            }
        }

        return dp[n][target];
    }
}
