package SubsetsII;

import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    /**
     * @param nums: A set of numbers.
     * @return: A list of lists. All valid subsets.
     */
    public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] nums) {
        // write your code here
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();

        if(nums == null)
            return res;

        ArrayList<Integer> line = new ArrayList<Integer>();
        int n = nums.length;
        boolean[] visited = new boolean[n];
        Arrays.sort(nums);

        for(int i = 0; i <= n; i++)
            helper(res, line, i, 0, nums, visited);

        return res;
    }

    public void helper(ArrayList<ArrayList<Integer>> res, ArrayList<Integer> line, int size, int start, int[] nums, boolean[] visited){
        if(line.size() == size){
            res.add(new ArrayList<Integer>(line));
            return;
        }

        if(start >= nums.length){
            return;
        }

        for(int i = start; i < nums.length; i++){
            if(i > 0 && nums[i] == nums[i - 1] && !visited[i - 1])
                continue;

            if(!visited[i]){
                line.add(nums[i]);
                visited[i] = true;
                helper(res, line, size, i + 1, nums, visited);
                visited[i] = false;
                line.remove(line.size() - 1);
            }
        }

        return;
    }
}
