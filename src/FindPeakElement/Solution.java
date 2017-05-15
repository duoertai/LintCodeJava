package FindPeakElement;

class Solution {
    /**
     * @param A: An integers array.
     * @return: return any of peek positions.
     */
    public int findPeak(int[] A) {
        // write your code here

        if(A == null || A.length == 0)
            return 0;

        if(A.length == 1)
            return 0;

        int left = 0;
        int right = A.length - 1;

        while(left < right - 1){
            int mid = left + (right - left) / 2;

            if(A[mid] > A[mid - 1] && A[mid] > A[mid + 1])
                return mid;

            if(A[mid] < A[mid - 1])
                right = mid - 1;
            else
                left = mid + 1;
        }

        return A[left] > A[right] ? left : right;
    }
}
