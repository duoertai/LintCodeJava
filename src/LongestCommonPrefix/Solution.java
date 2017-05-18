package LongestCommonPrefix;

public class Solution {
    public String longestCommonPrefix(String[] strs) {
        // write your code here
        if(strs == null || strs.length == 0)
            return "";

        int min_len = Integer.MAX_VALUE;
        for(String s: strs)
            min_len = Math.min(min_len, s.length());

        int end = 0;

        for(; end < min_len; end++){
            char c = strs[0].charAt(end);

            for(int j = 1; j < strs.length; j++)
                if(strs[j].charAt(end) != c){
                    return strs[0].substring(0, end);
                }
        }

        return strs[0].substring(0, end);
    }
}
