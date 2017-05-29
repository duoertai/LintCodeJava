package CountOfSmallerNumberBeforeItself;

import java.util.ArrayList;

/**
 * Created by ertaiduo on 5/28/17.
 */
public class Solution2 {
    public ArrayList<Integer> countOfSmallerNumberII(int[] A) {
        ArrayList<Integer> res = new ArrayList<Integer>();

        if(A == null || A.length == 0)
            return res;

        ArrayList<Integer> line = new ArrayList<Integer>();

        for(int i = 0; i < A.length; i++){
            res.add(insert(line, A[i]));
        }

        return res;
    }

    public int insert(ArrayList<Integer> line, int num){
        if(line.size() == 0){
            line.add(num);
            return 0;
        }

        if(num < line.get(0)){
            line.add(0, num);
            return 0;
        }

        if(num > line.get(line.size() - 1)){
            line.add(num);
            return line.size() - 1;
        }

        int left = 0;
        int right = line.size() - 1;

        while(left < right - 1){
            int mid = left + (right - left) / 2;

            if(line.get(mid) < num){
                left = mid;
            }
            else{
                right = mid;
            }
        }

        int res = left;
        if(line.get(left) == num){
            res = left;
            line.add(left, num);
        }
        else{
            res = right;
            line.add(right, num);
        }

        return res;
    }
}
