package SubmatrixSum;

import java.util.HashMap;

public class Solution {
    /**
     * @param matrix an integer matrix
     * @return the coordinate of the left-up and right-down number
     */
    public int[][] submatrixSum(int[][] matrix) {
        // Write your code here
        if(matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0)
            return new int[2][2];

        int m = matrix.length;
        int n = matrix[0].length;

        int[][] sum = new int[m + 1][n + 1];

        for(int i = 1; i <= m; i++){
            for(int j = 1; j <= n; j++){
                sum[i][j] = sum[i - 1][j] + sum[i][j - 1] - sum[i - 1][j - 1] + matrix[i - 1][j - 1];
            }
        }

        int[][] res = new int[2][2];

        for(int i = 0; i <= m; i++){
            for(int j = 0; j < i; j++){
                HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

                for(int k = 0; k <= n; k++){
                    int temp = sum[i][k] - sum[j][k];

                    if(!map.containsKey(temp)){
                        map.put(temp, k);
                    }
                    else{
                        res[0][0] = j;
                        res[0][1] = map.get(temp);
                        res[1][0] = i - 1;
                        res[1][1] = k - 1;
                        return res;
                    }
                }
            }
        }

        return res;
    }
}