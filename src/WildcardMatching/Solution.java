package WildcardMatching;

public class Solution {
    /**
     * @param s: A string
     * @param p: A string includes "?" and "*"
     * @return: A boolean
     */
    public boolean isMatch(String s, String p) {
        if(s == null && p == null)
            return true;
        if(s == null || p == null)
            return false;

        int m = s.length();
        int n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;

        for(int i = 1; i <= n; i++){
            if(p.charAt(i - 1) == '*'){
                dp[0][i] = true;
            }
            else{
                for(; i <= n; i++)
                    dp[0][i] = false;
            }
        }

        for(int i = 1; i <= m; i++){
            for(int j = 1; j <= n; j++){
                if(p.charAt(j - 1) != '*'){
                    if(p.charAt(j - 1) == '?' || p.charAt(j - 1) == s.charAt(i - 1))
                        dp[i][j] = dp[i - 1][j - 1];
                    else
                        dp[i][j] = false;
                }
                else{
                    if(dp[i][j - 1])
                        dp[i][j] = true;
                    else if(dp[i - 1][j - 1])
                        dp[i][j] = true;
                    else if(dp[i - 1][j])
                        dp[i][j] = true;
                    else
                        dp[i][j] = false;
                }


            }
        }

        return dp[m][n];
    }
}