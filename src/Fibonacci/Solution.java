package Fibonacci;

class Solution {
    /**
     * @param n: an integer
     * @return an integer f(n)
     */
    public int fibonacci(int n) {
        // write your code here

        if(n <= 1)
            return 0;

        if(n == 2)
            return 1;

        int first = 0;
        int second = 1;

        for(int i = 2; i < n; i++){
            int temp = first + second;
            first = second;
            second = temp;
        }

        return second;
    }
}

