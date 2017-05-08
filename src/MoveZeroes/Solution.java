package MoveZeroes;

public class Solution {
    /**
     * @param nums an integer array
     * @return nothing, do this in-place
     */
    public void moveZeroes(int[] nums) {
        // Write your code here
        if(nums == null || nums.length <= 1)
            return;

        int i = 0;
        int left = 0;

        while(i < nums.length){
            if(nums[i] != 0)
                swap(nums, i++, left++);
            else
                i++;
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
