public class Solution {
    /**
     * @param n non-negative integer, n posts
     * @param k non-negative integer, k colors
     * @return an integer, the total number of ways
     */
    public int numWays(int n, int k) {
        // Write your code here
        if(n == 1)
            return k;
        if(n == 2)
            return k * k;

        if(n > 2 && k == 1)
            return 0;

        int[] same = new int[n];
        int[] diff = new int[n];

        same[0] = k;
        diff[0] = k;
        same[1] = k;
        diff[1] = k * (k - 1);

        for(int i = 2; i < n; i++){
            same[i] = diff[i - 1];
            diff[i] = same[i - 1] * (k - 1) + diff[i - 1] * (k - 1);
        }

        return same[n - 1] + diff[n - 1];
    }
}