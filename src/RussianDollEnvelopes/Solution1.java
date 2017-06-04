package RussianDollEnvelopes;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by ertaiduo on 6/3/17.
 */
public class Solution1 {
    public int maxEnvelopes(int[][] envelopes) {
        if(envelopes == null || envelopes.length == 0)
            return 0;

        Arrays.sort(envelopes, new Comparator<int[]>(){
            public int compare(int[] e1, int[] e2){
                if(e1[0] != e2[0])
                    return e1[0] - e2[0];
                else
                    return e1[1] - e2[1];
            }
        });

        int n = envelopes.length;
        int[] count = new int[n];
        for(int i = 0; i < n; i++)
            count[i] = 1;

        for(int i = 1; i < n; i++){
            for(int j = 0; j < i; j++){
                if(envelopes[i][0] > envelopes[j][0] && envelopes[i][1] > envelopes[j][1])
                    count[i] = Math.max(count[i], count[j] + 1);
            }
        }

        int res = 0;
        for(int c: count)
            res = Math.max(res, c);

        return res;
    }
}
