package WiggleSort;

import java.util.Arrays;

public class Solution1 {
    /**
     * @param nums a list of integer
     * @return void
     */
    public void wiggleSort(int[] nums) {
        // Write your code here
        if(nums == null || nums.length < 2)
            return;

        Arrays.sort(nums);
        int len = nums.length;

        int i = 1;

        while(i + 1 < len){
            swap(nums, i, i + 1);
            i += 2;
        }
        return;
    }

    public void reverse(int[] nums, int start, int end){
        while(start < end){
            swap(nums, start++, end--);
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