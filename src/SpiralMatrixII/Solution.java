package SpiralMatrixII;

public class Solution {
    /**
     * @param n an integer
     * @return a square matrix
     */
    public int[][] generateMatrix(int n) {
        // Write your code here
        if(n <= 0)
            return new int[0][0];

        int[][] res = new int[n][n];
        int num = 1;

        for(int i = 0; i < n / 2; i++){
            for(int j = i; j < n - 1 - i; j++)
                res[i][j] = num++;
            for(int j = i; j < n - 1 - i; j++)
                res[j][n - 1 - i] = num++;
            for(int j = n - 1 - i; j > i; j--)
                res[n - 1 - i][j]= num++;
            for(int j = n - 1 - i; j > i; j--)
                res[j][i] = num++;
        }

        if(n % 2 == 1)
            res[n / 2][n / 2] = num;

        return res;
    }
}