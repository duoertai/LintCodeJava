package MinimumSizeSubarraySum;

public class Solution {
    /**
     * @param nums: an array of integers
     * @param s: an integer
     * @return: an integer representing the minimum size of subarray
     */
    public int minimumSize(int[] nums, int s) {
        // write your code here

        if(nums == null || nums.length == 0)
            return -1;

        int len = nums.length;
        int start = 0;
        int end = 0;
        int sum = 0;
        int res = Integer.MAX_VALUE;

        for(int n: nums)
            sum += n;

        if(sum < s)
            return -1;
        sum = 0;

        while(end < len){
            while(end < len && sum < s){
                sum += nums[end];
                end++;
            }

            while(start < end && sum >= s){
                sum -= nums[start];
                start++;
            }

            res = Math.min(res, end - start + 1);
        }

        return res;
    }
}
