package DivideTwoIntegers;

public class Solution {
    /**
     * @param dividend the dividend
     * @param divisor the divisor
     * @return the result
     */
    public int divide(int dividend, int divisor) {
        // Write your code here

        if(divisor == 1)
            return dividend;

        if(dividend == 0)
            return 0;

        if(divisor == 0)
            return Integer.MAX_VALUE;

        if(dividend == Integer.MIN_VALUE && divisor == -1)
            return Integer.MAX_VALUE;

        long res = 0;
        boolean neg = (dividend < 0 && divisor > 0) || (dividend > 0 && divisor < 0);

        long num = Math.abs((long) dividend);
        long den = Math.abs((long) divisor);

        while(num >= den){
            int shift = 0;

            while(num >= (den << shift))
                shift++;

            num -= den << (shift - 1);

            res += 1 << (shift - 1);
        }

        if(neg)
            res = -res;

        if(res > Integer.MAX_VALUE || res < Integer.MIN_VALUE)
            return Integer.MAX_VALUE;

        return (int) res;
    }
}
