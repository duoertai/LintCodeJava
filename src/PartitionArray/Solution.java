package PartitionArray;

public class Solution {
    /*
     * @param : The integer array you should partition
     * @param : An integer
     * @return: The index after partition
     */
    public int partitionArray(int[] nums, int k) {
        // write your code here

        if(nums == null || nums.length <= 1)
            return 0;

        int left = 0;
        int i = 0;
        int right = nums.length - 1;

        while(i <= right){
            if(nums[i] < k)
                swap(nums, i++, left++);
            else if(nums[i] > k)
                swap(nums, i, right--);
            else
                i++;
        }

        return left;
    }

    public void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;

        return;
    }
}

