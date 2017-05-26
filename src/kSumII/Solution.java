package kSumII;

import java.util.ArrayList;
import java.util.Arrays;

public class Solution {
    /**
     * @param A: an integer array.
     * @param k: a positive integer (k <= length(A))
     * @param target: a integer
     * @return a list of lists of integer
     */
    public ArrayList<ArrayList<Integer>> kSumII(int[] A, int k, int target) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();

        if(A == null || A.length == 0)
            return res;

        Arrays.sort(A);
        ArrayList<Integer> line = new ArrayList<Integer>();

        helper(res, line, k, 0, target, A);

        return res;
    }

    public void helper(ArrayList<ArrayList<Integer>> res, ArrayList<Integer> line, int k, int start, int target, int[] nums){
        if(line.size() == k){
            if(target == 0){
                res.add(new ArrayList<Integer>(line));
            }
            return;
        }

        for(int i = start; i < nums.length; i++){
            if(target >= nums[i]){
                line.add(nums[i]);
                helper(res, line, k, i + 1, target - nums[i], nums);
                line.remove(line.size() - 1);
            }
        }

        return;
    }

}
