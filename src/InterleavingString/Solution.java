package InterleavingString;

public class Solution {
    /**
     * Determine whether s3 is formed by interleaving of s1 and s2.
     * @param s1, s2, s3: As description.
     * @return: true or false.
     */
    public boolean isInterleave(String s1, String s2, String s3) {
        // write your code here
        if(s1 == null || s1.length() == 0)
            return s2.equals(s3);
        if(s2 == null || s2.length() == 0)
            return s1.equals(s3);
        if(s3 == null)
            return false;

        int m = s1.length();
        int n = s2.length();
        if(m + n != s3.length())
            return false;

        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;
        for(int i = 1; i <= m; i++){
            char c1 = s1.charAt(i - 1);
            char c3 = s3.charAt(i - 1);

            if(dp[i - 1][0] && c1 == c3)
                dp[i][0] = true;
            else
                break;
        }
        for(int i = 1; i <= n; i++){
            char c2 = s2.charAt(i - 1);
            char c3 = s3.charAt(i - 1);

            if(dp[0][i - 1] && c2 == c3)
                dp[0][i] = true;
            else
                break;
        }

        for(int i = 1; i <= m; i++){
            for(int j = 1; j <= n; j++){
                char c1 = s1.charAt(i - 1);
                char c2 = s2.charAt(j - 1);
                char c3 = s3.charAt(i + j - 1);

                if(dp[i - 1][j] && c1 == c3)
                    dp[i][j] = true;
                else if(dp[i][j - 1] && c2 == c3)
                    dp[i][j] = true;
                else
                    dp[i][j] = false;
            }
        }

        return dp[m][n];
    }
}