package FindTheMissingNumber;

public class Solution {
    /**
     * @param nums: an array of integers
     * @return: an integer
     */
    public int findMissing(int[] nums) {
        // write your code here

        if(nums == null || nums.length == 0)
            return 0;

        int sum = 0;
        for(int n: nums)
            sum += n;

        int n = nums.length;

        if(sum == n * (n + 1) / 2)
            return 0;
        else if(sum == (n - 1) * n / 2)
            return n;
        else
            return n * (n + 1) / 2 - sum;
    }
}