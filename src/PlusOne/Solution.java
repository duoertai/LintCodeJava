package PlusOne;

public class Solution {
    /**
     * @param digits a number represented as an array of digits
     * @return the result
     */
    public int[] plusOne(int[] digits) {
        // Write your code here
        if(digits == null || digits.length == 0)
            return digits;

        int carry = 1;

        for(int i = digits.length - 1; i >= 0; i--){
            int temp = digits[i];
            digits[i] = (temp + carry) % 10;
            carry = (temp + carry) / 10;
        }

        if(carry == 0)
            return digits;

        int[] res = new int[digits.length + 1];
        res[0] = 1;
        for(int i = 0; i < digits.length; i++)
            res[i + 1] = digits[i];

        return res;
    }
}
