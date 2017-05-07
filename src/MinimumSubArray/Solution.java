package MinimumSubArray;

import java.util.ArrayList;

public class Solution {
    /**
     * @param nums: a list of integers
     * @return: A integer indicate the sum of minimum subarray
     */
    public int minSubArray(ArrayList<Integer> nums) {
        // write your code
        if(nums == null || nums.size() == 0)
            return 0;

        if(nums.size() == 1)
            return nums.get(0);

        int sum = nums.get(0);
        int min = nums.get(0);
        int res = nums.get(0);

        for(int i = 1; i < nums.size(); i++){
            if(sum > 0)
                sum = 0;

            sum += nums.get(i);
            res = Math.min(res, sum);
        }

        return res;
    }
}

