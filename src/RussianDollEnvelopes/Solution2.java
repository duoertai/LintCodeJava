package RussianDollEnvelopes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Solution2 {
    public int maxEnvelopes(int[][] envelopes) {
        if(envelopes == null || envelopes.length == 0)
            return 0;

        Arrays.sort(envelopes, new Comparator<int[]>(){
            public int compare(int[] e1, int[] e2){
                if(e1[0] != e2[0])
                    return e1[0] - e2[0];
                else
                    return e2[1] - e1[1];
            }
        });

        ArrayList<Integer> list = new ArrayList<Integer>();

        for(int i = 0; i < envelopes.length; i++){
            if(list.size() == 0 || envelopes[i][1] > list.get(list.size() - 1)){
                list.add(envelopes[i][1]);
            }
            else{
                int left = 0;
                int right = list.size() - 1;

                while(left < right - 1){
                    int mid = left + (right - left) / 2;

                    if(list.get(mid) < envelopes[i][1])
                        left = mid;
                    else
                        right = mid;
                }

                if(list.get(left) > envelopes[i][1])
                    list.set(left, envelopes[i][1]);
                else
                    list.set(right, envelopes[i][1]);
            }

        }

        return list.size();
    }

}
