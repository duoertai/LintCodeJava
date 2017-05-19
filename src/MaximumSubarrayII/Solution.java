package MaximumSubarrayII;

import java.util.ArrayList;

public class Solution {
    /**
     * @param nums: A list of integers
     * @return: An integer denotes the sum of max two non-overlapping subarrays
     */
    public int maxTwoSubArrays(ArrayList<Integer> nums) {
        // write your code

        if(nums == null || nums.size() == 0)
            return 0;

        int n = nums.size();
        int[] left = new int[n];
        int[] right = new int[n];

        left[0] = nums.get(0);
        int sum = nums.get(0);

        for(int i = 1; i < n; i++){
            if(sum < 0)
                sum = 0;

            sum += nums.get(i);

            left[i] = Math.max(left[i - 1], sum);
        }

        right[n - 1] = nums.get(n - 1);
        sum = nums.get(n - 1);

        for(int i = n - 2; i >= 0; i--){
            if(sum < 0)
                sum = 0;

            sum += nums.get(i);

            right[i] = Math.max(right[i + 1], sum);
        }

        int res = Integer.MIN_VALUE;

        for(int i = 0; i < n - 1; i++)
            res = Math.max(res, left[i] + right[i + 1]);

        return res;
    }
}


