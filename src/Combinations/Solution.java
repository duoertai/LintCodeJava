package Combinations;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    /**
     * @param n: Given the range of numbers
     * @param k: Given the numbers of combinations
     * @return: All the combinations of k numbers out of 1..n
     */
    public List<List<Integer>> combine(int n, int k) {
        // write your code here

        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(n < 1 || k > n || k < 0)
            return res;

        List<Integer> line = new ArrayList<Integer>();

        helper(res, line, 1, n, k);

        return res;
    }

    public void helper(List<List<Integer>> res, List<Integer> line, int start, int n, int k){

        if(line.size() == k){
            res.add(new ArrayList<Integer>(line));
            return;
        }

        for(int i = start; i <= n; i++){
            line.add(i);
            helper(res, line, i + 1, n, k);
            line.remove(line.size() - 1);
        }

        return;
    }

}
