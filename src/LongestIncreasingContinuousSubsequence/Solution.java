package LongestIncreasingContinuousSubsequence;

public class Solution {
    /**
     * @param A an array of Integer
     * @return  an integer
     */
    public int longestIncreasingContinuousSubsequence(int[] A) {
        // Write your code here
        if(A == null || A.length == 0)
            return 0;

        if(A.length == 1)
            return 1;

        int res = 1;

        int[] l2r = new int[A.length];
        int[] r2l = new int[A.length];

        l2r[0] = 1;

        for(int i = 1; i < A.length; i++){
            if(A[i] > A[i - 1]){
                l2r[i] = l2r[i - 1] + 1;
                if(l2r[i] > res)
                    res = l2r[i];
            }
            else{
                l2r[i] = 1;
            }
        }

        r2l[A.length - 1] = 1;

        for(int i = A.length - 2; i >= 0; i--){
            if(A[i] > A[i + 1]){
                r2l[i] = r2l[i + 1] + 1;
                if(r2l[i] > res)
                    res = r2l[i];
            }
            else{
                r2l[i] = 1;
            }
        }

        return res;
    }
}