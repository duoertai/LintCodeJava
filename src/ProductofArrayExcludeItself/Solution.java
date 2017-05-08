package ProductofArrayExcludeItself;

import java.util.ArrayList;

public class Solution {
    /**
     * @param A: Given an integers array A
     * @return: A Long array B and B[i]= A[0] * ... * A[i-1] * A[i+1] * ... * A[n-1]
     */
    public ArrayList<Long> productExcludeItself(ArrayList<Integer> A) {
        // write your code
        if(A == null || A.size() == 0)
            return new ArrayList<Long>();

        int len = A.size();
        long[] left = new long[len];
        long[] right = new long[len];

        left[0] = 1;
        right[len - 1] = 1;

        for(int i = 1; i < len; i++){
            left[i] = left[i - 1] * A.get(i - 1);
        }
        for(int i = len - 2; i >= 0; i--){
            right[i] = right[i + 1] * A.get(i + 1);
        }

        ArrayList<Long> res = new ArrayList<Long>();
        for(int i = 0; i < len; i++){
            res.add(left[i] * right[i]);
        }

        return res;
    }
}

