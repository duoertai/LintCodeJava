package FindMinimumInRotatedSortedArray;

public class Solution {
    /**
     * @param nums: a rotated sorted array
     * @return: the minimum number in the array
     */
    public int findMin(int[] nums) {
        // write your code here

        if(nums == null || nums.length == 0)
            return 0;

        int left = 0;
        int right = nums.length - 1;

        if(nums[left] < nums[right])
            return nums[left];

        while(left < right - 1){
            int mid = left + (right - left) / 2;

            if(nums[left] < nums[mid])
                left = mid;
            else
                right = mid;
        }

        return Math.min(nums[left], nums[right]);
    }
}