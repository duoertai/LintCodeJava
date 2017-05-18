package LongestPalindromicSubstring;

public class Solution {
    public String longestPalindrome(String s) {
        // Write your code here
        if(s == null || s.length() <= 1)
            return s;

        String res = "";

        for(int i = 0; i < s.length() - 1; i++){
            int start = i;
            int end = i;

            while(start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)){
                start--;
                end++;
            }

            String s1 = s.substring(start + 1, end);
            if(s1.length() > res.length())
                res = s1;

            start = i;
            end = i + 1;

            while(start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)){
                start--;
                end++;
            }

            s1 = s.substring(start + 1, end);
            if(s1.length() > res.length())
                res = s1;

        }

        return res;
    }
}
