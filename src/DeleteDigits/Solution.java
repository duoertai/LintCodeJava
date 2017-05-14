package DeleteDigits;

public class Solution {
    /**
     *@param A: A positive integer which has N digits, A is a string.
     *@param k: Remove k digits.
     *@return: A string
     */
    public String DeleteDigits(String A, int k) {
        // write your code here

        if(A == null || A.length() == 0 || k <= 0)
            return A;

        StringBuilder res = new StringBuilder(A);

        for(int i = 0; i < k; i++){
            int index = 0;
            while(index < res.length() - 1 && res.charAt(index) <= res.charAt(index + 1))
                index++;

            res.deleteCharAt(index);
        }

        while(res.length() > 1 && res.charAt(0) == '0')
            res.deleteCharAt(0);

        return res.toString();
    }
}
