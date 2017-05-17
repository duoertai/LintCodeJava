package IntegerToRoman;

public class Solution {
    /**
     * @param n The integer
     * @return Roman representation
     */
    public String intToRoman(int n) {
        // Write your code here

        String[] symbol = {"I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M"};
        int[] num = {1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000};

        int p_sym = symbol.length - 1;
        int p_n = num.length - 1;
        StringBuilder res = new StringBuilder();

        while(n > 0){
            while(n >= num[p_n]){
                n -= num[p_n];
                res.append(symbol[p_sym]);
            }
            p_n--;
            p_sym--;
        }

        return res.toString();
    }
}