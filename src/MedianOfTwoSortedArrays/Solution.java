package MedianOfTwoSortedArrays;

class Solution {
    /**
     * @param A: An integer array.
     * @param B: An integer array.
     * @return: a double whose format is *.5 or *.0
     */
    public double findMedianSortedArrays(int[] A, int[] B) {
        int m = A.length;
        int n = B.length;
        int len = m + n;

        if(len % 2 == 1)
            return 1.0 * findKth(A, 0, B, 0, len / 2 + 1);
        else
            return (findKth(A, 0, B, 0, len / 2) + findKth(A, 0, B, 0, len / 2 + 1)) / 2.0;
    }

    public int findKth(int[] A, int A_start, int[] B, int B_start, int k){
        if(A_start >= A.length)
            return B[B_start + k - 1];
        if(B_start >= B.length)
            return A[A_start + k - 1];

        if(k == 1)
            return Math.min(A[A_start], B[B_start]);

        int A_mid = A_start + k / 2 - 1 >= A.length ? Integer.MAX_VALUE : A[A_start + k / 2 - 1];
        int B_mid = B_start + k / 2 - 1 >= B.length ? Integer.MAX_VALUE : B[B_start + k / 2 - 1];

        if(A_mid < B_mid)
            return findKth(A, A_start + k / 2, B, B_start, k - k / 2);
        else
            return findKth(A, A_start, B, B_start + k / 2, k - k / 2);
    }

}