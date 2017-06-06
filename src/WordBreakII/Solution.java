package WordBreakII;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Solution {
    public List<String> wordBreak(String s, Set<String> wordDict) {
        List<String> res = new ArrayList<String>();

        if(s == null || s.length() == 0 || wordDict == null || wordDict.size() == 0)
            return res;

        helper(res, "", s, wordDict);

        return res;
    }

    public void helper(List<String> res, String str, String s, Set<String> dict){
        if(s.length() == 0){
            res.add(str.trim());
            return;
        }

        for(String word: dict){
            int len = word.length();

            if(len > s.length() || len == 0)
                continue;

            String temp = s.substring(0, len);
            if(temp.equals(word)){
                helper(res, str + " " + temp, s.substring(len), dict);
            }
        }

        return;
    }
}
