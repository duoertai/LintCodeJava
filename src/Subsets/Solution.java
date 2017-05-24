package Subsets;

import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    public ArrayList<ArrayList<Integer>> subsets(int[] nums) {
        // write your code here
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();

        if(nums == null){
            return res;
        }

        ArrayList<Integer> line = new ArrayList<Integer>();
        Arrays.sort(nums);

        for(int i = 0; i <= nums.length; i++)
            helper(res, line, i, 0, nums);

        return res;
    }

    public void helper(ArrayList<ArrayList<Integer>> res, ArrayList<Integer> line, int size, int start, int[] nums){
        if(line.size() == size){
            res.add(new ArrayList<Integer>(line));
            return;
        }
        if(start >= nums.length)
            return;


        for(int i = start; i < nums.length; i++){
            line.add(nums[i]);
            helper(res, line, size, i + 1, nums);
            line.remove(line.size() - 1);
        }

        return;
    }

}
