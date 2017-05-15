package EditDistanceII;

public class Solution {
    /**
     * @param s a string
     * @param t a string
     * @return true if they are both one edit distance apart or false
     */
    public boolean isOneEditDistance(String s, String t) {
        // Write your code here
        if(s == null && t == null)
            return false;
        if(s == null || s.length() == 0)
            return t.length() == 1;
        if(t == null || t.length() == 0)
            return s.length() == 1;
        if(Math.abs(s.length() - t.length()) > 1)
            return false;

        int p1 = 0;
        int p2 = 0;

        while(p1 < s.length() && p2 < t.length() && s.charAt(p1) == t.charAt(p2)){
            p1++;
            p2++;
        }

        if(p1 == s.length() && p2 == t.length())
            return false;
        if(p1 == s.length())
            return p2 == t.length() - 1;
        if(p2 == t.length())
            return p1 == s.length() - 1;

        return s.substring(p1 + 1).equals(t.substring(p2)) || s.substring(p1).equals(t.substring(p2 + 1)) || s.substring(p1 + 1).equals(t.substring(p2 + 1));

    }
}
