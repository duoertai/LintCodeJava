package HouseRobberII;

public class Solution {
    /**
     * @param nums: An array of non-negative integers.
     * return: The maximum amount of money you can rob tonight
     */
    public int houseRobber2(int[] nums) {
        // write your code here
        if(nums == null || nums.length == 0)
            return 0;

        if(nums.length == 1)
            return nums[0];


        int[] last = new int[nums.length - 1];
        int[] max = new int[nums.length - 1];

        last[0] = nums[0];
        max[0] = nums[0];
        last[1] = nums[1];
        max[1] = Math.max(nums[0], nums[1]);

        for(int i = 2; i < nums.length - 1; i++){
            last[i] = nums[i] + max[i - 2];
            max[i] = Math.max(last[i - 1], nums[i] + max[i - 2]);
        }

        int res = max[nums.length - 2];

        last[0] = nums[1];
        last[1] = nums[2];
        max[0] = nums[1];
        max[1] = Math.max(nums[1], nums[2]);

        for(int i = 3; i < nums.length; i++){
            last[i - 1] = nums[i] + max[i - 3];
            max[i - 1] = Math.max(last[i - 2], nums[i] + max[i - 3]);
        }

        res = Math.max(res, max[nums.length - 2]);

        return res;
    }
}
