package FindDuplicateNumber;

public class Solution {
    /**
     * @param nums an array containing n + 1 integers which is between 1 and n
     * @return the duplicate one
     */
    public int findDuplicate(int[] nums) {
        // Write your code here

        if(nums == null || nums.length == 0)
            return 0;

        int p1 = nums[0];
        int p2 = nums[nums[0]];

        while(p1 != p2){
            p1 = nums[p1];
            p2 = nums[nums[p2]];
        }

        p1 = 0;
        while(p1 != p2){
            p1 = nums[p1];
            p2 = nums[p2];
        }

        return p1;
    }
}
