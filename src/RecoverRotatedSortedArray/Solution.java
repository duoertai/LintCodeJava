package RecoverRotatedSortedArray;

import java.util.ArrayList;

public class Solution {
    /**
     * @param nums: The rotated sorted array
     * @return: void
     */
    public void recoverRotatedSortedArray(ArrayList<Integer> nums) {
        // write your code
        if(nums == null || nums.size() == 0)
            return;

        int k = 0;

        while(k < nums.size() - 1 && nums.get(k) <= nums.get(k + 1))
            k++;

        if(k == nums.size() - 1)
            return;

        reverse(nums, 0, k);
        reverse(nums, k + 1, nums.size() - 1);
        reverse(nums, 0, nums.size() - 1);

        return;
    }

    public void reverse(ArrayList<Integer> nums, int left, int right){
        while(left < right)
            swap(nums, left++, right--);
        return;
    }

    public void swap(ArrayList<Integer> res, int i, int j){
        int temp = res.get(i);
        res.set(i, res.get(j));
        res.set(j, temp);
        return;
    }

}