package FastPower;

class Solution {
    /*
     * @param a, b, n: 32bit integers
     * @return: An integer
     */
    public int fastPower(int a, int b, int n) {
        // write your code here

        if(n == 0)
            return 1 % b;

        if(n == 1)
            return a % b;

        if(n % 2 == 0){
            long temp = fastPower(a, b, n / 2);
            long res = (temp * temp) % b;
            return (int) res;
        }
        else{
            long temp = fastPower(a, b, n / 2);
            long res = (temp * temp) % b;
            res = (res * a) % b;

            return (int) res;
        }

    }
}
