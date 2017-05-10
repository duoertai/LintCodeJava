package TwoStringsAreAnagrams;

public class Solution {
    /**
     * @param : The first string
     * @param : The second string
     * @return true or false
     */
    public boolean anagram(String s, String t) {
        // write your code here
        if(s == null && t == null)
            return true;
        if(s == null || t == null)
            return false;

        int[] count = new int[128];

        for(int i = 0; i < s.length(); i++)
            count[s.charAt(i)]++;
        for(int i = 0; i < t.length(); i++)
            count[t.charAt(i)]--;

        for(int i = 0; i < 128; i++)
            if(count[i] != 0)
                return false;

        return true;
    }
}
