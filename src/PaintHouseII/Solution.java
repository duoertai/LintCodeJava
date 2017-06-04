package PaintHouseII;

public class Solution {
    /**
     * @param costs n x k cost matrix
     * @return an integer, the minimum cost to paint all houses
     */
    public int minCostII(int[][] costs) {
        if(costs == null || costs.length == 0 || costs[0] == null || costs[0].length <= 1)
            return 0;

        int m = costs.length;
        int n = costs[0].length;

        int smallest = -1;
        int second = -1;

        for(int i = 0; i < n; i++){
            if(smallest == -1){
                smallest = i;
            }
            else if(costs[0][i] < costs[0][smallest]){
                second = smallest;
                smallest = i;
            }
            else if(second == -1 || costs[0][i] < costs[0][second]){
                second = i;
            }
        }

        for(int i = 1; i < m; i++){
            int next_smallest = -1;
            int next_second = -1;

            for(int j = 0; j < n; j++){
                if(j != smallest)
                    costs[i][j] += costs[i - 1][smallest];
                else
                    costs[i][j] += costs[i - 1][second];

                if(next_smallest == -1){
                    next_smallest = j;
                }
                else if(costs[i][j] < costs[i][next_smallest]){
                    next_second = next_smallest;
                    next_smallest = j;
                }
                else if(next_second == -1 || costs[i][j] < costs[i][next_second]){
                    next_second = j;
                }
            }

            smallest = next_smallest;
            second = next_second;
        }

        return costs[m - 1][smallest];
    }
}
