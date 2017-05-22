package ReversePairs;

import java.util.ArrayList;

public class Solution {
    /**
     * @param A an array
     * @return total of reverse pairs
     */
    public long reversePairs(int[] A) {
        // Write your code here
        if(A == null || A.length <= 1)
            return 0;

        ArrayList<Integer> list = new ArrayList<Integer>();
        long res = 0;
        list.add(A[0]);

        for(int i = 1; i < A.length; i++){
            res += getLargerCount(list, A[i]);
        }

        return res;
    }

    public long getLargerCount(ArrayList<Integer> list, int num){
        if(num < list.get(0)){
            list.add(0, num);
            return list.size() - 1;
        }

        if(num > list.get(list.size() - 1)){
            list.add(num);
            return 0;
        }

        int left = 0;
        int right = list.size() - 1;

        while(left < right - 1){
            int mid = left + (right - left) / 2;

            if(list.get(mid) <= num)
                left = mid;
            else
                right = mid;
        }

        if(list.get(right) == num){
            list.add(right, num);
            return 0;
        }
        else{
            long res = list.size() - right;
            list.add(right, num);
            return res;
        }
    }

}
