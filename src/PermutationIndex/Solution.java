package PermutationIndex;

public class Solution {
    /**
     * @param A an integer array
     * @return a long integer
     */
    public long permutationIndex(int[] A) {
        // Write your code here
        if(A == null || A.length == 0)
            return 0;

        long res = 1;

        for(int i = 0; i < A.length; i++){
            int smaller = 0;
            for(int j = i + 1; j < A.length; j++)
                if(A[j] < A[i])
                    smaller++;

            res += smaller * factor(A.length - i - 1);
        }

        return res;
    }

    public long factor(int n){
        if(n <= 1)
            return 1;

        long res = 1;

        for(int i = 1; i <= n; i++)
            res *= i;

        return res;
    }

}
