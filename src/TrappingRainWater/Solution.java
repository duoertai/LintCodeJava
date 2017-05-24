package TrappingRainWater;

public class Solution {
    /**
     * @param heights: an array of integers
     * @return: a integer
     */
    public int trapRainWater(int[] heights) {
        // write your code here

        if(heights == null || heights.length < 3)
            return 0;

        int n = heights.length;
        int[] left = new int[n];
        int[] right = new int[n];
        int res = 0;

        left[0] = 0;
        right[n - 1] = 0;

        for(int i = 1; i < n; i++)
            left[i] = Math.max(left[i - 1], heights[i - 1]);
        for(int i = n - 2; i >= 0; i--)
            right[i] = Math.max(right[i + 1], heights[i + 1]);

        for(int i = 1; i < n - 1; i++){
            int minHeight = Math.min(left[i], right[i]);
            if(minHeight > heights[i])
                res += minHeight - heights[i];
        }

        return res;
    }
}
