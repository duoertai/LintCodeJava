package RemoveDuplicatesfromSortedArrayII;

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
        int count = 1;

        for(; fast < nums.length; fast++){
            if(nums[fast] == nums[fast - 1]){
                if(count == 1){
                    count++;
                    nums[slow++] = nums[fast];
                }
            }
            else{
                nums[slow++] = nums[fast];
                count = 1;
            }
        }

        return slow;
    }
}
