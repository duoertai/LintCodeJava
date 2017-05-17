package JumpGameII;

public class Solution {
    public int jump(int[] A) {
        // write your code here
        if(A == null || A.length <= 1)
            return 0;

        int[] step = new int[A.length];
        step[0] = 0;
        for(int i = 1; i < A.length; i++)
            step[i] = Integer.MAX_VALUE;

        int max = 0;
        for(int i = 0; i < A.length; i++){
            if(max < i)
                return Integer.MAX_VALUE;

            max = Math.max(max, i + A[i]);
            for(int j = i; j <= max && j < A.length; j++)
                step[j] = Math.min(step[j], step[i] + 1);
        }

        return step[A.length - 1];
    }
}

