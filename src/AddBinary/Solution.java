package AddBinary;

public class Solution {
    /**
     * @param a a number
     * @param b a number
     * @return the result
     */
    public String addBinary(String a, String b) {
        // Write your code here
        if(a == null)
            return b;
        if(b == null)
            return a;

        StringBuilder res = new StringBuilder();
        int p1 = a.length() - 1;
        int p2 = b.length() - 1;
        int carry = 0;

        while(p1 >= 0 || p2 >= 0){
            int bit1 = 0;
            if(p1 >= 0){
                bit1 = a.charAt(p1) - '0';
                p1--;
            }

            int bit2 = 0;
            if(p2 >= 0){
                bit2 = b.charAt(p2) - '0';
                p2--;
            }

            int temp = (bit1 + bit2 + carry) % 2;
            carry = (bit1 + bit2 + carry) / 2;
            res.insert(0, temp);
        }

        if(carry == 1)
            res.insert(0, 1);

        return res.toString();
    }
}