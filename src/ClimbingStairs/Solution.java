package ClimbingStairs;

public class Solution {
    /**
     * @param n: An integer
     * @return: An integer
     */
    public int climbStairs(int n) {
        // write your code here
        if(n <= 1)
            return 1;

        if(n == 2)
            return 2;

        int a = 1;
        int b = 2;

        for(int i = n - 3; i >= 0; i--){
            int temp = a + b;
            a = b;
            b = temp;
        }

        return b;
    }
}
