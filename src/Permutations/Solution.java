package Permutations;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    /*
     * @param : A list of integers.
     * @return: A list of permutations.
     */
    public List<List<Integer>> permute(int[] nums) {
        // write your code here
        List<List<Integer>> res = new ArrayList<List<Integer>>();

        if(nums == null)
            return res;

        boolean[] visited = new boolean[nums.length];
        List<Integer> line = new ArrayList<Integer>();

        helper(res, line, nums, visited);

        return res;
    }

    public void helper(List<List<Integer>> res, List<Integer> line, int[] nums, boolean[] visited){

        if(line.size() == nums.length){
            res.add(new ArrayList<Integer>(line));
            return;
        }

        for(int i = 0; i < nums.length; i++){
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
