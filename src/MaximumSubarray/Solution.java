package MaximumSubarray;

public class Solution {
    /**
     * @param nums: A list of integers
     * @return: A integer indicate the sum of max subarray
     */
    public int maxSubArray(int[] nums) {
        // write your code
        if(nums == null || nums.length == 0)
            return 0;
        if(nums.length == 1)
            return nums[0];

        int sum = nums[0];
        int res = nums[0];

        for(int i = 1; i < nums.length; i++){
            if(sum < 0)
                sum = 0;

            sum += nums[i];

            res = Math.max(res, sum);
        }

        return res;
    }
}