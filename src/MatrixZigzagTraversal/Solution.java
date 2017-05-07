package MatrixZigzagTraversal;

public class Solution {
    /**
     * @param matrix: a matrix of integers
     * @return: an array of integers
     */
    public int[] printZMatrix(int[][] matrix) {
        // write your code here

        if(matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0)
            return new int[0];

        int m = matrix.length;
        int n = matrix[0].length;

        int[] res = new int[m * n];

        boolean upright = true;
        int row = 0;
        int col = 0;

        for(int i = 0; i < m * n; i++){
            res[i] = matrix[row][col];

            if(upright){
                if(row == 0 && col < n - 1){
                    col++;
                    upright = !upright;
                }
                else if(col == n - 1){
                    row++;
                    upright = !upright;
                }
                else{
                    row--;
                    col++;
                }
            }
            else{
                if(col == 0 && row < m - 1){
                    row++;
                    upright = !upright;
                }
                else if(row == m - 1){
                    col++;
                    upright = !upright;
                }
                else{
                    row++;
                    col--;
                }
            }
        }

        return res;
    }
}
