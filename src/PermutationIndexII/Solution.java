package PermutationIndexII;

import java.util.HashMap;

public class Solution {
    /**
     * @param A an integer array
     * @return a long integer
     */
    public long permutationIndexII(int[] A) {
        if(A == null || A.length == 0)
            return 0;

        long res = 0;

        for(int i = 0; i < A.length; i++){
            int smaller = 0;

            for(int j = i + 1; j < A.length; j++){
                if(A[j] < A[i])
                    smaller++;
            }

            long num = smaller * factor(A.length - i - 1);
            HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

            for(int k = i; k < A.length; k++){
                if(!map.containsKey(A[k]))
                    map.put(A[k], 1);
                else
                    map.put(A[k], map.get(A[k]) + 1);
            }

            for(Integer key: map.keySet()){
                num /= factor(map.get(key));
            }

            res += num;
        }

        return res + 1;
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