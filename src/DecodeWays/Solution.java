package DecodeWays;

public class Solution {
    /**
     * @param s a string,  encoded message
     * @return an integer, the number of ways decoding
     */
    public int numDecodings(String s) {
        // Write your code here

        if(s == null || s.length() == 0)
            return 0;

        if(s.charAt(0) == '0')
            return 0;

        int len = s.length();
        int[] dp = new int[len + 1];
        dp[0] = 1;
        dp[1] = 1;

        for(int i = 2; i <= len; i++){
            if(valid(s.substring(i - 1, i)))
                dp[i] += dp[i - 1];
            if(valid(s.substring(i - 2, i)))
                dp[i] += dp[i - 2];
        }

        return dp[len];
    }

    public boolean valid(String s){
        if(s.equals("0"))
            return false;

        if(s.charAt(0) == '0')
            return false;

        int num = Integer.parseInt(s);

        return num >= 1 && num <= 26;
    }

}
