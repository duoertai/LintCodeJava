package CombinationSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    /**
     * @param candidates: A list of integers
     * @param target:An integer
     * @return: A list of lists of integers
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        // write your code here

        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(candidates == null || candidates.length == 0)
            return res;

        List<Integer> line = new ArrayList<Integer>();
        Arrays.sort(candidates);

        helper(res, line, 0, candidates, target);

        return res;
    }

    public void helper(List<List<Integer>> res, List<Integer> line, int start, int[] candidates, int target){
        if(target < 0)
            return;

        if(target == 0){
            res.add(new ArrayList<Integer>(line));
            return;
        }

        for(int i = start; i < candidates.length; i++){
            if(i > 0 && candidates[i - 1] == candidates[i])
                continue;

            line.add(candidates[i]);
            helper(res, line, i, candidates, target - candidates[i]);
            line.remove(line.size() - 1);
        }

        return;
    }

}
