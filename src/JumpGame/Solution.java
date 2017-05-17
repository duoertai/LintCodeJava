package JumpGame;

public class Solution {
    /**
     * @param A: A list of integers
     * @return: The boolean answer
     */
    public boolean canJump(int[] A) {
        if(A == null || A.length <= 1)
            return true;

        int max = 0;

        for(int i = 0; i < A.length; i++){
            if(max < i)
                return false;

            max = Math.max(max, i + A[i]);

            if(max >= A.length - 1)
                return true;
        }

        return false;
    }
}

