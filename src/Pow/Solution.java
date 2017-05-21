package Pow;

public class Solution {
    /**
     * @param x the base number
     * @param n the power number
     * @return the result
     */
    public double myPow(double x, int n) {
        if(n < 0)
            return 1.0 / myPow(x, -n);

        if(n == 0)
            return 1.0;
        if(n == 1)
            return x;

        if(n % 2 == 0){
            double temp = myPow(x, n / 2);
            return temp * temp;
        }
        else{
            double temp = myPow(x, n / 2);
            return temp * temp * x;
        }
    }
}
