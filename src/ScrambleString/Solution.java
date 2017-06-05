package ScrambleString;

public class Solution {
    /**
     * @param s1 A string
     * @param s2 Another string
     * @return whether s2 is a scrambled string of s1
     */
    public boolean isScramble(String s1, String s2) {
        if(s1 == null && s2 == null)
            return true;
        if(s1 == null || s2 == null)
            return false;

        if(s1.length() != s2.length())
            return false;

        if(s1.equals(s2))
            return true;

        int len = s1.length();

        for(int i = 0; i < len - 1; i++){
            if(isScramble(s1.substring(0, i + 1), s2.substring(0, i + 1)) && isScramble(s1.substring(i + 1), s2.substring(i + 1)))
                return true;

            if(isScramble(s1.substring(0, i + 1), s2.substring(len - i - 1)) && isScramble(s1.substring(i + 1), s2.substring(0, len - i - 1)))
                return true;
        }

        return false;
    }
}