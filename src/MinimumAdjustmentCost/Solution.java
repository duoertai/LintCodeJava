package MinimumAdjustmentCost;

import java.util.ArrayList;

public class Solution {
    /**
     * @param A: An integer array.
     * @param target: An integer.
     */
    public int MinAdjustmentCost(ArrayList<Integer> A, int target) {
        // write your code here

        if(A == null || A.size() == 0)
            return target;

        int n = A.size();
        int[][] dp = new int[n + 1][101];

        for(int i = 1; i <= n; i++){
            for(int j = 0; j <= 100; j++){
                dp[i][j] = Integer.MAX_VALUE;
            }
        }

        for(int i = 1; i <= n; i++){
            for(int j = 0; j <= 100; j++){

                if(dp[i - 1][j] == Integer.MAX_VALUE)
                    continue;

                for(int k = 0; k <= 100; k++){
                    if(Math.abs(j - k) <= target){
                        dp[i][k] = Math.min(dp[i][k],dp[i - 1][j] + Math.abs(A.get(i - 1) - k));
                    }
                }

            }
        }

        int res = Integer.MAX_VALUE;
        for(int i = 0; i <= 100; i++)
            res = Math.min(res, dp[n][i]);

        return res;
    }
}