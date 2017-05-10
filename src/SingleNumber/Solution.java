package SingleNumber;

public class Solution {
    /**
     *@param A : an integer array
     *return : a integer
     */
    public int singleNumber(int[] A) {
        // Write your code here
        if(A == null || A.length == 0)
            return 0;

        int res = A[0];

        for(int i = 1; i < A.length; i++){
            res = res ^ A[i];
        }

        return res;
    }
}
