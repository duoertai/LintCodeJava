package RemoveDuplicatesfromSortedArray;

public class Solution {
    /**
     * @param : a array of integers
     * @return : return an integer
     */
    public int removeDuplicates(int[] nums) {
        // write your code here
        if(nums == null || nums.length == 0)
            return 0;

        int slow = 1;
        int fast = 1;

        while(fast < nums.length){
            while(fast < nums.length && nums[fast] == nums[fast - 1])
                fast++;
            if(fast == nums.length)
                break;

            nums[slow++] = nums[fast++];
        }

        return slow;
    }
}