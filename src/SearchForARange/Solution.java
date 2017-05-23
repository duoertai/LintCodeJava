package SearchForARange;

public class Solution {
    /**
     *@param A : an integer sorted array
     *@param target :  an integer to be inserted
     *return : a list of length 2, [index1, index2]
     */
    public int[] searchRange(int[] A, int target) {
        // write your code here
        int[] res = new int[2];

        if(A == null || A.length == 0 || target < A[0] || target > A[A.length - 1]){
            res[0] = -1;
            res[1] = -1;
            return res;
        }

        int left = 0;
        int right = A.length - 1;

        while(left < right - 1){
            int mid = left + (right - left) / 2;

            if(A[mid] < target)
                left = mid;
            else
                right = mid;
        }

        if(A[left] == target){
            res[0] = left;
        }
        else if(A[right] == target){
            res[0] = right;
        }
        else{
            res[0] = -1;
            res[1] = -1;
            return res;
        }

        left = 0;
        right = A.length - 1;

        while(left < right - 1){
            int mid = left + (right - left) / 2;

            if(A[mid] <= target)
                left = mid;
            else
                right = mid;
        }

        if(A[right] == target)
            res[1] = right;
        else if(A[left] == target)
            res[1] = left;

        return res;
    }
}
