package SingleNumberII;

public class Solution {
    /**
     * @param A : An integer array
     * @return : An integer
     */
    public int singleNumberII(int[] A) {
        // write your code here
        int[] count = new int[32];

        if(A == null || A.length == 0)
            return 0;

        for(int i = 0; i < A.length; i++){
            int n = A[i];
            for(int j = 0; j < 32; j++){
                if(((n >> j) & 1) == 1)
                    count[j]++;
            }
        }

        for(int i = 0; i < 32; i++)
            count[i] = count[i] % 3;

        int res = 0;
        for(int i = 0; i < 32; i++){
            res = res | (count[i] << i);
        }

        return res;
    }
}
