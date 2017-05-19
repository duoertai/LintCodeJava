package MaximumSubarrayDifference;

public class Solution {
    /**
     * @param nums: A list of integers
     * @return: An integer indicate the value of maximum difference between two
     *          Subarrays
     */
    public int maxDiffSubArrays(int[] nums) {
        // write your code here
        if(nums == null || nums.length < 2)
            return 0;

        int n = nums.length;
        int[] left_max = new int[n];
        int[] left_min = new int[n];

        int sum = nums[0];
        left_max[0] = nums[0];
        for(int i = 1; i < n; i++){
            if(sum < 0)
                sum = 0;

            sum += nums[i];

            left_max[i] = Math.max(left_max[i - 1], sum);
        }

        left_min[0] = nums[0];
        sum = nums[0];
        for(int i = 1; i < n; i++){
            if(sum > 0)
                sum = 0;

            sum += nums[i];

            left_min[i] = Math.min(left_min[i - 1], sum);
        }

        int[] right_max = new int[n];
        int[] right_min = new int[n];

        sum = nums[n - 1];
        right_max[n - 1] = nums[n - 1];
        for(int i = n - 2; i >= 0; i--){
            if(sum < 0)
                sum = 0;

            sum += nums[i];

            right_max[i] = Math.max(right_max[i + 1], sum);
        }

        sum = nums[n - 1];
        right_min[n - 1] = nums[n - 1];
        for(int i = n - 2; i >= 0; i--){
            if(sum > 0)
                sum = 0;

            sum += nums[i];

            right_min[i] = Math.min(right_min[i + 1], sum);
        }

        int res = 0;

        for(int i = 0; i < n - 1; i++){
            res = Math.max(res, Math.abs(left_max[i] - right_min[i + 1]));
            res = Math.max(res, Math.abs(left_min[i] - right_max[i + 1]));
        }

        return res;
    }
}


