package GenerateParentheses;

import java.util.ArrayList;

public class Solution {
    /**
     * @param n n pairs
     * @return All combinations of well-formed parentheses
     */
    public ArrayList<String> generateParenthesis(int n) {
        // Write your code here
        ArrayList<String> res = new ArrayList<String>();

        if(n <= 0)
            return res;

        helper(res, "", 0, 0, n);

        return res;
    }

    public void helper(ArrayList<String> res, String curr, int left, int right, int n){
        if(curr.length() == 2 * n){
            if(left == right){
                res.add(curr);
                return;
            }
            else{
                return;
            }
        }

        if(curr.length() > 2 * n)
            return;

        if(right > left)
            return;

        helper(res, curr + "(", left + 1, right, n);
        helper(res, curr + ")", left, right + 1, n);

        return;
    }

}
