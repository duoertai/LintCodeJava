package TheSmallestDifference;

import java.util.Arrays;

public class Solution {
    /**
     * @param A, B: Two integer arrays.
     * @return: Their smallest difference.
     */
    public int smallestDifference(int[] A, int[] B) {
        // write your code here
        if(A == null || A.length == 0)
            return 0;
        if(B == null || B.length == 0)
            return 0;

        Arrays.sort(A);
        Arrays.sort(B);

        int i = 0;
        int j = 0;
        int res = Integer.MAX_VALUE;

        while(i < A.length && j < B.length){
            if(A[i] > B[j]){
                res = Math.min(res, A[i] - B[j]);
                j++;
            }
            else {
                res = Math.min(res, B[j] - A[i]);
                i++;
            }
        }

        return res;
    }
}
