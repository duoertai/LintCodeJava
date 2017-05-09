package ReverseInteger;

public class Solution {
    /**
     * @param n the integer to be reversed
     * @return the reversed integer
     */
    public int reverseInteger(int n) {
        // Write your code here

        boolean neg = n < 0;
        long n_abs = 0;

        if(n < 0)
            n_abs = -((long) n);
        else
            n_abs = (long) n;

        long res = 0;

        while(n_abs > 0){
            res = res * 10 + n_abs % 10;
            n_abs /= 10;
        }

        if(neg)
            res = -res;

        if(res > Integer.MAX_VALUE || res < Integer.MIN_VALUE)
            return 0;
        else
            return (int) res;
    }
}