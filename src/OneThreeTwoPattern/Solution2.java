package OneThreeTwoPattern;

import java.util.Stack;

public class Solution2 {
    /**
     * @param nums a list of n integers
     * @return true if there is a 132 pattern or false
     */
    public boolean find132pattern(int[] nums) {
        // Write your code here
        if(nums == null || nums.length < 3)
            return false;

        Stack<Integer> stack = new Stack<Integer>();

        int second = Integer.MIN_VALUE;

        for(int i = nums.length - 1; i >= 0; i--){
            if(nums[i] < second)
                return true;
            else{
                while(!stack.isEmpty() && nums[i] > stack.peek()){
                    second = Math.max(second, stack.pop());
                }

                stack.push(nums[i]);
            }
        }

        return false;
    }
}
