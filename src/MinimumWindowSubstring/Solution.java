package MinimumWindowSubstring;

import java.util.HashMap;

public class Solution {
    /**
     * @param source: A string
     * @param target: A string
     * @return: A string denote the minimum window
     *          Return "" if there is no such a string
     */
    public String minWindow(String source, String target) {
        // write your code

        if(target == null || target.length() == 0 || target.length() > source.length())
            return "";

        HashMap<Character, Integer> count = new HashMap<Character, Integer>();
        HashMap<Character, Integer> window = new HashMap<Character, Integer>();

        int start = 0;
        int end = 0;
        int len = source.length();

        for(int i = 0; i < target.length(); i++){
            char c = target.charAt(i);

            if(count.containsKey(c))
                count.put(c, count.get(c) + 1);
            else
                count.put(c, 1);
        }

        for(int i = 0; i < source.length(); i++){
            char c = source.charAt(i);

            if(window.containsKey(c))
                window.put(c, window.get(c) + 1);
            else
                window.put(c, 1);
        }

        if(!valid(count, window))
            return "";

        window.clear();
        String res = source;

        while(end < len){
            while(end < len && !valid(count, window)){
                char c = source.charAt(end);

                if(count.containsKey(c)){
                    if(!window.containsKey(c))
                        window.put(c, 1);
                    else
                        window.put(c, window.get(c) + 1);
                }

                end++;

            }

            while(start < end && valid(count, window)){
                char c = source.charAt(start);

                if(count.containsKey(c)){
                    if(window.containsKey(c)){
                        window.put(c, window.get(c) - 1);
                    }
                }
                start++;
            }

            if(end - start< res.length())
                res = source.substring(start - 1, end);

            end++;
        }

        return res;
    }

    public boolean valid(HashMap<Character, Integer> count, HashMap<Character, Integer> window){
        for(Character c: count.keySet()){
            if(!window.containsKey(c) || window.get(c) < count.get(c))
                return false;
        }

        return true;
    }
}
