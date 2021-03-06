package MaximumProductSubarray;

public class Solution {
    /**
     * @param nums: an array of integers
     * @return: an integer
     */
    public int maxProduct(int[] nums) {
        // write your code here
        if(nums == null || nums.length == 0)
            return 0;

        int n = nums.length;
        int[] max = new int[n];
        int[] min = new int[n];
        int res = nums[0];

        max[0] = nums[0];
        min[0] = nums[0];

        for(int i = 1; i < n; i++){
            if(nums[i] < 0){
                max[i] = Math.max(nums[i], min[i - 1] * nums[i]);
                min[i] = Math.min(nums[i], max[i - 1] * nums[i]);
            }
            else if(nums[i] > 0){
                max[i] = Math.max(nums[i], max[i - 1] * nums[i]);
                min[i] = Math.min(nums[i], min[i - 1] * nums[i]);
            }

            res = Math.max(res, max[i]);
        }

        return res;
    }
}