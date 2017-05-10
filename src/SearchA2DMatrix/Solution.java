package SearchA2DMatrix;

public class Solution {
    /**
     * @param matrix, a list of lists of integers
     * @param target, an integer
     * @return a boolean, indicate whether matrix contains target
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        // write your code here
        if(matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0)
            return false;

        int m = matrix.length;
        int n = matrix[0].length;

        int left = 0;
        int right = m * n - 1;

        while(left < right){
            int mid = left + (right - left) / 2;

            int row = mid / n;
            int col = mid % n;

            if(matrix[row][col] == target)
                return true;

            if(matrix[row][col] < target)
                left = mid + 1;
            else
                right = mid - 1;
        }

        return matrix[left / n][left % n] == target;
    }
}
