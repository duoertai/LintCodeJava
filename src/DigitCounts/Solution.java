package DigitCounts;

public class Solution {
    /*
     * @param : An integer
     * @param : An integer
     * @return: An integer denote the count of digit k in 1..n
     */
    public int digitCounts(int k, int n) {
        // write your code here
        if(n < 0 || k < 0 || k > 9)
            return 0;

        int res = 0;

        for(int i = 0; i <= n; i++){
            int num = i;

            if(num == 0 && k == 0){
                res++;
                continue;
            }

            while(num > 0){
                if(num % 10 == k)
                    res++;

                num /= 10;
            }

        }

        return res;
    }
}
