package BackPackII;

public class Solution {
    /**
     * @param m: An integer m denotes the size of a backpack
     * @param A & V: Given n items with size A[i] and value V[i]
     * @return: The maximum value
     */
    public int backPackII(int m, int[] A, int V[]) {
        // write your code here

        if(A == null || A.length == 0 || m <= 0)
            return 0;

        int n = A.length;

        int[][] value = new int[n + 1][m + 1];


        value[0][0] = 0;

        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= m; j++){

                value[i][j] = value[i - 1][j];
                if(j >= A[i - 1])
                    value[i][j] = Math.max(value[i][j], value[i - 1][j - A[i - 1]] + V[i - 1]);
            }
        }

        int res = Integer.MIN_VALUE;
        for(int i = m; i >= 0; i--)
            res = Math.max(res, value[n][i]);

        return res;
    }
}
