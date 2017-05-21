package PreviousPermutation;

import java.util.ArrayList;

public class Solution {
    /**
     * @param nums: A list of integers
     * @return: A list of integers that's previous permuation
     */
    public ArrayList<Integer> previousPermuation(ArrayList<Integer> nums) {
        if(nums == null || nums.size() <= 1)
            return nums;

        int mark = nums.size() - 1;
        while(mark > 0 && nums.get(mark) >= nums.get(mark - 1))
            mark--;

        if(mark == 0){
            reverse(nums, 0, nums.size() - 1);
            return nums;
        }

        int smaller = mark;
        for(int i = mark; i < nums.size(); i++){
            if(nums.get(i) < nums.get(mark - 1)){
                if(nums.get(i) >= nums.get(smaller)){
                    smaller = i;
                }
            }
        }

        swap(nums, mark - 1, smaller);
        reverse(nums, mark, nums.size() - 1);

        return nums;
    }

    public void swap(ArrayList<Integer> nums, int i, int j){
        int temp = nums.get(i);
        nums.set(i, nums.get(j));
        nums.set(j, temp);

        return;
    }

    public void reverse(ArrayList<Integer> nums, int left, int right){
        while(left < right){
            swap(nums, left, right);
            left++;
            right--;
        }

        return;
    }

}

