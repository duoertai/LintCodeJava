package LengthOfLastWord;

public class Solution {
    /**
     * @param s A string
     * @return the length of last word
     */
    public int lengthOfLastWord(String s) {
        // Write your code here
        if(s == null || s.length() == 0)
            return 0;

        int index = s.length() - 1;

        while(index >= 0 && s.charAt(index) == ' ')
            index--;

        if(index < 0)
            return 0;

        int res = 0;

        while(index >= 0 && s.charAt(index) != ' '){
            index--;
            res++;
        }

        return res;
    }
}