package GrayCode;

import java.util.ArrayList;

public class Solution {
    /**
     * @param n a number
     * @return Gray code
     */
    public ArrayList<Integer> grayCode(int n) {
        // Write your code here
        ArrayList<Integer> res = new ArrayList<Integer>();

        if(n <= 0){
            res.add(0);
            return res;
        }

        if(n == 1){
            res.add(0);
            res.add(1);
            return res;
        }

        ArrayList<Integer> temp = grayCode(n - 1);
        res.addAll(temp);

        for(int i = temp.size() - 1; i >= 0; i--){
            res.add((1 << (n - 1)) + temp.get(i));
        }

        return res;
    }
}