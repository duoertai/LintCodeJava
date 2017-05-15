package BigIntegerMultiplication;

public class Solution {
    /**
     * @param num1 a non-negative integers
     * @param num2 a non-negative integers
     * @return return product of num1 and num2
     */
    public String multiply(String num1, String num2) {
        // Write your code here

        if(num1.equals("0") || num2.equals("0"))
            return "0";

        String res = "0";

        for(int i = 0; i < num2.length(); i++){
            int digit = num2.charAt(num2.length() - i - 1) - '0';

            String temp = "0";
            for(int j = 0; j < digit; j++)
                temp = add(temp, num1);

            for(int j = 0; j < i; j++)
                temp = temp + "0";

            res = add(res, temp);
        }

        return res.toString();
    }

    public String add(String num1, String num2){
        StringBuilder res = new StringBuilder();

        int p1 = num1.length() - 1;
        int p2 = num2.length() - 1;
        int carry = 0;

        while(p1 >= 0 || p2 >= 0){
            int d1 = 0;
            if(p1 >= 0){
                d1 = num1.charAt(p1) - '0';
                p1--;
            }

            int d2 = 0;
            if(p2 >= 0){
                d2 = num2.charAt(p2) - '0';
                p2--;
            }

            res.insert(0, (d1 + d2 + carry) % 10);
            carry = (d1 + d2 + carry) / 10;
        }

        if(carry == 1)
            res.insert(0, 1);

        return res.toString();
    }

}
