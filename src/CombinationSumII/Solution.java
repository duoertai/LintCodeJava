package CombinationSumII;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    /**
     * @param num: Given the candidate numbers
     * @param target: Given the target number
     * @return: All the combinations that sum to target
     */
    public List<List<Integer>> combinationSum2(int[] num, int target) {
        // write your code here

        List<List<Integer>> res = new ArrayList<List<Integer>>();

        if(num == null || num.length == 0)
            return res;

        Arrays.sort(num);
        List<Integer> line = new ArrayList<Integer>();
        boolean[] visited = new boolean[num.length];

        helper(res, line, 0, num, visited, target);

        return res;
    }

    public void helper(List<List<Integer>> res, List<Integer> line, int start, int[] num, boolean[] visited, int target){
        if(target < 0)
            return;

        if(target == 0){
            res.add(new ArrayList<Integer>(line));
            return;
        }

        for(int i = start; i < num.length; i++){
            if(i > 0 && num[i - 1] == num[i] && !visited[i - 1])
                continue;

            line.add(num[i]);
            visited[i] = true;
            helper(res, line, i + 1, num, visited, target - num[i]);
            visited[i] = false;
            line.remove(line.size() - 1);
        }

        return;
    }

}