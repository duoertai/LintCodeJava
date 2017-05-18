package LongestIncreasingSubsequence;

public class Solution1 {
    public int longestIncreasingSubsequence(int[] nums) {
        // write your code here
        if(nums == null || nums.length == 0)
            return 0;

        if(nums.length == 1)
            return 1;

        int[] count = new int[nums.length];
        for(int i = 0; i < nums.length; i++)
            count[i] = 1;

        for(int i = 0; i < nums.length; i++){
            for(int j = 0; j < i; j++){
                if(nums[i] > nums[j] && count[i] < count[j] + 1)
                    count[i] = count[j] + 1;
            }
        }

        int max = 1;
        for(int c: count)
            max = Math.max(max, c);

        return max;
    }
}
