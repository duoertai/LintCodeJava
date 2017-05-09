package ReverseWordsInAString;

public class Solution {
    /**
     * @param s : A string
     * @return : A string
     */
    public String reverseWords(String s) {
        // write your code
        if(s == null || s.length() == 0)
            return s;

        s = s.trim();

        if(s.length() == 0)
            return "";

        StringBuilder res = new StringBuilder();

        int start = 0;
        int end = 0;
        while(end < s.length()){
            while(end < s.length() && s.charAt(end) != ' ')
                end++;
            res.insert(0, s.substring(start, end));
            res.insert(0, ' ');

            if(end == s.length())
                break;

            while(end < s.length() && s.charAt(end) == ' ')
                end++;

            start = end;
        }

        return res.substring(1);
    }
}

