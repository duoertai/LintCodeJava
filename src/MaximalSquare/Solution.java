package MaximalSquare;

public class Solution {
    /**
     * @param matrix: a matrix of 0 and 1
     * @return: an integer
     */
    public int maxSquare(int[][] matrix) {
        // write your code here

        if(matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0)
            return 0;

        int m = matrix.length;
        int n = matrix[0].length;
        int max = 0;

        int[][] count = new int[m][n];

        for(int i = 0; i < m; i++){
            count[i][0] = matrix[i][0];
            max = Math.max(max, count[i][0]);
        }
        for(int i = 0; i < n; i++){
            count[0][i] = matrix[0][i];
            max = Math.max(max, count[0][i]);
        }

        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                if(matrix[i][j] == 0){
                    count[i][j] = 0;
                }
                else{
                    count[i][j] = Math.min(Math.min(count[i - 1][j - 1], count[i - 1][j]), count[i][j - 1]) + 1;
                }
                max = Math.max(max, count[i][j]);
            }
        }

        return max * max;
    }
}