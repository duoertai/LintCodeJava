package APlusBProblem;

class Solution {
    /*
     * param a: The first integer
     * param b: The second integer
     * return: The sum of a and b
     */
    public int aplusb(int a, int b) {
        // write your code here, try to do it without arithmetic operators.
        int result = 0;
        int carry = 0;

        for(int i = 0; i < 32; i++){
            result = result | (((a >> i) & 1 ^ (b >> i) & 1 ^ carry) << i);
            carry = ((a >> i) & 1) & ((b >> i) & 1) | carry & (((a >> i) & 1) ^ ((b >> i) & 1));
        }

        return result;
    }
};
