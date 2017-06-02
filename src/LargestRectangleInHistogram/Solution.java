package LargestRectangleInHistogram;

import java.util.Stack;

public class Solution {
    /**
     * @param height: A list of integer
     * @return: The area of largest rectangle in the histogram
     */
    public int largestRectangleArea(int[] height) {
        if(height == null || height.length == 0)
            return 0;

        Stack<Integer> stack = new Stack<Integer>();
        int res = 0;
        int i = 0;

        while(i < height.length){
            if(stack.isEmpty() || height[i] >= height[stack.peek()]){
                stack.push(i);
                i++;
            }
            else{
                int index = stack.pop();
                int h = height[index];
                int w = stack.isEmpty() ? i : i - 1 - stack.peek();
                res = Math.max(res, h * w);
            }
        }

        while(!stack.isEmpty()){
            int index = stack.pop();
            int h = height[index];
            int w = stack.isEmpty() ? height.length : height.length - 1 - stack.peek();
            res = Math.max(res, h * w);
        }

        return res;
    }
}
