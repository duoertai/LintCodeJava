package LongestIncreasingSubsequence;

import java.util.ArrayList;

public class Solution3 {
    public int longestIncreasingSubsequence(int[] nums) {
        // write your code here
        if(nums == null || nums.length == 0)
            return 0;
        if(nums.length == 1)
            return 1;

        ArrayList<Integer> record = new ArrayList<Integer>();

        for(int i = 0; i < nums.length; i++){
            add(record, nums[i]);
        }

        return record.size();
    }

    public void add(ArrayList<Integer> nums, int n){
        if(nums.size() == 0){
            nums.add(n);
            return;
        }

        if(n > nums.get(nums.size() - 1)){
            nums.add(n);
            return;
        }

        int left = 0;
        int right = nums.size() - 1;

        while(left < right - 1){
            int mid = left + (right - left) / 2;

            if(nums.get(mid) < n)
                left = mid;
            else
                right = mid;
        }

        if(nums.get(left) > n)
            nums.set(left, n);
        else
            nums.set(right, n);
        return;
    }
}
