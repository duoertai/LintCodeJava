package ContainerWithMostWater;

public class Solution {
    /**
     * @param heights: an array of integers
     * @return: an integer
     */
    public int maxArea(int[] heights) {
        // write your code here

        if(heights == null || heights.length < 2)
            return 0;

        int res = 0;

        int left = 0;
        int right = heights.length - 1;

        while(left < right){
            res = Math.max(res, Math.min(heights[left], heights[right]) * (right - left));

            if(heights[left] < heights[right])
                left++;
            else
                right--;
        }

        return res;
    }
}
