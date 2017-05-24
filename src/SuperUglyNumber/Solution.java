package SuperUglyNumber;

public class Solution {
    /**
     * @param n a positive integer
     * @param primes the given prime list
     * @return the nth super ugly number
     */
    public int nthSuperUglyNumber(int n, int[] primes) {
        // Write your code here
        if(n == 1)
            return 1;
        if(n <= 0 || primes == null || primes.length == 0)
            return 0;

        int[] res = new int[n];
        res[0] = 1;
        int len = primes.length;
        int[] index = new int[len];

        for(int i = 1; i < n; i++){
            int last = res[i - 1];

            int min = Integer.MAX_VALUE;

            for(int j = 0; j < len; j++){

                while(primes[j] * res[index[j]] <= last)
                    index[j]++;

                min = Math.min(min, primes[j] * res[index[j]]);
            }

            res[i] = min;
        }

        return res[n - 1];
    }
}
