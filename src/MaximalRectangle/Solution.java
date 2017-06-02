package MaximalRectangle;

import java.util.Stack;

public class Solution {
    /**
     * @param matrix a boolean 2D matrix
     * @return an integer
     */
    public int maximalRectangle(boolean[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0)
            return 0;

        int m = matrix.length;
        int n = matrix[0].length;

        int[] height = new int[n];
        int res = 0;

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(matrix[i][j])
                    height[j]++;
                else
                    height[j] = 0;
            }

            int area = getMaxRec(height);
            res = Math.max(res, area);
        }

        return res;
    }

    public int getMaxRec(int[] height){
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
                int w = stack.isEmpty() ? i : i - stack.peek() - 1;

                res = Math.max(res, h * w);
            }
        }

        while(!stack.isEmpty()){
            int index = stack.pop();
            int h = height[index];
            int w = stack.isEmpty() ? i : i - stack.peek() - 1;

            res = Math.max(res, h * w);
        }

        return res;
    }

}