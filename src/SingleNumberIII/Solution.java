package SingleNumberIII;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    /**
     * @param A : An integer array
     * @return : Two integers
     */
    public List<Integer> singleNumberIII(int[] A) {
        List<Integer> res = new ArrayList<Integer>();

        if(A == null || A.length == 0)
            return res;

        int temp = A[0];
        for(int i = 1; i < A.length; i++)
            temp = temp ^ A[i];

        int index = 0;
        for(int i = 0; i < 32; i++){
            if(((temp >> i) & 1) == 1){
                index = i;
                break;
            }
        }

        List<Integer> list1 = new ArrayList<Integer>();
        List<Integer> list2 = new ArrayList<Integer>();

        for(int i = 0; i < A.length; i++){
            if(((A[i] >> index) & 1) == 1)
                list1.add(A[i]);
            else
                list2.add(A[i]);
        }

        int res1 = list1.get(0);
        for(int i = 1; i < list1.size(); i++)
            res1 = res1 ^ list1.get(i);

        int res2 = list2.get(0);
        for(int i = 1; i < list2.size(); i++)
            res2 = res2 ^ list2.get(i);

        res.add(res1);
        res.add(res2);
        return res;
    }
}
