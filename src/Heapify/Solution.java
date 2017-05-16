package Heapify;

public class Solution {
    /**
     * @param A: Given an integer array
     * @return: void
     */
    public void heapify(int[] A) {
        // write your code here

        if(A == null || A.length <= 1)
            return;

        for(int i = A.length / 2; i >= 0; i--)
            shiftdown(A, i);

        return;
    }

    public void shiftdown(int[] nums, int i){
        while(i < nums.length){
            int smallest = i;

            if(2 * i + 1 < nums.length && nums[2 * i + 1] < nums[smallest])
                smallest = 2 * i + 1;
            if(2 * i + 2 < nums.length && nums[2 * i + 2] < nums[smallest])
                smallest = 2 * i + 2;

            if(smallest == i)
                break;

            int temp = nums[smallest];
            nums[smallest] = nums[i];
            nums[i] = temp;

            i = smallest;
        }

        return;
    }
}