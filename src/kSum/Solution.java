package kSum;

public class Solution {
    /**
     * @param A: an integer array.
     * @param k: a positive integer (k <= length(A))
     * @param target: a integer
     * @return an integer
     */
    public int kSum(int A[], int k, int target) {
        if(A == null || A.length == 0)
            return 0;

        int m = A.length;
        int[][][] dp = new int[m + 1][k + 1][target + 1];

        for(int i = 0; i <= m; i++){
            dp[i][0][0] = 1;
        }

        for(int i = 1; i <= m; i++){
            for(int j = 1; j <= i && j <= k; j++){
                for(int n = 0; n <= target; n++){
                    if(n + A[i - 1] <= target){
                        dp[i][j][n + A[i - 1]] += dp[i - 1][j - 1][n];
                    }
                    dp[i][j][n] += dp[i - 1][j][n];
                }
            }
        }

        return dp[m][k][target];
    }
}

