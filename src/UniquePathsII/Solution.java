package UniquePathsII;

public class Solution {
    /**
     * @param obstacleGrid: A list of lists of integers
     * @return: An integer
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        // write your code here

        if(obstacleGrid == null || obstacleGrid.length == 0 || obstacleGrid[0] == null || obstacleGrid[0].length == 0)
            return 0;

        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] count = new int[m][n];

        for(int i = 0; i < m; i++){
            if(obstacleGrid[i][0] == 0){
                count[i][0] = 1;
            }
            else{
                while(i < m){
                    count[i][0] = 0;
                    i++;
                }
            }
        }
        for(int i = 0; i < n; i++){
            if(obstacleGrid[0][i] == 0){
                count[0][i] = 1;
            }
            else{
                while(i < n){
                    count[0][i] = 0;
                    i++;
                }
            }
        }

        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                if(obstacleGrid[i][j] == 0)
                    count[i][j] = count[i - 1][j] + count[i][j - 1];
                else
                    count[i][j] = 0;
            }
        }

        return count[m - 1][n - 1];
    }
}

