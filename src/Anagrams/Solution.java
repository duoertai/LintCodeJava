package Anagrams;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    /**
     * @param strs: A list of strings
     * @return: A list of strings
     */
    public List<String> anagrams(String[] strs) {
        // write your code here

        List<String> res = new ArrayList<String>();

        if(strs == null || strs.length <= 1)
            return res;

        HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();

        for(String s: strs){
            String count = getStr(s);

            if(map.containsKey(count)){
                map.get(count).add(s);
            }
            else{
                map.put(count, new ArrayList<String>());
                map.get(count).add(s);
            }
        }

        for(Map.Entry<String, ArrayList<String>> entry: map.entrySet()){
            if(entry.getValue().size() > 1)
                res.addAll(entry.getValue());
        }

        return res;
    }

    public String getStr(String s){
        if(s == null || s.length() == 0)
            return "";

        int[] count = new int[128];
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            count[c]++;
        }

        StringBuilder res = new StringBuilder();

        for(int i = 0; i < 128; i++){
            if(count[i] > 0)
                res.append((char) i).append(count[i]);
        }

        return res.toString();
    }

}