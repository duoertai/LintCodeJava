package TrailingZeros;

class Solution {
    /*
     * param n: As desciption
     * return: An integer, denote the number of trailing zeros in n!
     */
    public long trailingZeros(long n) {
        // write your code here

        long i = 5;
        long res = 0;

        for(; i <= n; i *= 5)
            res += n / i;

        return res;
    }
}

