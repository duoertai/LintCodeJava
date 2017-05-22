package RestoreIPAddresses;

import java.util.ArrayList;

public class Solution {
    /**
     * @param s the IP string
     * @return All possible valid IP addresses
     */
    public ArrayList<String> restoreIpAddresses(String s) {
        ArrayList<String> res = new ArrayList<String>();

        if(s == null || s.length() == 0)
            return res;

        ArrayList<Integer> line = new ArrayList<Integer>();

        helper(res, line, 0, s);

        return res;
    }

    public void helper(ArrayList<String> res, ArrayList<Integer> line, int start, String s){
        if(start > s.length())
            return;
        if(line.size() == 4){
            if(start == s.length()){
                String temp = "";
                for(int i = 0; i < 4; i++)
                    if(i < 3)
                        temp = temp + line.get(i) + '.';
                    else
                        temp = temp + line.get(i);

                res.add(temp);
            }
            return;
        }

        for(int i = start; i < start + 3 && i < s.length(); i++){
            String str = s.substring(start, i + 1);
            if(valid(str)){
                line.add(Integer.valueOf(str));
                helper(res, line, i + 1, s);
                line.remove(line.size() - 1);
            }
        }

        return;
    }

    public boolean valid(String s){
        if(s.length() == 0 || s.length() > 3)
            return false;

        if(s.length() > 1 && s.charAt(0) == '0')
            return false;

        int num = Integer.valueOf(s);

        return num >= 0 && num <= 255;
    }
}