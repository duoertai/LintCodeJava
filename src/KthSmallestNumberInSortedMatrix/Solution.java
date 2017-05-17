package KthSmallestNumberInSortedMatrix;

import java.util.PriorityQueue;

public class Solution {
    /**
     * @param matrix: a matrix of integers
     * @param k: an integer
     * @return: the kth smallest number in the matrix
     */
    public int kthSmallest(int[][] matrix, int k) {
        // write your code here

        int m = matrix.length;
        int n = matrix[0].length;

        PriorityQueue<point> heap = new PriorityQueue<point>();
        for(int i = 0; i < m; i++)
            heap.offer(new point(i, 0, matrix[i][0]));

        for(int i = 0; i < k - 1; i++){
            point temp = heap.poll();
            if(temp.y + 1 < n)
                heap.offer(new point(temp.x, temp.y + 1, matrix[temp.x][temp.y + 1]));
        }

        return heap.poll().val;
    }

    class point implements Comparable<point>{
        public int x;
        public int y;
        public int val;

        public point(int x, int y, int val){
            this.x = x;
            this.y = y;
            this.val = val;
        }

        public int compareTo(point t){
            if(this.val == t.val)
                return 0;
            else if(this.val < t.val)
                return -1;
            else
                return 1;
        }
    }
}
