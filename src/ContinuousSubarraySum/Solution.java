package ContinuousSubarraySum;

import java.util.ArrayList;

public class Solution {
    /**
     * @param A an integer array
     * @return  A list of integers includes the index of the first number and the index of the last number
     */
    public ArrayList<Integer> continuousSubarraySum(int[] A) {
        // Write your code here

        ArrayList<Integer> res = new ArrayList<Integer>();

        if(A == null || A.length == 0)
            return res;

        int sum = A[0];
        int max = A[0];

        int[] index = new int[2];
        res.add(0);
        res.add(0);

        for(int i = 1; i < A.length; i++){
            if(sum < 0){
                sum = 0;
                index[0] = i;
                index[1] = i;
            }

            sum += A[i];

            if(sum > max){
                max = sum;
                index[1] = i;
                res.set(0, index[0]);
                res.set(1, index[1]);
            }

        }

        return res;
    }
}
