package NumberOfIslands;

public class Solution {
    /**
     * @param grid a boolean 2D matrix
     * @return an integer
     */
    public int numIslands(boolean[][] grid) {
        // Write your code here
        if(grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0)
            return 0;

        int m = grid.length;
        int n = grid[0].length;
        int res = 0;

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == true){
                    res++;
                    flip(grid, i, j);
                }
            }
        }

        return res;
    }

    public void flip(boolean[][] grid, int i, int j){
        int m = grid.length;
        int n = grid[0].length;

        if(i < 0 || i >= m || j < 0 || j >= n)
            return;

        if(grid[i][j] == true){
            grid[i][j] = false;
            flip(grid, i - 1, j);
            flip(grid, i + 1, j);
            flip(grid, i, j - 1);
            flip(grid, i, j + 1);
        }

        return;
    }

}
