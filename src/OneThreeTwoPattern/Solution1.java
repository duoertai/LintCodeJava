package OneThreeTwoPattern;

/**
 * Created by ertaiduo on 5/11/17.
 */
public class Solution1 {
    public boolean find132pattern(int[] nums) {
        // Write your code here

        if(nums == null || nums.length < 3)
            return false;

        int i = 0;

        while(i < nums.length - 2){
            while(i < nums.length - 2 && nums[i] >= nums[i + 1])
                i++;
            if(i == nums.length - 2)
                return false;

            int j = i + 1;
            while(j < nums.length - 1 && nums[j] <= nums[j + 1])
                j++;
            if(j == nums.length - 1)
                return false;

            int k = j + 1;

            while(k < nums.length && !(nums[k] > nums[i] && nums[j] > nums[k]))
                k++;

            if(k == nums.length)
                i = j + 1;
            else
                return true;
        }

        return false;
    }
}
