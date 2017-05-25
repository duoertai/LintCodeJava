package UglyNumberII;

class Solution {
    /**
     * @param n an integer
     * @return the nth prime number as description.
     */
    public int nthUglyNumber(int n) {
        // Write your code here
        if(n <= 0)
            return 0;
        if(n == 1)
            return 1;

        int[] res = new int[n];
        int[] index = new int[3];
        res[0] = 1;

        for(int i = 1; i < n; i++){
            int last = res[i - 1];

            int min = Integer.MAX_VALUE;

            while(res[index[0]] * 2 <= last)
                index[0]++;

            min = Math.min(min, res[index[0]] * 2);

            while(res[index[1]] * 3 <= last)
                index[1]++;

            min = Math.min(min, res[index[1]] * 3);

            while(res[index[2]] * 5 <= last)
                index[2]++;

            min = Math.min(min, res[index[2]] * 5);

            res[i] = min;
        }

        return res[n - 1];
    }
}
