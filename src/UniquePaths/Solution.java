package UniquePaths;

public class Solution {
    /**
     * @param n, m: positive integer (1 <= n ,m <= 100)
     * @return an integer
     */
    public int uniquePaths(int m, int n) {
        // write your code here
        if(n == 1 || m == 1)
            return 1;

        int[][] count = new int[m][n];

        for(int i = 0; i < m; i++)
            count[i][0] = 1;
        for(int i = 0; i < n; i++)
            count[0][i] = 1;

        for(int i = 1; i < m; i++)
            for(int j = 1; j < n; j++)
                count[i][j] = count[i - 1][j] + count[i][j - 1];

        return count[m - 1][n - 1];
    }
}

