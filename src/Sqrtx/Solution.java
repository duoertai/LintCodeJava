package Sqrtx;

class Solution {
    /**
     * @param x: An integer
     * @return: The sqrt of x
     */
    public int sqrt(int x) {
        // write your code here
        if(x <= 0)
            return 0;

        if(x == 1)
            return 1;

        long left = 1;
        long right = x / 2;

        while(left < right){
            long mid = left + (right - left) / 2;

            if(mid * mid <= x && (mid + 1) * (mid + 1) > x)
                return (int) mid;

            if(mid * mid > x)
                right = mid - 1;
            else if((mid + 1) * (mid + 1) <= x)
                left = mid + 1;
        }

        return (int) left;
    }
}
