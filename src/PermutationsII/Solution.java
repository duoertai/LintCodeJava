package PermutationsII;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    /*
     * @param :  A list of integers
     * @return: A list of unique permutations
     */
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();

        if(nums == null)
            return res;

        List<Integer> line = new ArrayList<Integer>();
        Arrays.sort(nums);
        boolean[] visited = new boolean[nums.length];

        helper(res, line, nums, visited);

        return res;
    }

    public void helper(List<List<Integer>> res, List<Integer> line, int[] nums, boolean[] visited){
        if(line.size() == nums.length){
            res.add(new ArrayList<Integer>(line));
            return;
        }

        for(int i = 0; i < nums.length; i++){
            if(i > 0 && nums[i] == nums[i - 1] && !visited[i - 1])
                continue;

            if(!visited[i]){
                visited[i] = true;
                line.add(nums[i]);
                helper(res, line, nums, visited);
                line.remove(line.size() - 1);
                visited[i] = false;
            }
        }

        return;
    }

}
