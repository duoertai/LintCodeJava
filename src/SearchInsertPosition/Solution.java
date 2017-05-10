package SearchInsertPosition;

public class Solution {
    /**
     * param A : an integer sorted array
     * param target :  an integer to be inserted
     * return : an integer
     */
    public int searchInsert(int[] A, int target) {
        // write your code here

        if(A == null || A.length == 0)
            return 0;

        if(target <= A[0])
            return 0;
        if(target > A[A.length - 1])
            return A.length;

        int left = 0;
        int right = A.length - 1;

        while(left < right - 1){
            int mid = left + (right - left) / 2;

            if(A[mid] == target)
                return mid;

            if(A[mid] > target)
                right = mid;
            else
                left = mid;
        }

        if(A[left] < target)
            return right;
        else
            return left;
    }
}
