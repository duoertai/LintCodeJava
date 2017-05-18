package LongestSubstringWithoutRepeatingCharacters;

import java.util.HashMap;

public class Solution {
    public int lengthOfLongestSubstring(String s) {
        // write your code here

        if(s == null || s.length() == 0)
            return 0;
        if(s.length() == 1)
            return 1;

        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int start = 0;
        int end = 0;
        int len = s.length();
        int res = 1;

        while(end < len){
            while(end < len && !map.containsKey(s.charAt(end))){
                map.put(s.charAt(end), end);
                end++;
            }

            res = Math.max(res, end - start);

            if(end == len)
                break;

            int new_start = map.get(s.charAt(end));
            for(int i = start; i <= new_start; i++)
                map.remove(s.charAt(i));

            start = new_start + 1;
        }

        return res;
    }
}
