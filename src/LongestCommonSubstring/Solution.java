package LongestCommonSubstring;

public class Solution {
    /**
     * @param A, B: Two string.
     * @return: the length of the longest common substring.
     */
    public int longestCommonSubstring(String A, String B) {
        // write your code here
        if(A == null || A.length() == 0 || B == null || B.length() == 0)
            return 0;

        int m = A.length();
        int n = B.length();

        int[][] dp = new int[m + 1][n + 1];
        int max = 0;

        for(int i = 1; i <= m; i++){
            for(int j = 1; j <= n; j++){
                char ca = A.charAt(i - 1);
                char cb = B.charAt(j - 1);

                if(ca == cb){
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    max = Math.max(max, dp[i][j]);
                }
                else{
                    dp[i][j] = 0;
                }
            }
        }

        return max;
    }
}