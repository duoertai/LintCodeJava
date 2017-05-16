package HouseRobber;

public class Solution {
    /**
     * @param A: An array of non-negative integers.
     * return: The maximum amount of money you can rob tonight
     */
    public long houseRobber(int[] A) {
        // write your code here
        if(A == null || A.length == 0)
            return 0;
        if(A.length == 1)
            return A[0];

        long[] last = new long[A.length];
        long[] max = new long[A.length];

        last[0] = A[0];
        last[1] = A[1];
        max[0] = A[0];
        max[1] = Math.max(A[0], A[1]);

        for(int i = 2; i < A.length; i++){
            last[i] = A[i] + max[i - 2];
            max[i] = Math.max(last[i - 1], A[i] + max[i - 2]);
        }

        return max[A.length - 1];
    }
}
