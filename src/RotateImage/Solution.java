package RotateImage;

public class Solution {
    /**
     * @param matrix: A list of lists of integers
     * @return: Void
     */
    public void rotate(int[][] matrix) {
        // write your code here
        if(matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0)
            return;

        int n = matrix.length;
        if(n == 1)
            return;

        for(int i = 0; i < n / 2; i++)
            rotate(matrix, i);

        return;
    }

    public void rotate(int[][]matrix, int layer){
        int n = matrix.length;

        for(int i = layer; i < n - 1 - layer; i++){
            int temp = matrix[layer][i];
            matrix[layer][i] = matrix[n - 1 - i][layer];
            matrix[n - 1 - i][layer] = matrix[n - 1 - layer][n - 1 - i];
            matrix[n - 1 - layer][n - 1 - i] = matrix[i][n - 1 - layer];
            matrix[i][n - 1 - layer] = temp;
        }

        return;
    }

}
