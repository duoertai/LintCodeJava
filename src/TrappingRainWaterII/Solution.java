package TrappingRainWaterII;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {
    /**
     * @param heights: a matrix of integers
     * @return: an integer
     */
    public int trapRainWater(int[][] heights) {
        if(heights == null || heights.length <= 2 || heights[0] == null || heights[0].length <= 2)
            return 0;

        PriorityQueue<Point> heap = new PriorityQueue<Point>(10, new Comparator<Point>(){
            public int compare(Point p1, Point p2){
                return p1.h - p2.h;
            }
        });

        int m = heights.length;
        int n = heights[0].length;
        boolean[][] visited = new boolean[m][n];

        for(int i = 0; i < n; i++){
            heap.offer(new Point(0, i, heights[0][i]));
            visited[0][i] = true;
            heap.offer(new Point(m - 1, i, heights[m - 1][i]));
            visited[m - 1][i] = true;
        }
        for(int i = 1; i < m - 1; i++){
            heap.offer(new Point(i, 0, heights[i][0]));
            visited[i][0] = true;
            heap.offer(new Point(i, n - 1, heights[i][n - 1]));
            visited[i][n - 1] = true;
        }

        int res = 0;

        int[] dir_x = {0, 0, 1, -1};
        int[] dir_y = {-1, 1, 0, 0};

        while(!heap.isEmpty()){
            Point temp = heap.poll();

            for(int i = 0; i < 4; i++){
                int x = temp.x + dir_x[i];
                int y = temp.y + dir_y[i];

                if(x >= 0 && x < m && y >= 0 && y < n && !visited[x][y]){
                    heap.offer(new Point(x, y, Math.max(temp.h, heights[x][y])));
                    visited[x][y] = true;

                    res += Math.max(0, temp.h - heights[x][y]);
                }
            }
        }

        return res;
    }

    class Point{
        public int x;
        public int y;
        public int h;

        public Point(int x, int y, int h){
            this.x = x;
            this.y = y;
            this.h = h;
        }
    }

}