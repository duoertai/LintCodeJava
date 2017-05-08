package PartitionArraybyOddandEven;

public class Solution {
    /**
     * @param nums: an array of integers
     * @return: nothing
     */
    public void partitionArray(int[] nums) {
        // write your code here;

        if(nums == null || nums.length <= 1)
            return;

        int left = 0;
        int i = 0;
        int right = nums.length - 1;

        while(i <= right){
            if(nums[i] % 2 == 1){
                swap(nums, i++, left++);
            }
            else{
                swap(nums, i, right--);
            }
        }

        return;
    }

    public void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
        return;
    }
}