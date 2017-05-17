package KthLargestElement;

public class Solution {
    public int kthLargestElement(int n, int[] nums) {
        // write your code here

        if(nums == null || nums.length < n || n < 1)
            return 0;

        n--;

        return quickselect(nums, 0, nums.length - 1, nums.length - 1 - n);
    }

    public int quickselect(int[] nums, int start, int end, int k){
        int left = start;
        int i = start;
        int right = end;
        int pivot = nums[end];

        while(i <= right){
            if(nums[i] < pivot)
                swap(nums, i++, left++);
            else if(nums[i] > pivot)
                swap(nums, i, right--);
            else
                i++;
        }
        if(k >= left && k <= right)
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

};