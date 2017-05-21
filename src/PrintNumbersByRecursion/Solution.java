package PrintNumbersByRecursion;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    /**
     * @param n: An integer.
     * return : An array storing 1 to the largest number with n digits.
     */
    public List<Integer> numbersByRecursion(int n) {
        // write your code here

        List<Integer> res = new ArrayList<Integer>();

        if(n <= 0)
            return res;

        helper(n, 0, res);

        return res;
    }

    public void helper(int n, int num, List<Integer> res){
        if(n == 0){
            if(num > 0)
                res.add(num);

            return;
        }

        helper(n - 1, num * 10, res);
        helper(n - 1, num * 10 + 1, res);
        helper(n - 1, num * 10 + 2, res);
        helper(n - 1, num * 10 + 3, res);
        helper(n - 1, num * 10 + 4, res);
        helper(n - 1, num * 10 + 5, res);
        helper(n - 1, num * 10 + 6, res);
        helper(n - 1, num * 10 + 7, res);
        helper(n - 1, num * 10 + 8, res);
        helper(n - 1, num * 10 + 9, res);

        return;
    }

}
