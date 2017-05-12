package BackPackVI;

public class Solution {
    /**
     * @param nums an integer array and all positive numbers, no duplicates
     * @param target an integer
     * @return an integer
     */
    public int backPackVI(int[] nums, int target) {
        // Write your code here

        if(nums == null || nums.length == 0)
            return 0;

        int[] count = new int[target + 1];
        count[0] = 1;

        for(int i = 0; i <= target; i++){
            for(int j = 0; j < nums.length; j++){
                if(i >= nums[j])
                    count[i] += count[i - nums[j]];
            }
        }

        return count[target];
    }
}
