package WordLadder;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class Solution {
    /**
     * @param start, a string
     * @param end, a string
     * @param dict, a set of string
     * @return an integer
     */
    public int ladderLength(String start, String end, Set<String> dict) {
        // write your code here
        if(start == null || end == null || start.length() != end.length() || start.length() == 0 || end.length() == 0)
            return 0;

        if(start.equals(end))
            return 1;

        if(dict == null || dict.size() == 0)
            return 0;

        int res = 1;
        LinkedList<String> curr = new LinkedList<String>();
        LinkedList<String> next = new LinkedList<String>();
        HashSet<String> set = new HashSet<String>();
        dict.remove(start);
        dict.add(end);

        curr.offer(start);

        while(!curr.isEmpty()){
            String temp = curr.poll();
            if(temp.equals(end))
                return res;
            char[] chars = temp.toCharArray();

            for(int i = 0; i < chars.length; i++){
                char original = chars[i];

                for(char c = 'a'; c <= 'z'; c++){
                    if(c == original)
                        continue;

                    chars[i] = c;
                    String newStr = String.valueOf(chars);

                    if(set.contains(newStr))
                        continue;
                    set.add(newStr);

                    if(dict.contains(newStr))
                        next.offer(newStr);
                }

                chars[i] = original;
            }

            if(curr.isEmpty()){
                curr = next;
                next = new LinkedList<String>();
                res++;
            }

        }

        return 0;
    }
}