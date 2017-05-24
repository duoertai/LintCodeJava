package SpiralMatrix;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    /**
     * @param matrix a matrix of m x n elements
     * @return an integer list
     */
    public List<Integer> spiralOrder(int[][] matrix) {
        // Write your code here
        List<Integer> res = new ArrayList<Integer>();

        if(matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0)
            return res;

        int m = matrix.length - 1;
        int n = matrix[0].length - 1;
        int i = 0;
        int j = 0;

        while(i < m - i && j < n - j){
            go(res, matrix, i, m - i, j, n - j);

            if(i < m - i){
                i++;
            }
            if(j < n - j){
                j++;
            }
        }

        if(i == m - i && j == n - j){
            res.add(matrix[i][j]);
        }

        if(i == m - i && j < n - j){
            for(int k = j; k <= n - j; k++)
                res.add(matrix[i][k]);
        }

        if(i < m - i && j == n - j){
            for(int k = i; k <= m - i; k++)
                res.add(matrix[k][j]);
        }

        return res;
    }

    public void go(List<Integer> res, int[][] matrix, int row_start, int row_end, int col_start, int col_end){


        for(int i = col_start; i < col_end; i++)
            res.add(matrix[row_start][i]);
        for(int i = row_start; i < row_end; i++)
            res.add(matrix[i][col_end]);
        for(int i = col_end; i > col_start; i--)
            res.add(matrix[row_end][i]);
        for(int i = row_end; i > row_start; i--)
            res.add(matrix[i][col_start]);

        return;
    }
}
