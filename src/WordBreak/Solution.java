package WordBreak;

import java.util.Set;

public class Solution {
    /**
     * @param s: A string s
     * @param dict: A dictionary of words dict
     */
    public boolean wordBreak(String s, Set<String> dict) {
        // write your code here
        if(s == null || s.length() == 0)
            return true;

        if(dict == null || dict.size() == 0)
            return false;

        int len = s.length();
        boolean[] dp = new boolean[len + 1];

        dp[0] = true;

        for(int i = 1; i <= len; i++){
            for(String word: dict){
                int l = word.length();
                if(i >= l){
                    String temp = s.substring(i - l, i);
                    if(word.contains(temp) && dp[i - l]){
                        dp[i] = true;
                        break;
                    }
                }
            }
        }

        return dp[len];
    }
}