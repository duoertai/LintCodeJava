package DistinctSubsequences;

public class Solution {
    /**
     * @param S, T: Two string.
     * @return: Count the number of distinct subsequences
     */
    public int numDistinct(String s, String t) {
        // write your code here
        if(s == null && t == null)
            return 1;

        if(s == null || t == null)
            return 0;

        if(s.equals(t))
            return 1;

        int m = s.length();
        int n = t.length();

        int[][] dp = new int[m + 1][n + 1];
        for(int i = 0; i <= m; i++)
            dp[i][0] = 1;
        for(int i = 1; i <= n; i++)
            dp[0][i] = 0;

        for(int i = 1; i <= m; i++){
            for(int j = 1; j <= n; j++){
                if(j > i){
                    dp[i][j] = 0;
                }
                else{
                    dp[i][j] = dp[i - 1][j];
                    if(s.charAt(i - 1) == t.charAt(j - 1))
                        dp[i][j] += dp[i - 1][j - 1];
                }
            }
        }

        return dp[m][n];
    }
}