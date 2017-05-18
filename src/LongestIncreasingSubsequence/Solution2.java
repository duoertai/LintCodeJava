package LongestIncreasingSubsequence;

public class Solution2 {
    public int longestIncreasingSubsequence(int[] nums) {
        // write your code here

        if(nums == null || nums.length == 0)
            return 0;
        if(nums.length == 1)
            return 1;

        int n = nums.length;
        int[] record = new int[n + 1];
        record[0] = Integer.MIN_VALUE;
        for(int i = 1; i <= n; i++)
            record[i] = Integer.MAX_VALUE;

        for(int i = 0; i < n; i++){
            int index = search(record, nums[i]);
            record[index] = nums[i];
        }

        for(int i = n; i >= 1; i--)
            if(record[i] != Integer.MAX_VALUE)
                return i;

        return 1;
    }

    public int search(int[] nums, int n){
        int left = 0;
        int right = nums.length - 1;

        while(left < right - 1){
            int mid = left + (right - left) / 2;

            if(nums[mid] < n)
                left = mid;
            else
                right = mid;
        }

        if(nums[left] > n)
            return left;
        else
            return right;
    }
}
