package PalindromePartitioning;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    /**
     * @param s: A string
     * @return: A list of lists of string
     */
    public List<List<String>> partition(String s) {
        // write your code here
        List<List<String>> res = new ArrayList<List<String>>();

        if(s == null || s.length() == 0)
            return res;

        List<String> line = new ArrayList<String>();

        helper(res, line, 0, s);

        return res;
    }

    public void helper(List<List<String>> res, List<String> line, int start, String s){
        if(start == s.length()){
            res.add(new ArrayList<String>(line));
            return;
        }

        int end = start + 1;

        for(; end <= s.length(); end++){
            String temp = s.substring(start, end);

            if(isPalindrome(temp)){
                line.add(temp);
                helper(res, line, end, s);
                line.remove(line.size() - 1);
            }
        }

        return;
    }

    public boolean isPalindrome(String s){
        int left = 0;
        int right = s.length() - 1;

        while(left < right){
            if(s.charAt(left) != s.charAt(right))
                return false;

            left++;
            right--;
        }

        return true;
    }
}
