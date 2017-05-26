package AddOperators;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    /**
     * @param num a string contains only digits 0-9
     * @param target an integer
     * @return return all possibilities
     */
    public List<String> addOperators(String num, int target) {
        List<String> res = new ArrayList<String>();

        if(num == null || num.length() == 0)
            return res;

        helper(res, "", 0, 0, 0, num, target);

        return res;
    }

    public void helper(List<String> res, String str, long currSum, long preSum, int start, String num, int target){

        if(start == num.length()){
            if(currSum == target)
                res.add(str);

            return;
        }

        for(int i = start + 1; i <= num.length(); i++){
            String temp = num.substring(start, i);
            if(!valid(temp))
                return;

            long n = Long.parseLong(temp);

            if(str.length() == 0){
                helper(res, temp, n, 0, i, num, target);
                continue;
            }

            helper(res, str + "+" + temp, currSum + n, currSum, i, num, target);
            helper(res, str + "-" + temp, currSum - n, currSum, i, num, target);
            helper(res, str + "*" + temp, (currSum - preSum) * n + preSum, preSum, i, num, target);

        }

        return;
    }

    public boolean valid(String s){
        if(s == null || s.length() == 0)
            return false;
        if(s.length() > 1 && s.charAt(0) == '0')
            return false;

        return true;
    }
}
