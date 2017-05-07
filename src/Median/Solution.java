package Median;

public class Solution {
    /**
     * @param nums: A list of integers.
     * @return: An integer denotes the middle number of the array.
     */
    public int median(int[] nums) {
        // write your code here
        if(nums == null || nums.length == 0)
            return 0;
        if(nums.length == 1)
            return nums[0];

        if(nums.length % 2 == 1)
            return quickselect(nums, 0, nums.length - 1, nums.length / 2);
        else
            return quickselect(nums, 0, nums.length - 1, nums.length / 2 - 1);
    }

    public int quickselect(int[] nums, int start, int end, int k){
        if(start > end)
            return 0;

        int left = start;
        int i = start;
        int right = end;
        int pivot = nums[end];

        while(i <= right){
            if(nums[i] < pivot)
                swap(nums, i++, left++);
            else if (nums[i] > pivot)
                swap(nums, i, right--);
            else
                i++;
        }

        if(left <= k && k <= right)
            return nums[k];
        else if(k < left)
            return quickselect(nums, start, left - 1, k);
        else
            return quickselect(nums, right + 1, end, k);
    }

    public void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
        return;
    }
}

